package org.infatlan.personalizador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Realizado por Maria Alvarado 26/9/2022
 **/

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

@Entity(name = "PERMISSION_ROLE")
@Table(name = "PERMISSION_ROLE")
public class PERMISSION_ROLE implements Serializable {

	private static final long serialVersionUID = -6172909070363279822L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERMISSION_PROFILE_CODE", nullable = false, unique = true)
	private int PERMISSION_PROFILE_CODE;

	@ManyToOne
	@JoinColumn(name = "PERMISSION_SCREEN_CODE", referencedColumnName = "PERMISSION_SCREEN_CODE")
	private PERMISSION_SCREEN PERMISSION_SCREEN_CODE;

	@ManyToOne
	@JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE")
	private ROLE ROLE_CODE;

	@Column(name = "STATUS", nullable = true, unique = false)
	private Integer STATUS;

	@Column(name = "AVAILABLE_FIELD1", nullable = true, unique = false)
	private Integer AVAILABLE_FIELD1;

	@Column(name = "AVAILABLE_FIELD2", nullable = true, unique = false)
	private String AVAILABLE_FIELD2;

	@Column(name = "AVAILABLE_FIELD3", nullable = true, unique = false)
	private String AVAILABLE_FIELD3;

}
