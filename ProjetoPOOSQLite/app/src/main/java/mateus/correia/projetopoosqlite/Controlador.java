package mateus.correia.projetopoosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Controlador extends AppCompatActivity {

    private DatabaseAluno dbAuxAluno;
    private DatabaseProfessor dbAuxProf;
    private SQLiteDatabase dbAluno, dbProf;

    public Controlador(Context context) {
        dbAuxAluno = new DatabaseAluno(context);
        dbAuxProf = new DatabaseProfessor(context);
    }

    public void cadastrarAluno(Aluno aluno) {
        dbAluno = dbAuxAluno.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("matricula", aluno.getMatricula());
        values.put("usuario", aluno.getConta().getUsuario());
        values.put("senha", aluno.getConta().getSenha());
        values.put("nomeCurso", aluno.getCurso().getNome());

        Disciplina[] d = aluno.getCurso().getDisciplinas();
        values.put("nomeDisciplina1", d[0].getNome());
        values.put("falta1", d[0].getFalta());
        values.put("nota1", d[0].getNota());
        values.put("nomeDisciplina2", d[1].getNome());
        values.put("falta2", d[1].getFalta());
        values.put("nota2", d[1].getNota());

        long newRow = dbAluno.insert("tabelaAluno", null, values);
        dbAluno.close();
    }

    public void cadastrarProfessor(Professor prof) {
        dbProf = dbAuxProf.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", prof.getNome());
        values.put("matricula", prof.getMatricula());
        values.put("usuario", prof.getConta().getUsuario());
        values.put("senha", prof.getConta().getSenha());
        values.put("nomeDisciplina1", prof.getDisciplinas().get(0));
        values.put("nomeDisciplina2", prof.getDisciplinas().get(1));

        long newRow = dbProf.insert("tabelaProfessor", null, values);
        dbProf.close();
    }

    public Cursor logarAluno(String usuario, String senha) {
        dbAluno = dbAuxAluno.getReadableDatabase();
        Cursor cursor = dbAluno.rawQuery("select * from tabelaAluno", null);
        cursor.moveToFirst();
        String user, pass;

        do {
            user = cursor.getString(3);
            pass = cursor.getString(4);
            if (user.equals(usuario) && pass.equals(senha)) {
                dbAluno.close();
                return cursor;
            }
        } while (cursor.moveToNext());

        dbAluno.close();
        return null;
    }

    public Cursor logarProf(String usuario, String senha) {
        dbProf = dbAuxProf.getReadableDatabase();
        Cursor cursor = dbProf.rawQuery("select * from tabelaProfessor", null);
        cursor.moveToFirst();
        String user, pass;

        do {
            user = cursor.getString(3);
            pass = cursor.getString(4);
            if (user.equals(usuario) && pass.equals(senha)) {
                dbProf.close();
                return cursor;
            }
        } while (cursor.moveToNext());

        dbProf.close();
        return null;
    }

    public void alterarAluno(String matricula, String disciplina, String falta, String nota) {
        dbAluno = dbAuxAluno.getReadableDatabase();
        Cursor cursor = dbAluno.rawQuery("select * from tabelaAluno", null);
        cursor.moveToFirst();
        String mat;
        do {
            mat = cursor.getString(2);
            if(mat.equals(matricula)) {
                if(disciplina.equals(cursor.getString(6))) {
                    dbAluno = dbAuxAluno.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("falta1", falta);
                    values.put("nota1", nota);
                    dbAluno.update("tabelaAluno", values, "matricula = '" + matricula + "'", null);
                    dbAluno.close();
                    return;
                }
                if(disciplina.equals(cursor.getString(9))) {
                    dbAluno = dbAuxAluno.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("falta2", falta);
                    values.put("nota2", nota);
                    dbAluno.update("tabelaAluno", values, "matricula = '" + matricula + "'", null);
                    dbAluno.close();
                    return;
                }
            }
        } while(cursor.moveToNext());
    }

    public int verificarMatricula(String matricula) {
        dbAluno = dbAuxAluno.getReadableDatabase();
        Cursor cursor = dbAluno.rawQuery("select * from tabelaAluno", null);
        cursor.moveToFirst();
        String mat;

        do {
            mat = cursor.getString(2);
            if (mat.equals(matricula)) {
                dbAluno.close();
                return 0;
            }
        } while (cursor.moveToNext());

        dbAluno.close();
        return 1;
    }

    public Cursor retornaDados() {
        dbAluno = dbAuxAluno.getReadableDatabase();
        Cursor cursor = dbAluno.rawQuery("select * from tabelaAluno", null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        dbAluno.close();
        return cursor;
    }

    public List<Aluno> listarAlunos(Cursor cursor, String prof1, String prof2) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        cursor.moveToFirst();
        do {
            Aluno aluno = new Aluno();

            String alu1 = cursor.getString(cursor.getColumnIndex("nomeDisciplina1"));
            String alu2 = cursor.getString(cursor.getColumnIndex("nomeDisciplina2"));
            if(alu1 == null) {
                alu1 = ".";
            }
            if(alu2 == null) {
                alu2 = ".";
            }

            if(alu1.equals(prof1) || alu1.equals(prof2) ||
                    alu2.equals(prof1) || alu2.equals(prof2)) {
                aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                aluno.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
                Curso c = new Curso();
                c.setNome(cursor.getString(cursor.getColumnIndex("nomeCurso")));
                Disciplina[] disciplinas = new Disciplina[2];
                Disciplina d1 = new Disciplina();
                Disciplina d2 = new Disciplina();

                //disciplina 1
                if(alu1.equals(prof1) || alu1.equals(prof2)) {
                    d1.setNome(cursor.getString(cursor.getColumnIndex("nomeDisciplina1")));
                    d1.setFalta(cursor.getString(cursor.getColumnIndex("falta1")));
                    d1.setNota(cursor.getString(cursor.getColumnIndex("nota1")));
                }
                else {
                    d1.setNome("");
                    d1.setFalta("");
                    d1.setNota("");
                }

                //disciplina 2
                if(alu2.equals(prof1) || alu2.equals(prof2)) {
                    d2.setNome(cursor.getString(cursor.getColumnIndex("nomeDisciplina2")));
                    d2.setFalta(cursor.getString(cursor.getColumnIndex("falta2")));
                    d2.setNota(cursor.getString(cursor.getColumnIndex("nota2")));
                }
                else {
                    d2.setNome("");
                    d2.setFalta("");
                    d2.setNota("");
                }

                disciplinas[0] = d1;
                disciplinas[1] = d2;
                c.setDisciplinas(disciplinas);
                aluno.setCurso(c);
            }
            else {
                aluno.setNome("");
                aluno.setMatricula("");
                Curso c = new Curso();
                c.setNome("");
                Disciplina[] disciplinas = new Disciplina[2];
                Disciplina d1 = new Disciplina();
                Disciplina d2 = new Disciplina();
                d1.setNome("");
                d1.setFalta("");
                d1.setNota("");
                d2.setNome("");
                d2.setFalta("");
                d2.setNota("");
                disciplinas[0] = d1;
                disciplinas[1] = d2;
                c.setDisciplinas(disciplinas);
                aluno.setCurso(c);
            }

            alunos.add(aluno);
        } while (cursor.moveToNext());

        return alunos;
    }

    public String verificarCurso(String curso) {
        String padrao = curso.toUpperCase();

        if (padrao.equals("CIENCIA DA COMPUTACAO") || padrao.equals("CIÊNCIA DA COMPUTACAO") || padrao.equals("CIÊNCIA DA COMPUTAÇAO") || padrao.equals("CIÊNCIA DA COMPUTAÇÃO")
                || padrao.equals("CIENCIA DA COMPUTAÇAO") || padrao.equals("CIENCIA DA COMPUTAÇÃO") || padrao.equals("CC")) {
            return "CIÊNCIA DA COMPUTAÇÃO";
        } else if (padrao.equals("FÍSICA") || padrao.equals("FISICA")) {
            return "FÍSICA";
        } else {
            return null;
        }
    }

    public String verificarDisciplina(String disciplina) {
        String padrao = disciplina.toUpperCase();

        if (padrao.equals("CALCULO") || padrao.equals("CÁLCULO")) {
            return "CÁLCULO";
        } else if (padrao.equals("PROGRAMACAO ORIENTADA A OBJETOS") || padrao.equals("PROGRAMAÇAO ORIENTADA A OBJETOS") || padrao.equals("PROGRAMAÇÃO ORIENTADA A OBJETOS")
                || padrao.equals("POO") || padrao.equals("OO") || padrao.equals("OOP")) {
            return "PROGRAMAÇÃO ORIENTADA A OBJETOS";
        } else {
            return null;
        }
    }
}
