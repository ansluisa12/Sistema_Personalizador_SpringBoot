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

@Entity(name = "PERMISSION_SCREEN")
@Table(name = "PERMISSION_SCREEN")
public class PERMISSION_SCREEN implements Serializable {

	private static final long serialVersionUID = 8556123864475780200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERMISSION_SCREEN_CODE", nullable = false, unique = true)
	private int PERMISSION_SCREEN_CODE;

	@ManyToOne
	@JoinColumn(name = "PERMISSION_CODE", referencedColumnName = "PERMISSION_CODE")
	private PERMISSION PERMISSION_CODE;

	@ManyToOne
	@JoinColumn(name = "MODULE_CODE", referencedColumnName = "MODULE_CODE")
	private MODULE MODULE_CODE;

	@Column(name = "STATUS", nullable = true, unique = false)
	private Integer STATUS;

	@Column(name = "AVAILABLE_FIELD1", nullable = true, unique = false)
	private Integer AVAILABLE_FIELD1;

	@Column(name = "AVAILABLE_FIELD2", nullable = true, unique = false)
	private String AVAILABLE_FIELD2;

	@Column(name = "AVAILABLE_FIELD3", nullable = true, unique = false)
	private String AVAILABLE_FIELD3;

}
