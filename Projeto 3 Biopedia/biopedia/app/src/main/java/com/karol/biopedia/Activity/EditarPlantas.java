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

public class EditarPlantas extends AppCompatActivity {

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
    private Button btnEditarFlora, btnVoltar4;
    private DatabaseReference firebase;
    private Flora flora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_plantas);

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
        btnEditarFlora = (Button) findViewById(R.id.btnEditarFlora);
        btnVoltar4 = (Button) findViewById(R.id.btnVoltar4);

        final Bundle bundleDadosPlanta = getIntent().getExtras();

        final Flora flora = new Flora();

        flora.setFiloF(bundleDadosPlanta.getString("filo_planta"));
        flora.setNomeIngF(bundleDadosPlanta.getString("nomeIng_planta"));
        flora.setOrgCel(bundleDadosPlanta.getString("orgcel_planta"));
        flora.setTipoCel(bundleDadosPlanta.getString("tipocel_planta"));
        flora.setClasseF(bundleDadosPlanta.getString("classe_planta"));
        flora.setEspecieF(bundleDadosPlanta.getString("especie_planta"));
        flora.setClassificacao(bundleDadosPlanta.getString("classificacao_planta"));
        flora.setNutricao(bundleDadosPlanta.getString("nutricao_planta"));
        flora.setFamiliaF(bundleDadosPlanta.getString("familia_planta"));
        flora.setGrupo(bundleDadosPlanta.getString("grupo_planta"));
        flora.setDivisao(bundleDadosPlanta.getString("divisao_planta"));
        flora.setDominio(bundleDadosPlanta.getString("dominio_planta"));
        flora.setNomeCientificoF(bundleDadosPlanta.getString("nomeCient_planta"));
        flora.setNomeComumF(bundleDadosPlanta.getString("nomeCom_planta"));
        flora.setCaracteristicasF(bundleDadosPlanta.getString("caracteristicas_planta"));
        flora.setReproducaoF(bundleDadosPlanta.getString("reproducao_planta"));
        flora.setOrdemF(bundleDadosPlanta.getString("ordem_planta"));
        flora.setGeneroF(bundleDadosPlanta.getString("genero_planta"));

        this.setDadosPlanta((flora));

        btnEditarFlora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarPlanta(flora);
            }
        });

        btnVoltar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarTelaViewPlanta();
            }
        });

    }

    private boolean atualizarPlanta( Flora flora){
        try{
            firebase = ConfiguracaoFirebase.getFirebase().child("newplanta");
            firebase.child(flora.getNomeComumF()).setValue(flora);
            Toast.makeText(EditarPlantas.this, "Planta atualizada com sucesso!",Toast.LENGTH_LONG).show();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private void setDadosPlanta(Flora flora){

        this.editFiloF.setText(flora.getFiloF());
        this.editNomeCientificoF.setText(flora.getNomeCientificoF());
        this.editNomeComumF.setText(flora.getNomeComumF());
        this.editNomeIngF.setText(flora.getNomeIngF());
        this.editGrupo.setText(flora.getGrupo());
        this.editGeneroF.setText(flora.getGeneroF());
        this.editDivisao.setText(flora.getDivisao());
        this.editClasseF.setText(flora.getClasseF());
        this.editEspecieF.setText(flora.getEspecieF());
        this.editNutricao.setText(flora.getNutricao());
        this.editFamiliaF.setText(flora.getFamiliaF());
        this.editDominio.setText(flora.getDominio());
        this.editOrdemF.setText(flora.getOrdemF());
        this.editClassificacao.setText(flora.getClassificacao());
        this.editClasseF.setText(flora.getClasseF());
        this.editCaracteristicasF.setText(flora.getCaracteristicasF());
        this.editTipoCel.setText(flora.getTipoCel());
        this.editOrgCel.setText(flora.getOrgCel());
    }

    private void voltarTelaViewPlanta(){
        Intent intent = new Intent(EditarPlantas.this, ViewFlora.class );
        startActivity(intent);
        finish();
    }
}
