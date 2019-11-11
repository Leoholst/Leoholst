import java.util.Scanner;

public class JavaPhysicsLibrary {
	
	static double G = 9.82;
	static double R = 8.3144621;
	static double p_0 = 1013.25;
	static double c = 299792458;
	static double g_swe = 9.82;
	
	public static void main(String[] args) {
		System.out.println(fahrenheitToCelsius(2));
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
	return (9 * fahrenheit /5 + 32);
	//fahrenheitToCelsius(50) => 10
	}
	
	public static double kelvinToCelsius(double kelvin) {
	//kelvinToCelsius(0) => -273.15
	}
	
	public static double fluidPressure(FluidTable fluid, double deep) {
	//fluidPressure(FluidTable.WATER, 10) => 98003,6
	}
	
	public static double pressureUnderWater(double deep) {
	pressureUnderWater(10) => 98003,6
	}
	
	public static double kineticEnergy(double mass, double velocity) {
	kineticEnergy(2,2) => 4
	}
	
	public static double potentialEnergy(double mass, double height) {
	potentialEnergy(2,5) => 98.2
	}
	
	public static double fallSpeed(double height) {
	//fallSpeed(2.5) => 7,00713922
	}
	
	public static double delta(double first, double last) {
	//delta(1,10) => 9
	//delta(5,1) => -4
	}
	
	public static double volumeToMass(FluidTable fluid, double volume) {
	//volumeToMass(FluidTable.WATER,1) => 998
	}
	
	public static double volumeToMass(GasTable gas, double volume) {
	//volumeToMass(GasTable.AIR,1) => 1.29
	}
	
	double volumeToMass(SolidTable solid, double volume) {
	//volumeToMass(SolidTable.IRON,1) => 7870
	}
	
	public static double svtVelocity(double distance, double time) {
	//svtVelocity(10,5) => 2
	}
	
	public static double svtDistance(double velocity, double time) {
	//svtDistance(10,5) => 50
	}
	
	public static double svtTime(double distance, double velocity) {
	//svtTime(10,2) => 5
	}
	
	public static double work(double force, double distance) {
	//work(50,10) => 500
	}
	
	double power(double work, double time) {
	//power(1000,2) => 500
	}
	
	public static double heat(SolidTable solid, double mass, double deltaT) {
	//heat(SolidTable.IRON,1,2) => 900
	}
	
	public static double heat(FluidTable fluid, double mass, double deltaT) {
	//heat(FluidTable.WATER,1,10) => 41900
	}
	
	public static double heat(GasTable gas, double mass, double deltaT) {
	//heat(GasTable.AIR,1,1) => 1010
	}
	
	public static double velocityToHeight(double velocity) {
	//velocityToHeight(9.82) => 4.91
	}
}