package com.tut.hiberpro;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@JsonProperty("id")
	private int i_id;

	//@JsonProperty("id")
	public int getI_id() {
		return i_id;
	}
	//@JsonProperty("id")
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	private String type;
	private String name;
	private double ppu;
	@OneToOne
	BattersEntity batters;
	@OneToMany(targetEntity = ToppingsEntity.class, mappedBy = "t_item")
	List<ToppingsEntity> topping;

	public int getId() {
		return id;
	}

	public ItemEntity(int id, String type, String name, double ppu, BattersEntity batters,
			List<ToppingsEntity> topping) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.ppu = ppu;
		this.batters = batters;
		this.topping = topping;
	}

	public List<ToppingsEntity> getTopping() {
		return topping;
	}

	public void setTopping(List<ToppingsEntity> list) {
		this.topping = list;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPpu() {
		return ppu;
	}

	public void setPpu(double ppu) {
		this.ppu = ppu;
	}

	public BattersEntity getBatters() {
		return batters;
	}

	public void setBatters(BattersEntity bts) {
		this.batters = bts;
	}

	public ItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "type=" + type + ", name=" + name + ", ppu=" + ppu + ", batters=" + batters + ", toppings=" + topping;
	}

}
