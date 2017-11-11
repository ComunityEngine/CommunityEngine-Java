package ce.engine;

import java.io.InputStream;

public class Util {
	
	public static InputStream loadInternal(String fileName) {
		return Util.class.getResourceAsStream("/" + fileName);
	}

}
