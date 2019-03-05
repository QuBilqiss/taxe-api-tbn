/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.rest.converter.CategorieTnbConverter;
import com.sir.taxeapiTNB.rest.vo.CategorieTnbVo;
import com.sir.taxeapiTNB.service.CategorieTnbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins={"http://localhost:8099"})
@RequestMapping("/taxe-api-TNB/categories")
public class CategorieTnbRest {
    @Autowired
  private CategorieTnbService categorieTnbService;
@GetMapping("reference/{reference}")
    public CategorieTnbVo findByReference(@PathVariable String reference) {
        return new CategorieTnbConverter().toVo( categorieTnbService.findByReference(reference));
    }
@PostMapping("/")
    public int creerCategorie( @RequestBody CategorieTnbVo categorieTnbVo) {
        CategorieTnbConverter ctConverter= new CategorieTnbConverter();
        CategorieTnb categorieTnb= ctConverter.toItem(categorieTnbVo);
       return  categorieTnbService.creerCategorie(categorieTnb);
    }

    public CategorieTnbService getCategorieTnbService() {
        return categorieTnbService;
    }

    public void setCategorieTnbService(CategorieTnbService categorieTnbService) {
        this.categorieTnbService = categorieTnbService;
    }

 
    
}
