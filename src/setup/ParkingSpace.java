package setup;

import java.util.ArrayList;

public abstract class ParkingSpace {
	@Override
	public String toString() {
		return "ParkingSpace [size=" + size + ", parkingSpace=" + parkingSpace
				+ "]";
	}

	int size;
	ArrayList<ParkingSpot> parkingSpace;

	public ParkingSpace(int size) {
		super();
		this.size = size;
		this.parkingSpace = new ArrayList<ParkingSpot>(size);
		System.out.println("Parking space of size " + size + " created");
	}

	public abstract ParkingSpot park(String rNo, String color) throws Exception;

	protected ParkingSpot park(Vehical v) throws Exception {
		ParkingSpot spot = null;

		for (ParkingSpot p : this.parkingSpace) {
			if (p.isAvailable()) {
				spot = p;
				spot.setVehical(v);
				break;
			}
		}
		if (spot != null) {
			System.out.println(spot);
			return spot;
		} else
			throw new Exception("Parking full");
	}

	public Vehical emptyParkingSpot(String id) throws Exception {
		Vehical v = null;
		for (ParkingSpot p : this.parkingSpace) {
			if (p.getSpotID().equals(id)) {
				v = p.emptySpot();
				break;
			}
		}
		if (v != null)
			return v;
		else
			throw new Exception("Spot not found");
	}

	private String getVehicalsFromProperty(String color, String rNo) {
		ArrayList<ParkingSpot> ps = new ArrayList<>();
		for (ParkingSpot p : this.parkingSpace) {
			if (!p.isAvailable()) {
				Vehical v = p.getVehical();
				if (color == null && rNo == null)
					ps.add(p);
				else if (color != null && v.getColor().equals(color))
					ps.add(p);
				else if (rNo != null && v.getrNo().equals(rNo))
					ps.add(p);;
			}
		}
		return ps.toString();
	}

	public String getVehicalsWithColor(String color) throws Exception {
		if (color == null)
			throw new Exception("Color cannot be null");
		return getVehicalsFromProperty(color, null);
	}

	public String getVehicalsWithRNo(String rNo) throws Exception {
		if (rNo == null)
			throw new Exception("rNo cannot be null");
		return getVehicalsFromProperty(null, rNo);
	}

	public String getAllVehicals() {
		return getVehicalsFromProperty(null, null);
	}

}
