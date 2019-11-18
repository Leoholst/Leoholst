import java.util.Scanner;

public class JavaPhysicsLibrary {
	
	static double G = 6.67*Math.pow(10, -11);
	static double R = 8.3144621;
	static double p_0 = 1013.25;
	static double c = 299792458;
	static double g_swe = 9.82;
	
	public static void main(String[] args) {
		System.out.println(fahrenheitToCelsius(2));
		System.out.println(kelvinToCelsius(300));
		System.out.println(fluidPressure(FluidTable.WATER,10));
		System.out.println(pressureUnderWater(10));
		System.out.println(kineticEnergy(2,2));
		System.out.println(potentialEnergy(2,5));
		System.out.println(fallSpeed(2.5));
		System.out.println(delta(1,10));
		System.out.println(volumeToMass(FluidTable.WATER,1));
		System.out.println(volumeToMass(GasTable.AIR,1));
		System.out.println(volumeToMass(SolidTable.IRON,1));
		System.out.println(svtVelocity(10,5));
		System.out.println(svtDistance(10,5));
		System.out.println(svtTime(10,2));
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
	return (9 * fahrenheit /5 + 32);
	//fahrenheitToCelsius(50) => 10
	}
	
	public static double kelvinToCelsius(double kelvin) {
	return (kelvin - 273.15);
	//kelvinToCelsius(0) => -273.15
	}
	
	public static double fluidPressure(FluidTable fluid, double deep) {
	return (fluid.density * g_swe * deep);
	//fluidPressure(FluidTable.WATER, 10) => 98003,6
	}
	
	public static double pressureUnderWater(double deep) {
	return (FluidTable.WATER.density * g_swe * deep);
	//pressureUnderWater(10) => 98003,6
	}
	
	public static double kineticEnergy(double mass, double velocity) {
	return ((mass * Math.pow(velocity, 2)) / 2);
	//kineticEnergy(2,2) => 4
	}
	
	public static double potentialEnergy(double mass, double height) {
	return (mass * g_swe * height);
	//potentialEnergy(2,5) => 98.2
	}
	
	public static double fallSpeed(double height) {
	return (Math.sqrt(2*g_swe*height));
	//fallSpeed(2.5) => 7,00713922
	}
	
	public static double delta(double first, double last) {
	return (last - first);
	//delta(1,10) => 9
	//delta(5,1) => -4
	}
	
	public static double volumeToMass(FluidTable fluid, double volume) {
	return (fluid.density * volume);
	//volumeToMass(FluidTable.WATER,1) => 998
	}
	
	public static double volumeToMass(GasTable gas, double volume) {
	return (gas.density * volume);
	//volumeToMass(GasTable.AIR,1) => 1.29
	}
	
	public static double volumeToMass(SolidTable solid, double volume) {
	return (solid.density * volume);
	//volumeToMass(SolidTable.IRON,1) => 7870
	}
	
	public static double svtVelocity(double distance, double time) {
	return (distance / time);
	//svtVelocity(10,5) => 2
	}
	
	public static double svtDistance(double velocity, double time) {
	return (velocity * time);
	//svtDistance(10,5) => 50
	}
	
	public static double svtTime(double distance, double velocity) {
	return (velocity / distance);
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