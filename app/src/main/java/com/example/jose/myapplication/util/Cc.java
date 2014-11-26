package com.example.jose.myapplication.util;

/**
 * Created by Jose on 26/11/2014.
 */
public class Cc {
    public static final double NA_1 = 4.9424;
    public static final double NA_2 = 12.3513;
    public static final double NA_3 = 10.8150;
    public static final double NA_4 = 7.9884;
    public static final double EX_1 = 6.3644;
    public static final double EX_2 = 12.3776;
    public static final double EX_3 = 10.5341;
    public static final double EX_4 = 15.1778;

    public static final double KF_me_10 = 0.0175;
    public static final double KF_MA_10 = 0.0312;
    public static final double KD_me_10 = 0.0251;
    public static final double KD_MA_10 = 0.0454;

    public static final double a0117 = 0.117;

    public Double pMedio_kilometroFijo (int km_mensuales){
        if (km_mensuales!=0 && km_mensuales <=10000){
            return KF_me_10;}
            else{
            return (10000*KF_me_10+((km_mensuales-10000)*KF_MA_10))/km_mensuales;
        }
    }
    public Double pMedio_kilometroDieta (int km_mensuales){
        if (km_mensuales!=0 && km_mensuales <=10000){
            return KD_me_10;}
        else{
            return (10000*KD_me_10+((km_mensuales-10000)*KD_MA_10))/km_mensuales;
        }
    }



}
