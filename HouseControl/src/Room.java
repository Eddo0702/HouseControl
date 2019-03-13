import java.util.ArrayList;

/**
 *
 * @author edgar.cambranes
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

	public void addDevice(Device device) {
		devices.add(device);
	}

	/**
	 * @return the devices
	 */
	public ArrayList<Device> getDevices() {
		return devices;
	}

	/**
	 * @param devices the devices to set
	 */
	public void setDevices(Device[] devices) {
		this.setDevices(devices);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < this.devices.size(); i++) {
			output = output + devices.get(i).toString() + "\n";
		}
		return output;
	}

	/**
	 * @return the deviceCounter
	 */
	public int getDeviceCounter() {
		return devices.size();
	}
	
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

	public int searchDevice(Device otherDevice) {
		int position = -1;
		for (int index = 0; index < getDeviceCounter(); index++) {
			if (devices.get(index).equals(otherDevice)) {
				position = index;
				break;
			}
		}
		return position;
	}

	public boolean removeDevice(Device device) {
		return devices.remove(device);
	}

	public void switchOffAllDevices() {
		for (int index = 0; index < getDeviceCounter(); index++) {
			devices.get(index).switchOffDevice();
		}
	}

	public void switchOnAllDevices() {
		for (int index = 0; index < getDeviceCounter(); index++) {
			devices.get(index).switchOnDevice();
		}
	}
	
	public void swithcOffDevicesByName(String name) {
		int numberOfDevices = devices.size();
		for (int i = 0; i < numberOfDevices; i++) {
			if (devices.get(i).getName().equals(name)) {
				devices.get(i).switchOffDevice();
			}
		}
	}

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
