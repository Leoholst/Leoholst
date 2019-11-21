import java.util.Scanner;

public class JavaPhysicsLibrary {
	
	static double G = 6.67 * Math.pow(10, -11);
	static double R = 8.3144621;
	static double p_0 = 1013.25;
	static double c = 299792458;
	static double g_swe = 9.82;
	
	public static void main(String[] args) {
		
	}
	
	/** Method 1
	 * This method converts fahrenheit to celsius.
	 * @param fahrenheit
	 * @return
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (9 * fahrenheit /5 + 32);
	}
	
	/** Method 2
	 * This method converts kelvin to celsuis.
	 * @param kelvin
	 * @return
	 */
	public static double kelvinToCelsius(double kelvin) {
		return (kelvin - 273.15);
	}
	
	/** Method 3
	 *  This method calculates the fluidpressure on a fluid by a deep.
	 * @param fluid
	 * @param deep
	 * @return
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		return (fluid.density * g_swe * deep);
	}
	
	/** Method 4
	 *  This method calculates the pressure under water by a specific deep.
	 * @param deep
	 * @return
	 */
	public static double pressureUnderWater(double deep) {
		return (FluidTable.WATER.density * g_swe * deep);
	}
	
	/** Method 5
	 *  This method uses the formula for kinetic energy to calculate the impetus.  
	 * @param mass
	 * @param velocity
	 * @return
	 */
	public static double kineticEnergy(double mass, double velocity) {
		return ((mass * Math.pow(velocity, 2)) / 2);
	}
	
	/** Method 6
	 *  This method uses the formula for potential energy to calculate the impetus.
	 * @param mass
	 * @param height
	 * @return
	 */
	public static double potentialEnergy(double mass, double height) {
		return (mass * g_swe * height);
	}
	
	/** Method 7
	 *  The method calculates the speed when falling from a specific height.
	 * @param height
	 * @return
	 */
	public static double fallSpeed(double height) {
		return (Math.sqrt(2*g_swe*height));
	}
	
	/** Method 8
	 *  The method determines delta.
	 * @param first
	 * @param last
	 * @return
	 */
	public static double delta(double first, double last) {
		return (last - first);
	}
	
	/** Method 9
	 *  This method converts a fluids volume to mass.
	 * @param fluid
	 * @param volume
	 * @return
	 */
	public static double volumeToMass(FluidTable fluid, double volume) {
		return (fluid.density * volume);
	}
	
	/** Method 10
	 *  The method converts the volume of a gas to mass.
	 * @param gas
	 * @param volume
	 * @return
	 */
	public static double volumeToMass(GasTable gas, double volume) {
		return (gas.density * volume);
	}
	
	/** Method 11
	 *  The method converts the volume of a solid substance to mass.
	 * @param solid
	 * @param volume
	 * @return
	 */
	public static double volumeToMass(SolidTable solid, double volume) {
		return (solid.density * volume);
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
		return (force * distance);
	//work(50,10) => 500
	}
	
	
	public static double power(double work, double time) {
		return (work / time);
	//power(1000,2) => 500
	}
	
	
	public static double heat(SolidTable solid, double mass, double deltaT) {
		return (solid.heatCapacity * mass * deltaT);
	//heat(SolidTable.IRON,1,2) => 900
	}
	
	
	public static double heat(FluidTable fluid, double mass, double deltaT) {
		return (fluid.heatCapacity * mass * deltaT);
	//heat(FluidTable.WATER,1,10) => 41900
	}
	
	
	public static double heat(GasTable gas, double mass, double deltaT) {
		return (gas.heatCapacity * mass * deltaT);
	//heat(GasTable.AIR,1,1) => 1010
	}
	
	
	public static double velocityToHeight(double velocity) {
		return (Math.pow(Math.sin(1.57079633), 2) * Math.pow(velocity, 2)/ (2 * g_swe));
	//velocityToHeight(9.82) => 4.91
	}
}