package com.tut.hiberpro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Batters {
	@OneToMany
	List<Batter> batter;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int batters_id;
	@OneToOne
	Item item;
	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	@Override
    public String toString() {
        return "batter:" + batter;
    }
	
	

	public Batters(ArrayList<Batter> batter) {
		super();
		this.batter = batter;
	}

	public Batters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Batter> getBatter() {
		return batter;
	}

	public void setBatter(List<Batter> batter) {
		this.batter = batter;
	}
	
	
}
