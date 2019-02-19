/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service.impl;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.dao.TaxeTnbAnnuelleDao;
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

    @Override
    public TaxeTnbAnnuelle findByReference(String reference) {
        return taxeTnbAnnuelleDao.findByReference(reference);
    }

    @Override
    public List<TaxeTnbAnnuelle> findByTerrainReference(String reference) {
        return taxeTnbAnnuelleDao.findByTerrainReference(reference);
    }
 @Override
    public int creerTaxe(TaxeTnbAnnuelle taxeTnbAnnuelle,Terrain terrain,TauxTaxeTnb tauxTaxeTnb) {
        int res = 0;
        Terrain t = terrainService.findByReference(terrain.getReference());
        TaxeTnbAnnuelle taxe = findByReference(taxeTnbAnnuelle.getReference());
        if (taxe
                != null) {
            return -1;
        } else if (t
                == null || terrain.getReference()
                == null) {
            return -2;
        } else {
            double montant = 0;
            double montantDeBase = terrain.getSurface() * tauxTaxeTnb.getMonatantParMetreCarre();
            double montantMajoration = montantDeBase * (10 / 100);
            double montantPenalite = montantDeBase * (5 / 100);
            if (taxeTnbAnnuelle.getNombreMoisRetard() == 0) {
                montant += montantDeBase;
                res = 1;
            } else if (taxeTnbAnnuelle.getNombreMoisRetard() == 1) {
                montant += montantDeBase + montantMajoration;
                res = 2;
            } else if (taxeTnbAnnuelle.getNombreMoisRetard() > 1) {
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


}
