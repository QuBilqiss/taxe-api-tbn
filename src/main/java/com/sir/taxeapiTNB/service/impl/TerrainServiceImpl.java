/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service.impl;

import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.dao.TerrainDao;
import com.sir.taxeapiTNB.service.TerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SAMSUNG
 */
@Service
public class TerrainServiceImpl implements TerrainService {
    @Autowired 
    private TerrainDao terrainDao;

    @Override
    public Terrain findByReference(String reference) {
        return terrainDao.findByReference(reference);
    }

    @Override
    public List<Terrain> findByCategorieReference(String reference) {
        return terrainDao.findByCategorieTnbReference(reference);
    }

    @Override
    public int creerTerrain(Terrain terrain) {
        terrain.setDernierMontantPayer(0D);
        terrainDao.save(terrain);
        return 1;
    }

    public TerrainDao getTerrainDao() {
        return terrainDao;
    }

    public void setTerrainDao(TerrainDao terrainDao) {
        this.terrainDao = terrainDao;
    }
    
    
    
}
