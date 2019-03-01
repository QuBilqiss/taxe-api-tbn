/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.converter;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.commun.util.DateUtil;
import com.sir.taxeapiTNB.commun.util.NumberUtil;
import com.sir.taxeapiTNB.rest.vo.TauxTaxeTnbVo;



/**
 *
 * @author SAMSUNG
 */
public class TauxTaxeTnbConverter extends AbstractConverter<TauxTaxeTnb,TauxTaxeTnbVo> {

    @Override
    public TauxTaxeTnb toItem(TauxTaxeTnbVo vo) {
        if(vo==null){
            return null;
        }else{
            TauxTaxeTnb item = new TauxTaxeTnb();
           item.setDateFin(DateUtil.parseYYYYMMDDmmhhSS(vo.getDateFin()));
            item.setDateDebut(DateUtil.parseYYYYMMDDmmhhSS(vo.getDateDebut()));
            item.setId(vo.getId());
            item.setMontantParMetreCarre(NumberUtil.toDouble(vo.getMontantParMetreCarre()));
            item.setSurfaceMax(NumberUtil.toDouble(vo.getSurfaceMax()));
            item.setSurfaceMin(NumberUtil.toDouble(vo.getSurfaceMin()));
             return item;
            
        }
    }

    @Override
    public TauxTaxeTnbVo toVo(TauxTaxeTnb item) {
              if(item==null){
            return null;
        }else{
            TauxTaxeTnbVo vo = new TauxTaxeTnbVo();
           vo.setDateFin(DateUtil.formatYYYYMMDDmmhhSS(item.getDateFin()));
            vo.setDateDebut(DateUtil.formatYYYYMMDDmmhhSS(item.getDateDebut()));
            vo.setId(vo.getId());
            vo.setMontantParMetreCarre(NumberUtil.toString(item.getMontantParMetreCarre()));
            vo.setSurfaceMax(NumberUtil.toString(item.getSurfaceMax()));
            vo.setSurfaceMin(NumberUtil.toString(item.getSurfaceMin()));
             return vo;
            
        }
    }

  

    

   
    
}
