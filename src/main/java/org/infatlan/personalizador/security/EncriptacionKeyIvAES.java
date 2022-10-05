package org.infatlan.personalizador.security;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.infatlan.personalizador.security.dto.EncriptacionControlDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncriptacionKeyIvAES implements Serializable {

	private static final long serialVersionUID = 7244310736286433524L;
	private SecretKeySpec secretKey;
	private IvParameterSpec ivParameterSpec;

	private Cipher encryptCipher;
	private Cipher decryptCipher;

	public EncriptacionKeyIvAES(EncriptacionControlDto ecd) {
		try {
			
			if (ecd.getEncriptionKey() == null || ecd.getEncriptionKey().length() == 0 || ecd.getEncriptionKey().isEmpty()) {
				throw new Exception(
						"No se puede encriptar, por que se esta enviando llave de encriptacion con valor nulo o vacio");
			}

			if (ecd.getEncriptionIv() == null || ecd.getEncriptionIv().length() == 0 || ecd.getEncriptionIv().isEmpty()) {
				throw new Exception(
						"No se puede encriptar, por que se esta enviando vector de inicializacion con valor nulo o vacio");
			}
			
			secretKey = new SecretKeySpec(ecd.getEncriptionKey().getBytes(StandardCharsets.UTF_8), ecd.getEncriptionCipher());
			ivParameterSpec = new IvParameterSpec(ecd.getEncriptionIv().getBytes(StandardCharsets.UTF_8));

			encryptCipher = Cipher.getInstance(ecd.getEncriptionInstance());
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

			decryptCipher = Cipher.getInstance(ecd.getEncriptionInstance());
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		} catch (Exception e) {
			log.error("Error creating the constructor: " + e.getMessage());
			//util.registrarLogServicio(1, e.getMessage(), e.getStackTrace());
		}
	}

	public String encrypt(String strToEncrypt) {
		try {
			if (strToEncrypt == null || strToEncrypt.length() <= 0 || strToEncrypt.isEmpty()) {
				throw new Exception("No se puede encriptar cadena de caracteres nula o vacia");
			}
			return Base64.getEncoder()
					.encodeToString((encryptCipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8))));
		} catch (IllegalBlockSizeException | BadPaddingException e1) {
			log.error("Error while encrypting: " + e1.getMessage());
		} catch (Exception e2) {
			log.error("Error while encrypting: " + e2.getMessage());
		}
		return null;
	}

	public String decrypt(String strToDecrypt) {
		try {
			if (strToDecrypt == null || strToDecrypt.length() <= 0 || strToDecrypt.isEmpty()) {
				throw new Exception("No se puede desencriptar cadena de caracteres nula o vacia");
			}
			return new String(decryptCipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (IllegalBlockSizeException | BadPaddingException e1) {
			log.error("Error while decrypting: " + e1.getMessage());
		} catch (Exception e2) {
			log.error("Error while decrypting: " + e2.getMessage());
		}
		return null;
	}

	public void CheckForUnlimitedCryptoPolicies() throws NoSuchAlgorithmException {
		/* Security.setProperty("crypto.policy", "limited"); */
		log.info("Check for unlimited crypto policies");
		log.info("Restricted cryptography: " + checkRestrictedCryptography()
				+ " | Notice: 'false' means unlimited policies");
		log.info("Security properties: " + Security.getProperty("crypto.policy"));
		int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
		log.info("Max AES key length = " + maxKeyLen);
	}

	public static boolean checkRestrictedCryptography() {
		try {
			return Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding") < Integer.MAX_VALUE;
		} catch (final NoSuchAlgorithmException e) {
			throw new IllegalStateException(
					"The transform \"AES/CBC/PKCS5Padding\" is not available (the availability of this algorithm is mandatory for Java SE implementations)",
					e);
		}
	}

	public String generateKey(Integer keySize) throws NoSuchAlgorithmException {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(keySize);
			SecretKey secretKey = keyGenerator.generateKey();
			String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
			return secretKeyString;
		} catch (Exception e) {
			log.error("Error generating the key " + e.getMessage());
		}
		return null;
	}
}

