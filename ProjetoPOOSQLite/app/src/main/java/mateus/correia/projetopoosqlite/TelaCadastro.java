package mateus.correia.projetopoosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCadastro extends AppCompatActivity {

    private Button btnAluno, btnProfessor, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        btnAluno = (Button)findViewById(R.id.telaCadastroAluno);
        btnProfessor = (Button)findViewById(R.id.telaCadastroProfessor);
        btnVoltar = (Button)findViewById(R.id.telaCadastroVoltar);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaCadastro.this, TelaCadastroAluno.class);
                startActivity(it);
            }
        });

        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaCadastro.this, TelaCadastroProfessor.class);
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
