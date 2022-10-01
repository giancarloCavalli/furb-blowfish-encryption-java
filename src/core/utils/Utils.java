package core.utils;

import java.util.Base64;

public class Utils {
	public static String getHex(byte[] bytes) {
        StringBuilder hexSb = new StringBuilder();
        
		for (byte b : bytes) {
            hexSb.append(String.format("%02X", b));
        }
		
		return hexSb.toString();
	}
	
	public static String getEncode64(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}
}
