/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.vo;

import com.sir.taxeapiTNB.bean.Terrain;
import javax.persistence.Temporal;

/**
 *
 * @author SAMSUNG
 */
public class TaxeTnbAnnuelleVo {
   private Long id;
    private String reference;
    private String montantDeBase;
    private String montantMajoration;
    private String montantPenalite;
    private String montantTaxe;
    private String nombreMoisRetard;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private String datePresentation;
    private String referenceRedevable;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private String datePaiement;
    private Terrain terrain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMontantDeBase() {
        return montantDeBase;
    }

    public void setMontantDeBase(String montantDeBase) {
        this.montantDeBase = montantDeBase;
    }

    public String getMontantMajoration() {
        return montantMajoration;
    }

    public void setMontantMajoration(String montantMajoration) {
        this.montantMajoration = montantMajoration;
    }

    public String getMontantPenalite() {
        return montantPenalite;
    }

    public void setMontantPenalite(String montantPenalite) {
        this.montantPenalite = montantPenalite;
    }

    public String getMontantTaxe() {
        return montantTaxe;
    }

    public void setMontantTaxe(String montantTaxe) {
        this.montantTaxe = montantTaxe;
    }

    public String getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(String nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public String getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(String datePresentation) {
        this.datePresentation = datePresentation;
    }

    public String getReferenceRedevable() {
        return referenceRedevable;
    }

    public void setReferenceRedevable(String referenceRedevable) {
        this.referenceRedevable = referenceRedevable;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    
 
}
