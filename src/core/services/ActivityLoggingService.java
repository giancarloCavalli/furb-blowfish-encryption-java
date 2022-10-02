package core.services;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import core.utils.Utils;

public class ActivityLoggingService {
	
	public ActivityLoggingService() {
	}
	
	public void Case1() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "FURB";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUEST�O 1.1
		System.out.println("1.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUEST�O 1.2
		System.out.println("\n2.2) Extens�o do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
	}
	
	public void Case2() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "COMPUTADOR";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUEST�O 2.1
		System.out.println("1.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUEST�O 2.2
		System.out.println("\n2.2) Extens�o do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUEST�O 2.3
		System.out.println("\n2.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada d�gito hexadecimal � capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 d�gitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " d�gitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso � dividida em blocos de 8 bytes, obrigatoriamente.");
	}
	
	public void Case3() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "SABONETE";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUEST�O 3.1
		System.out.println("3.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUEST�O 3.2
		System.out.println("\n3.2) Extens�o do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUEST�O 3.3
		System.out.println("\n3.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada d�gito hexadecimal � capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 d�gitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " d�gitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso � dividida em blocos de 8 bytes E DEVE HAVER PELO MENOS 1 BYTE NO FINAL INDICANDO A QTDE DE BYTES DE PREENCHIMENTO, obrigatoriamente. Neste caso, foram 8 bytes \"8\".");
	}
	
	public void Case4() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "SABONETESABONETESABONETE";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUEST�O 4.1
		System.out.println("4.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUEST�O 4.2
		System.out.println("\n4.2) Extens�o do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUEST�O 4.3
		System.out.println("\n4.3) Que conclus�o � poss�vel obter a partir do texto cifrado e do texto simples?");
		System.out.println("Embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso � dividida em blocos de 8 bytes E DEVE HAVER PELO MENOS 1 BYTE NO FINAL INDICANDO A QTDE DE BYTES DE PREENCHIMENTO, obrigatoriamente. Neste caso, foram 8 bytes \"8\".");
	}
	
	public void Case5() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		String textToBeEncoded = "FURB";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUEST�O 5.1
		System.out.println("5.1) Encrypt CBC em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUEST�O 5.2 
		System.out.println("\n5.2) Tente decifrar o texto cifrado para recuperar o texto simples. O que acontece?");
		
		System.out.println("Uma exce��o \"InvalidKeyException\" � lan�ada com a seguinte msg:");
		Cipher cipherDecode = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		byte[] cipherDecodedBytes = getCipherBytes(cipherDecode, "ABCDE", cipherInHex, Cipher.DECRYPT_MODE);
		System.out.println(Utils.getEncode64(cipherDecodedBytes));
	}
	
	private byte[] getCipherBytes(Cipher cipher, String keyText, String text, int cipherMode) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		cipher.init(cipherMode, secretKey);
		
		byte[] cipherBytes = cipher.doFinal(text.getBytes());
		
		return cipherBytes;
	}
}
