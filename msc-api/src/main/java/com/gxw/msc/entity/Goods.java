package com.gxw.msc.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private Long id;
	private String name;
	private Double price;
	private String db_source;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public Goods setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public Goods setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public Goods setPrice(Double price) {
		this.price = price;
		return this;
	}

	/**
	 * @return the data_source
	 */
	public String getDb_source() {
		return db_source;
	}

	/**
	 * @param data_source the data_source to set
	 */
	public Goods setDb_source(String data_source) {
		this.db_source = data_source;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", db_source=" + db_source + "]";
	}

	public Goods(Long id, String name, Double price, String data_source) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.db_source = data_source;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
}
