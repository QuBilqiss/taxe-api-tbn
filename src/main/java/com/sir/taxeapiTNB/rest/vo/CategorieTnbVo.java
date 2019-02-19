/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.vo;

import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class CategorieTnbVo {
     private Long id;
    private String reference;
    private String libelle;
    private List<TerrainVo> terrainVos;
    private List<TauxTaxeTnbVo> tauxTaxeTnbVos;

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<TerrainVo> getTerrainVos() {
        return terrainVos;
    }

    public void setTerrainVos(List<TerrainVo> terrainVos) {
        this.terrainVos = terrainVos;
    }

    public List<TauxTaxeTnbVo> getTauxTaxeTnbVos() {
        return tauxTaxeTnbVos;
    }

    public void setTauxTaxeTnbVos(List<TauxTaxeTnbVo> tauxTaxeTnbVos) {
        this.tauxTaxeTnbVos = tauxTaxeTnbVos;
    }
     
    
}
