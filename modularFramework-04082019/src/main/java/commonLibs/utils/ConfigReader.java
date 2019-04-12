package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties readConfigProperty(String configFilename) throws Exception{
		
		configFilename = configFilename.trim();
		
		Properties configProperty;
		
		configProperty = new Properties();
		
		InputStream inputReader = new FileInputStream(configFilename);
		
		configProperty.load(inputReader);
		
		return configProperty;
	}

}
