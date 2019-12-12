package com.karol.biopedia.Entidades.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.karol.biopedia.Entidades.Flora;
import com.karol.biopedia.R;

import java.util.ArrayList;

public class PlantasAdapter extends ArrayAdapter<Flora> {

    private ArrayList<Flora> plantas;
    private Context context;

    public PlantasAdapter( Context c, ArrayList<Flora> planta) {
        super(c,0, planta);
        this.context = c;
        this.plantas = planta;
    }

    //conta quantos itens tem na lista
    @Override
    public int getCount(){
        return this.plantas.size();
    }

    //pega um item pela posição
    @Override
    public Flora getItem(int position){
        return this.plantas.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public void excluirPlanta (int position){
        this.plantas.remove(position);
        notifyDataSetChanged();
    }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {

       View view = null;

       if (plantas != null){
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

           view = inflater.inflate(R.layout.lista_planta, parent, false);

           TextView txtViewDominio = (TextView) view.findViewById(R.id.txtViewDominio);
           TextView txtViewClasseF = (TextView) view.findViewById(R.id.txtViewClasseF);
           TextView txtViewFiloF = (TextView) view.findViewById(R.id.txtViewFiloF);
           TextView txtViewOrdemF = (TextView) view.findViewById(R.id.txtViewOrdemF);
           TextView txtViewDivisao = (TextView) view.findViewById(R.id.txtViewDivisao);
           TextView txtViewFamilia = (TextView) view.findViewById(R.id.txtViewFamiliaF);
           TextView txtViewGenero = (TextView) view.findViewById(R.id.txtViewGeneroF);
           TextView txtViewEspecie = (TextView) view.findViewById(R.id.txtViewEspecieF);
           TextView txtViewGrupo = (TextView) view.findViewById(R.id.txtViewGrupo);
           TextView txtViewNomeComum = (TextView) view.findViewById(R.id.txtViewNomeComumF);
           TextView txtViewNomeCient = (TextView) view.findViewById(R.id.txtViewNomeCientF);
           TextView txtViewNomeIng = (TextView) view.findViewById(R.id.txtViewNomeIngF);
           TextView txtViewNutricao = (TextView) view.findViewById(R.id.txtViewNutricao);
           TextView txtViewClassificacao = (TextView) view.findViewById(R.id.txtViewClassificacao);
           TextView txtViewReproducaoF = (TextView) view.findViewById(R.id.txtViewReproducaoF);
           TextView txtViewOrgCel = (TextView) view.findViewById(R.id.txtViewOrgCel);
           TextView txtViewTipoCel = (TextView) view.findViewById(R.id.txtViewTipoCel);
           TextView txtViewCaractF = (TextView) view.findViewById(R.id.txtViewCaractF);

           Flora flora2 = plantas.get(position);

           txtViewDominio.setText(flora2.getDominio());
           txtViewClasseF.setText(flora2.getClasseF());
           txtViewFiloF.setText(flora2.getFiloF());
           txtViewOrdemF.setText(flora2.getOrdemF());
           txtViewDivisao.setText(flora2.getDivisao());
           txtViewFamilia.setText(flora2.getFamiliaF());
           txtViewGenero.setText(flora2.getGeneroF());
           txtViewEspecie.setText(flora2.getEspecieF());
           txtViewGrupo.setText(flora2.getGrupo());
           txtViewNomeComum.setText(flora2.getNomeComumF());
           txtViewNomeCient.setText(flora2.getNomeCientificoF());
           txtViewNomeIng.setText(flora2.getNomeIngF());
           txtViewNutricao.setText(flora2.getNutricao());
           txtViewClassificacao.setText(flora2.getClassificacao());
           txtViewReproducaoF.setText(flora2.getReproducaoF());
           txtViewOrgCel.setText(flora2.getOrgCel());
           txtViewTipoCel.setText(flora2.getTipoCel());
           txtViewCaractF.setText(flora2.getCaracteristicasF().toString());

       }

       return view;
   }
}
