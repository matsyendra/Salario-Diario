package com.example.jose.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.jose.myapplication.util.Cc;
import com.example.jose.myapplication.util.TextCambioListener;


public class MainActivity extends ActionBarActivity {
    private EditText km_diarios, km_del_mes;
    private int kilometrosDiarios, kilometrosMensuales;
    private CheckBox na_1, na_2, na_3, na_4, ex_1, ex_2, ex_3, ex_4;
    private Button btn_precio_km;
    ImageButton btn_calculadora;
    private TableLayout tabla_resultados;
    private TextView resultado1,resultado2,resultado3,acumula_dieta;
    private static Double Desayuno = 0d,Comida = 0d,Cena = 0d, Pernoctacion = 0d;
    private Double dieta = Desayuno + Comida +Cena+ Pernoctacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarComponentes();
        dieta = 0d;



        //<editor-fold desc="LISTENER DE LOS CHECKBOX">
        na_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                           @Override
                                           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && ex_1.isChecked()) {
                                                    ex_1.setChecked(false);
                                                    Desayuno = Cc.NA_1;
                                                }else if (isChecked){
                                                    Desayuno = Cc.NA_1;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                               valorizar();

                                           }
                                       }
       );
        na_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.NA_2);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.NA_2);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                                valorizar();

                                            }
                                        }
        );
        na_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.NA_3);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.NA_3);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                                valorizar();

                                            }
                                        }
        );
        na_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                      @Override
                                                      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                          if (isChecked){
                                                              dieta = Redondeo(dieta + Cc.NA_4);
                                                          }else{
                                                              dieta = Redondeo(dieta - Cc.NA_4);
                                                          }
                                                          acumula_dieta.setText(String.format("( %s € )", dieta));
                                                          valorizar();

                                                      }
                                                  }
        );
        ex_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Desayuno = Cc.EX_1;
                if (isChecked && na_1.isChecked()) {
                    na_1.setChecked(false);
                    dieta = Redondeo(dieta + Desayuno);
                }else if (isChecked){
                    dieta = Redondeo(dieta + Desayuno);
                }else{
                    dieta = Redondeo(dieta - Desayuno);
                }
                acumula_dieta.setText(String.format("( %s € )", dieta));
                valorizar();
            }
        }
        );
        ex_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.EX_2);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.EX_2);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                                valorizar();
                                            }
                                        }
        );
        ex_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.EX_3);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.EX_3);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                                valorizar();
                                            }
                                        }
        );
        ex_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.EX_4);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.EX_4);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
                                                valorizar();
                                            }
                                        }
        );
        //</editor-fold>

    }

    private  void cargarComponentes (){
        km_diarios = (EditText)findViewById(R.id.kms_diarios);
        km_diarios.requestFocus();
        km_del_mes = (EditText)findViewById(R.id.km_del_mes);
        na_1 = (CheckBox)findViewById(R.id.cb_na_1);
        na_2 = (CheckBox)findViewById(R.id.cb_na_2);
        na_3 = (CheckBox)findViewById(R.id.cb_na_3);
        na_4 = (CheckBox)findViewById(R.id.cb_na_4);
        ex_1 = (CheckBox)findViewById(R.id.cb_ex_1);
        ex_2 = (CheckBox)findViewById(R.id.cb_ex_2);
        ex_3 = (CheckBox)findViewById(R.id.cb_ex_3);
        ex_4 = (CheckBox)findViewById(R.id.cb_ex_4);
        btn_calculadora = (ImageButton) findViewById(R.id.btn_calculadora);
        btn_calculadora.setEnabled(false);
        tabla_resultados = (TableLayout) findViewById(R.id.tabla_resultados);
        km_diarios.addTextChangedListener(new TextCambioListener(){
            public void onTextChanged(CharSequence secuencia, int start, int before, int count) {
                tabla_resultados.setVisibility(View.GONE);
                btn_calculadora.setEnabled(!secuencia.toString().trim().isEmpty());
            }
        });

        resultado1 = (TextView) findViewById(R.id.txt_resultado_1);
        resultado2 = (TextView) findViewById(R.id.txt_resultado_2);
        resultado3 = (TextView) findViewById(R.id.txt_resultado_3);
        acumula_dieta = (TextView) findViewById(R.id.acumula_dieta);

        btn_precio_km = (Button) findViewById(R.id.btn_precio_km);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.item_calcular) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClicCalculadora(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus()
        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        tabla_resultados.setVisibility(View.VISIBLE);
        valorizar();

    }

    private void valorizar() {
        if (km_diarios.getText().toString().equals("")){
            kilometrosDiarios = 0;
        }else{
            kilometrosDiarios = Integer.parseInt(km_diarios.getText().toString());
        }
        if (km_del_mes.getText().toString().equals("")){}
        Double kmsFdietas = pMedio_kilometroFijo(Integer.parseInt(km_del_mes.getText().toString()))*kilometrosDiarios;
        Double kmsVdietas = pMedio_kilometroDieta(Integer.parseInt(km_del_mes.getText().toString()))*kilometrosDiarios;


        resultado1.setText(String.valueOf(RedondeoDosCifras(dieta+kmsVdietas+kmsFdietas))+" €");
        resultado2.setText(String.valueOf(RedondeoDosCifras(kilometrosDiarios* Cc.a0117))+" €");
        resultado3.setText(String.valueOf(RedondeoDosCifras(kilometrosDiarios*Cc.a0117-(dieta+kmsVdietas+kmsFdietas)))+" €");
    }

    public  void onClickPrecioKm(View view){
        //TODO: Accion de cambio de precio de kilómetro
    }
    public double Redondeo(double numero)
    {
        return Math.rint(numero*10000)/10000;
    }
    public double RedondeoDosCifras(double numero)
    {
        return Math.rint(numero*100)/100;
    }
    public static Double pMedio_kilometroFijo (int km_mensuales){
        if (km_mensuales!=0 && km_mensuales <=10000){
            return Cc.KF_me_10;}
        else{
            return (10000*Cc.KF_me_10+((km_mensuales-10000)*Cc.KF_MA_10))/km_mensuales;
        }
    }
    public Double pMedio_kilometroDieta (int km_mensuales){
        if (km_mensuales!=0 && km_mensuales <=10000){
            return Cc.KD_me_10;}
        else{
            return (10000*Cc.KD_me_10+((km_mensuales-10000)*Cc.KD_MA_10))/km_mensuales;
        }
    }
}
