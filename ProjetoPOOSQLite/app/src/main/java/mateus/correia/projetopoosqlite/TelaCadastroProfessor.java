package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaCadastroProfessor extends AppCompatActivity {

    private Button btnVoltar, btnSalvar;
    private EditText txtNome, txtMatricula, txtUsuario, txtSenha, txtSenha2, txtDisc1, txtDisc2;
    private Controlador control = new Controlador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_professor);

        btnSalvar = (Button)findViewById(R.id.cadastroProfSalvar);
        btnVoltar = (Button)findViewById(R.id.cadastroProfVoltar);

        txtNome = (EditText)findViewById(R.id.cadastroProfNome);
        txtMatricula = (EditText)findViewById(R.id.cadastroProfMatricula);
        txtUsuario = (EditText)findViewById(R.id.cadastroProfUsuario);
        txtSenha = (EditText)findViewById(R.id.cadastroProfSenha);
        txtSenha2 = (EditText)findViewById(R.id.cadastroProfSenha2);
        txtDisc1 = (EditText)findViewById(R.id.cadastroProfDisc1);
        txtDisc2 = (EditText)findViewById(R.id.cadastroProfDisc2);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verificarDisciplina1 = control.verificarDisciplina(txtDisc1.getText().toString());
                String verificarDisciplina2 = control.verificarDisciplina(txtDisc2.getText().toString());
                String vd2 = txtDisc2.getText().toString();
                if(txtNome.getText().toString().isEmpty() || txtMatricula.getText().toString().isEmpty() || txtUsuario.getText().toString().isEmpty()
                        || txtSenha.getText().toString().isEmpty() || txtSenha2.getText().toString().isEmpty() || txtDisc1.getText().toString().isEmpty()) {
                    Toast.makeText(TelaCadastroProfessor.this, "Campo(s) em branco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!(txtSenha.getText().toString().equals(txtSenha2.getText().toString()))) {
                    Toast.makeText(TelaCadastroProfessor.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(verificarDisciplina1 == null) {
                    Toast.makeText(TelaCadastroProfessor.this, "Disciplina nao existente", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(verificarDisciplina2 == null) {
                    if(!vd2.isEmpty()) {
                        Toast.makeText(TelaCadastroProfessor.this, "Disciplina 2 nao existente", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Professor prof = new Professor();
                Conta conta = new Conta();
                ArrayList<String> disciplinas = new ArrayList<String>();

                prof.setNome(txtNome.getText().toString());
                prof.setMatricula(txtMatricula.getText().toString());

                conta.setUsuario(txtUsuario.getText().toString());
                conta.setSenha(txtSenha.getText().toString());
                prof.setConta(conta);

                disciplinas.add(verificarDisciplina1);
                disciplinas.add(verificarDisciplina2);
                prof.setDisciplinas(disciplinas);

                control.cadastrarProfessor(prof);

                Intent it = new Intent(TelaCadastroProfessor.this, TelaPrincipal.class);
                startActivity(it);

                Toast.makeText(TelaCadastroProfessor.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
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
