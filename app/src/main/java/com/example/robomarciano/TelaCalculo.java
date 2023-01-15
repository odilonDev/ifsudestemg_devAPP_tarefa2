package com.example.robomarciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaCalculo extends AppCompatActivity {

    private TextView txtCampo1, txtCampo2;
    private EditText edtCampo1, edtCampo2;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculo);
        setTitle("Robô Marciano - "+MainActivity.varComando);

        txtCampo1 = findViewById(R.id.txtCampo1);
        txtCampo2 = findViewById(R.id.txtCampo2);
        edtCampo1 = findViewById(R.id.edtCampo1);
        edtCampo2 = findViewById(R.id.edtCampo2);
        btnCalcular = findViewById(R.id.btnCalculo);

        if (MainActivity.varComando.equals("adivinhe")){
            txtCampo1.setText("Número entre 1 e 5:");
            txtCampo2.setVisibility(View.INVISIBLE);
            edtCampo2.setVisibility(View.INVISIBLE);
            btnCalcular.setText("Adivinhar");
        }else if (MainActivity.varComando.equals("agir")){
            txtCampo1.setText("Ação:");
            edtCampo1.setInputType(InputType.TYPE_CLASS_TEXT);
            txtCampo2.setVisibility(View.INVISIBLE);
            edtCampo2.setVisibility(View.INVISIBLE);
            btnCalcular.setText("Agir");
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if ((MainActivity.varComando.equals("some"))||(MainActivity.varComando.equals("subtraia"))||(MainActivity.varComando.equals("multiplique"))||(MainActivity.varComando.equals("divida"))){
                    String operando1 = edtCampo1.getText().toString();
                    String operando2 = edtCampo2.getText().toString();
                    MainActivity.varResultado =  robo1.responda(MainActivity.varComando, operando1, operando2);
                }else if (MainActivity.varComando.equals("adivinhe")){
                    try {
                        Integer numero = Integer.valueOf(edtCampo1.getText().toString());
                        MainActivity.varResultado = robo1.responda(numero);
                    }catch (Exception ex){
                        MainActivity.varResultado = "Necesita ser digitado um número";
                    }
                }else if (MainActivity.varComando.equals("agir")){
                    String acao = edtCampo1.getText().toString();
                    MainActivity.varResultado = robo1.responda(MainActivity.varComando, acao);
                }
                Intent telaResultado = new Intent(TelaCalculo.this, TelaResultado.class);
                startActivity(telaResultado);
            }
        });
    }

    RoboPremium robo1 = new RoboPremium();
}