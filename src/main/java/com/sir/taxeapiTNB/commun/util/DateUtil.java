/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiTNB.commun.util;

/**
 *
 * @author SAMSUNG
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

    public static final String paternYYYYMMDDmmhhSS = "yyyyMMddmmhhss";
    public static final String paternYYYY_MM_DD_Space_mm_hh_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String paternYYYY_MM_DD = "yyyy-MM-dd";
    public static final String COMMANDE_DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private DateUtil() {

    }

    public static boolean isFormatYYYYMMDDmmhhSS(String date) {
        if (date == null) {
            return false;
        }
        return parseYYYYMMDDmmhhSS(date) != null;
    }

    public static java.util.Date parseCommandeStyle(String date) {
        if (date == null) {
            return null;
        }
        return parse(date, COMMANDE_DATE_PATTERN);
    }

    public static String formatCommandeStyle(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return format(date, COMMANDE_DATE_PATTERN);
    }

    public static java.util.Date parseYYYYMMDDmmhhSS(String date) {
        if (date == null) {
            return null;
        }
        return parse(date, paternYYYYMMDDmmhhSS);
    }

    public static String formatYYYYMMDDmmhhSS(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return format(date, paternYYYYMMDDmmhhSS);
    }

    public static String formatYYYY_MM_DD_Space_mm_hh_SS(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return format(date, paternYYYY_MM_DD_Space_mm_hh_SS);
    }

    public static java.util.Date now() {
        return new java.util.Date();
    }

    public static java.util.Date parse(String date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        java.util.Date myParsedDate = null;
        try {
            myParsedDate = formatter.parse(date);
        } catch (ParseException e) {
        }
        return myParsedDate;
    }

    public static String format(java.util.Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static java.sql.Date convertToSqlDate(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static int diff(Date datePresentation, long anneePaiement) {
        if (datePresentation == null) {
            return -1;
        }
        String datePaiementAsString = anneePaiement + "-03-31";
        System.out.println("datePaiementAsString = " + datePaiementAsString);
        String datePresentationAsString = format(datePresentation, paternYYYY_MM_DD);
        System.out.println("datePresentationAsString = " + datePresentationAsString);
//Date datePaiement = parse(datePaiementAsString, paternYYYY_MM_DD);
//        int diffMois = (int) ((datePresentation.getTime() - datePaiement.getTime()) / (1000 * 3600 * 24 * 30));
//        return diffMois;

        long monthsBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse(datePresentationAsString).withDayOfMonth(1),
                LocalDate.parse(datePaiementAsString).withDayOfMonth(1));
        int m = (int) -monthsBetween;
        System.out.println("monthsBetween = " + m);
        return m;
    }

    public static void main(String[] args) {
      //  diff(new Date(), 2018);
        System.out.println(parse("2015-02-12", paternYYYY_MM_DD));
    }
}
