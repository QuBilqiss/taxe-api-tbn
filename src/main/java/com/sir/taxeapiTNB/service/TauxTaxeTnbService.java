/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public interface TauxTaxeTnbService {

    public TauxTaxeTnb findByCategorieTnbReference(String reference);
    public List<TauxTaxeTnb> findByCategorieTnb(CategorieTnb categorieTnb);
    public int creerTaux(TauxTaxeTnb tauxTaxeTnb);


}
