package com.example.gymgenix;

import java.util.ArrayList;

public class ExerciceListUtils {
    public static final ArrayList<Exercice> exerciceList = new ArrayList<Exercice>() {
        {
            //copy string add(new Exercice("",new String[]{""},""));
            add(new Exercice("Curl Biceps", new String[]{"Biceps"}, "Haut"));
            add(new Exercice("Developpé Couché", new String[]{"Pectoraux", "Epaule", "Triceps"}, "Haut"));
            add(new Exercice("Tirage Vertical", new String[]{"Dos"}, "Haut"));
            add(new Exercice("Squat", new String[]{"Quadriceps", "Ischio-Jambier"}, "Jambes"));
            add(new Exercice("Developpé Militaire", new String[]{"Epaule", "Triceps"}, "Haut"));
        }
    };

    public static ArrayList<Exercice> getExerciceList() {
        return exerciceList;
    }
}
