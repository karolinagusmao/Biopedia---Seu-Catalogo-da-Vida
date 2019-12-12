package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Fauna;
import com.karol.biopedia.R;

public class CadastroFauna extends AppCompatActivity {

    private EditText editHabitat;
    private EditText editNomeCientifico;
    private EditText editNomeComum;
    private EditText editSubespecie;
    private EditText editGenero;
    private EditText editClasse;
    private EditText editInfraclasse;
    private EditText editSexoAnimal;
    private EditText editFilo;
    private EditText editReproducao;
    private EditText editOrdem;
    private EditText editFamilia;
    private EditText editSuperfamilia;
    private EditText editCaracteristicas;
    private EditText editConservacao;
    private EditText editEspecie;
    private EditText editIdade;
    private EditText editNomeIng;
    private RadioButton rbInvertebrados;
    private RadioButton rbVertebrados;
    private Button btnCadastrarFauna, btnVoltar1;
    private DatabaseReference firebase;
    private Fauna fauna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fauna);

        editHabitat = (EditText) findViewById(R.id.editHabitat);
        editNomeCientifico = (EditText) findViewById(R.id.editNomeCientifico);
        editNomeComum = (EditText) findViewById(R.id.editNomeComum);
        editSubespecie = (EditText) findViewById(R.id.editSubespecie);
        editGenero = (EditText) findViewById(R.id.editGenero);
        editClasse = (EditText) findViewById(R.id.editClasse);
        editInfraclasse = (EditText) findViewById(R.id.editInfraclasse);
        editSexoAnimal = (EditText) findViewById(R.id.editSexoAnimal);
        editFilo = (EditText) findViewById(R.id.editFilo);
        editReproducao = (EditText) findViewById(R.id.editReproducao);
        editOrdem = (EditText) findViewById(R.id.editOrdem);
        editFamilia = (EditText) findViewById(R.id.editFamilia);
        editSuperfamilia = (EditText) findViewById(R.id.editSuperfamilia);
        editCaracteristicas = (EditText) findViewById(R.id.editCaracteristicas);
        editConservacao = (EditText) findViewById(R.id.editConservacao);
        editEspecie = (EditText) findViewById(R.id.editEspecie);
        editIdade = (EditText) findViewById(R.id.editIdadeAnimal);
        editNomeIng = (EditText) findViewById(R.id.editNomeIng);
        rbInvertebrados = (RadioButton) findViewById(R.id.rbInvertebrados);
        rbVertebrados = (RadioButton) findViewById(R.id.rbVertebrados);
        btnCadastrarFauna = (Button) findViewById(R.id.btnCadastrarFauna);
        btnVoltar1 = (Button) findViewById(R.id.btnVoltar1);

        //evento de click
        btnCadastrarFauna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fauna = new Fauna();
                fauna.setHabitat(editHabitat.getText().toString());
                fauna.setNomeCientifico(editNomeCientifico.getText().toString());
                fauna.setNomeComum(editNomeComum.getText().toString());
                fauna.setSubEspecie(editSubespecie.getText().toString());
                fauna.setGenero(editGenero.getText().toString());
                fauna.setClasse(editClasse.getText().toString());
                fauna.setInfraClasse(editInfraclasse.getText().toString());
                fauna.setSexoAnimal(editSexoAnimal.getText().toString());
                fauna.setFilo(editFilo.getText().toString());
                fauna.setReproducao(editReproducao.getText().toString());
                fauna.setOrdem(editOrdem.getText().toString());
                fauna.setFamilia(editFamilia.getText().toString());
                fauna.setSuperFamilia(editSuperfamilia.getText().toString());
                fauna.setCaracteristicas(editCaracteristicas.getText().toString());
                fauna.setConservacao(editConservacao.getText().toString());
                fauna.setEspecie(editEspecie.getText().toString());
                fauna.setIdadeAnimal(editIdade.getText().toString());
                fauna.setNomeIng(editNomeIng.getText().toString());

                if (rbInvertebrados.isChecked()) {
                    fauna.setReino("Invertebrados");
                } else {
                    fauna.setReino("Vertebrados");
                }

                salvarAnimais(fauna);
                limparCampos();
            }

        });


        btnVoltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarTelaInicial();
            }
        });
    }

    private boolean salvarAnimais( Fauna fauna){
        try{
            firebase = ConfiguracaoFirebase.getFirebase().child("newanimal");
            firebase.child(fauna.getNomeComum()).setValue(fauna);
            Toast.makeText(CadastroFauna.this, "Animal cadastrado com sucesso!",Toast.LENGTH_LONG).show();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private void voltarTelaInicial(){
        Intent intent = new Intent(CadastroFauna.this, PrincipalActivity.class );
        startActivity(intent);
        finish();
    }

    private void limparCampos(){
        editNomeIng.setText("");
        editIdade.setText("");
        editEspecie.setText("");
        editConservacao.setText("");
        editCaracteristicas.setText("");
        editSuperfamilia.setText("");
        editFamilia.setText("");
        editOrdem.setText("");
        editReproducao.setText("");
        editFilo.setText("");
        editSexoAnimal.setText("");
        editInfraclasse.setText("");
        editClasse.setText("");
        editGenero.setText("");
        editSubespecie.setText("");
        editNomeComum.setText("");
        editNomeCientifico.setText("");
        editHabitat.setText("");

    }
}