package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Flora;
import com.karol.biopedia.R;

public class CadastroFlora extends AppCompatActivity {

    private EditText editDominio;
    private EditText editClasseF;
    private EditText editFiloF;
    private EditText editOrdemF;
    private EditText editDivisao;
    private EditText editFamiliaF;
    private EditText editGeneroF;
    private EditText editEspecieF;
    private EditText editGrupo;
    private EditText editNomeCientificoF;
    private EditText editNomeComumF;
    private EditText editNomeIngF;
    private EditText editNutricao;
    private EditText editClassificacao;
    private EditText editReproducaoF;
    private EditText editCaracteristicasF;
    private EditText editTipoCel;
    private EditText editOrgCel;
    private Button btnCadastrarFlora, btnVoltar;
    private DatabaseReference firebase;
    private Flora flora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_flora);


        editOrdemF = (EditText) findViewById(R.id.editOrdemF);
        editFamiliaF = (EditText) findViewById(R.id.editFamiliaF);
        editDominio = (EditText) findViewById(R.id.editDominio);
        editClasseF = (EditText) findViewById(R.id.editClasseF);
        editFiloF = (EditText) findViewById(R.id.editFiloF);
        editDivisao = (EditText) findViewById(R.id.editDivisao);
        editGeneroF = (EditText) findViewById(R.id.editGeneroF);
        editEspecieF = (EditText) findViewById(R.id.editEspecieF);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editNomeCientificoF = (EditText) findViewById(R.id.editNomeCientificoF);
        editNomeIngF = (EditText) findViewById(R.id.editNomeIngF);
        editNomeComumF = (EditText) findViewById(R.id.editNomeComumF);
        editNutricao= (EditText) findViewById(R.id.editNutricao);
        editClassificacao = (EditText) findViewById(R.id.editClassificacao);
        editReproducaoF = (EditText) findViewById(R.id.editReproducaoF);
        editCaracteristicasF = (EditText) findViewById(R.id.editCaracteristicasF);
        editTipoCel = (EditText) findViewById(R.id.editTipoCel);
        editOrgCel = (EditText) findViewById(R.id.editOrgCel);
        btnCadastrarFlora = (Button) findViewById(R.id.btnCadastrarFlora);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnCadastrarFlora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flora = new Flora();
                flora.setNomeIngF(editNomeIngF.getText().toString());
                flora.setNomeCientificoF(editNomeCientificoF.getText().toString());
                flora.setNomeComumF(editNomeComumF.getText().toString());
                flora.setOrdemF(editOrdemF.getText().toString());
                flora.setFamiliaF(editFamiliaF.getText().toString());
                flora.setDominio(editDominio.getText().toString());
                flora.setClasseF(editClasseF.getText().toString());
                flora.setFiloF(editFiloF.getText().toString());
                flora.setDivisao(editDivisao.getText().toString());
                flora.setGeneroF(editGeneroF.getText().toString());
                flora.setEspecieF(editEspecieF.getText().toString());
                flora.setGrupo(editGrupo.getText().toString());
                flora.setNutricao(editNutricao.getText().toString());
                flora.setClassificacao(editClassificacao.getText().toString());
                flora.setReproducaoF(editReproducaoF.getText().toString());
                flora.setCaracteristicasF(editCaracteristicasF.getText().toString());
                flora.setTipoCel(editTipoCel.getText().toString());
                flora.setOrgCel(editOrgCel.getText().toString());

                salvarPlantas(flora);
                limparCampos();

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarTelaInicio();
            }
        });

    }

    private boolean salvarPlantas( Flora flora){
        try{
            firebase = ConfiguracaoFirebase.getFirebase().child("newplanta");
            firebase.child(flora.getNomeComumF()).setValue(flora);
            Toast.makeText(CadastroFlora.this, "Planta cadastrada com sucesso!",Toast.LENGTH_LONG).show();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private void voltarTelaInicio(){
        Intent intent = new Intent(CadastroFlora.this, PrincipalActivity.class );
        startActivity(intent);
        finish();
    }

    private void limparCampos(){
        editNomeIngF.setText("");
        editClassificacao.setText("");
        editEspecieF.setText("");
        editOrgCel.setText("");
        editCaracteristicasF.setText("");
        editTipoCel.setText("");
        editFamiliaF.setText("");
        editOrdemF.setText("");
        editReproducaoF.setText("");
        editFiloF.setText("");
        editNutricao.setText("");
        editDominio.setText("");
        editClasseF.setText("");
        editGeneroF.setText("");
        editGrupo.setText("");
        editNomeComumF.setText("");
        editNomeCientificoF.setText("");
        editDivisao.setText("");
    }
}
