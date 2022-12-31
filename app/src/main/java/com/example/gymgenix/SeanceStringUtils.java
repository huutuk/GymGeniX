package com.example.gymgenix;

import android.provider.BaseColumns;

// Classe permettant l'ajout de nom de colonnes/tables
public class SeanceStringUtils {

    private SeanceStringUtils() {

    }

    public static final class SeanceEntry implements BaseColumns {
        public static final String TABLE_SEANCE_NAME = "seanceList";
        public static final String COLUMN_SEANCE_NAME = "name";

    }

    public static final class ExoEntry implements BaseColumns {
        public static final String TABLE_EXO_NAME = "exoList";
        public static final String COLUMN_EXO_NAME = "name";
        public static final String COLUMN_EXO_REP = "rep";
        public static final String COLUMN_EXO_WEIGHT = "WEIGHT";
        public static final String COLUMN_EXO_SEANCENAME = "seanceName";

    }
}
