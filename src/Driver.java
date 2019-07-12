import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import setup.CarParkingSpace;
import setup.ParkingLot;
import setup.VehicalType;

public class Driver {
	static ParkingLot pl;

	public static void executeFunction(String str) {
		try {
			String[] strSplit = str.split(" ");
			String cmd = strSplit[0];
			if (cmd.equalsIgnoreCase("createSpace")) {
				pl = new ParkingLot(Integer.parseInt(strSplit[1]));
			} else {
				CarParkingSpace cps = (CarParkingSpace) pl.getParkingSpace(VehicalType.Car);
				if (cmd.equalsIgnoreCase("park")) {
					cps.park(strSplit[1], strSplit[2]);
				} else if (cmd.equalsIgnoreCase("emptyParkingSpot")) {
					System.out.println(cps.emptyParkingSpot(strSplit[1]));
				} else if (cmd.equalsIgnoreCase("getAllVehicals")) {
					System.out.println(cps.getAllVehicals());
				} else if (cmd.equalsIgnoreCase("getVehicalsWithColor")) {
					System.out.println(cps.getVehicalsWithColor(strSplit[1]));
				} else if (cmd.equalsIgnoreCase("getVehicalsWithRNo")) {
					System.out.println(cps.getVehicalsWithRNo(strSplit[1]));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = bf.readLine();
			while (str != null) {
				executeFunction(str);
				str = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
