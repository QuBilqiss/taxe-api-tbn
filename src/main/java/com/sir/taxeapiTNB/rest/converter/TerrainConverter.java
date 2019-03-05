/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.converter;

import com.sir.taxeapiTNB.bean.Terrain;
import com.sir.taxeapiTNB.commun.util.DateUtil;
import com.sir.taxeapiTNB.commun.util.NumberUtil;
import com.sir.taxeapiTNB.rest.vo.TerrainVo;

/**
 *
 * @author SAMSUNG
 */
public class TerrainConverter extends AbstractConverter<Terrain, TerrainVo> {

    @Override
    public Terrain toItem(TerrainVo vo) {
        if (vo == null) {
            return null;
        } else {
            Terrain item = new Terrain();
            item.setId(vo.getId());
            item.setReference(vo.getReference());
            item.setSurface(NumberUtil.toDouble(vo.getSurface()));
            item.setDernierMontantPayer(NumberUtil.toDouble(vo.getDernierMontantPayer()));
            item.setDernierAnneePaiement(NumberUtil.toLong(vo.getDernierAnneePaiement()));
            item.setReferenceRedevable(vo.getReferenceRedevable());
            item.setReferenceRue(vo.getReferenceRue());
            return item;
        }
    }

    @Override
    public TerrainVo toVo(Terrain item) {
        if (item == null) {
            return null;
        } else {
            TerrainVo vo = new TerrainVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setSurface(NumberUtil.toString(item.getSurface()));
            vo.setDernierMontantPayer(NumberUtil.toString(item.getDernierMontantPayer()));
            vo.setDernierAnneePaiement(NumberUtil.toString(item.getDernierAnneePaiement()));
            vo.setReferenceRedevable(item.getReferenceRedevable());
            vo.setReferenceRue(item.getReferenceRue());
            vo.setTaxeTnbAnnuelleVos(new TaxeTnbAnnuelleConverter().toVo(item.getTaxeTnbAnnuelles()));
            return vo;
        }

        
    }

}
