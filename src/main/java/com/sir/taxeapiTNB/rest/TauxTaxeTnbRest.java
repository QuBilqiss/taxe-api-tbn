/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.service.TauxTaxeTnbService;
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
@RequestMapping("/taxe-api-TNB/tauxTaxeTnbs")
public class TauxTaxeTnbRest {
    @Autowired
private TauxTaxeTnbService tauxTaxeTnbService; 
@GetMapping("/reference/{reference}")
    public List<TauxTaxeTnb> findByCategorieTnbReference(@PathVariable String reference) {
        return tauxTaxeTnbService.findByCategorieTnbReference(reference);
    }
@PostMapping("/")
    public int creerTaux(@RequestBody TauxTaxeTnb tauxTaxeTnb) {
        return tauxTaxeTnbService.creerTaux(tauxTaxeTnb);
    }
@GetMapping("/categorieTnb/{categorieTnb }")
    public TauxTaxeTnb findByCategorieTnb(@PathVariable CategorieTnb categorieTnb) {
        return tauxTaxeTnbService.findByCategorieTnb(categorieTnb);
    }
    

    public TauxTaxeTnbService getTauxTaxeTnbService() {
        return tauxTaxeTnbService;
    }

    public void setTauxTaxeTnbService(TauxTaxeTnbService tauxTaxeTnbService) {
        this.tauxTaxeTnbService = tauxTaxeTnbService;
    }
    
    
}
