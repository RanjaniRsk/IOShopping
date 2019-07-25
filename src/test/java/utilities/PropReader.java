package utilities;

import java.io.IOException;
import java.util.Properties;

public class PropReader {

	Properties prop;

	public PropReader() {
		prop = new Properties();
	}

	public void getPropertyList(String propFileName) {

		try {
			prop.load(PropReader.class.getClassLoader().getResourceAsStream(propFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;

	}

	public String getProperty(String propFileName, String propKey) {
		String propValue = null;
		try {
			prop.load(PropReader.class.getClassLoader().getResourceAsStream(propFileName));
			propValue = prop.getProperty(propKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propValue;

	}

	public String getProperty(String propKey) {
		String propValue = null;

		if (prop != null) {
			propValue = prop.getProperty(propKey);
		}
		return propValue;

	}

}