package main.java.NarasimhaKarumanchi.java;

public class TwoWheelerFourWheelerCalculator {
	
	public void noOfTwoWheelerFourWheeler(int veh, int wh) {
		
		if(wh < 2 || (wh % 2) != 0 || veh > wh) {
			System.out.println("Invalid input");
		} else {
			int tw = ((4 * veh) - wh) / 2;
			int fw = veh - tw;
			
			System.out.println("Two wheelers : " + tw + ", four wheelers : " + fw);
		}
		
		
	}
	public static void main(String[] args) {
		int veh = 460;
		int wh = 1600;
		System.out.println("Given vehicles : " + veh);
		System.out.println("Given wheels: " + wh);
		
		TwoWheelerFourWheelerCalculator mainClass = new TwoWheelerFourWheelerCalculator();
		mainClass.noOfTwoWheelerFourWheeler(veh, wh);
	}

}
