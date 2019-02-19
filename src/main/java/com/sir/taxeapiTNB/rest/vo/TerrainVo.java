/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.vo;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class TerrainVo {
     private Long id;
    private String reference;
    private String surface;
    private String dernierMontantPayer;
    private String dernierAnneePaiement;
    private CategorieTnb categorieTnb;
    private String referenceRue;
    private String referenceRedeveble;
    private List<TaxeTnbAnnuelleVo> taxeTnbAnnuelleVos;

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

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getDernierMontantPayer() {
        return dernierMontantPayer;
    }

    public void setDernierMontantPayer(String dernierMontantPayer) {
        this.dernierMontantPayer = dernierMontantPayer;
    }

    public String getDernierAnneePaiement() {
        return dernierAnneePaiement;
    }

    public void setDernierAnneePaiement(String dernierAnneePaiement) {
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

    public List<TaxeTnbAnnuelleVo> getTaxeTnbAnnuelleVos() {
        return taxeTnbAnnuelleVos;
    }

    public void setTaxeTnbAnnuelleVos(List<TaxeTnbAnnuelleVo> taxeTnbAnnuelleVos) {
        this.taxeTnbAnnuelleVos = taxeTnbAnnuelleVos;
    }
    

    
}
