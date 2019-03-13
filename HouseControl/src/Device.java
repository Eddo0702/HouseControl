
/**
 * 
 * @author eduardo.perez
 */
public class Device {

	private String name;
	private String brand;
	private String model;
	private boolean status;

	
	public Device(String name, String brand, String model, boolean status) {
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.status = status;
	}

	/**
	 * Returns the name of the device. Said name is often used as an identifier so the device can be tracked.
	 * @return	name	The name of the device
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the device. Said name is often used as an identifier so the device can be tracked
	 * @param	name	The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the brand of the device. Said brand let us categorize certain types of devices.
	 * @return	brand	The brand of the device. Also Known as the provider.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand of the device. Said brand let us categorize certain types of devices.
	 * @param	brand	The brand of the device. Also known as the provider.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Returns the model of the device. Said model let us compare devices among the same kind.
	 * @return	model	The model of the device. Also known as the version.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the device. Said model let us compare devices among the same kind.
	 * @param	model	The model of the device. Also known as the version.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Returns the status of the device. The status is used to identify if the device is On or is Off.
	 * @return	status	The status of the device. If true the device is On. If False the device is Off.
	 */
	public boolean isOn() {
		return status;
	}

	/**
	 * Sets the status of the device. The status is used to identify if the device is On or is Off.
	 * @param	status	The status of the device. If true the device is On. If False the device is Off.
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Returns the Information of the device. This is often used for display purposes.
	 * @return	String	A String containing the name, brand, model, and the status of the device, separated by blank spaces.
	 */
	public String toString() {
		return name + " " + brand + " " + model + " " + status;
	}

	/**
	 * Compares the device to another object.
	 * @param	obj		The object to to compare to.
	 * @return	boolean	The result of the comparison. True if both objects are equal. False if they are not.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Device && obj != null) {
			Device otherDevice = (Device) obj;
			if (isEqualTo(otherDevice)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compares the device to another device.
	 * @param	device	The device to to compare to.
	 * @return	boolean	The result of the comparison. True if the name, model and brand are equal between both devices.
	 * 					False if name, model or brand are different between both devices.
	 */
	private boolean isEqualTo(Device device) {
		boolean isSameName = this.name == device.name;
		boolean isSameBrand = this.brand == device.brand;
		boolean isSameModel = this.model == device.model;
		
		return isSameName && isSameBrand && isSameModel;
	}

	/**
	 * Switch the status of the device from On to Off and vice versa.
	 * @return	boolean	True if the device toggled from Off to On. False if the device toggled from On to Off.
	 */
	public boolean toggleDevice() {
		this.status = !(this.status);
		return status;
	}

	/**
	 * Turns off the device
	 */
	public boolean switchOffDevice() {
		status = false;
		return status;
	}

	/**
	 * Turns on the device
	 */
	public boolean switchOnDevice() {
		status = true;
		return status;
	}

}
