/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.dao;

import com.sir.taxeapiTNB.bean.CategorieTnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAMSUNG
 */
@Repository
public interface CategorieTnbDao extends JpaRepository<CategorieTnb, Long> {
    public CategorieTnb findByReference(String reference);
    
}
