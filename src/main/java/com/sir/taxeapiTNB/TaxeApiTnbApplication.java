package com.sir.taxeapiTNB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxeApiTnbApplication {

    public static void main(String[] args) {
//        long nombreMois = DateUtil.diff(new Date(), 2018);
//        System.out.println("nombreMois== " + nombreMois);
        SpringApplication.run(TaxeApiTnbApplication.class, args);
    }

}
