package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.ResourceBundle;

public class TelaListar extends AppCompatActivity {

    private Button btnVoltar;
    private AlunoAdapter adapter;
    private String prof1, prof2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_listar);

        Intent it = getIntent();
        if(it != null) {
            Bundle dProf = it.getExtras();
            if(dProf != null) {
                prof1 = dProf.getString("profD1");
                prof2 = dProf.getString("profD2");
            }
        }

        List<Aluno> lista;
        ListView controle;
        Controlador control = new Controlador(getBaseContext());
        Cursor cursor = control.retornaDados();
        lista = control.listarAlunos(cursor, prof1, prof2);
        adapter = new AlunoAdapter(getApplicationContext(), R.layout.modelo_listar, lista);
        controle = (ListView)findViewById(R.id.listarListView);
        controle.setAdapter(adapter);

        btnVoltar = (Button)findViewById(R.id.listarVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
