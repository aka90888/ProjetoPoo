package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaAluno extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_aluno);

        btnVoltar = (Button)findViewById(R.id.alunoVoltar);

        Intent it = getIntent();
        if(it != null) {
            Bundle param = it.getExtras();
            if(param != null) {
                String nome = param.getString("nome");
                String matricula = param.getString("matricula");
                String curso = param.getString("nomeCurso");

                String disc1 = param.getString("nomeDisciplina1");
                String falta1 = param.getString("falta1");
                String nota1 = param.getString("nota1");

                String disc2 = param.getString("nomeDisciplina2");
                String falta2 = param.getString("falta2");
                String nota2 = param.getString("nota2");

                TextView txtNome = (TextView)findViewById(R.id.alunoNome);
                TextView txtMatricula = (TextView)findViewById(R.id.alunoMatricula);
                TextView txtCurso = (TextView)findViewById(R.id.alunoCurso);

                TextView txtDisc1 = (TextView)findViewById(R.id.alunoDisc1);
                TextView txtFalta1 = (TextView)findViewById(R.id.alunoFalta1);
                TextView txtNota1 = (TextView)findViewById(R.id.alunoNota1);

                TextView txtDisc2 = (TextView)findViewById(R.id.alunoDisc2);
                TextView txtFalta2 = (TextView)findViewById(R.id.alunoFalta2);
                TextView txtNota2 = (TextView)findViewById(R.id.alunoNota2);

                txtNome.setText(nome);
                txtMatricula.setText(matricula);
                txtCurso.setText(curso);

                txtDisc1.setText(disc1);
                txtFalta1.setText(falta1);
                txtNota1.setText(nota1);

                txtDisc2.setText(disc2);
                txtFalta2.setText(falta2);
                txtNota2.setText(nota2);
            }
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
