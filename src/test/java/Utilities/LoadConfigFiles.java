package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFiles {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(LoadConfigFiles.class);

    public Properties readPropertyValue() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            String proFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(proFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file: " + proFileName + "not found in the classpath");
            }
        } catch (Exception e) {
            LOGGER.error("Exception is:" + e.getMessage());
        } finally {
            inputStream.close();
        }
        return prop;
    }

}

