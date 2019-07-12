package setup;

public abstract class Vehical {
	String rNo;
	String color;
	public String getrNo() {
		return rNo;
	}
	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		return "Vehical [rNo=" + rNo + ", color=" + color + "]";
	}
	public Vehical(String rNo, String color) {
		super();
		this.rNo = rNo;
		this.color = color;
	}
	
}
