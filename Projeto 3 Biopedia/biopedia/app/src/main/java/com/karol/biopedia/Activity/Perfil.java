package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.karol.biopedia.R;

public class Perfil extends AppCompatActivity {

    private Button  btnVolTelaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnVolTelaPrincipal = (Button) findViewById(R.id.btnVolTelaPrincipal);

        btnVolTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });
    }
    private void voltar(){
        Intent intent = new Intent(Perfil.this, PrincipalActivity.class );
        startActivity(intent);
        finish();
    }
}
