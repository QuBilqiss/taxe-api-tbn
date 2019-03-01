/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.commun.util;

import java.math.BigDecimal;
import static javassist.CtMethod.ConstParameter.integer;

/**
 *
 * @author SAMSUNG
 */
public class NumberUtil {
    private static final  String CHAINE_VIDE="";
   public static BigDecimal toBigDecimal(String value){
       if (value ==null|| value.isEmpty()){
           return BigDecimal.ZERO;
       }else{
           return new BigDecimal(value);
       }
       
   }
    public static String toString(Object value){
       if (value ==null){
           return CHAINE_VIDE;
       }else{
           return String.valueOf(value);
       }
       
   }
      private static final Double ZERO = new Double(0D);
    public static Double toDouble(String value){
        if(value==null || value.isEmpty()){
            return ZERO;
        }
        else{
            return Double.parseDouble(value);
        }
    }
    
    //private static final int ZEROO = new int(0);
    public static Integer toInteger(String value){
        if(value==null || value.isEmpty()){
            return 0;
        }
        else{
            return Integer.parseInt(value);
        }
    }
      private static final Long ZEROOO = new Long(0);
    public static Long toLong(String value){
        if(value==null || value.isEmpty()){
            return ZEROOO;
        }
        else{
            return Long.parseLong(value);
        }
    }
}

