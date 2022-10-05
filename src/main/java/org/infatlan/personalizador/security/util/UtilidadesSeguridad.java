package org.infatlan.personalizador.security.util;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UtilidadesSeguridad implements Serializable{


	private static final long serialVersionUID = -4057762279377944668L;

	public String base64Enconde(String strEncode) {
		try {
			if (strEncode == null || strEncode.length() <= 0 || strEncode.isEmpty()) {
				throw new Exception("No se puede codificar cadena de caracteres nula o vacia");
			}
			return Base64.getEncoder().encodeToString(strEncode.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			log.error("Error codificando base64: " + e.getMessage());
		}
		return null;
	}

	public String base64Decode(String strDecode) {
		try {
			if (strDecode == null || strDecode.length() <= 0 || strDecode.isEmpty()) {
				throw new Exception("No se puede codificar cadena de caracteres nula o vacia");
			}
			return new String(Base64.getDecoder().decode(strDecode.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			log.error("Error decodificando base64: " + e.getMessage());
		}
		return null;
	}

	public String base64EncondeMime(String strEncode) {
		try {
			if (strEncode == null || strEncode.length() <= 0 || strEncode.isEmpty()) {
				throw new Exception("No se puede codificar cadena de caracteres nula o vacia");
			}
			return Base64.getMimeEncoder().encodeToString(strEncode.getBytes(StandardCharsets.UTF_8.name()));
		} catch (Exception e) {
			log.error("Error codificando base64: " + e.getMessage());
		}
		return null;
	}

	public String base64EncondeR(String strEncode) {
		try {
			if (strEncode == null || strEncode.length() <= 0 || strEncode.isEmpty()) {
				throw new Exception("No se puede codificar cadena de caracteres nula o vacia");
			}
			String x1 = Base64.getEncoder().encodeToString(strEncode.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(x1.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			log.error("Error codificando base64: " + e.getMessage());
		}
		return null;
	}

	public String base64DecodeR(String strDecode) {
		try {
			if (strDecode == null || strDecode.length() <= 0 || strDecode.isEmpty()) {
				throw new Exception("No se puede codificar cadena de caracteres nula o vacia");
			}
			String x1 = new String(Base64.getDecoder().decode(strDecode.getBytes(StandardCharsets.UTF_8)));
			return new String(Base64.getDecoder().decode(x1.getBytes(StandardCharsets.UTF_8)));
			
		} catch (Exception e) {
			log.error("Error decodificando base64: " + e.getMessage());
		}
		return null;
	}

}
