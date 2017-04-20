package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaCadastroAluno extends AppCompatActivity {

    private Button btnCancelar, btnSalvar;
    private EditText txtNome, txtMatricula, txtUsuario, txtSenha, txtSenha2, txtCurso, txtDisc1, txtDisc2;
    private Controlador control = new Controlador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);

        btnSalvar = (Button)findViewById(R.id.cadastroSalvar);
        btnCancelar = (Button)findViewById(R.id.cadastroCancelar);

        txtNome = (EditText)findViewById(R.id.cadastroNome);
        txtMatricula = (EditText)findViewById(R.id.cadastroMatricula);
        txtUsuario = (EditText)findViewById(R.id.cadastroUsuario);
        txtSenha = (EditText)findViewById(R.id.cadastroSenha);
        txtSenha2 = (EditText)findViewById(R.id.cadastroSenha2);
        txtCurso = (EditText)findViewById(R.id.cadastroCurso);
        txtDisc1 = (EditText)findViewById(R.id.cadastroDisciplina1);
        txtDisc2 = (EditText)findViewById(R.id.cadastroDisciplina2);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verificarCurso = control.verificarCurso(txtCurso.getText().toString());
                String verificarDisciplina1 = control.verificarDisciplina(txtDisc1.getText().toString());
                String verificarDisciplina2 = control.verificarDisciplina(txtDisc2.getText().toString());
                String vd2 = txtDisc2.getText().toString();
                if(txtNome.getText().toString().isEmpty() || txtMatricula.getText().toString().isEmpty() || txtUsuario.getText().toString().isEmpty() || txtSenha.getText().toString().isEmpty()
                        || txtSenha2.getText().toString().isEmpty() || txtCurso.getText().toString().isEmpty() || txtDisc1.getText().toString().isEmpty()) {
                    Toast.makeText(TelaCadastroAluno.this, "Campo(s) em branco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!(txtSenha.getText().toString().equals(txtSenha2.getText().toString()))) {
                    Toast.makeText(TelaCadastroAluno.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(verificarCurso == null) {
                    Toast.makeText(TelaCadastroAluno.this, "Curso nao existente", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(verificarDisciplina1 == null) {
                    Toast.makeText(TelaCadastroAluno.this, "Disciplina 1 nao existente", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(verificarDisciplina2 == null) {
                    if(!vd2.isEmpty()) {
                        Toast.makeText(TelaCadastroAluno.this, "Disciplina 2 nao existente", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Aluno aluno = new Aluno();
                Conta conta = new Conta();
                Curso curso = new Curso();
                Disciplina[] disciplinas = new Disciplina[2];
                Disciplina d1 = new Disciplina();
                Disciplina d2 = new Disciplina();

                aluno.setNome(txtNome.getText().toString());
                aluno.setMatricula(txtMatricula.getText().toString());

                conta.setUsuario(txtUsuario.getText().toString());
                conta.setSenha(txtSenha.getText().toString());
                aluno.setConta(conta);

                curso.setNome(verificarCurso);
                d1.setNome(verificarDisciplina1);
                d1.setFalta("");
                d1.setNota("");
                d2.setNome(verificarDisciplina2);
                d2.setFalta("");
                d2.setNota("");
                disciplinas[0] = d1;
                disciplinas[1] = d2;
                curso.setDisciplinas(disciplinas);
                aluno.setCurso(curso);

                control.cadastrarAluno(aluno);

                Intent it = new Intent(TelaCadastroAluno.this, TelaPrincipal.class);
                startActivity(it);

                Toast.makeText(TelaCadastroAluno.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}