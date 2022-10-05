package org.infatlan.personalizador.security.dto;
import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncriptacionControlDto implements Serializable {


	private static final long serialVersionUID = 3284893851010512270L;
	private String encriptionKey;
	private String encriptionSalt;
	private String encriptionIv;
	private String encriptionCipher;
	private String encriptionSecretKeyFactory;
	private String encriptionInstance;
	private Integer iterations;
	private Integer lengthKey;
	
	public EncriptacionControlDto(String encriptionKey, String encriptionIv, String encriptionCipher,
			String encriptionInstance) {
		this.encriptionKey = encriptionKey;
		this.encriptionSalt = null;
		this.encriptionIv = encriptionIv;
		this.encriptionCipher = encriptionCipher;
		this.encriptionSecretKeyFactory = null;
		this.encriptionInstance = encriptionInstance;
		this.iterations = null;
		this.lengthKey = null;
	}

}
