package com.example.jose.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
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
    private EditText km_diarios, km_del_mes, preciokilometro;
    private int kilometrosDiarios, kilometrosMensuales;
    private CheckBox na_1, na_2, na_3, na_4, ex_1, ex_2, ex_3, ex_4;
    private Button btn_precio_km;
    private float p_k;
    private String preciokm;
    ImageButton btn_calculadora;
    private TableLayout tabla_resultados;
    private TextView resultado1, resultado2, resultado3, acumula_dieta;
    private static Double Desayuno = 0d, Comida = 0d, Cena = 0d, Pernoctacion = 0d;
    private Double dieta; // = Desayuno + Comida +Cena+ Pernoctacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarComponentes();
        dieta = 0d;
        SharedPreferences prefs = getSharedPreferences("preferencias",
                MODE_PRIVATE);
        p_k = prefs.getFloat("preciokm", 11.7f);
        preciokilometro.setText(String.valueOf(p_k));


        //<editor-fold desc="LISTENER DE LOS CHECKBOX">
        na_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && ex_1.isChecked()) {
                                                    ex_1.setChecked(false);
                                                    Desayuno = Cc.NA_1;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Desayuno = Cc.NA_1;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else {
                                                    Desayuno = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();

                                            }
                                        }
        );
        na_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && ex_2.isChecked()) {
                                                    ex_2.setChecked(false);
                                                    Comida = Cc.NA_2;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Comida = Cc.NA_2;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else {
                                                    Comida = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();

                                            }
                                        }
        );
        na_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && ex_3.isChecked()) {
                                                    ex_3.setChecked(false);
                                                    Cena = Cc.NA_3;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Cena = Cc.NA_3;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else {
                                                    Cena = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();

                                            }
                                        }
        );
        na_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && ex_4.isChecked()) {
                                                    ex_4.setChecked(false);
                                                    Pernoctacion = Cc.NA_4;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Pernoctacion = Cc.NA_4;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }  else {
                                                    Pernoctacion = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();

                                            }
                                        }
        );
        ex_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && na_1.isChecked()) {
                                                    na_1.setChecked(false);
                                                    Desayuno = Cc.EX_1;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Desayuno = Cc.EX_1;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }  else {
                                                    Desayuno = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();
                                            }
                                        }
        );
        ex_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && na_2.isChecked()) {
                                                    na_2.setChecked(false);
                                                    Comida = Cc.EX_2;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Comida = Cc.EX_2;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }  else {
                                                    Comida = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();
                                            }
                                        }
        );
        ex_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && na_3.isChecked()) {
                                                    na_3.setChecked(false);
                                                    Cena = Cc.EX_3;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Cena = Cc.EX_3;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }  else {
                                                    Cena = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();
                                            }
                                        }
        );
        ex_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                            @Override
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked && na_4.isChecked()) {
                                                    na_4.setChecked(false);
                                                    Pernoctacion = Cc.EX_4;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                } else if (isChecked) {
                                                    Pernoctacion = Cc.EX_4;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }  else {
                                                    Pernoctacion = 0d;
                                                    dieta = Desayuno + Comida + Cena + Pernoctacion;
                                                }
                                                acumula_dieta.setText(String.format("( %s € )", Redondeo(dieta)));
                                                valorizar();
                                            }
                                        }
        );
        //</editor-fold>

    }

    private void cargarComponentes() {
        km_diarios = (EditText) findViewById(R.id.kms_diarios);
        km_diarios.requestFocus();
        km_del_mes = (EditText) findViewById(R.id.km_del_mes);
        na_1 = (CheckBox) findViewById(R.id.cb_na_1);
        na_2 = (CheckBox) findViewById(R.id.cb_na_2);
        na_3 = (CheckBox) findViewById(R.id.cb_na_3);
        na_4 = (CheckBox) findViewById(R.id.cb_na_4);
        ex_1 = (CheckBox) findViewById(R.id.cb_ex_1);
        ex_2 = (CheckBox) findViewById(R.id.cb_ex_2);
        ex_3 = (CheckBox) findViewById(R.id.cb_ex_3);
        ex_4 = (CheckBox) findViewById(R.id.cb_ex_4);
        btn_calculadora = (ImageButton) findViewById(R.id.btn_calculadora);
        btn_calculadora.setEnabled(false);
        tabla_resultados = (TableLayout) findViewById(R.id.tabla_resultados);
        km_diarios.addTextChangedListener(new TextCambioListener() {
            public void onTextChanged(CharSequence secuencia, int start, int before, int count) {
                tabla_resultados.setVisibility(View.GONE);
                btn_calculadora.setEnabled(!secuencia.toString().trim().isEmpty());
            }
        });

        resultado1 = (TextView) findViewById(R.id.txt_resultado_1);
        resultado2 = (TextView) findViewById(R.id.txt_resultado_2);
        resultado3 = (TextView) findViewById(R.id.txt_resultado_3);
        acumula_dieta = (TextView) findViewById(R.id.acumula_dieta);
        preciokilometro = (EditText) findViewById(R.id.preciokilometro);

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
        ocultateclado();
        tabla_resultados.setVisibility(View.VISIBLE);
        valorizar();

    }

    private void ocultateclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus()
                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private void valorizar() {
        if (km_diarios.getText().toString().equals("")) {
            kilometrosDiarios = 0;
        } else {
            kilometrosDiarios = Integer.parseInt(km_diarios.getText().toString());
        }
        if (km_del_mes.getText().toString().equals("")) {
        }
        Double kmsFdietas = pMedio_kilometroFijo(Integer.parseInt(km_del_mes.getText().toString())) * kilometrosDiarios;
        Double kmsVdietas = pMedio_kilometroDieta(Integer.parseInt(km_del_mes.getText().toString())) * kilometrosDiarios;


        resultado1.setText(String.valueOf(RedondeoDosCifras(dieta + kmsVdietas + kmsFdietas)) + " €");
        resultado2.setText(String.valueOf(RedondeoDosCifras(kilometrosDiarios * p_k/100)) + " €");
        resultado3.setText(String.valueOf(RedondeoDosCifras(kilometrosDiarios * p_k/100 - (dieta + kmsVdietas + kmsFdietas))) + " €");

        preciokilometro.setText(String.valueOf(p_k));
    }

    public void onClickPrecioKm(View view) {
        ocultateclado();
        if(!preciokilometro.getText().toString().equals("")){
        SharedPreferences preferen = getSharedPreferences(
                "preferencias", MODE_PRIVATE);
        p_k=Float.parseFloat(preciokilometro.getText().toString());
        SharedPreferences.Editor editor = preferen.edit();
        editor.putFloat("preciokm",p_k );
        editor.commit();}
        valorizar();
    }

    public double Redondeo(double numero) {
        return Math.rint(numero * 10000) / 10000;
    }

    public double RedondeoDosCifras(double numero) {
        return Math.rint(numero * 100) / 100;
    }

    public static Double pMedio_kilometroFijo(int km_mensuales) {
        if (km_mensuales != 0 && km_mensuales <= 10000) {
            return Cc.KF_me_10;
        } else {
            return (10000 * Cc.KF_me_10 + ((km_mensuales - 10000) * Cc.KF_MA_10)) / km_mensuales;
        }
    }

    public Double pMedio_kilometroDieta(int km_mensuales) {
        if (km_mensuales != 0 && km_mensuales <= 10000) {
            return Cc.KD_me_10;
        } else {
            return (10000 * Cc.KD_me_10 + ((km_mensuales - 10000) * Cc.KD_MA_10)) / km_mensuales;
        }
    }
}
