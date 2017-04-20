package mateus.correia.projetopoosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAluno extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tabelaAluno.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS tabelaAluno(" +
                    "_id integer primary key autoincrement," +
                    "nome TEXT," +
                    "matricula TEXT," +
                    "usuario TEXT," +
                    "senha TEXT," +
                    "nomeCurso TEXT," +
                    "nomeDisciplina1 TEXT," +
                    "falta1 TEXT," +
                    "nota1 TEXT," +
                    "nomeDisciplina2 TEXT," +
                    "falta2 TEXT," +
                    "nota2 TEXT);";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + "tabelaAluno";

    public DatabaseAluno(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}