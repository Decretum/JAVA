
public class CargoAircraft extends Aircraft {

	private static double length;//meter
	private static double height;//meter
	private static double width;//meter
	private static double cargoArea;//cubic meter

	public CargoAircraft(double length, double height, double width) {
		super();
		this.length = length;
		this.height = height;
		this.width = width;
		calculateCargoArea();
	}

	public static void calculateCargoArea() {
		cargoArea = length * height * width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	public String toString() {
		String s = super.toString() + "\ncargoArea=" + cargoArea + "\n";
		return s;
	}

}