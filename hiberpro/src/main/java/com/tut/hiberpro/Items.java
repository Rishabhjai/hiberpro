package com.tut.hiberpro;

import java.util.ArrayList;

public class Items {
	ArrayList<Item> item;

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	@Override
    public String toString() {
        return 
                "items:" + item
                ;
    }
	
	

}
