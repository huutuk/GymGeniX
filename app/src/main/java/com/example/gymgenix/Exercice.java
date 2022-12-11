package com.example.gymgenix;

import java.util.Arrays;

public class Exercice {


    private String nom;
    private String[] muscles;
    private String groupeExo;
    private int image;

    public Exercice(String nom, String[] muscles, String groupeExo, int image) {
        this.nom = nom;
        this.muscles = muscles;
        this.groupeExo = groupeExo;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "nom='" + nom + '\'' +
                ", muscles=" + Arrays.toString(muscles) +
                ", groupeExo='" + groupeExo + '\'' +
                ", image=" + Integer.toString(image) + '\'' +
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

    public int getImage() {
        return image;
    }

    public void setImageURL(int image) {
        this.image = image;
    }

    // END SETTERS

}