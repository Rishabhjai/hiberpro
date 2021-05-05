package stud;

class Xyz {

	MyObject item;

	public MyObject getItem() {
		return item;
	}

	public void setItem(MyObject item) {
		this.item = item;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "user=" + item +
                '}';
    }
	
}
