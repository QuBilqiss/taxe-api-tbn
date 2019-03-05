/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service;

import com.sir.taxeapiTNB.bean.Terrain;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public interface TerrainService {
   public Terrain findByReference(String reference);
   public List<Terrain> findByCategorieReference(String reference);
   public int creerTerrain(Terrain terrain);
    
}
