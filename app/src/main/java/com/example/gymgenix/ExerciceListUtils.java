package com.example.gymgenix;

import java.util.ArrayList;

public class ExerciceListUtils {
    public static final ArrayList<Exercice> exerciceList = new ArrayList<Exercice>() {
        {
            //copy string add(new Exercice("",new String[]{""},""));
            add(new Exercice("Biceps Curl", new String[]{"Biceps"}, "Haut",R.drawable.biceps_curl));
            add(new Exercice("Bench Press", new String[]{"Pectoraux", "Epaule", "Triceps"}, "Haut",R.drawable.developpe_couche));
            add(new Exercice("Pull Down", new String[]{"Dos"}, "Haut",R.drawable.pull_down));
            add(new Exercice("Squat", new String[]{"Quadriceps", "Ischio-Jambier"}, "Jambes",R.drawable.squat));
            add(new Exercice("Shoulder Press", new String[]{"Epaule", "Triceps"}, "Haut",R.drawable.shoulder_press));
            add(new Exercice("Hammer Curl", new String[]{"Biceps"},"Haut",R.drawable.hammer_curl));
            add(new Exercice("Back Extension", new String[]{"Dos"}, "Haut",R.drawable.back_extension));
            add(new Exercice("Side Raise",new String[]{"Epaule"},"Haut",R.drawable.side_raise));
            add(new Exercice("Lat Pull Down", new String[]{"Dos"},"Haut",R.drawable.lat_pull_down));
            add(new Exercice("Seated Cable Row", new String[]{"Dos"},"Haut",R.drawable.seated_cable_row));
            add(new Exercice("Dips", new String[]{"Pectoraux", "Epaule"},"Haut",R.drawable.dips));
            add(new Exercice("Pull Up", new String[]{"Dos","Biceps"},"Haut",R.drawable.pull_up));
            add(new Exercice("Incline Bench Press", new String[]{"Pectoraux", "Triceps"},"Haut",R.drawable.incline_bench_press));
            add(new Exercice("Decline Bench Press", new String[]{"Pectoraux", "Triceps"},"Haut",R.drawable.decline_bench_press));
            add(new Exercice("Leg curl", new String[]{"Ischio-Jambier"},"Jambes",R.drawable.leg_curl));
            add(new Exercice("Calf Raises", new String[]{"Mollets"},"Jambes",R.drawable.calf_raise));
            add(new Exercice("Bulgarian Split Squat", new String[]{"Quadriceps"},"Jambes",R.drawable.bulgarian_split_squat));
            add(new Exercice("Leg Extension", new String[]{"Quadriceps"},"Jambes",R.drawable.leg_extension));
            add(new Exercice("Leg Press", new String[]{"Quadriceps","Ischio-Jambier"}, "Jambes",R.drawable.leg_press));
            add(new Exercice("Hip Thrust", new String[]{"Fessier"},"Jambes",R.drawable.hip_thrust));
            add(new Exercice("Triceps Extension", new String[]{"Triceps"},"Haut",R.drawable.triceps_extension));
            add(new Exercice("Triceps Push Down", new String[]{"Triceps"}, "Haut", R.drawable.triceps_push_down));
        }
    };

    public static ArrayList<Exercice> getExerciceList() {
        return exerciceList;
    }
}
