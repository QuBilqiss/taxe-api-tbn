/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.vo;

import com.sir.taxeapiTNB.bean.CategorieTnb;

/**
 *
 * @author SAMSUNG
 */
public class TauxTaxeTnbVo {

    private Long id;
    private String surfaceMin;
    private String surfaceMax;
    private String majoration;
    private String penalite;
    private String montantParMetreCarre;
    private String dateDebut;
    private String dateFin;
    private CategorieTnb categorieTnb;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurfaceMin() {
        return surfaceMin;
    }

    public void setSurfaceMin(String surfaceMin) {
        this.surfaceMin = surfaceMin;
    }

    public String getSurfaceMax() {
        return surfaceMax;
    }

    public void setSurfaceMax(String surfaceMax) {
        this.surfaceMax = surfaceMax;
    }

    public String getMontantParMetreCarre() {
        return montantParMetreCarre;
    }

    public void setMontantParMetreCarre(String montantParMetreCarre) {
        this.montantParMetreCarre = montantParMetreCarre;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public CategorieTnb getCategorieTnb() {
        return categorieTnb;
    }

    public String getMajoration() {
        return majoration;
    }

    public void setMajoration(String majoration) {
        this.majoration = majoration;
    }

    public String getPenalite() {
        return penalite;
    }

    public void setPenalite(String penalite) {
        this.penalite = penalite;
    }
    

    public void setCategorieTnb(CategorieTnb categorieTnb) {
        this.categorieTnb = categorieTnb;
    }

}
