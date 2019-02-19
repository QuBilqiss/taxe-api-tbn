/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.bean.Terrain;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public interface TaxeTnbAnnuelleService  {
     public TaxeTnbAnnuelle findByReference(String reference);
    public List<TaxeTnbAnnuelle> findByTerrainReference(String reference);
    public int creerTaxe(TaxeTnbAnnuelle taxeTnbAnnuelle,Terrain terrain,TauxTaxeTnb tauxTaxeTnb);
    
}
