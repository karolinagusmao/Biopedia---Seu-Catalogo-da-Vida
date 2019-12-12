package com.karol.biopedia.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

public class Fauna {

    private String id;
    private String reino;
    private String classe;
    private String infraClasse;
    private String ordem;
    private String superFamilia;
    private String familia;
    private String genero;
    private String especie;
    private String subEspecie;
    private String nomeComum;
    private String nomeCientifico;
    private String nomeIng;
    private String sexoAnimal;
    private String filo;
    private String habitat;
    private String reproducao;
    private String idadeAnimal;
    private String conservacao;
    private String caracteristicas;

    public Fauna() {
    }

    public void cadastrar(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("animal").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> hashMapAnimal = new HashMap<>();

        hashMapAnimal.put("id", getId());
        hashMapAnimal.put("reino", getReino());
        hashMapAnimal.put("classe", getClasse());
        hashMapAnimal.put("infraClasse", getInfraClasse());
        hashMapAnimal.put("ordem", getOrdem());
        hashMapAnimal.put("superFamilia", getSuperFamilia());
        hashMapAnimal.put("familia", getFamilia());
        hashMapAnimal.put("genero", getReino());
        hashMapAnimal.put("especie", getEspecie());
        hashMapAnimal.put("subEspecie", getSubEspecie());
        hashMapAnimal.put("nomeComum", getNomeComum());
        hashMapAnimal.put("nomeCientifico", getNomeCientifico());
        hashMapAnimal.put("nomeIng", getNomeIng());
        hashMapAnimal.put("filo", getFilo());
        hashMapAnimal.put("sexoAnimal", getSexoAnimal());
        hashMapAnimal.put("habitat", getHabitat());
        hashMapAnimal.put("reproducao", getReproducao());
        hashMapAnimal.put("idadeAnimal", getIdadeAnimal());
        hashMapAnimal.put("Conservacao", getConservacao());
        hashMapAnimal.put("caracteristicas", getCaracteristicas());

        return hashMapAnimal;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getInfraClasse() {
        return infraClasse;
    }

    public void setInfraClasse(String infraClasse) {
        this.infraClasse = infraClasse;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getSuperFamilia() {
        return superFamilia;
    }

    public void setSuperFamilia(String superFamilia) {
        this.superFamilia = superFamilia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSubEspecie() {
        return subEspecie;
    }

    public void setSubEspecie(String subEspecie) {
        this.subEspecie = subEspecie;
    }

    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getNomeIng() {
        return nomeIng;
    }

    public void setNomeIng(String nomeIng) {
        this.nomeIng = nomeIng;
    }

    public String getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(String sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getReproducao() {
        return reproducao;
    }

    public void setReproducao(String reproducao) {
        this.reproducao = reproducao;
    }

    public String getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(String idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return nomeComum;
    }
}
