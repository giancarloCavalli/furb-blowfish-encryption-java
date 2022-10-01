package core.domain;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import core.utils.Utils;

public class Cases {
	
	public static void Case1() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "FURB";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 1.1
		System.out.println("1.1) Encrypt em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUESTÃO 1.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
	}
	
	public static void Case2() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "COMPUTADOR";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 2.1
		System.out.println("1.1) Encrypt em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUESTÃO 2.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 2.3
		System.out.println("\n2.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada dígito hexadecimal é capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 dígitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " dígitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texte cifrado possui 16 bytes.");
		System.out.println("Isso porque a cifra neste caso é dividida em blocos de 8 bytes, obrigatoriamente.");
	}
	
	public static void Case3() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "SABONETE";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 2.1
		System.out.println("1.1) Encrypt em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUESTÃO 2.2
		System.out.println("\n3.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 2.3
		System.out.println("\n3.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada dígito hexadecimal é capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 dígitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " dígitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texte cifrado possui 16 bytes.");
		System.out.println("Isso porque a cifra neste caso é dividida em blocos de 8 bytes E DEVE HAVER PELO MENOS 1 BYTE NO FINAL INDICANDO A QTDE DE BYTES DE PREENCHIMENTO, obrigatoriamente. Neste caso, foram 8 bytes \"8\".");
	}
	
	private static byte[] getCipherBytes(Cipher cipher, String keyText, String textToBeEncoded) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] cipherBytes = cipher.doFinal(textToBeEncoded.getBytes());
		
		return cipherBytes;
	}
}
