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
import com.karol.biopedia.Entidades.Adapter.AnimaisAdapter;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Fauna;
import com.karol.biopedia.R;

import java.util.ArrayList;

public class ViewFauna extends AppCompatActivity  {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<Fauna> adapter;
    private static ArrayList<Fauna> animais;
    private DatabaseReference referenciaFirebase;
    private ValueEventListener valueEventListenerAnimais;
    private Button btnVoltarTelaPrincipal;
    private AlertDialog alerta;
    private Fauna animalExcluir;
    private Fauna animalSelecionado;
    private Fauna animalEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fauna);

        animais = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewAnimais);
        searchView = (SearchView) findViewById(R.id.pesquisaAnimal);
        adapter = new AnimaisAdapter(this,animais);
        listView.setAdapter(adapter);

        referenciaFirebase = ConfiguracaoFirebase.getFirebase().child("newanimal");

        valueEventListenerAnimais = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                animais.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()){
                    Fauna faunaNovo = dados.getValue(Fauna.class);

                    animais.add(faunaNovo);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        btnVoltarTelaPrincipal = (Button) findViewById(R.id.btnVoltarTelaPrincipal);
        btnVoltarTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewFauna.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final Fauna animalSelecionado = (Fauna) adapter.getItem(position);
                animalExcluir = adapter.getItem(position);
                animalEditar = adapter.getItem(position);


                AlertDialog.Builder opcoes = new AlertDialog.Builder(ViewFauna.this);

                opcoes.setTitle("Escolha:");
                opcoes.setMessage("O que deseja fazer com o animal selecionado?");

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

                        referenciaFirebase =ConfiguracaoFirebase.getFirebase().child("newanimal");

                        referenciaFirebase.child(animalExcluir.getNomeComum().toString()).removeValue();

                        Toast.makeText(ViewFauna.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();

                    }
                });

                //botao editar
                opcoes.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Bundle bundleDadosAnimal = new Bundle();

                        bundleDadosAnimal.putString("filo_animal", animalSelecionado.getFilo());
                        bundleDadosAnimal.putString("classe_animal", animalSelecionado.getClasse());
                        bundleDadosAnimal.putString("infraclasse_animal", animalSelecionado.getInfraClasse());
                        bundleDadosAnimal.putString("ordem_animal", animalSelecionado.getOrdem());
                        bundleDadosAnimal.putString("superFam_animal", animalSelecionado.getSuperFamilia());
                        bundleDadosAnimal.putString("familia_animal", animalSelecionado.getFamilia());
                        bundleDadosAnimal.putString("genero_animal", animalSelecionado.getGenero());
                        bundleDadosAnimal.putString("especie_animal", animalSelecionado.getEspecie());
                        bundleDadosAnimal.putString("subespecie_animal", animalSelecionado.getSubEspecie());
                        bundleDadosAnimal.putString("nomeCom_animal", animalSelecionado.getNomeComum());
                        bundleDadosAnimal.putString("nomeCient_animal", animalSelecionado.getNomeCientifico());
                        bundleDadosAnimal.putString("nomeIng_animal", animalSelecionado.getNomeIng());
                        bundleDadosAnimal.putString("sexo_animal", animalSelecionado.getSexoAnimal());
                        bundleDadosAnimal.putString("habitat_animal", animalSelecionado.getHabitat());
                        bundleDadosAnimal.putString("reproducao_animal", animalSelecionado.getReproducao());
                        bundleDadosAnimal.putString("idade_animal", animalSelecionado.getIdadeAnimal());
                        bundleDadosAnimal.putString("conservacao_animal", animalSelecionado.getConservacao());
                        bundleDadosAnimal.putString("caracteristicas_animal", animalSelecionado.getCaracteristicas());


                        Intent intentEditarAnimal = new Intent( ViewFauna.this, EditarAnimais.class);
                        intentEditarAnimal.putExtras(bundleDadosAnimal);
                        startActivity(intentEditarAnimal);

                    }
                });

                //exibe alerta
                opcoes.create().show();

            }

        });

        //Search View
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Fauna> templist = new ArrayList<>();
                for (Fauna temp : animais){
                    if (temp.toString().contains(newText.toString())){
                        templist.add(temp);
                    }
                }
                ArrayAdapter<Fauna> adapter = new ArrayAdapter<>(ViewFauna.this, android.R.layout.simple_list_item_1, templist);
                listView.setAdapter(adapter); //informar quem é o adapter
                return true;
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        referenciaFirebase.removeEventListener(valueEventListenerAnimais);
    }

    @Override
    protected void onStart() {
        super.onStart();
        referenciaFirebase.addValueEventListener(valueEventListenerAnimais);
    }

}
