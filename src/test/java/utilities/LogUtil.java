package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

	    public static Logger getLogger(Class<?> className) {
	        return LogManager.getLogger(className);
	    }

	    public static void info(Logger log, String message) {
	        log.info(message);
	    }

	    public static void error(Logger log, String message) {
	        log.error(message);
	    }

	    public static void debug(Logger log, String message) {
	        log.debug(message);
	    }
	
}
