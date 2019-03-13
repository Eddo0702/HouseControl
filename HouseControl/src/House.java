import java.util.ArrayList;

/**
 *
 * @author eduardo.perez
 */
public class House {
	private ArrayList<Level> levels;
	private String name;

	public House(ArrayList<Level> levels, String name) {
		this.levels = levels;
		this.name = name;
	}

	public House(String name) {
		this.levels = new ArrayList<Level>();
		this.name = name;
	}

	/**
	 * Adds a level to the array labeled levels.
	 * @param	level	The level to add.
	 */
	public void addLevel(Level level) {
		levels.add(level);
	}

	/**
	 * The current amount of levels in the house.
	 * @return	Integer	The size of the array of levels.
	 */
	public int getLevelCounter(ArrayList<Level> levels) {
		return levels.size();
	}

	/**
	 * Loops trough the array to find the given room.
	 * @param	level	The level we want to find in the house.
	 * @return	position	The position in the array of the level. If the level was not found returns -1.
	 */
	public int searchLevel(String name) {
		int position = -1;
		for (int index = 0; index < levels.size(); index++) {
			if (levels.get(index).equals(new Level(name))) {
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
		for (int i = 0; i < levels.size(); i++) {
			devicesOn += levels.get(i).countDevicesOn();
		}
		return devicesOn;
	}

	/**
	 * The current amount of devices that have a certain name.
	 * @param	name	The name of the device to count.
	 * @return	deviceCount	The number of devices found which have the name specified as parameter.
	 */
	public int countSpecificDevice(String name) {
		int devices = 0;
		for (int i = 0; i < levels.size(); i++) {
			devices += levels.get(i).countSpecificDevices(name);
		}
		return devices;
	}

	/**
	 * Switch the status from On to Off and vice versa to devices that have a certain name in a given level.
	 * @param	level	The name of the level which contains the devices to toggle.
	 * @param	name	The name of the device to toggle.
	 * @return	boolean	True if at least one device was toggled or the level exists in the house.
	 * 			False if no device was toggled or the level was not found in the house.
	 */
	public boolean toggleSpecificDeviceLevel(String level, String device) {
		int levelIndex = searchLevel(level);
		
		if (levelIndex < 0) {
			return false;
		}
		
		return levels.get(levelIndex).toggleSpecificDevice(name);
	}
	
	/**
	 * Returns the Information of the house. This is often used for display purposes.
	 * @return	String	A String containing the name of the house followed by a list of the levels of the house with their respective rooms and devicess.
	 */
	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < levels.size(); i++) {
			output = output + levels.get(i).toString() + "\n";
		}
		return output;
	}

}
