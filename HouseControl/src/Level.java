import java.util.ArrayList;

/**
 *
 * @author edgar.cambranes
 */
public class Level {
	private String name;
	private ArrayList<Room> rooms;

	public Level(String name, ArrayList<Room> rooms) {
		this.name = name;
		this.rooms = rooms;
	}

	public Level(String name) {
		this.name = name;
		this.rooms = new ArrayList<Room>();
	}

	public int getCounterRooms(ArrayList<Room> rooms) {
		return rooms.size();
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	/**
	 * @return the roomCounter
	 */
	public int getRoomCounter() {
		return rooms.size();
	}

	/**
	 * @return the rooms
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
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

	public int searchRoom(Room otherRoom) {
		int position = 0;
		for (int index = 0; index < rooms.size(); index++) {
			if (rooms.get(index).equals(otherRoom)) {
				position = index;
				break;
			}
		}
		return position;
	}

	public boolean removeRoom(Room room) {
		return rooms.remove(room);
	}
	
	public int countDevicesOn() {
		int devicesOn = 0;
		int numberOfRooms = getRoomCounter();
		for (int i = 0; i < numberOfRooms; i++) {
			devicesOn += rooms.get(i).countDevicesOn();
		}
		return devicesOn;
	}
	
	public int countSpecificDevices(String name) {
		int deviceCount = 0;
		int numberOfRooms = getRoomCounter();
		for (int i = 0; i < numberOfRooms; i++) {
			deviceCount += rooms.get(i).countSpecificDevices(name);
		}
		return deviceCount;
	}
	
	public boolean toggleSpecificDevice (String name) {
		boolean toogled = false;
		int numberOfRooms = getRoomCounter();
		for (int i = 0; i < numberOfRooms; i++) {
			if (rooms.get(i).toggleSpecificDevice(name)) {
				toogled = true;
			}
		}
		return toogled;
	}

	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < rooms.size(); i++) {
			output = output + rooms.get(i).toString() + "\n";
		}
		return output;
	}

	public void switchOffAllRooms() {
		for (int index = 0; index < getRoomCounter(); index++) {
			rooms.get(index).switchOffAllDevices();
		}
	}

	public void switchOnAllRooms() {
		for (int index = 0; index < getRoomCounter(); index++) {
			rooms.get(index).switchOnAllDevices();
		}
	}

	public boolean switchOffRoom(Room room) {
		int index;
		index = this.searchRoom(room);
		if (index > -1) {
			rooms.get(index).switchOffAllDevices();
			return true;
		}
		return false;
	}
	
	public boolean switchOnRoom(Room room) {
		int index;
		index = this.searchRoom(room);
		if (index > -1) {
			rooms.get(index).switchOnAllDevices();
			return true;
		}
		return false; 
	}

	public boolean levelSwitchDevice(Room room, Device device, boolean setOn) {
		Device roomDevice = getRoomDevice(room, device);
		if (roomDevice ==  null)
			return false;

		if (setOn)
			roomDevice.switchOnDevice();
		else
			roomDevice.switchOffDevice();
		
		return true;
	}
	
	private Device getRoomDevice(Room room, Device device) {
		int lRoom = this.searchRoom(room);
		if (lRoom > -1) {
			ArrayList<Device> devices;
			devices = rooms.get(lRoom).getDevices();
			int lDevice = rooms.get(lRoom).searchDevice(device);
			
			if (lDevice > -1)
				return devices.get(lDevice);
		}

		return null;
	}

	public void switchOffDevicesByName(String name) {
		int numberOfRooms = rooms.size();
		for (int i = 0; i < numberOfRooms; i++) {
			rooms.get(i).swithcOffDevicesByName(name);
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Level && obj != null) {
			Level otherDevice = (Level) obj;
			if (this.name == otherDevice.name) {
				return true;
			}
		}
		return false;
	}

}
