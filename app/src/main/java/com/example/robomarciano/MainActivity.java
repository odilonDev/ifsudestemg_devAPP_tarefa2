package com.example.robomarciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtComando;
    public static String varResultado, varComando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Robô Marciano");

        edtComando = findViewById(R.id.edtComando);

        Button btnComando = findViewById(R.id.btnComando);
        btnComando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varComando = edtComando.getText().toString();
                if (varComando.equals("FIM")) {
                    finish();
                    System.exit(0);
                }else if ((varComando.equals("some"))||(varComando.equals("subtraia"))||(varComando.equals("multiplique"))||
                        (varComando.equals("divida"))||(varComando.equals("adivinhe"))||(varComando.equals("agir"))){
                    Intent telaCalculo = new Intent(MainActivity.this, TelaCalculo.class);
                    startActivity(telaCalculo);
                }else {
                    varResultado = robo1.responda(varComando);
                    Intent telaResultado = new Intent(MainActivity.this, TelaResultado.class);
                    startActivity(telaResultado);
                    MainActivity.this.finishAffinity();
                }
            }
        });
    }

    RoboPremium robo1 = new RoboPremium();
}