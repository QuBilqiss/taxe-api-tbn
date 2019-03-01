/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author SAMSUNG
 */
@Entity
public class TaxeTnbAnnuelle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double montantDeBase;
    private double montantMajoration;
    private double montantPenalite;
    private double montantTaxe;
    private int nombreMoisRetard;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datePresentation;
    private Long anneePaiement;
    private String referenceRedevable;
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Date datePaiement;
    @ManyToOne
    private Terrain terrain;

    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }

    public String getReferenceRedevable() {
        return referenceRedevable;
    }

    public void setReferenceRedevable(String referenceRedevable) {
        this.referenceRedevable = referenceRedevable;
    }

    public double getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(double montantDeBase) {
        this.montantDeBase = montantDeBase;
    }

    public double getMontantMajoration() {
        return montantMajoration;
    }

    public void setMontantMajoration(double montantMajoration) {
        this.montantMajoration = montantMajoration;
    }

    public double getMontantPenalite() {
        return montantPenalite;
    }

    public void setMontantPenalite(double montantPenalite) {
        this.montantPenalite = montantPenalite;
    }

    public double getMontantTaxe() {
        return montantTaxe;
    }

    public void setMontantTaxe(double montantTaxe) {
        this.montantTaxe = montantTaxe;
    }

    public int getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(int nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

//    public Date getDatePaiement() {
//        return datePaiement;
//    }
//
//    public void setDatePaiement(Date datePaiement) {
//        this.datePaiement = datePaiement;
//    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAnneePaiement() {
        return anneePaiement;
    }

    public void setAnneePaiement(long anneePaiement) {
        this.anneePaiement = anneePaiement;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxeTnbAnnuelle)) {
            return false;
        }
        TaxeTnbAnnuelle other = (TaxeTnbAnnuelle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle[ id=" + id + " ]";
    }

}
