/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.rest.converter;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import com.sir.taxeapiTNB.rest.vo.CategorieTnbVo;

/**
 *
 * @author SAMSUNG
 */
public class CategorieTnbConverter extends AbstractConverter<CategorieTnb, CategorieTnbVo> {

    @Override
    public CategorieTnb toItem(CategorieTnbVo vo) {
        if (vo == null) {
            return null;
        } else {
            CategorieTnb item = new CategorieTnb();
            item.setReference(vo.getReference());
            item.setLibelle(vo.getLibelle());
            item.setId(vo.getId());
            item.setTauxTaxeTnbs(new TauxTaxeTnbConverter().toItem(vo.getTauxTaxeTnbVos()));
            item.setTerrains(new TerrainConverter().toItem(vo.getTerrainVos()));
            return item;
        }

    }

    @Override
    public CategorieTnbVo toVo(CategorieTnb item) {
 if (item == null) {
            return null;
        } else {
            CategorieTnbVo vo = new CategorieTnbVo();
            vo.setReference(item.getReference());
            vo.setLibelle(item.getLibelle());
            vo.setId(item.getId());
            vo.setTauxTaxeTnbVos(new TauxTaxeTnbConverter().toVo(item.getTauxTaxeTnbs()));
            vo.setTerrainVos(new TerrainConverter().toVo(item.getTerrains()));
            return vo;
        }
        
    }

    

}
