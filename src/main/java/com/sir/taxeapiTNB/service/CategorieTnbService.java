/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public interface CategorieTnbService {
    public CategorieTnb findByReference(String reference);
    public int creerCategorie(CategorieTnb categorieTnb);
    
}
