import java.util.ArrayList;

/**
 *
 * @author edgar.cambranes
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

	public void addLevel(Level level) {
		levels.add(level);
	}

	public int getLevelCounter(ArrayList<Level> levels) {
		return levels.size();
	}

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

	public int countDevicesOn() {
		int devicesOn = 0;
		for (int i = 0; i < levels.size(); i++) {
			devicesOn += levels.get(i).countDevicesOn();
		}
		return devicesOn;
	}

	public int countSpecificDevice(String name) {
		int devices = 0;
		for (int i = 0; i < levels.size(); i++) {
			devices += levels.get(i).countSpecificDevices(name);
		}
		return devices;
	}

	public boolean toogleSpecificDeviceLevel(String level, String device) {
		boolean flag = false;
		int levelIndex = searchLevel(level);
		
		if (levelIndex < 0) {
			flag = false;
		}else{
			ArrayList<Room> rooms = levels.get(levelIndex).getRooms();
			int counterRooms = levels.get(levelIndex).getCounterRooms(rooms);
			for (int i = 0; i < counterRooms; i++) {
				ArrayList<Device> devices = rooms.get(i).getDevices();
				int counterDevices = rooms.get(i).getDeviceCounter();
				for (int j = 0; j < counterDevices; j++) {
					if (devices.get(j).getName().equals(name)) {
						devices.get(j).toggleDevice();
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	
	

	public String toString() {
		String output = "";
		output = output + name + "\n";
		for (int i = 0; i < levels.size(); i++) {
			output = output + levels.get(i).toString() + "\n";
		}
		return output;
	}

}
