/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.service.TaxeTnbAnnuelleService;
import java.util.Date;
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
@RequestMapping({"/taxe-api-TNB/taxeTnbAnnuelles"})
public class TaxeTnbAnnuelleRest {

    @Autowired
    private TaxeTnbAnnuelleService taxeTnbAnnuelleService;

    @GetMapping("taxe/reference/{reference}")
    public TaxeTnbAnnuelle findByReference(@PathVariable String reference) {
        return taxeTnbAnnuelleService.findByReference(reference);
    }

    @GetMapping("terrain/reference/{reference}")
    public List<TaxeTnbAnnuelle> findByTerrainReference(@PathVariable String reference) {
        return taxeTnbAnnuelleService.findByTerrainReference(reference);
    }

    @PostMapping("/")
    public int creerTaxe(@RequestBody TaxeTnbAnnuelle taxeTnbAnnuelle, Terrain terrain, TauxTaxeTnb tauxTaxeTnb) {
        return taxeTnbAnnuelleService.creerTaxe(taxeTnbAnnuelle, terrain, tauxTaxeTnb);
    }


    public TaxeTnbAnnuelleService getTaxeTnbAnnuelleService() {
        return taxeTnbAnnuelleService;
    }

    public void setTaxeTnbAnnuelleService(TaxeTnbAnnuelleService taxeTnbAnnuelleService) {
        this.taxeTnbAnnuelleService = taxeTnbAnnuelleService;
    }

}
