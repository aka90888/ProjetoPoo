package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaProfessor2 extends AppCompatActivity {

    private Button btnListar, btnAlterar, btnVoltar;
    private TextView txtNome, txtMatricula, txtDisc1, txtDisc2;
    private String nome, matricula, disc1, disc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_professor2);

        btnListar = (Button)findViewById(R.id.professorListar);
        btnAlterar = (Button)findViewById(R.id.professorAlterar);
        btnVoltar = (Button)findViewById(R.id.professorVoltar);

        Intent it = getIntent();
        if(it != null) {
            Bundle param = it.getExtras();
            if (param != null) {
                nome = param.getString("nome");
                matricula = param.getString("matricula");
                disc1 = param.getString("nomeDisciplina1");
                disc2 = param.getString("nomeDisciplina2");

                txtNome = (TextView)findViewById(R.id.professorNome);
                txtMatricula = (TextView)findViewById(R.id.professorMatricula);
                txtDisc1 = (TextView)findViewById(R.id.professorDisc1);
                txtDisc2 = (TextView)findViewById(R.id.professorDisc2);

                txtNome.setText(nome);
                txtMatricula.setText(matricula);
                txtDisc1.setText(disc1);
                txtDisc2.setText(disc2);
            }
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle dProf = new Bundle();
                dProf.putString("profD1", disc1);
                dProf.putString("profD2", disc2);

                Intent it = new Intent(TelaProfessor2.this, TelaListar.class);
                it.putExtras(dProf);
                startActivity(it);
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaProfessor2.this, TelaAlterar.class);
                startActivity(it);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
