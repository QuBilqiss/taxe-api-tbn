/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.service.impl;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.dao.TauxTaxeTnbDao;
import com.sir.taxeapiTNB.service.TauxTaxeTnbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SAMSUNG
 */
@Service
public class TauxTaxeTnbServiceImpl implements TauxTaxeTnbService {

    @Autowired
    private TauxTaxeTnbDao tauxTaxeTnbDao;

    @Override
    public List<TauxTaxeTnb> findByCategorieTnbReference(String reference) {
        return tauxTaxeTnbDao.findByCategorieTnbReference(reference);
    }

    @Override
    public int creerTaux(TauxTaxeTnb tauxTaxeTnb) {
        tauxTaxeTnbDao.save(tauxTaxeTnb);
        return 1;
    }
        @Override
    public TauxTaxeTnb findByCategorieTnb(CategorieTnb categorieTnb) {
        return tauxTaxeTnbDao.findByCategorieTnb(categorieTnb);
    }
    

    public TauxTaxeTnbDao getTauxTaxeTnbDao() {
        return tauxTaxeTnbDao;
    }

    public void setTauxTaxeTnbDao(TauxTaxeTnbDao tauxTaxeTnbDao) {
        this.tauxTaxeTnbDao = tauxTaxeTnbDao;
    }

    

    

}
