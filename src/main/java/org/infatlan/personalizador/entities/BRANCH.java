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
 * Realizado por Maria Alvarado 20/10/2022
 **/

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

@Entity(name = "BRANCH")
@Table(name = "BRANCH")
public class BRANCH implements Serializable{

    private static final long serialVersionUID = 4909459598478155821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_CODE", nullable = false, unique = true)
    private int BRANCH_CODE;
    
    @ManyToOne
    @JoinColumn(name = "INSTITUTION_CODE", referencedColumnName = "INSTITUTION_CODE")
    private INSTITUTION INSTITUTION_CODE;

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



