package com.gxw.myrelu;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyRoundRule extends AbstractLoadBalancerRule {

	// 自定义规则 轮询方式，但每次连续5次
	private int total = 0;
	private int index = 0;

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes only get more
				 * restrictive.
				 */
				return null;
			}
			// 修改 为自定义模式
			if (total < 5) {
				total++;
			} else {
				total = 1;
				index = (index + 1) % upList.size();
			}
			server = upList.get(index);

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were somehow trimmed.
				 * This is a transient condition. Retry after yielding.
				 */
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub

	}

}
