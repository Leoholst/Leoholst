import java.util.Scanner;

public class JavaPhysicsLibrary {
	
	static double G = 6.67 * Math.pow(10, -11);
	static double R = 8.3144621;
	static double p_0 = 1013.25;
	static double c = 299792458;
	static double g_swe = 9.82;
	
	// All units are determined in SI-units, if nothing else is stated.
	
	public static void main(String[] args) {
		//Question 1: 60 cubic decimeter = 0,06 cubic meter
		System.out.println(volumeToMass(SolidTable.IRON, 0.06));
		//Question 2: Tomas is running with 2,7m/s in 50 minutes(50 minutes = 3000 seconds).
		System.out.println(svtDistance(2.7, 3000));
		//Question 3: How much energy is needed to heat 4 liters (4 liters = 4 kg) of water from 22 degrees to the boiling point, which is 100 degrees.
		System.out.println(heat(FluidTable.WATER, 4, 78));
		//Question 4: What is the pressure 75 meters under the surface.
		System.out.println(pressureUnderWater(75));
		//Question 5: Tomas throws a ball with the velocity 60 km/h or 16,666...7 m/s.
		System.out.println(velocityToHeight(16.6666666667));
		//Question 6: How much power is needed for a car with the mass 735kg to drive from 0 to 100km/h in 4.8s?
		System.out.println(powerFV(4253.47, 27.777));
		//Question 7: 
		System.out.println();
	}
	
	/** Method 1
	 * This method converts Fahrenheit to Celsius.
	 * @param fahrenheit (F)
	 * @return
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (9 * fahrenheit /5 + 32);
	}
	
	/** Method 2
	 * This method converts Kelvin to Celsuis.
	 * @param kelvin (K)
	 * @return
	 */
	public static double kelvinToCelsius(double kelvin) {
		return (kelvin - 273.15);
	}
	
	/** Method 3
	 *  This method calculates the fluid pressure on a fluid by a deep.
	 * @param fluid The fluid substance
	 * @param deep Meter (m)
	 * @return
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		return (fluid.density * g_swe * deep);
	}
	
	/** Method 4
	 *  This method calculates the pressure under water by a specific deep.
	 * @param deep Meter (m)
	 * @return
	 */
	public static double pressureUnderWater(double deep) {
		return (FluidTable.WATER.density * g_swe * deep);
	}
	
	/** Method 5
	 *  This method uses the formula for kinetic energy to calculate the impetus.  
	 * @param mass kilogram (kg)
	 * @param velocity Meter/Second (m/s)
	 * @return
	 */
	public static double kineticEnergy(double mass, double velocity) {
		return ((mass * Math.pow(velocity, 2)) / 2);
	}
	
	/** Method 6
	 *  This method uses the formula for potential energy to calculate the impetus.
	 * @param mass Kilogram (kg)
	 * @param height Meter (m)
	 * @return
	 */
	public static double potentialEnergy(double mass, double height) {
		return (mass * g_swe * height);
	}
	
	/** Method 7
	 *  The method calculates the speed when falling from a specific height.
	 * @param height meter (m)
	 * @return
	 */
	public static double fallSpeed(double height) {
		return (Math.sqrt(2*g_swe*height));
	}
	
	/** Method 8
	 *  The method determines delta, which is the difference between two numbers.
	 * @param first The first number
	 * @param last The last number
	 * @return
	 */
	public static double delta(double first, double last) {
		return (last - first);
	}
	
	/** Method 9
	 *  This method converts a fluids volume to mass.
	 * @param fluid The fluid substance
	 * @param volume cubic meter (Math.pow(meter,3))
	 * @return
	 */
	public static double volumeToMass(FluidTable fluid, double volume) {
		return (fluid.density * volume);
	}
	
	/** Method 10
	 *  The method converts the volume of a gas to mass.
	 * @param gas The Gas substance
	 * @param volume cubic meter (Math.pow(meter,3)
	 * @return
	 */
	public static double volumeToMass(GasTable gas, double volume) {
		return (gas.density * volume);
	}
	
	/** Method 11
	 *  The method converts the volume of a solid substance to mass.
	 * @param solid The solid substance
	 * @param volume cubic meter (Math.pow(meter,3))
	 * @return
	 */
	public static double volumeToMass(SolidTable solid, double volume) {
		return (solid.density * volume);
	}
	
	/** Method 12
	 *  The method calculates velocity through the svt formula.
	 * @param distance Meter (m)
	 * @param time Second (s)
	 * @return
	 */
	public static double svtVelocity(double distance, double time) {
		return (distance / time);
	}
	
	/** Method 13
	 *  The method calculates distance through the svt formula.
	 * @param velocity Meter/Second (m/s)
	 * @param time Second (s)
	 * @return
	 */
	public static double svtDistance(double velocity, double time) {
		return (velocity * time);
	}
	
	/** Method 14
	 *  The method calculates Time through the svt formula.
	 * @param distance Meter (m)
	 * @param velocity Meter/Second (m/s)
	 * @return
	 */
	public static double svtTime(double distance, double velocity) {
		return (velocity / distance);
	}
	
	/** Method 15
	 *  The method calculate work through wfs formula.
	 * @param force Newton (N)
	 * @param distance Meter (m)
	 * @return
	 */
	public static double work(double force, double distance) {
		return (force * distance);
	}
	
	/** Method 16
	 *  This method calculates power through dividing work by time.
	 * @param work NewtonMeter (Nm)
	 * @param time Second (s)
	 * @return
	 */
	public static double power(double work, double time) {
		return (work / time);
	}
	
	/** Method 17
	 *  The method determines the heat of a solid substance by calculating the heat capacity of the substance, times the mass, times delta temperature.
	 * @param solid The solid Substance
	 * @param mass kilogram (kg)
	 * @param deltaT The difference in temperature in degrees (C)
	 * @return
	 */
	public static double heat(SolidTable solid, double mass, double deltaT) {
		return (solid.heatCapacity * mass * deltaT);
	}
	
	/** Method 18
	 * The method determines the heat of a fluid substance by calculating the heat capacity of the substance, times the mass, times delta temperature.
	 * @param fluid The fluid substance
	 * @param mass kilogram (kg)
	 * @param deltaT The difference in temperature in degrees (C)
	 * @return
	 */
	public static double heat(FluidTable fluid, double mass, double deltaT) {
		return (fluid.heatCapacity * mass * deltaT);
	}
	
	/** Method 19
	 *  The method determines the heat of a gas substance by calculating the heat capacity of the substance, times the mass, times delta temperature.
	 * @param gas The gas substance
	 * @param mass kilogram (kg)
	 * @param deltaT The difference in temperature in degrees (C)
	 * @return
	 */
	public static double heat(GasTable gas, double mass, double deltaT) {
		return (gas.heatCapacity * mass * deltaT);
	}
	
	/** Method 20
	 *  This method calculates how high an object with an velocity reaches.
	 * @param velocity Meter/Second (m/s)
	 * @return
	 */
	public static double velocityToHeight(double velocity) {
		return (Math.pow(Math.sin(1.57079633), 2) * Math.pow(velocity, 2)/ (2 * g_swe));
	}
	
	/** Method 21
	 *  This method calculates acceleration by dividing velocity with time.
	 * @param velocity Meter/Second (m/s)
	 * @param time Second (s)
	 * @return
	 */
	public static double acceleration(double velocity, double time) {
		return (velocity/time);
	}
	
	/** Method 22
	 *  This method calculates power through mass times acceleration.
	 * @param mass Kilogram (kg)
	 * @param acceleration Math.pow(Meter/Second, 2) (Math.pow(m/s, 2))
	 * @return
	 */
	public static double forceMA(double mass, double acceleration) {
		return (mass * acceleration);
	}
	
	/** Method 23
	 *  This method calculates Power through force times velocity.
	 * @param force Newton (N)
	 * @param velocity Meter/Second (m/s)
	 * @return
	 */
	public static double powerFV(double force, double velocity) {
		return (force * velocity);
	}
}