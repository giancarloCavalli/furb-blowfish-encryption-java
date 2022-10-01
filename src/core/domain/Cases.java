package core.domain;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import core.utils.Utils;

public class Cases {
	
	public static void Case1() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", "FURB");
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 1.1
		System.out.println("1.1) Encrypt em hexadecimal:\n" + cipherInHex);	
		
		// QUESTÃO 1.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
	}
	
	public static void Case2() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", "COMPUTADOR");
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 2.1
		System.out.println("2.1) Encrypt em hexadecimal:\n" + cipherInHex);	
		
		// QUESTÃO 2.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 2.3
		System.out.println("\n2.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada dígito hexadecimal é capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 dígitos hexadecimais.");
		System.out.println("Assim sendo, 16 bytes => 32 dígitos hexadecimais.");
	}
	
	private static byte[] getCipherBytes(Cipher cipher, String keyText, String textToBeEncoded) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] cipherBytes = cipher.doFinal(textToBeEncoded.getBytes());
		
		return cipherBytes;
	}
}
