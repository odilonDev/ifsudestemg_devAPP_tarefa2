package com.example.robomarciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);
        setTitle("Robô Marciano - "+MainActivity.varComando);

        TextView txtResultado = findViewById(R.id.txtResultado);
        txtResultado.setText(MainActivity.varResultado);

        Button btnRetornar = findViewById(R.id.btnRetornar);
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaComando = new Intent(TelaResultado.this, MainActivity.class);
                startActivity(telaComando);

                TelaResultado.this.finishAffinity();
            }});

    }
}