import java.util.ArrayList;

/**
 *
 * @author eduardo.perez
 */
public class DeviceParsing {
    ArrayList<Device> devices;
    String content;
    
    public DeviceParsing(){
        this.devices = new ArrayList<Device>();

    }
    
    /**
	 * Reads the content of Devices.text and sets it to content
	 */
    public void getString(){
        content = new FileReader("Devices.txt").getContentFile();
    }
    
    /**
	 * Separates content by each instance of a comma.
	 * @return	parsing	The content converted to an array 	
	 */
    public String[] parsingContent(){
        
        String[] parsing= content.split(",");
        return parsing;
    }
    
    /**
	 * Creates devices and sets them to the list of devices called devices 
	 * @param	parsing	The list of device attributes each type of attribute repeats every three elements of the array,
	 * 					first name, then brand, and finally model.  
	 */
    public void setDevices(String[] parsing){
        for(int i = 0; i<parsing.length; i=i+2){
            devices.add(new Device(parsing[i], parsing[i+1], parsing[i+2], true));
        }
    }
}
