package setup;

import java.util.HashMap;

public class ParkingLot {
	@Override
	public String toString() {
		return "ParkingLot [carParkingSpace=" + carParkingSpace
				+ ", parkingSpaceMapping=" + parkingSpaceMapping + "]";
	}

	private CarParkingSpace carParkingSpace;

	public ParkingLot(int n) {
		super();
		this.carParkingSpace = new CarParkingSpace(n);
		parkingSpaceMapping.put(VehicalType.Car, carParkingSpace);
	}

	private HashMap<VehicalType, ParkingSpace> parkingSpaceMapping = new HashMap<>();

	public ParkingSpace getParkingSpace(VehicalType type) throws Exception {
		ParkingSpace ps = parkingSpaceMapping.get(type);
		if (ps != null)
			return ps;
		else
			throw new Exception("Vehical type unknown");
	}
}
