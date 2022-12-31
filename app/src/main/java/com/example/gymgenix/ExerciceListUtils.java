package com.example.gymgenix;

import java.util.ArrayList;

//Ajout des exercices de façon statique
public class ExerciceListUtils {
    public static final ArrayList<Exercice> exerciceList = new ArrayList<Exercice>() {
        {
            //copy string add(new Exercice("",new String[]{""},""));
            add(new Exercice("Biceps Curl", new String[]{"Biceps"}, "Haut", R.drawable.biceps_curl, "Le Biceps Curl est l’un des meilleurs pour augmenter la force et le volume de vos bras. Il cible tout l’ensemble du biceps ainsi que certains muscles de l’avant-bras."));
            add(new Exercice("Bench Press", new String[]{"Pectoraux", "Épaules", "Triceps"}, "Haut", R.drawable.developpe_couche, "Le Bench Press est un exercice poly-articulaire efficace pour développer les pectoraux mais aussi améliorer la force du haut du corps et l'endurance."));
            add(new Exercice("Squat", new String[]{"Quadriceps", "Ischio-Jambiers", "Fessiers"}, "Jambes", R.drawable.squat, "Les squats sont un exercice basic de renforcement musculaire. Ils permettent de développer les muscles des jambes et aide au développement d'autre muscles à travers tout le corps."));
            add(new Exercice("Shoulder Press", new String[]{"Épaules", "Triceps"}, "Haut", R.drawable.shoulder_press, "Le Shoulder Press est un mouvement poly-articulaire qui cible particulièrement les triceps et les deltoïdes. \n\r C'est un exercice très efficace pour développer et renforcer les épaules."));
            add(new Exercice("Hammer Curl", new String[]{"Biceps"}, "Haut", R.drawable.hammer_curl, "Le Hammer Curl est un exercice d'isolation qui cible  le muscle brachio-radial."));
            add(new Exercice("Back Extension", new String[]{"Dos"}, "Haut", R.drawable.back_extension, "Le Back Extension est un exercice d’isolation simple mais efficace pour renforcer le bas du dos. Ce mouvement de musculation cible spécifiquement les lombaires."));
            add(new Exercice("Cable Side Raise", new String[]{"Épaules"}, "Haut", R.drawable.side_raise, "Le Cable Side Raise est un exercice qui cible les deltoïd latéraux, le câble permet d'avoir une tension continue durant tout le mouvement."));
            add(new Exercice("Lat Pull Down", new String[]{"Dos"}, "Haut", R.drawable.lat_pull_down, "Le Lat Pull Down est un exercice poly-articulaire pour travailler les dorsaux et obtenir un dos en V"));
            add(new Exercice("Seated Cable Row", new String[]{"Dos"}, "Haut", R.drawable.seated_cable_row, "Le Seated Cable Row est un exercice très efficace pour obtenir un dos puissant. Il renforce les muscles du dos en profondeur."));
            add(new Exercice("Dips", new String[]{"Pectoraux", "Triceps", "Épaules"}, "Haut", R.drawable.dips, "Les Dips sont un exercice au point de corps qui cible les pectoraux, les triceps et les épaules."));
            add(new Exercice("Pull Up", new String[]{"Dos", "Triceps"}, "Haut", R.drawable.pull_up, "Les Pull Up sont un exercice poly-articulaire qui travaille presque tous les muscles du haut du corps. Ils ciblent principalement les muscles du dos."));
            add(new Exercice("Incline Bench Press", new String[]{"Pectoraux", "Triceps"}, "Haut", R.drawable.incline_bench_press, "L'Incline Bench Press est un exercice poly-articulaire qui cible le haut des pectoraux. C'est un excellent exercice pour construire un haut du corps fort et large."));
            add(new Exercice("Decline Bench Press", new String[]{"Pectoraux", "Triceps"}, "Haut", R.drawable.decline_bench_press, "Le Decline Bench Press est un exercice poly-articulaire qui cible les muscles inférieurs de la poitrine et permet une meilleure définition des pectoraux."));
            add(new Exercice("Leg curl", new String[]{"Ischio-Jambiers"}, "Jambes", R.drawable.leg_curl, "Le Leg Curl est un exercice d'isolation qui se concentre sur les ischio-jambiers. Vous pouvez inclure cette exercice à votre entraînement pour développer, renforcer et raffermir les muscles de la jambe."));
            add(new Exercice("Calf Raise", new String[]{"Mollets"}, "Jambes", R.drawable.calf_raise, "Les Calf Raise ciblent les mollets et permet d'isoler le groupe musculaire, maximisant ainsi le développement des mollets."));
            add(new Exercice("Bulgarian Split Squat", new String[]{"Quadriceps", "Ischio-Jambiers", "Fessiers"}, "Jambes", R.drawable.bulgarian_split_squat, "Les Bulgarian Split Squat sont un exercice d'isolation qui permettent de construire du volume et de la force dans les quadriceps, les fessiers et les ischio-jambiers."));
            add(new Exercice("Leg Extension", new String[]{"Quadriceps"}, "Jambes", R.drawable.leg_extension, "Le leg extension est un exercice d’isolation qui concentre l’effort sur les quadriceps, situés à l’avant des cuisses."));
            add(new Exercice("Leg Press", new String[]{"Quadriceps", "Ischio-Jambiers"}, "Jambes", R.drawable.leg_press, "La Leg Press est un mouvement de musculation poly-articulaire qui se pratique sur une machine."));
            add(new Exercice("Hip Thrust", new String[]{"Fessiers"}, "Jambes", R.drawable.hip_thrust, "Le Hip Thrust cible les muscles de la hanche. Vous pouvez l'inclure dans votre programme d'entraînement pour raffermir et tonifier les muscles de la hanche ainsi qu'améliorer votre mobilité à ce niveau et renforcer votre bassin."));
            add(new Exercice("Triceps Extension", new String[]{"Triceps"}, "Haut", R.drawable.triceps_extension, "Le Triceps Extension est un exercice d’isolation qui cible exclusivement le triceps brachial."));
            add(new Exercice("Triceps Push Down", new String[]{"Triceps"}, "Haut", R.drawable.triceps_push_down, "Le Triceps Push Down est un très bon exercice d’isolation pour développer et renforcer les trois faisceaux qui composent le triceps."));
        }
    };

    public static ArrayList<Exercice> getExerciceList() {
        return exerciceList;
    }
}
