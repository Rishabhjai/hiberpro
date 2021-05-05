package com.tut.hiberpro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class Batter {
	int id;
	String type;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int batter_id;
	@ManyToOne
	Batters b_item;

	public Batter(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Batters getBatters() {
		return b_item;
	}

	public void setBatters(Batters item) {
		this.b_item = item;
	}

	
	public int getId() {
		return id;
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

	@Override
    public String toString() {
        return "batterType=" + type ;
    }
	
	public Batter() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
