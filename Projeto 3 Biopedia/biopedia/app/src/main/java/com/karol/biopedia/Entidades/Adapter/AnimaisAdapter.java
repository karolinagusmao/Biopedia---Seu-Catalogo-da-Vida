package com.karol.biopedia.Entidades.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.karol.biopedia.Entidades.Fauna;
import com.karol.biopedia.R;

import java.util.ArrayList;

public class AnimaisAdapter extends ArrayAdapter<Fauna>{

    private ArrayList<Fauna> animais;
    private Context context;

    public AnimaisAdapter( Context c, ArrayList<Fauna> animal) {
        super(c,0, animal);
        this.context = c;
        this.animais = animal;
    }
 //conta quantos itens tem na lista
    @Override
    public int getCount(){
        return this.animais.size();
    }

    //pega um item pela posição
    @Override
    public Fauna getItem(int position){
        return this.animais.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public void excluirAnimal (int position){
        this.animais.remove(position);
        notifyDataSetChanged();
    }

    //metodo que é chamado e pega os componentes
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View view = null;

        if (animais != null){
            // cria um objeto "inflador"
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            // usa o inflador para criar uma View a partir do arquivo de layout com os itens
            view = inflater.inflate(R.layout.lista_animal, parent, false);

            //pega referências para as views que definimos dentro do item da lista
            TextView txtViewFilo = (TextView) view.findViewById(R.id.txtViewFilo);
            TextView txtViewClasse = (TextView) view.findViewById(R.id.txtViewClasse);
            TextView txtViewInfraclasse = (TextView) view.findViewById(R.id.txtViewInfraclasse);
            TextView txtViewOrdem = (TextView) view.findViewById(R.id.txtViewOrdem);
            TextView txtViewSuperfamilia = (TextView) view.findViewById(R.id.txtViewSuperfamilia);
            TextView txtViewFamilia = (TextView) view.findViewById(R.id.txtViewFamilia);
            TextView txtViewGenero = (TextView) view.findViewById(R.id.txtViewGenero);
            TextView txtViewEspecie = (TextView) view.findViewById(R.id.txtViewEspecie);
            TextView txtViewSubespecie = (TextView) view.findViewById(R.id.txtViewSubespecie);
            TextView txtViewNomeComum = (TextView) view.findViewById(R.id.txtViewNomeComum);
            TextView txtViewNomeCient = (TextView) view.findViewById(R.id.txtViewNomeCient);
            TextView txtViewNomeIng = (TextView) view.findViewById(R.id.txtViewNomeIng);
            TextView txtViewSexo = (TextView) view.findViewById(R.id.txtViewSexo);
            TextView txtViewHabitat = (TextView) view.findViewById(R.id.txtViewHabitat);
            TextView txtViewReproducao = (TextView) view.findViewById(R.id.txtViewReproducao);
            TextView txtViewIdade = (TextView) view.findViewById(R.id.txtViewIdade);
            TextView txtViewConserv = (TextView) view.findViewById(R.id.txtViewConserv);
            TextView txtViewCaract = (TextView) view.findViewById(R.id.txtViewCaract);


            // usa esse valor (position) para acessar o objeto  correto
            Fauna fauna2 = animais.get(position);

            //coloca os valores dos objetos recuperado nas views que formam o item da lista
            txtViewFilo.setText(fauna2.getFilo());
            txtViewClasse.setText(fauna2.getClasse());
            txtViewInfraclasse.setText(fauna2.getInfraClasse());
            txtViewOrdem.setText(fauna2.getOrdem());
            txtViewSuperfamilia.setText(fauna2.getSuperFamilia());
            txtViewFamilia.setText(fauna2.getFamilia());
            txtViewGenero.setText(fauna2.getGenero());
            txtViewEspecie.setText(fauna2.getEspecie());
            txtViewSubespecie.setText(fauna2.getSubEspecie());
            txtViewNomeComum.setText(fauna2.getNomeComum());
            txtViewNomeCient.setText(fauna2.getNomeCientifico());
            txtViewNomeIng.setText(fauna2.getNomeIng());
            txtViewSexo.setText(fauna2.getSexoAnimal());
            txtViewHabitat.setText(fauna2.getHabitat());
            txtViewReproducao.setText(fauna2.getReproducao());
            txtViewIdade.setText(fauna2.getIdadeAnimal());
            txtViewConserv.setText(fauna2.getConservacao());
            txtViewCaract.setText(fauna2.getCaracteristicas());

            view.setTag(animais.get(position).getId());
        }
        return view;
    }
}
