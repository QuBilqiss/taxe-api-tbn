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
    public TaxeTnbAnnuelle findByReference(String reference) {
        return taxeTnbAnnuelleDao.findByReference(reference);
    }

    @Override
    public List<TaxeTnbAnnuelle> findByTerrainReference(String reference) {
        return taxeTnbAnnuelleDao.findByTerrainReference(reference);
    }

    @Override
    public int creerTaxe(TaxeTnbAnnuelle taxeTnbAnnuelle, Terrain terrain, TauxTaxeTnb tauxTaxeTnb) {
        TaxeTnbAnnuelle taxe = findByReference(taxeTnbAnnuelle.getReference());
        Terrain t = terrainService.findByReference(taxeTnbAnnuelle.getReference());
        TauxTaxeTnb taux = tauxTaxeTnbService.findByCategorieTnb(terrain.getCategorieTnb());
        int res = 0;
        if (t == null) {
           res=-1;
        } 
        else if (taxe!= null ) {
            res= -2;
        }
        else if(taux==null){
            return -3;
        }
        
        else {
            int nombreMoisRetard = (int) DateUtil.diff(taxeTnbAnnuelle.getDatePresentation(), (int) taxeTnbAnnuelle.getAnneePaiement());
            System.out.println("le nombre de retard est" + nombreMoisRetard);
            double montant = 0;
            double montantDeBase = terrain.getSurface() * tauxTaxeTnb.getMontantParMetreCarre();
            double montantMajoration = montantDeBase * tauxTaxeTnb.getMajoration();
            double montantPenalite = montantDeBase * tauxTaxeTnb.getPenalite();
            if (nombreMoisRetard == 0) {
                montant += montantDeBase;
                res = 1;
            } else if (nombreMoisRetard == 1) {
                montant += montantDeBase + montantMajoration;
                res = 2;

            } else if (nombreMoisRetard > 1) {
                montant += montantDeBase + montantMajoration + montantPenalite;
                res = 3;
            }
            taxeTnbAnnuelle.setMontantTaxe(montant);
            taxeTnbAnnuelleDao.save(taxeTnbAnnuelle);
        }
        return res;
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
