package com.example.jose.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jose.myapplication.util.Cc;
import com.example.jose.myapplication.util.TextCambioListener;


public class MainActivity extends ActionBarActivity {
    private EditText km_diarios, km_del_mes;
    private CheckBox na_1, na_2, na_3, na_4, ex_1, ex_2, ex_3, ex_4;
    private Button btn_precio_km;
    ImageButton btn_calculadora;
    private TableLayout tabla_resultados;
    private TextView resultado1,resultado2,resultado3,acumula_dieta;
    private Double dieta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarComponentes();
        dieta = 0d;



       na_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                           @Override
                                           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked){
                                                    dieta = Redondeo(dieta + Cc.NA_1);
                                                }else{
                                                    dieta = Redondeo(dieta - Cc.NA_1);
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", dieta));
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
                                                      }
                                                  }
        );
        ex_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                      @Override
                                                      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                          if (isChecked){
                                                              dieta = Redondeo(dieta + Cc.EX_1);
                                                          }else{
                                                              dieta = Redondeo(dieta - Cc.EX_1);
                                                          }
                                                          acumula_dieta.setText(String.format("( %s € )", dieta));
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
                                            }
                                        }
        );


        //

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

        km_diarios.addTextChangedListener(new TextCambioListener(){
            public void onTextChanged(CharSequence secuencia, int start, int before, int count) {

                btn_calculadora.setEnabled(!secuencia.toString().trim().isEmpty());
            }
        });
        tabla_resultados = (TableLayout) findViewById(R.id.tabla_resultados);
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
        tabla_resultados.setVisibility(View.VISIBLE);
        Double kmsFdietas = pMedio_kilometroFijo(Integer.parseInt(km_del_mes.getText().toString()))*Integer.parseInt(km_diarios.getText().toString());
        Double kmsVdietas = pMedio_kilometroDieta(Integer.parseInt(km_del_mes.getText().toString()))*Integer.parseInt(km_diarios.getText().toString());


        resultado1.setText(String.valueOf(RedondeoDosCifras(dieta+kmsVdietas+kmsFdietas)));
        resultado2.setText(String.valueOf(RedondeoDosCifras((Integer.parseInt(km_diarios.getText().toString())*Cc.a0117))));
        resultado3.setText(String.valueOf(RedondeoDosCifras(((Integer.parseInt(km_diarios.getText().toString())*Cc.a0117))-(dieta+kmsVdietas+kmsFdietas))));

    }
    public  void onClickPrecioKm(View view){
        //Toast.makeText(this,"onclick ok",Toast.LENGTH_SHORT).show();
        //btn_precio_km.setText("cambia el texto");
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
