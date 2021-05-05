package com.tut.hiberpro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class Item {
	
	private int id;
	
	private int i_id;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	private String type;
	private String name;
	private double ppu;
	@OneToOne
	Batters batters;
	@OneToMany(targetEntity=Toppings.class, mappedBy="t_item")
	List<Toppings> topping;

	public int getId() {
		return id;
	}

	public Item(int id, String type, String name, double ppu, Batters batters, List<Toppings> topping) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.ppu = ppu;
		this.batters = batters;
		this.topping = topping;
	}

	

	public List<Toppings> getTopping() {
		return topping;
	}

	public void setTopping(List<Toppings> list) {
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

	public Batters getBatters() {
		return batters;
	}

	public void setBatters(Batters batters) {
		this.batters = batters;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return  "type=" + type +
                ", name=" + name +
                ", ppu=" + ppu +
                ", batters=" + batters +
                ", toppings=" + topping;
    }

}
