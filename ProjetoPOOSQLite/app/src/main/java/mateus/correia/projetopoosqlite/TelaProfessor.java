package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaProfessor extends AppCompatActivity {

    private Button btnEntrar, btnCancelar;
    private EditText txtUsuario, txtSenha;
    private Controlador control = new Controlador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_professor);

        btnEntrar = (Button)findViewById(R.id.professorEntrar);
        btnCancelar = (Button)findViewById(R.id.professorCancelar);

        txtUsuario = (EditText)findViewById(R.id.professorUsuario);
        txtSenha = (EditText)findViewById(R.id.professorSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario;
                String senha;

                usuario = txtUsuario.getText().toString();
                senha = txtSenha.getText().toString();
                Cursor aux = control.logarProf(usuario, senha);

                if(aux != null) {
                    Bundle param = new Bundle();
                    param.putString("nome", aux.getString(1));
                    param.putString("matricula", aux.getString(2));
                    param.putString("nomeDisciplina1", aux.getString(5));
                    param.putString("nomeDisciplina2", aux.getString(6));

                    Intent it = new Intent(TelaProfessor.this, TelaProfessor2.class);
                    it.putExtras(param);
                    startActivity(it);

                    Toast.makeText(TelaProfessor.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TelaProfessor.this, "Falha ao logar", Toast.LENGTH_SHORT).show();
                }
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
