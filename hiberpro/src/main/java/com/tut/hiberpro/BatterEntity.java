package com.tut.hiberpro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class BatterEntity {
	int id;
	String type;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int batter_id;
	@ManyToOne
	BattersEntity b_item;

	public BatterEntity(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public BattersEntity getBatters() {
		return b_item;
	}

	public void setBatters(BattersEntity item) {
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
	
	public BatterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
