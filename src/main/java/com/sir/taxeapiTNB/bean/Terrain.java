/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author SAMSUNG
 */
@Entity
public class Terrain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double surface;
    private double dernierMontantPayer;
    private int dernierAnneePaiement;
    @ManyToOne
    private CategorieTnb categorieTnb;
    private String referenceRue;
    private String referenceRedeveble;
    @OneToMany(mappedBy = "terrain")
    private List<TaxeTnbAnnuelle> taxeTnbAnnuelles;

    @JsonIgnore
    public List<TaxeTnbAnnuelle> getTaxeTnbAnnuelles() {
        return taxeTnbAnnuelles;
    }

    @JsonSetter
    public void setTaxeTnbAnnuelles(List<TaxeTnbAnnuelle> taxeTnbAnnuelles) {
        this.taxeTnbAnnuelles = taxeTnbAnnuelles;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getDernierMontantPayer() {
        return dernierMontantPayer;
    }

    public void setDernierMontantPayer(double dernierMontantPayer) {
        this.dernierMontantPayer = dernierMontantPayer;
    }

    public int getDernierAnneePaiement() {
        return dernierAnneePaiement;
    }

    public void setDernierAnneePaiement(int dernierAnneePaiement) {
        this.dernierAnneePaiement = dernierAnneePaiement;
    }

    public CategorieTnb getCategorieTnb() {
        return categorieTnb;
    }

    public void setCategorieTnb(CategorieTnb categorieTnb) {
        this.categorieTnb = categorieTnb;
    }

    public String getReferenceRue() {
        return referenceRue;
    }

    public void setReferenceRue(String referenceRue) {
        this.referenceRue = referenceRue;
    }

    public String getReferenceRedeveble() {
        return referenceRedeveble;
    }

    public void setReferenceRedeveble(String referenceRedeveble) {
        this.referenceRedeveble = referenceRedeveble;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Terrain)) {
            return false;
        }
        Terrain other = (Terrain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sir.taxeTNBapiv1.bean.Terrain[ id=" + id + " ]";
    }

}
