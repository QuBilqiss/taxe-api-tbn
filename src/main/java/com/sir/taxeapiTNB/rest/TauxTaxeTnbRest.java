/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.rest.converter.CategorieTnbConverter;
import com.sir.taxeapiTNB.rest.converter.TauxTaxeTnbConverter;
import com.sir.taxeapiTNB.rest.vo.CategorieTnbVo;
import com.sir.taxeapiTNB.rest.vo.TauxTaxeTnbVo;
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
    public TauxTaxeTnbVo findByCategorieTnbReference(@PathVariable String reference) {
        return new TauxTaxeTnbConverter().toVo(tauxTaxeTnbService.findByCategorieTnbReference(reference));
    }
@PostMapping("/")
    public int creerTaux(@RequestBody TauxTaxeTnbVo tauxTaxeTnbVo) {
        TauxTaxeTnbConverter tauxTaxeTnbConverter=new TauxTaxeTnbConverter();
        TauxTaxeTnb tauxTaxeTnb= tauxTaxeTnbConverter.toItem(tauxTaxeTnbVo);
        return tauxTaxeTnbService.creerTaux(tauxTaxeTnb);
    }
@GetMapping("/categorieTnb/{categorieTnb }")
    public List<TauxTaxeTnbVo> findByCategorieTnb(@PathVariable CategorieTnbVo categorieTnbVo) {
        CategorieTnbConverter categorieTnbConverter=new CategorieTnbConverter();
        CategorieTnb categorieTnb= categorieTnbConverter.toItem(categorieTnbVo);
        return new TauxTaxeTnbConverter().toVo(tauxTaxeTnbService.findByCategorieTnb(categorieTnb));
    }   
    

    public TauxTaxeTnbService getTauxTaxeTnbService() {
        return tauxTaxeTnbService;
    }

    public void setTauxTaxeTnbService(TauxTaxeTnbService tauxTaxeTnbService) {
        this.tauxTaxeTnbService = tauxTaxeTnbService;
    }
    
    
}
