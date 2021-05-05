package com.tut.hiberpro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class BattersEntity {

	@OneToMany
	List<BatterEntity> batter;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int batters_id;
	@OneToOne
	ItemEntity item;

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "batter:" + batter;
	}

	public BattersEntity(List<BatterEntity> batter) {
		super();
		this.batter = batter;
	}

	public BattersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BatterEntity> getBatter() {
		return batter;
	}

	public void setBatter(List<BatterEntity> batter) {
		this.batter = batter;
	}
}
