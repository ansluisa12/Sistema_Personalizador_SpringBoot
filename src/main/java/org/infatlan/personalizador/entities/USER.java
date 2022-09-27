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

@Entity(name = "USER")
@Table(name = "USER")

public class USER implements Serializable {

	private static final long serialVersionUID = -1748306858146396889L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_CODE", nullable = false, unique = true)
	private int USER_CODE;

	@ManyToOne
	@JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE")
	private ROLE ROLE_CODE;

	@Column(name = "FIRST_NAME", nullable = true, unique = false)
	private String FIRST_NAME;

	@Column(name = "LAST_NAME", nullable = true, unique = false)
	private String LAST_NAME;

	@Column(name = "USER_NAME", nullable = true, unique = false)
	private String USER_NAME;

	@Column(name = "PASSWORD", nullable = true, unique = false)
	private String PASSWORD;

	@Column(name = "EMAIL", nullable = true, unique = false)
	private String EMAIL;

	@Column(name = "DESCRIPTION", nullable = true, unique = false)
	private String DESCRIPCION;

	@Column(name = "TOKEN", nullable = true, unique = false)
	private String TOKEN;

	@Column(name = "STATUS", nullable = true, unique = false)
	private Integer STATUS;

	@Column(name = "CREATE_BY", nullable = true, unique = false)
	private String CREATE_BY;

	@Column(name = "CREATION_DATE", nullable = true, unique = false)
	private String CREATION_DATE;

	@Column(name = "MODIFIED_BY", nullable = true, unique = false)
	private String MODIFIED_BY;

	@Column(name = "MODIFICATION_DATE", nullable = true, unique = false)
	private String MODIFICATION_DATE;

	@Column(name = "AVAILABLE_FIELD_1", nullable = true, unique = false)
	private Integer AVAILABLE_FIELD_1;

	@Column(name = "AVAILABLE_FIELD_2", nullable = true, unique = false)
	private String AVAILABLE_FIELD_2;

	@Column(name = "AVAILABLE_FIELD_3", nullable = true, unique = false)
	private String AVAILABLE_FIELD_3;
}
