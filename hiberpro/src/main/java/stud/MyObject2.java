package stud;
class MyObject2 {
	String type;
	
	String name;
	double ppu;
	public String getType() {
		return type;
	}
//
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
//
	public void setName(String name) {
		this.name = name;
	}
//
	public double getPpu() {
		return ppu;
	}
//
	public void setPpu(double ppu) {
		this.ppu = ppu;
	}
	
	@Override
    public String toString() {
        return type+name+ppu+
//                ", lastName='" + lastName + '\'' +
                '}';
    }
}