/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service.impl;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.commun.util.DateUtil;
import com.sir.taxeapiTNB.dao.TaxeTnbAnnuelleDao;
import com.sir.taxeapiTNB.service.TauxTaxeTnbService;
import com.sir.taxeapiTNB.service.TaxeTnbAnnuelleService;
import com.sir.taxeapiTNB.service.TerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SAMSUNG
 */
@Service
public class TaxeTnbAnnuelleServiceImpl implements TaxeTnbAnnuelleService {

    @Autowired
    private TaxeTnbAnnuelleDao taxeTnbAnnuelleDao;
    @Autowired
    private TerrainService terrainService;
    @Autowired
    private TaxeTnbAnnuelleService taxeTnbAnnuelleService;
    @Autowired
    private TauxTaxeTnbService tauxTaxeTnbService;

    @Override
    public TaxeTnbAnnuelle findByTerrainReferenceAndAnneePaiement(String reference, Long anneePaiement) {
        return taxeTnbAnnuelleDao.findByTerrainReferenceAndAnneePaiement(reference, anneePaiement);
    }

    @Override
    public List<TaxeTnbAnnuelle> findByTerrainReference(String reference) {
        return taxeTnbAnnuelleDao.findByTerrainReference(reference);
    }

    @Override
    public int creerTaxe(TaxeTnbAnnuelle taxeTnbAnnuelle) {
        String terrainReference = taxeTnbAnnuelle.getTerrain().getReference();
        TaxeTnbAnnuelle taxe = findByTerrainReferenceAndAnneePaiement(terrainReference, taxeTnbAnnuelle.getAnneePaiement());
        System.out.println("terrain.getReference() == " + terrainReference);
        Terrain terrain = terrainService.findByReference(terrainReference);
        //hada l'erreur ta3 before flushing
        taxeTnbAnnuelle.setTerrain(terrain);
        TauxTaxeTnb tauxTaxeTnb = tauxTaxeTnbService.findByCategorieTnbReference(terrain.getCategorieTnb().getReference());
        System.out.println("tauxTaxeTnb = " + tauxTaxeTnb);
        int res = 0;
        if (terrain == null) {
            return -11;
        } else if (taxe != null) {
            return -22;
        } else if (tauxTaxeTnb == null) {
            return -33;
        } else {
            int nombreMoisRetard = (int) DateUtil.diff(taxeTnbAnnuelle.getDatePresentation(), (int) taxeTnbAnnuelle.getAnneePaiement());
            System.out.println("le nombre de retard est" + nombreMoisRetard);
            double montant = 0;
            double nvMontantDeBase = terrain.getSurface() * tauxTaxeTnb.getMontantParMetreCarre();
            double nvMontantMajoration = nvMontantDeBase * tauxTaxeTnb.getMajoration();
            double nvMontantPenalite = nvMontantDeBase * tauxTaxeTnb.getPenalite();
            System.out.println("montantPenalite = " + nvMontantPenalite);
            System.out.println("montantMajoration = " + nvMontantMajoration);
            System.out.println("montantDeBase = " + nvMontantDeBase);

            if (nombreMoisRetard == 0) {
                montant += nvMontantDeBase;
                res = 1;
            } else if (nombreMoisRetard == 1) {
                montant += nvMontantDeBase + nvMontantMajoration;
                taxeTnbAnnuelle.setMontantMajoration(nvMontantMajoration);
                res = 2;
            } else if (nombreMoisRetard > 1) {
                montant += nvMontantDeBase + nvMontantMajoration + nvMontantPenalite*nombreMoisRetard;
                taxeTnbAnnuelle.setMontantMajoration(nvMontantMajoration);
                taxeTnbAnnuelle.setMontantPenalite(nvMontantPenalite);
                res = 3;
            }
            taxeTnbAnnuelle.setMontantTaxe(montant);
            taxeTnbAnnuelle.setNombreMoisRetard(nombreMoisRetard);
            taxeTnbAnnuelle.setMontantDeBase(nvMontantDeBase);
            taxeTnbAnnuelleDao.save(taxeTnbAnnuelle);
            return nombreMoisRetard;
        }
    }

    public TaxeTnbAnnuelleDao getTaxeTnbAnnuelleDao() {
        return taxeTnbAnnuelleDao;
    }

    public void setTaxeTnbAnnuelleDao(TaxeTnbAnnuelleDao taxeTnbAnnuelleDao) {
        this.taxeTnbAnnuelleDao = taxeTnbAnnuelleDao;
    }

    public TerrainService getTerrainService() {
        return terrainService;
    }

    public void setTerrainService(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    public TaxeTnbAnnuelleService getTaxeTnbAnnuelleService() {
        return taxeTnbAnnuelleService;
    }

    public void setTaxeTnbAnnuelleService(TaxeTnbAnnuelleService taxeTnbAnnuelleService) {
        this.taxeTnbAnnuelleService = taxeTnbAnnuelleService;
    }

    public TauxTaxeTnbService getTauxTaxeTnbService() {
        return tauxTaxeTnbService;
    }

    public void setTauxTaxeTnbService(TauxTaxeTnbService tauxTaxeTnbService) {
        this.tauxTaxeTnbService = tauxTaxeTnbService;
    }

}
