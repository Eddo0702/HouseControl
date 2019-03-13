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
	
	/**
	 * Adds a room to the array labeled rooms.
	 * @param	room	The room to add.
	 */
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	/**
	 * removes a room from the array labeled rooms.
	 * @param	room	The room to remove.
	 */
	public boolean removeRoom(Room room) {
		return rooms.remove(room);
	}

	/**
	 * The current amount of rooms in the level.
	 * @return	Integer	The size of the array of devices.
	 */
	public int getRoomCounter() {
		return rooms.size();
	}

	/**
	 * @return	rooms	The array containing all the rooms in the level.
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	/**
	 * Replaces the rooms in this level with a new list of rooms.
	 * @param rooms The new list of rooms.
	 */
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Returns the name of the level. Said name is often used as an identifier so the level can be tracked.
	 * @return	name	The name of the level.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the level. Said name is often used as an identifier so the level can be tracked.
	 * @param	name	The name of the level.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Loops trough the array to find the given room.
	 * @param	room	The room we want to find in the room.
	 * @return	position	The position in the array of the room. If the room was no found returns -1.
	 */
	public int searchRoom(Room room) {
		int position = 0;
		for (int index = 0; index < rooms.size(); index++) {
			if (rooms.get(index).equals(room)) {
				position = index;
				break;
			}
		}
		return position;
	}
	
	/**
	 * The current amount of devices turned on in the level.
	 * @return	devicesOn	The number of devices where the status is True.
	 */
	public int countDevicesOn() {
		int devicesOn = 0;
		int numberOfRooms = getRoomCounter();
		for (int i = 0; i < numberOfRooms; i++) {
			devicesOn += rooms.get(i).countDevicesOn();
		}
		return devicesOn;
	}
	
	/**
	 * The current amount of devices that have a certain name.
	 * @param	name	The name of the device to count.
	 * @return	deviceCount	The number of devices found which have the name specified as parameter.
	 */
	public int countSpecificDevices(String name) {
		int deviceCount = 0;
		int numberOfRooms = getRoomCounter();
		for (int i = 0; i < numberOfRooms; i++) {
			deviceCount += rooms.get(i).countSpecificDevices(name);
		}
		return deviceCount;
	}
	
	/**
	 * Switch the status from On to Off and vice versa to devices that have a certain name.
	 * @param	name	The name of the device to toggle.
	 * @return	toggled	True if at least one device was toggled False if no device was toggled.
	 */
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

	/**
	 * Returns the Information of the level. This is often used for display purposes.
	 * @return	String	A String containing the name of the room followed by a list of the rooms in the level with their respective devices.
	 */
	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < rooms.size(); i++) {
			output = output + rooms.get(i).toString() + "\n";
		}
		return output;
	}

	/**
	 * Turns off All the devices in the level
	 */
	public void switchOffAllRooms() {
		for (int index = 0; index < getRoomCounter(); index++) {
			rooms.get(index).switchOffAllDevices();
		}
	}

	/**
	 * Turns on All the devices in the level
	 */
	public void switchOnAllRooms() {
		for (int index = 0; index < getRoomCounter(); index++) {
			rooms.get(index).switchOnAllDevices();
		}
	}

	/**
	 * Turns off All the devices in a given room of this level
	 * @param	room	The room which its devices will turn off.
	 * @return	boolean	True if the room given room exist in this level False if the room was not found in this level.
	 */
	public boolean switchOffRoom(Room room) {
		int index;
		index = this.searchRoom(room);
		if (index > -1) {
			rooms.get(index).switchOffAllDevices();
			return true;
		}
		return false;
	}
	
	/**
	 * Turns on All the devices in a given room of this level
	 * @param	room	The room which its devices will turn on.
	 * @return	boolean	True if the given room exist in this level False if the room was not found in this level.
	 */
	public boolean switchOnRoom(Room room) {
		int index;
		index = this.searchRoom(room);
		if (index > -1) {
			rooms.get(index).switchOnAllDevices();
			return true;
		}
		return false; 
	}

	/**
	 * Turns on or off a given device in a given room within this level
	 * @param	room	The room which contains the device that will be switched.
	 * @param	device	The device which will be switched.
	 * @param	setOn	the status of the device True for On and False for Off.
	 * @return	boolean	True if the given device exist in this level False if the level was not found in this level.
	 */
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
	
	/**
	 * Search for a given device within a given room
	 * @param	room	The room which contains the device.
	 * @param	device	The device the be found.
	 * @return	Device	The device contained in the given room. NUll if neither the room nor the device where found.
	 */
	
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
	
	/**
	 * Turn off all the devices that have a certain name.
	 * @param	name	The name of the device to turn off.
	 */

	public void switchOffDevicesByName(String name) {
		int numberOfRooms = rooms.size();
		for (int i = 0; i < numberOfRooms; i++) {
			rooms.get(i).swithcOffDevicesByName(name);
		}
	}
	
	/**
	 * Compares the level to another object.
	 * @param	obj		The object to to compare to.
	 * @return	boolean	The result of the comparison. True if both objects are equal. False if they are not.
	 */

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
