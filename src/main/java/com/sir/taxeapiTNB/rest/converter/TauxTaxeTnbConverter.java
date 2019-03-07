/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.converter;

import com.sir.taxeapiTNB.bean.TauxTaxeTnb;
import com.sir.taxeapiTNB.commun.util.DateUtil;
import static com.sir.taxeapiTNB.commun.util.DateUtil.paternYYYY_MM_DD;
import com.sir.taxeapiTNB.commun.util.NumberUtil;
import com.sir.taxeapiTNB.rest.vo.TauxTaxeTnbVo;

/**
 *
 * @author SAMSUNG
 */
public class TauxTaxeTnbConverter extends AbstractConverter<TauxTaxeTnb, TauxTaxeTnbVo> {

    @Override
    public TauxTaxeTnb toItem(TauxTaxeTnbVo vo) {
        if (vo == null) {
            return null;
        } else {
            TauxTaxeTnb item = new TauxTaxeTnb();
            item.setId(vo.getId());
            item.setDateFin(DateUtil.parse(vo.getDateFin(),paternYYYY_MM_DD));
            item.setDateDebut(DateUtil.parse(vo.getDateDebut(),paternYYYY_MM_DD));
            item.setMontantParMetreCarre(NumberUtil.toDouble(vo.getMontantParMetreCarre()));
            item.setSurfaceMax(NumberUtil.toDouble(vo.getSurfaceMax()));
            item.setSurfaceMin(NumberUtil.toDouble(vo.getSurfaceMin()));
            item.setPenalite(NumberUtil.toDouble(vo.getPenalite()));
            item.setMajoration(NumberUtil.toDouble(vo.getMajoration()));
            item.setCategorieTnb(vo.getCategorieTnb());
            return item;

        }
    }

    @Override
    public TauxTaxeTnbVo toVo(TauxTaxeTnb item) {
        if (item == null) {
            return null;
        } else {
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
