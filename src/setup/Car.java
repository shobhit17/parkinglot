package setup;

public class Car extends Vehical{
	@Override
	public String toString() {
		return "Car [rNo=" + rNo + ", color=" + color + "]";
	}
	public Car(String rNo, String color) {
		super(rNo, color);
	}
}
