package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.karol.biopedia.R;

public class InicioFlora extends AppCompatActivity {

    private Button btnVerPlanta, btnAddPlanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_flora);

        btnVerPlanta = (Button) findViewById(R.id.btnVerPlanta);
        btnAddPlanta = (Button) findViewById(R.id.btnAddPlanta);

        btnVerPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPlanta();
            }
        });


        btnAddPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlanta();
            }
        });
    }

    private void verPlanta() {
        Intent intent = new Intent( InicioFlora.this, ViewFlora.class);
        startActivity(intent);
        finish();
    }


    private void addPlanta() {
        Intent intent = new Intent( InicioFlora.this, CadastroFlora.class);
        startActivity(intent);
        finish();
    }
}
