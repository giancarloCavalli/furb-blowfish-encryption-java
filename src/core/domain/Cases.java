package core.domain;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import core.utils.Utils;

public class Cases {
	
	public static void Case1() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", "FURB");
		
		// QUESTÃO 1.1
		System.out.println("1.1) Encrypt em hexadecimal:\n" + Utils.getHex(cipherBytes));	
		
		// QUESTÃO 1.2
		System.out.println("\n1.2) Extensão do texto cifrado:\n" + cipherBytes.length + " caracteres");
	}
	
	public static void Case2() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", "COMPUTADOR");
		
		// QUESTÃO 2.1
		System.out.println("2.1) Encrypt em hexadecimal:\n" + Utils.getHex(cipherBytes));	
		
		// QUESTÃO 2.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherBytes.length + " caracteres");
	}
	
	private static byte[] getCipherBytes(Cipher cipher, String keyText, String textToBeEncoded) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		String text = "COMPUTADOR";		
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] cipherBytes = cipher.doFinal(text.getBytes());
		
		return cipherBytes;
	}
}
