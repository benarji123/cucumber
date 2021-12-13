package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyVC {
	public FileInputStream input;
	public PropertyVC(String path) throws FileNotFoundException {
	  input=new FileInputStream(new File(path));
	}
	public String getKey(String key) throws IOException {
		Properties po=new Properties();
		po.load(input);
		return po.getProperty(key);
		
	}

}
