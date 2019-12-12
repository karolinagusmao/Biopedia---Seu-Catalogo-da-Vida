package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.R;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirTelaActivityLogin;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificaUsuarioLogado();

        btnAbrirTelaActivityLogin = (Button) findViewById(R.id.btnEntrar);
        btnAbrirTelaActivityLogin.setOnClickListener(new View.OnClickListener()   {
            @Override
            public void onClick(View v) {
                Intent intentAbrirEntrar = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentAbrirEntrar);
            }
        });
    }

    private void verificaUsuarioLogado() {
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() != null) {
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
