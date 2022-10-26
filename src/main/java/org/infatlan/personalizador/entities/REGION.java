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
 * Realizado por Maria Alvarado 19/10/2022
 **/

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

@Entity(name = "REGION")
@Table(name = "REGION")

public class REGION implements Serializable {

    private static final long serialVersionUID = 4909099598478155821L;

  //test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_CODE", nullable = false, unique = true)
    private int REGION_CODE;

    @Column(name = "NAME", nullable = true, unique = false)
    private String NAME;

    @Column(name = "DESCRIPTION", nullable = true, unique = false)
    private String DESCRIPTION;

    @Column(name = "STATUS", nullable = true, unique = false)
    private Integer STATUS;

    @Column(name = "AVAILABLE_FIELD1", nullable = true, unique = false)
    private Integer AVAILABLE_FIELD1;

    @Column(name = "AVAILABLE_FIELD2", nullable = true, unique = false)
    private String AVAILABLE_FIELD2;

    @Column(name = "AVAILABLE_FIELD3", nullable = true, unique = false)
    private String AVAILABLE_FIELD3;

}

