/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.service.TerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAMSUNG
 */
@RestController()
@RequestMapping("/taxe-api-TNB/terrains")
public class TerrainRest {

    @Autowired
    private TerrainService terrainService;

    @GetMapping("terrain/reference/{reference}")
    public Terrain findByReference(@PathVariable String reference) {
        return terrainService.findByReference(reference);
    }

    @GetMapping("categorie/reference/{reference}")
    public List<Terrain> findByCategorieReference(@PathVariable String reference) {
        return terrainService.findByCategorieReference(reference);
    }

    @PostMapping("/")
    public int creerTerrain(@RequestBody Terrain terrain) {
        return terrainService.creerTerrain(terrain);
    }

    public TerrainService getTerrainService() {
        return terrainService;
    }

    public void setTerrainService(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

}
