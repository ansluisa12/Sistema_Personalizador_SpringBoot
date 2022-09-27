package org.infatlan.personalizador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Realizado por Maria Alvarado 25/9/2022
 **/

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

@Entity(name = "MODULE")
@Table(name = "MODULE")

public class MODULE implements Serializable {

	private static final long serialVersionUID = -370641891832972459L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULE_CODE", nullable = false, unique = true)
	private int MODULE_CODE;

	@Column(name = "NAME", nullable = true, unique = false)
	private String NAME;

	@Column(name = "DESCRIPTION", nullable = true, unique = false)
	private String DESCRIPTION;

	@Column(name = "STATUS", nullable = true, unique = false)
	private Integer STATUS;

	@Column(name = "URL", nullable = true, unique = false)
	private String URL;

	@Column(name = "CATEGORY", nullable = true, unique = false)
	private Integer CATEGORY;

	@Column(name = "AVAILABLE_FIELD1", nullable = true, unique = false)
	private Integer AVAILABLE_FIELD1;

	@Column(name = "AVAILABLE_FIELD2", nullable = true, unique = false)
	private String AVAILABLE_FIELD2;

	@Column(name = "AVAILABLE_FIELD3", nullable = true, unique = false)
	private String AVAILABLE_FIELD3;
}
