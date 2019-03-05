/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.rest.converter.TauxTaxeTnbConverter;
import com.sir.taxeapiTNB.rest.converter.TaxeTnbAnnuelleConverter;
import com.sir.taxeapiTNB.rest.converter.TerrainConverter;
import com.sir.taxeapiTNB.rest.vo.TauxTaxeTnbVo;
import com.sir.taxeapiTNB.rest.vo.TaxeTnbAnnuelleVo;
import com.sir.taxeapiTNB.rest.vo.TerrainVo;
import com.sir.taxeapiTNB.service.TaxeTnbAnnuelleService;
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

    @GetMapping("taxe/reference/{reference}/anneePaiement/{anneePaiement}")
    public TaxeTnbAnnuelleVo findByTerrainReferenceAndAnneePaiement(@PathVariable String reference, Long anneePaiement) {
        return new TaxeTnbAnnuelleConverter().toVo(taxeTnbAnnuelleService.findByTerrainReferenceAndAnneePaiement(reference,anneePaiement));
    }

    @GetMapping("terrain/reference/{reference}")
    public List<TaxeTnbAnnuelleVo> findByTerrainReference(@PathVariable String reference) {
        return new TaxeTnbAnnuelleConverter().toVo(taxeTnbAnnuelleService.findByTerrainReference(reference));
    }

    @PostMapping("/")
    public int creerTaxe(@RequestBody TaxeTnbAnnuelleVo taxeTnbAnnuelleVo) {
        TaxeTnbAnnuelleConverter taxeTnbAnnuelleConverter = new TaxeTnbAnnuelleConverter();
        TaxeTnbAnnuelle taxeTnbAnnuelle = taxeTnbAnnuelleConverter.toItem(taxeTnbAnnuelleVo);
        return taxeTnbAnnuelleService.creerTaxe(taxeTnbAnnuelle);
    }

    public TaxeTnbAnnuelleService getTaxeTnbAnnuelleService() {
        return taxeTnbAnnuelleService;
    }

    public void setTaxeTnbAnnuelleService(TaxeTnbAnnuelleService taxeTnbAnnuelleService) {
        this.taxeTnbAnnuelleService = taxeTnbAnnuelleService;
    }

}
