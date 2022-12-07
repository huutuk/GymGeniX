package com.example.gymgenix;

import java.util.Arrays;

public class Exercice {


    private String nom;
    private String[] muscles;
    private String groupeExo;

    public Exercice(String nom, String[] muscles, String groupeExo) {
        this.nom = nom;
        this.muscles = muscles;
        this.groupeExo = groupeExo;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "nom='" + nom + '\'' +
                ", muscles=" + Arrays.toString(muscles) +
                ", groupeExo='" + groupeExo + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getMuscles() {
        return muscles;
    }

    public void setMuscles(String[] muscles) {
        this.muscles = muscles;
    }

    public String getGroupeExo() {
        return groupeExo;
    }

    public void setGroupeExo(String groupeExo) {
        this.groupeExo = groupeExo;
    }


// END SETTERS

}