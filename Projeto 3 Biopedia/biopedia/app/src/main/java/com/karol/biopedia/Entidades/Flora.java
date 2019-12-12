package com.karol.biopedia.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

public class Flora {

    private String id;
    private String classeF;
    private String dominio;
    private String ordemF;
    private String familiaF;
    private String generoF;
    private String especieF;
    private String nomeComumF;
    private String nomeCientificoF;
    private String nomeIngF;
    private String divisao;
    private String filoF;
    private String grupo;
    private String CaracteristicasF;
    private String tipoCel;
    private String orgCel;
    private String reproducaoF;
    private String classificacao;
    private String nutricao;

    public Flora() {
    }

    public void cadastrar(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("planta").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> hashMapPlanta = new HashMap<>();

        hashMapPlanta.put("id", getId());
        hashMapPlanta.put("nutricao", getNutricao());
        hashMapPlanta.put("classificacao", getClassificacao());
        hashMapPlanta.put("reproducao", getReproducaoF());
        hashMapPlanta.put("orgCel", getOrgCel());
        hashMapPlanta.put("tipoCel", getTipoCel());
        hashMapPlanta.put("caracteristicas", getCaracteristicasF());
        hashMapPlanta.put("grupo", getGrupo());
        hashMapPlanta.put("filo", getFiloF());
        hashMapPlanta.put("divisao", getDivisao());
        hashMapPlanta.put("nomeComum", getNomeComumF());
        hashMapPlanta.put("nomeIng", getNomeIngF());
        hashMapPlanta.put("nomeCientifico", getNomeCientificoF());
        hashMapPlanta.put("genero", getGeneroF());
        hashMapPlanta.put("especie", getEspecieF());
        hashMapPlanta.put("familia", getFamiliaF());
        hashMapPlanta.put("ordem", getOrdemF());
        hashMapPlanta.put("dominio", getDominio());
        hashMapPlanta.put("classe", getClasseF());

        return hashMapPlanta;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasseF() {
        return classeF;
    }

    public void setClasseF(String classeF) {
        this.classeF = classeF;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getOrdemF() {
        return ordemF;
    }

    public void setOrdemF(String ordemF) {
        this.ordemF = ordemF;
    }

    public String getFamiliaF() {
        return familiaF;
    }

    public void setFamiliaF(String familiaF) {
        this.familiaF = familiaF;
    }

    public String getGeneroF() {
        return generoF;
    }

    public void setGeneroF(String generoF) {
        this.generoF = generoF;
    }

    public String getEspecieF() {
        return especieF;
    }

    public void setEspecieF(String especieF) {
        this.especieF = especieF;
    }

    public String getNomeComumF() {
        return nomeComumF;
    }

    public void setNomeComumF(String nomeComumF) {
        this.nomeComumF = nomeComumF;
    }

    public String getNomeCientificoF() {
        return nomeCientificoF;
    }

    public void setNomeCientificoF(String nomeCientificoF) {
        this.nomeCientificoF = nomeCientificoF;
    }

    public String getNomeIngF() {
        return nomeIngF;
    }

    public void setNomeIngF(String nomeIngF) {
        this.nomeIngF = nomeIngF;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public String getFiloF() {
        return filoF;
    }

    public void setFiloF(String filoF) {
        this.filoF = filoF;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCaracteristicasF() {
        return CaracteristicasF;
    }

    public void setCaracteristicasF(String caracteristicasF) {
        CaracteristicasF = caracteristicasF;
    }

    public String getTipoCel() {
        return tipoCel;
    }

    public void setTipoCel(String tipoCel) {
        this.tipoCel = tipoCel;
    }

    public String getOrgCel() {
        return orgCel;
    }

    public void setOrgCel(String orgCel) {
        this.orgCel = orgCel;
    }

    public String getReproducaoF() {
        return reproducaoF;
    }

    public void setReproducaoF(String reproducaoF) {
        this.reproducaoF = reproducaoF;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getNutricao() {
        return nutricao;
    }

    public void setNutricao(String nutricao) {
        this.nutricao = nutricao;
    }

    @Override
    public String toString() {
        return nomeComumF;
    }
}
