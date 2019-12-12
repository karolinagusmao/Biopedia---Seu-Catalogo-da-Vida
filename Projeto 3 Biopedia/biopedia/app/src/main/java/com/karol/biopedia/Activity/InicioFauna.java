package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.karol.biopedia.R;

public class InicioFauna extends AppCompatActivity {

    private Button btnVerAnimal, btnAddAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_fauna);

        btnVerAnimal = (Button) findViewById(R.id.btnVerAnimal);
        btnAddAnimal = (Button) findViewById(R.id.btnAddAnimal);

        btnVerAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verAnimal();
            }
        });

        btnAddAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnimal();
            }
        });

    }

    private void verAnimal() {
        Intent intent = new Intent( InicioFauna.this, ViewFauna.class);
        startActivity(intent);
        finish();
    }

    private void addAnimal() {
        Intent intent = new Intent( InicioFauna.this, CadastroFauna.class);
        startActivity(intent);
        finish();
    }
}
