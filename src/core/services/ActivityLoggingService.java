package core.services;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import core.utils.Utils;

public class ActivityLoggingService {
	
	public ActivityLoggingService() {
	}
	
	public void Case1() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		final String textToBeEncoded = "FURB";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 1.1
		System.out.println("1.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUESTÃO 1.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
	}
	
	public void Case2() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		final String textToBeEncoded = "COMPUTADOR";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 2.1
		System.out.println("1.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUESTÃO 2.2
		System.out.println("\n2.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 2.3
		System.out.println("\n2.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada dígito hexadecimal é capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 dígitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " dígitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso é dividida em blocos de 8 bytes, obrigatoriamente.");
	}
	
	public void Case3() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		final String textToBeEncoded = "SABONETE";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 3.1
		System.out.println("3.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUESTÃO 3.2
		System.out.println("\n3.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 3.3
		System.out.println("\n3.3) Por que o texto cifrado tem tal tamanho?");
		System.out.println("Porque cada dígito hexadecimal é capaz de representar 4 bits. Logo, cada byte pode ser representado com 2 dígitos hexadecimais.");
		System.out.println("Assim sendo, " + cipherBytes.length + " bytes => " + cipherInHex.length() + " dígitos hexadecimais.");
		System.out.println("OBS: embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso é dividida em blocos de 8 bytes E DEVE HAVER PELO MENOS 1 BYTE NO FINAL INDICANDO A QTDE DE BYTES DE PREENCHIMENTO, obrigatoriamente. Neste caso, foram 8 bytes \"8\".");
	}
	
	public void Case4() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		final String textToBeEncoded = "SABONETESABONETESABONETE";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 4.1
		System.out.println("4.1) Encrypt ECB em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);
		
		// QUESTÃO 4.2
		System.out.println("\n4.2) Extensão do texto cifrado:\n" + cipherInHex.length() + " caracteres hexadecimais || " + cipherBytes.length + " bytes");
		
		// QUESTÃO 4.3
		System.out.println("\n4.3) Que conclusão é possível obter a partir do texto cifrado e do texto simples?");
		System.out.println("Embora o texto a ser cifrado contenha inicialmente somente " + textToBeEncoded.length() + " bytes, o texto cifrado possui " + cipherBytes.length + " bytes.");
		System.out.println("Isso porque a cifra neste caso é dividida em blocos de 8 bytes E DEVE HAVER PELO MENOS 1 BYTE NO FINAL INDICANDO A QTDE DE BYTES DE PREENCHIMENTO, obrigatoriamente. Neste caso, foram 8 bytes \"8\".");
	}
	
	public void Case5() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		final String textToBeEncoded = "FURB";
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 5.1
		System.out.println("5.1) Encrypt CBC em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUESTÃO 5.2 
		System.out.println("\n5.2) Tente decifrar o texto cifrado para recuperar o texto simples. O que acontece?");
		
		System.out.println("Uma exceção \"InvalidKeyException\" é lançada com a seguinte msg:");
		try {
			Cipher cipherDecode = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
			byte[] cipherDecodedBytes = getCipherBytes(cipherDecode, "ABCDE", cipherInHex, Cipher.DECRYPT_MODE);
			System.out.println(Utils.getEncode64(cipherDecodedBytes));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Case6() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		String textToBeEncoded = "FURB";
		
		IvParameterSpec initializationVector = new IvParameterSpec("11223344".getBytes());
		
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE, initializationVector);
		String cipherContent = Utils.getEncode64(cipherBytes);
		
		// QUESTÃO 6.1
		System.out.println("6.1) Encrypt CBC (" + textToBeEncoded + "):\n" + cipherContent);	
	}
	
	public void Case7() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		String textToBeEncoded = "SABONETESABONETESABONETE";
		
		IvParameterSpec initializationVector = new IvParameterSpec("11223344".getBytes());
		
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE, initializationVector);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 7.1
		System.out.println("7.1) Encrypt CBC em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUESTÃO 7.2
		System.out.println("7.2) O conteúdo cifrado é diferente do apresentado em 4.1 devido ao encadeamento de blocos cifrados no caso 7.1");	
	}
	
	public void Case8() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		String textToBeEncoded = "SABONETESABONETESABONETE";
		
		byte[] initializationVectorBytes = {10, 20, 30, 40, 50, 60, 70, 80};
		
		IvParameterSpec initializationVector = new IvParameterSpec(initializationVectorBytes);
		
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE, initializationVector);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		// QUESTÃO 8.1
		System.out.println("8.1) Encrypt CBC em hexadecimal (" + textToBeEncoded + "):\n" + cipherInHex);	
		
		// QUESTÃO 8.2
		System.out.println("8.2) Diferiu do item 7.1 porque o primeiro bloco teve um resultado diferente da cifra devido ao vetor de inicialização, assim alterando todo o conteúdo cifrado subsequente");
		
		// QUESTÃO 8.3
		try {
			Cipher cipherDecode = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
			
			byte[] initializationVectorDecodeBytes = {1, 1, 2, 2, 3, 3, 4, 4};
			
			IvParameterSpec initializationVectorDecode = new IvParameterSpec(initializationVectorDecodeBytes);
			
			byte[] cipherDecodedBytes = getCipherBytes(cipherDecode, "ABCDE", cipherInHex, Cipher.DECRYPT_MODE, initializationVectorDecode);
			System.out.println(Utils.getHex(cipherDecodedBytes));
		} catch (Exception e) {
			System.out.println("8.3) Um erro ocorre apresentando a seguinte mensagem:");
			System.out.println(e.getMessage());
		}
	}
	
	public void Case9() throws Exception {
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		String textToBeEncoded = "FURB";
		
		byte[] cipherBytes = getCipherBytes(cipher, "ABCDE", textToBeEncoded, Cipher.ENCRYPT_MODE);
		String cipherInHex = Utils.getHex(cipherBytes);
		
		try {
			Cipher cipherDecode = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
			
			byte[] initializationVectorDecodeBytes = {1, 1, 1, 1, 1};
			
			IvParameterSpec initializationVectorDecode = new IvParameterSpec(initializationVectorDecodeBytes);
			
			byte[] cipherDecodedBytes = getCipherBytes(cipherDecode, "ABCDE", cipherInHex, Cipher.DECRYPT_MODE, initializationVectorDecode);
			System.out.println(Utils.getHex(cipherDecodedBytes));
		} catch (Exception e) {
			System.out.println("9.1) Um erro ocorre apresentando a seguinte mensagem:");
			System.out.println(e.getMessage());
			System.out.println("O vetor de inicializacao nao contem 8 bytes como deveria no modo ECB");
		}
	}
	
	private byte[] getCipherBytes(Cipher cipher, String keyText, String text, int cipherMode) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		cipher.init(cipherMode, secretKey);
		
		byte[] cipherBytes = cipher.doFinal(text.getBytes());
		
		return cipherBytes;
	}
	
	private byte[] getCipherBytes(Cipher cipher, String keyText, String text, int cipherMode, IvParameterSpec initializationVector) throws Exception {
		String algorithm = cipher.getAlgorithm().split("/")[0];
		Key secretKey = new SecretKeySpec(keyText.getBytes(), algorithm);
		
		cipher.init(cipherMode, secretKey, initializationVector);
		
		byte[] cipherBytes = cipher.doFinal(text.getBytes());
		
		return cipherBytes;
	}
}
