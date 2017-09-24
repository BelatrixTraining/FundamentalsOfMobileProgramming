package com.belatrix.fundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;

public class CalculadoraBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CalculadoraBaseA";
    private EditText editTextOp1;
    private EditText editTextOp2;
    private TextView tviOp;

    private View iviSum, iviSubtract, iviMultiply, iviDivide;

    private int op1, op2, op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        ui();
    }

    private void ui() {

        editTextOp1 = (EditText) findViewById(R.id.editTextOp1);
        editTextOp2 = (EditText) findViewById(R.id.editTextOp2);
        tviOp = (TextView) findViewById(R.id.tviOp);

        iviSum = findViewById(R.id.iviSum);
        iviSubtract = findViewById(R.id.iviSubtract);
        iviMultiply = findViewById(R.id.iviMultiply);
        iviDivide = findViewById(R.id.iviDivide);

        iviSum.setOnClickListener(this);
        iviSubtract.setOnClickListener(this);
        iviMultiply.setOnClickListener(this);
        iviDivide.setOnClickListener(this);
    }

    private boolean validar(){

        String mValor1=editTextOp1.getText().toString().trim();
        String mValor2=editTextOp2.getText().toString().trim();
        if(mValor1.isEmpty() || mValor2.isEmpty()){
            return false;
        }
        return true;
    }
    @Override
    public void onClick(View v) {

        //TODO capturar valores
        if(!validar()) {
            Toast.makeText(this,"Ingresar valores válidos",Toast.LENGTH_LONG).show();
            return;
        };

        String resultado = "";
        String mValor1 = editTextOp1.getText().toString().trim();
        int valor1 = Integer.parseInt(mValor1);
        int valor2 = Integer.parseInt(editTextOp2.getText().toString().trim());
        //int valor1= Integer.parseInt(editTextOp1.getText().toString().trim());
        Log.v("CONSOLE", String.format("valor1 : %s valor2 : %s", valor1, valor2));

        //TODO operaciones
        switch (v.getId()) {
            case R.id.iviSum:
                Log.v(TAG, "sumar");
                //op= 1;
                resultado = " " + suma(valor1, valor2);
                break;

            case R.id.iviSubtract:
                Log.v(TAG, "restar");
                //resultado= " "+restar(valor1,valor2);
                //op= 2;
                resultado = " " + restar(valor1, valor2);
                break;

            case R.id.iviMultiply:
                Log.v(TAG, "multiplicar");
                resultado = " " + multiplicar(valor1, valor2);
                //op=3;
                break;

            case R.id.iviDivide:
                Log.v(TAG, "dividir");
                resultado = " " + dividir(valor1, valor2);
                //op=4;
                break;

        }
        //resultado= " "+procesar(op,valor1,valor2);
        //TODO mostrar resultados
        tviOp.setText("Resultado " + resultado);

    }

    private int procesar(int op, int v1, int v2) {
        switch (op) {
            case 0:
                return suma(v1, v2);
            default:
                return 0;
        }

    }

    private int suma(int v1, int v2) {
        return v1 + v2;
    }

    private int restar(int v1, int v2) {
        return v1 - v2;
    }

    private int multiplicar(int v1, int v2) {
        return v1 * v2;
    }

    private float dividir(int v1, int v2) {
        if (v2 == 0) {
            return 0;
        }
        //int mV2=(v2==0)?(1):v2;

        //return  v1/v2;
        return 1.0f * v1 / v2;
    }
}
