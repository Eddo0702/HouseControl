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

	// searchRoom
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

	// removeRoom
	public boolean removeRoom(Room room) {
		return rooms.remove(room);
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

	public boolean levelSwitchOffDevice(Room room, Device device) {
		boolean found = true;
		
		Device roomDevice = getRoomDevice(room, device);
		if (roomDevice ==  null)
			found = false;
		else {
			roomDevice.switchOffDevice();
		}
		
		return found;
	}

	public boolean levelSwitchOnDevice(Room room, Device device) {
		boolean found = false;
		
		Device roomDevice = getRoomDevice(room, device);	
		if (roomDevice ==  null)
			found = false;
		else {
			roomDevice.switchOnDevice();
		}
		
		return found;
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

	public void switchAllOffSameDevices(String nameDevices) {// Nuevo
		for (int i = 0; i < rooms.size(); i++) {
			ArrayList<Device> devices = rooms.get(i).getDevices();
			for (int j = 0; j < rooms.get(i).getDeviceCounter(); j++) {
				if (devices.get(j).getName().equals(nameDevices)) {
					devices.get(j).switchOffDevice();
				}
			}
		}
	}

	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof Level && obj != null) {
			Level otherDevice = (Level) obj;
			if (this.name == otherDevice.name) {
				flag = true;
			}
		}
		return flag;
	}

}
