package setup;
public class CarParkingSpace extends ParkingSpace {

	public CarParkingSpace(int size) {
		super(size);
		for (int i = 0; i < this.size; i++) {
			this.parkingSpace.add(i, new CarParkingSpot("" + i));
		}
	}

	public ParkingSpot park(String rNo, String color) throws Exception {
		Car car = new Car(rNo, color);
		return super.park(car);
	}

}
