/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.converter;

import com.sir.taxeapiTNB.bean.TaxeTnbAnnuelle;
import com.sir.taxeapiTNB.commun.util.DateUtil;
import static com.sir.taxeapiTNB.commun.util.DateUtil.paternYYYY_MM_DD;
import com.sir.taxeapiTNB.commun.util.NumberUtil;
import com.sir.taxeapiTNB.rest.vo.TaxeTnbAnnuelleVo;

/**
 *
 * @author SAMSUNG
 */
public class TaxeTnbAnnuelleConverter extends AbstractConverter<TaxeTnbAnnuelle, TaxeTnbAnnuelleVo> {

    @Override
    public TaxeTnbAnnuelle toItem(TaxeTnbAnnuelleVo vo) {
       if(vo==null){
           return null;
       }
       else{
           TaxeTnbAnnuelle item=new TaxeTnbAnnuelle();
           item.setId(vo.getId());
           item.setReference(vo.getReference());
           item.setAnneePaiement(NumberUtil.toLong(vo.getAnneePaiement()));
           item.setDatePresentation(DateUtil.parse(vo.getDatePresentation(),paternYYYY_MM_DD));
           item.setMontantDeBase(NumberUtil.toDouble(vo.getMontantDeBase()));
           item.setMontantMajoration(NumberUtil.toDouble(vo.getMontantMajoration()));
           item.setMontantPenalite(NumberUtil.toDouble(vo.getMontantPenalite()));
           item.setMontantTaxe(NumberUtil.toDouble(vo.getMontantTaxe()));
           item.setNombreMoisRetard(NumberUtil.toInteger(vo.getNombreMoisRetard()));
           item.setReferenceRedevable(vo.getReferenceRedevable());
           item.setTerrain(new TerrainConverter().toItem(vo.getTerrainVo()));
           return item;
       }
    }

    @Override
    public TaxeTnbAnnuelleVo toVo(TaxeTnbAnnuelle item) {
         if(item==null){
           return null;
       }
       else{
           TaxeTnbAnnuelleVo vo=new TaxeTnbAnnuelleVo();
           vo.setId(item.getId());
           vo.setReference(item.getReference());
           vo.setAnneePaiement(NumberUtil.toString(item.getAnneePaiement()));
           vo.setDatePresentation(DateUtil.formatYYYYMMDDmmhhSS(item.getDatePresentation()));
           vo.setMontantDeBase(NumberUtil.toString(item.getMontantDeBase()));
           vo.setMontantMajoration(NumberUtil.toString(item.getMontantMajoration()));
           vo.setMontantPenalite(NumberUtil.toString(item.getMontantPenalite()));
           vo.setMontantTaxe(NumberUtil.toString(item.getMontantTaxe()));
           vo.setNombreMoisRetard(NumberUtil.toString(item.getNombreMoisRetard()));
           vo.setReferenceRedevable(item.getReferenceRedevable());
           return vo;
       }

    }
    
}
