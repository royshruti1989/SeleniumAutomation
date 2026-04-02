package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop=new Properties();
	
	 static {
	
	InputStream Is=ConfigReader.class
			       .getClassLoader()
			       .getResourceAsStream("config.properties");
			
	try {
		prop.load(Is);
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}

}
