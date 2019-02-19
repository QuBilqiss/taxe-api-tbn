/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.dao;

import com.sir.taxeapiTNB.bean.Terrain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAMSUNG
 */
@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
   public Terrain findByReference(String reference);
   public List<Terrain> findByCategorieTnbReference(String reference);   
}
