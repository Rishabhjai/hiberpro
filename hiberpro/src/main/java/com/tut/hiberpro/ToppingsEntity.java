package com.tut.hiberpro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class ToppingsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int get_id() {
		return id;
	}

	public void setTopping_id(int topping_id) {
		this.id = topping_id;
	}

	//@JsonProperty("id")
	int t_id;
	//@JsonProperty("type")
	String t_type;
	@ManyToOne
	ItemEntity t_item;

	public ItemEntity getItem() {
		return t_item;
	}

	public void setItem(ItemEntity item) {
		this.t_item = item;
	}
	
	public ToppingsEntity(int id, String type) {
		super();
		this.t_id = id;
		this.t_type = type;
	}

	public ToppingsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("id")
	public int getId() {
		return t_id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.t_id = id;
	}

	@JsonProperty("type")
	public String getType() {
		return t_type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.t_type = type;
	}

	@Override
	public String toString() {
		return "toppings=" + t_type;
	}
}
