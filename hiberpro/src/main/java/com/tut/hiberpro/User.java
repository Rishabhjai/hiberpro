package com.tut.hiberpro;
class User {
	Items items;
	
	@Override
    public String toString() {
        return "items=" + items;
    }

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	

}