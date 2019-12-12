package com.karol.biopedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Fauna;
import com.karol.biopedia.R;

public class EditarAnimais extends AppCompatActivity {

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
    private Fauna animalEditar;
    private DatabaseReference databaseReference;
    private DatabaseReference firebase;
    private Fauna fauna;
    private EditarAnimais data;
    private Button btnVoltar3, btnAtualizarAnimal;
    private Adapter adapter;

    private String key;

    private int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_animais);

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
        rbVertebrados = (RadioButton) findViewById(R.id.rbVertebrados);
        rbInvertebrados = (RadioButton) findViewById(R.id.rbInvertebrados);
        btnVoltar3 = (Button) findViewById(R.id.btnVoltar3);
        btnAtualizarAnimal = (Button) findViewById(R.id.btnAtualizarAnimal);

        final Bundle bundleDadosAnimal = getIntent().getExtras();

        final Fauna fauna = new Fauna();

        fauna.setFilo(bundleDadosAnimal.getString("filo_animal"));
        fauna.setNomeIng(bundleDadosAnimal.getString("nomeIng_animal"));
        fauna.setIdadeAnimal(bundleDadosAnimal.getString("idade_animal"));
        fauna.setInfraClasse(bundleDadosAnimal.getString("infraclasse_animal"));
        fauna.setClasse(bundleDadosAnimal.getString("classe_animal"));
        fauna.setEspecie(bundleDadosAnimal.getString("especie_animal"));
        fauna.setSuperFamilia(bundleDadosAnimal.getString("superFam_animal"));
        fauna.setSubEspecie(bundleDadosAnimal.getString("subespecie_animal"));
        fauna.setFamilia(bundleDadosAnimal.getString("familia_animal"));
        fauna.setHabitat(bundleDadosAnimal.getString("habitat_animal"));
        fauna.setSexoAnimal(bundleDadosAnimal.getString("sexo_animal"));
        fauna.setConservacao(bundleDadosAnimal.getString("conservacao_animal"));
        fauna.setNomeCientifico(bundleDadosAnimal.getString("nomeCient_animal"));
        fauna.setNomeComum(bundleDadosAnimal.getString("nomeCom_animal"));
        fauna.setCaracteristicas(bundleDadosAnimal.getString("caracteristicas_animal"));
        fauna.setReproducao(bundleDadosAnimal.getString("reproducao_animal"));
        fauna.setOrdem(bundleDadosAnimal.getString("ordem_animal"));
        fauna.setGenero(bundleDadosAnimal.getString("genero_animal"));

        this.setDadosAnimal((fauna));

        btnAtualizarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atualizarAnimal(fauna);

            }
        });


        btnVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarTelaViewAnimal();
            }
        });

    }


    private boolean atualizarAnimal( Fauna fauna){

        try{

            databaseReference = ConfiguracaoFirebase.getFirebase().child("newanimal");
            databaseReference.child(fauna.getNomeComum()).setValue(fauna);

            Toast.makeText(EditarAnimais.this, "Animal atualizado com sucesso!",Toast.LENGTH_LONG).show();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    private void setDadosAnimal(Fauna fauna){

        this.editFilo.setText(fauna.getFilo());
        this.editNomeCientifico.setText(fauna.getNomeCientifico());
        this.editNomeComum.setText(fauna.getNomeComum());
        this.editNomeIng.setText(fauna.getNomeIng());
        this.editIdade.setText(fauna.getIdadeAnimal());
        this.editInfraclasse.setText(fauna.getInfraClasse());
        this.editCaracteristicas.setText(fauna.getCaracteristicas());
        this.editClasse.setText(fauna.getClasse());
        this.editEspecie.setText(fauna.getEspecie());
        this.editSubespecie.setText(fauna.getSubEspecie());
        this.editFamilia.setText(fauna.getFamilia());
        this.editSuperfamilia.setText(fauna.getSuperFamilia());
        this.editOrdem.setText(fauna.getOrdem());
        this.editHabitat.setText(fauna.getHabitat());
        this.editConservacao.setText(fauna.getConservacao());
        this.editReproducao.setText(fauna.getReproducao());
        this.editGenero.setText(fauna.getGenero());
        this.editSexoAnimal.setText(fauna.getSexoAnimal());
    }

    private void voltarTelaViewAnimal(){
        Intent intent = new Intent(EditarAnimais.this, ViewFauna.class );
        startActivity(intent);
        finish();
    }
}
