package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaAlterar extends AppCompatActivity {

    private EditText txtFalta, txtNota, txtMatricula, txtDisciplina;
    private Button btnAlterar, btnVoltar;
    private Controlador control = new Controlador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_alterar);

        btnAlterar = (Button)findViewById(R.id.alterarAlterar);
        btnVoltar = (Button)findViewById(R.id.alterarVoltar);

        txtFalta = (EditText)findViewById(R.id.alterarFalta);
        txtNota = (EditText)findViewById(R.id.alterarNota);
        txtMatricula = (EditText)findViewById(R.id.alterarMatricula);
        txtDisciplina = (EditText)findViewById(R.id.alterarDisciplina);

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.verificarMatricula(txtMatricula.getText().toString()) == 0) {
                    //int nota = new Integer(txtNota.getText().toString());
                    double nota = Double.parseDouble(txtNota.getText().toString());
                    if(nota >= 0 && nota <= 10) {
                        control.alterarAluno(txtMatricula.getText().toString(), txtDisciplina.getText().toString(), txtFalta.getText().toString(), txtNota.getText().toString());

                        Toast.makeText(TelaAlterar.this, "Aluno alterado com sucesso", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(TelaAlterar.this, "Nota invalida", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(TelaAlterar.this, "Matricula nao encontrada", Toast.LENGTH_SHORT).show();
                }
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
