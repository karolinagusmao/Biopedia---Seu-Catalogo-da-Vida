package com.karol.biopedia.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.karol.biopedia.Entidades.Adapter.PlantasAdapter;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Flora;
import com.karol.biopedia.R;

import java.util.ArrayList;

public class ViewFlora extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<Flora> adapter;
    private ArrayList<Flora> plantas;
    private DatabaseReference firebase;
    private DatabaseReference referenciaFirebase;
    private ValueEventListener valueEventListenerPlantas;
    private Button btnVoltTelaPrincipal;
    private AlertDialog alerta;
    private Flora floraExcluir;
    private Flora plantaSelecionado;
    private Flora plantaEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flora);

        plantas = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewPlantas);
        searchView = (SearchView) findViewById(R.id.pesquisaPlanta);
        adapter = new PlantasAdapter(this, plantas);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("newplanta");

        valueEventListenerPlantas = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                plantas.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    Flora floraNovo = dados.getValue(Flora.class);

                    plantas.add(floraNovo);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        btnVoltTelaPrincipal = (Button) findViewById(R.id.btnVoltTelaPrincipal);
        btnVoltTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewFlora.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final Flora plantaSelecionado = (Flora) adapter.getItem(position);
                floraExcluir = adapter.getItem(position);
                plantaEditar = adapter.getItem(position);

                //cria o gerador de alertDialog
                AlertDialog.Builder opcoes = new AlertDialog.Builder(ViewFlora.this);

                //define o titulo
                opcoes.setTitle("Escolha:");
                //define uma mensagem
                opcoes.setMessage("O que deseja fazer com a planta selecionada?");

                opcoes.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                //botao excluir
                opcoes.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        firebase = ConfiguracaoFirebase.getFirebase().child("newplanta");

                        firebase.child(floraExcluir.getNomeComumF().toString()).removeValue();

                        Toast.makeText(ViewFlora.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                opcoes.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bundle bundleDadosPlanta = new Bundle();


                        bundleDadosPlanta.putString("filo_planta", plantaSelecionado.getFiloF());
                        bundleDadosPlanta.putString("classe_planta", plantaSelecionado.getClasseF());
                        bundleDadosPlanta.putString("classificacao_planta", plantaSelecionado.getClassificacao());
                        bundleDadosPlanta.putString("ordem_planta", plantaSelecionado.getOrdemF());
                        bundleDadosPlanta.putString("reproducao_planta", plantaSelecionado.getReproducaoF());
                        bundleDadosPlanta.putString("familia_planta", plantaSelecionado.getFamiliaF());
                        bundleDadosPlanta.putString("genero_planta", plantaSelecionado.getGeneroF());
                        bundleDadosPlanta.putString("especie_planta", plantaSelecionado.getEspecieF());
                        bundleDadosPlanta.putString("nutricao_planta", plantaSelecionado.getNutricao());
                        bundleDadosPlanta.putString("nomeCom_planta", plantaSelecionado.getNomeComumF());
                        bundleDadosPlanta.putString("nomeCient_planta", plantaSelecionado.getNomeCientificoF());
                        bundleDadosPlanta.putString("nomeIng_planta", plantaSelecionado.getNomeIngF());
                        bundleDadosPlanta.putString("tipocel_planta", plantaSelecionado.getTipoCel());
                        bundleDadosPlanta.putString("orgcel_planta", plantaSelecionado.getOrgCel());
                        bundleDadosPlanta.putString("dominio_planta", plantaSelecionado.getDominio());
                        bundleDadosPlanta.putString("divisao_planta", plantaSelecionado.getDivisao());
                        bundleDadosPlanta.putString("grupo_planta", plantaSelecionado.getGrupo());
                        bundleDadosPlanta.putString("caracteristicas_planta", plantaSelecionado.getCaracteristicasF());


                        Intent intentEditarPlanta = new Intent(ViewFlora.this, EditarPlantas.class);
                        intentEditarPlanta.putExtras(bundleDadosPlanta);
                        startActivity(intentEditarPlanta);

                    }
                });

                //exibe alerta
                opcoes.create().show();

            }

        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Flora> templist = new ArrayList<>();
                for (Flora temp : plantas){
                    if (temp.toString().contains(newText.toString())){
                        templist.add(temp);
                    }
                }
                ArrayAdapter<Flora> adapter = new ArrayAdapter<>(ViewFlora.this, android.R.layout.simple_list_item_1, templist);
                listView.setAdapter(adapter);
                return true;
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerPlantas);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerPlantas);
    }
}

