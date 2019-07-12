package setup;

public abstract class ParkingSpot {
	private Vehical vehical;
	private String spotID;
	@Override
	public String toString() {
		return "ParkingSpot [vehical=" + vehical + ", spotID=" + spotID + "]";
	}
	public ParkingSpot(String spotID) {
		super();
		this.spotID = spotID;
		this.vehical = null;
	}
	public Vehical getVehical() {
		return vehical;
	}
	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}
	public String getSpotID() {
		return spotID;
	}
	public Vehical emptySpot() throws Exception{
		Vehical v = this.vehical;
		if(v==null) throw new Exception("Spot already empty");
		this.vehical = null;
		return v;
	}
	public boolean isAvailable(){
		return this.vehical == null;
	}
	
}
