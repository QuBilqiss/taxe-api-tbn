/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service.impl;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.dao.CategorieTnbDao;
import com.sir.taxeapiTNB.service.CategorieTnbService;
import com.sir.taxeapiTNB.service.TauxTaxeTnbService;
import com.sir.taxeapiTNB.service.TerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author SAMSUNG
 */
@Service
public class CategorieTnbServiceImpl implements CategorieTnbService {

    @Autowired
    private CategorieTnbDao categorieTnbDao;
    @Autowired
    private TerrainService terrainService;
    @Autowired
    private TauxTaxeTnbService tauxTaxeTnbService;

    @Override
    public CategorieTnb findByReference(String reference) {
        return categorieTnbDao.findByReference(reference);
    }

    @Override
    public int creerCategorie(CategorieTnb categorieTnb) {
        CategorieTnb ct = categorieTnbDao.findByReference(categorieTnb.getReference());
        if (ct != null) {
            return -1;
        } else {
            categorieTnbDao.save(categorieTnb);
//            List<Terrain> terrains = categorieTnb.getTerrains();
//            List<TauxTaxeTnb> TauxTaxeTnb = categorieTnb.getTauxTaxeTnbs();
//            for (Terrain terrain : terrains) {
//                terrain.setCategorieTnb(categorieTnb);
//                terrainService.creerTerrain(terrain);
//
//            }
//            for (TauxTaxeTnb tauxTaxeTnb : TauxTaxeTnb) {
//             tauxTaxeTnb.setCategorieTnb(categorieTnb);
//             tauxTaxeTnbService.creerTaux(tauxTaxeTnb);
//                
//            }
            return 1;
        }
    }

    public CategorieTnbDao getCategorieTnbDao() {
        return categorieTnbDao;
    }

    public void setCategorieTnbDao(CategorieTnbDao categorieTnbDao) {
        this.categorieTnbDao = categorieTnbDao;
    }

    public TerrainService getTerrainService() {
        return terrainService;
    }

    public void setTerrainService(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    public TauxTaxeTnbService getTauxTaxeTnbService() {
        return tauxTaxeTnbService;
    }

    public void setTauxTaxeTnbService(TauxTaxeTnbService tauxTaxeTnbService) {
        this.tauxTaxeTnbService = tauxTaxeTnbService;
    }
    

}
