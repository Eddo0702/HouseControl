import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar.cambranes
 */
public class FileReader {

	Scanner file;

	public FileReader(String path) {

		try {
			file = new Scanner(new File(path));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());
		}

	}

	public String getContentFile() {
		String content = "";
		while (file.hasNextLine()) {
			content += file.nextLine() + "\n";
		}
		file.close();
		return content;
	}

	public void closeFile() {
		file.close();
	}

	public static void main(String ar[]) {
		System.out.println(new FileReader("Devices.txt").getContentFile());

	}
}
