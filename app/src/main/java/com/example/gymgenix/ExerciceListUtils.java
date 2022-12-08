package com.example.gymgenix;

import java.util.ArrayList;

public class ExerciceListUtils {
    public static final ArrayList<Exercice> exerciceList = new ArrayList<Exercice>() {
        {
            //copy string add(new Exercice("",new String[]{""},""));
            add(new Exercice("Biceps Curl", new String[]{"Biceps"}, "Haut"));
            add(new Exercice("Développé Couché", new String[]{"Pectoraux", "Epaule", "Triceps"}, "Haut"));
            add(new Exercice("Tirage Vertical", new String[]{"Dos"}, "Haut"));
            add(new Exercice("Squat", new String[]{"Quadriceps", "Ischio-Jambier"}, "Jambes"));
            add(new Exercice("Développé Militaire", new String[]{"Epaule", "Triceps"}, "Haut"));
            add(new Exercice("Hammer Curl", new String[]{"Biceps"},"Haut"));
            add(new Exercice("Back Extension", new String[]{"Dos"}, "Haut"));
            add(new Exercice("Elévation latérale",new String[]{"Epaule"},"Haut"));
            add(new Exercice("Lat Pull Down", new String[]{"Dos"},"Haut"));
            add(new Exercice("Tirage horizontal", new String[]{"Dos"},"Haut"));
            add(new Exercice("Dips", new String[]{"Pectoraux, Epaule"},"Haut"));
            add(new Exercice("Traction", new String[]{"Dos","Biceps"},"Haut"));
            add(new Exercice("Développé incliné", new String[]{"Pectoraux", "Triceps"},"Haut"));
            add(new Exercice("Leg curl", new String[]{"Ischio-Jambier"},"Jambes"));
            add(new Exercice("Calves Rise", new String[]{"Mollets"},"Jambes"));
            add(new Exercice("Adducteur", new String[]{"Adducteur"},"Jambes"));
            add(new Exercice("Abducteur", new String[]{"Abducteur"},"Jambes"));
            add(new Exercice("Leg Press", new String[]{"Quadriceps","Ischio-Jambier"}, "Jambes"));
            add(new Exercice("Hip Thrust", new String[]{"Fessier"},"Jambes"));
            add(new Exercice("Triceps Extension", new String[]{"Triceps"},"Haut"));
        }
    };

    public static ArrayList<Exercice> getExerciceList() {
        return exerciceList;
    }
}
