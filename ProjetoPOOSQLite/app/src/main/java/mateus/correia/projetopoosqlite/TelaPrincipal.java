package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    private Button btnEntrar, btnCadastrar, btnProfessor;
    private EditText txtUsuario, txtSenha;
    private Controlador control = new Controlador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        btnEntrar = (Button)findViewById(R.id.principalEntrar);
        btnCadastrar = (Button)findViewById(R.id.principalCadastrar);
        btnProfessor = (Button)findViewById(R.id.principalProfessor);

        txtUsuario = (EditText)findViewById(R.id.principalUsuario);
        txtSenha = (EditText)findViewById(R.id.principalSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario;
                String senha;

                usuario = txtUsuario.getText().toString();
                senha = txtSenha.getText().toString();
                Cursor aux = control.logarAluno(usuario, senha);

                if(aux != null) {
                    Bundle param = new Bundle();
                    param.putString("nome", aux.getString(1));
                    param.putString("matricula", aux.getString(2));
                    param.putString("nomeCurso", aux.getString(5));
                    param.putString("nomeDisciplina1", aux.getString(6));
                    param.putString("falta1", aux.getString(7));
                    param.putString("nota1", aux.getString(8));
                    param.putString("nomeDisciplina2", aux.getString(9));
                    param.putString("falta2", aux.getString(10));
                    param.putString("nota2", aux.getString(11));


                    Intent it = new Intent(TelaPrincipal.this, TelaAluno.class);
                    it.putExtras(param);
                    startActivity(it);
                    Toast.makeText(TelaPrincipal.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TelaPrincipal.this, "Falha ao logar", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaPrincipal.this, TelaCadastro.class);
                startActivity(it);
            }
        });

        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaPrincipal.this, TelaProfessor.class);
                startActivity(it);
            }
        });

    }
}
