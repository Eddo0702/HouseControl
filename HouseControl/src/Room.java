import java.util.ArrayList;

/**
 *
 * @author eduardo.perez
 */
public class Room {
	private ArrayList<Device> devices;
	private String name;

	public Room(String name, ArrayList<Device> devices) {
		this.name = name;
		this.devices = devices;
	}

	public Room(String name) {
		this.devices = new ArrayList<Device>();
		this.name = name;

	}

	/**
	 * Adds a device to the array labeled devices.
	 * @param	device	The device to add.
	 */
	public void addDevice(Device device) {
		devices.add(device);
	}
	
	/**
	 * removes a device from the array labeled devices.
	 * @param	device	The device to add.
	 */
	public boolean removeDevice(Device device) {
		return devices.remove(device);
	}

	/**
	 * @return	devices	The array containing all the devices in the room.
	 */
	public ArrayList<Device> getDevices() {
		return devices;
	}

	/**
	 * Replaces the devices in this room with a new list of devices.
	 * @param devices The new list of devices.
	 */
	public void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}

	/**
	 * Returns the name of the room. Said name is often used as an identifier so the room can be tracked.
	 * @return	name	The name of the room.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the room. Said name is often used as an identifier so the room can be tracked.
	 * @param	name	The name of the room.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the Information of the room. This is often used for display purposes.
	 * @return	String	A String containing the name of the room followed by a list of the devices in the room.
	 */
	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < this.devices.size(); i++) {
			output = output + devices.get(i).toString() + "\n";
		}
		return output;
	}

	/**
	 * The current amount of devices in the room.
	 * @return	Integer	The size of the array of devices.
	 */
	public int getDeviceCounter() {
		return devices.size();
	}
	
	/**
	 * The current amount of devices turned on in the room.
	 * @return	devicesOn	The number of devices where the status is True.
	 */
	public int countDevicesOn () {
		int devicesOn = 0;
		int numberOfDevices = getDeviceCounter();
		for (int i = 0; i < numberOfDevices; i++) {
			if (devices.get(i).isOn()) {
				devicesOn++;
			}
		}
		return devicesOn;
	}
	
	/**
	 * The current amount of devices that have a certain name.
	 * @param	name	The name of the device to count.
	 * @return	deviceCount	The number of devices found which have the name specified as parameter.
	 */
	public int countSpecificDevices (String name) {
		int deviceCount = 0;
		int numberOfDevices = getDeviceCounter();
		for (int i = 0; i < numberOfDevices; i++) {
			if (devices.get(i).getName().equals(name)) {
				deviceCount++;
			}
		}
		return deviceCount;
	}
	
	/**
	 * Switch the status from On to Off and vice versa to devices that have a certain name.
	 * @param	name	The name of the device to toggle.
	 * @return	toggled	True if at least one device was toggled False if no device was toggled.
	 */
	public boolean toggleSpecificDevice(String name) {
		boolean toggled = false;
		int numberOfDevices = getDeviceCounter();
		for (int i = 0; i < numberOfDevices; i++) {
			if (devices.get(i).getName().equals(name)) {
				devices.get(i).toggleDevice();
				toggled = true;
			}
		}
		return toggled;
	}

	/**
	 * Loops trough the array to find the given device.
	 * @param	device	The device we want to find in the room.
	 * @return	position	The position in the array of the device. If the device was not found returns -1.
	 */
	public int searchDevice(Device device) {
		int position = -1;
		for (int index = 0; index < getDeviceCounter(); index++) {
			if (devices.get(index).equals(device)) {
				position = index;
				break;
			}
		}
		return position;
	}

	/**
	 * Turns off All the devices in the room
	 */
	public void switchOffAllDevices() {
		for (int index = 0; index < getDeviceCounter(); index++) {
			devices.get(index).switchOffDevice();
		}
	}

	/**
	 * Turns on All the devices in the room
	 */
	public void switchOnAllDevices() {
		for (int index = 0; index < getDeviceCounter(); index++) {
			devices.get(index).switchOnDevice();
		}
	}
	
	/**
	 * Turn off all the devices that have a certain name.
	 * @param	name	The name of the device to turn off.
	 */
	public void swithcOffDevicesByName(String name) {
		int numberOfDevices = devices.size();
		for (int i = 0; i < numberOfDevices; i++) {
			if (devices.get(i).getName().equals(name)) {
				devices.get(i).switchOffDevice();
			}
		}
	}

	/**
	 * Compares the room to another object.
	 * @param	obj		The object to to compare to.
	 * @return	boolean	The result of the comparison. True if both objects are equal. False if they are not.
	 */
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof Room && obj != null) {
			Room otherRoom = (Room) obj;
			if (this.name == otherRoom.name) {
				flag = true;
			}
		}
		return flag;
	}

}
