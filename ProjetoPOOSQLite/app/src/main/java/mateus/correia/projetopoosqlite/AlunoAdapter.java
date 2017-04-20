package mateus.correia.projetopoosqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Teteu on 04/04/2017.
 */

public class AlunoAdapter extends ArrayAdapter<Aluno> {

    private Context context;
    private int id;
    private List<Aluno> lista;

    public AlunoAdapter(Context context, int id, List<Aluno> lista) {
        super(context, id, lista);
        this.context = context;
        this.id = id;
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Aluno aluno;
        TextView nome, matricula, curso, disc1, falta1, nota1, disc2, falta2, nota2;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(id, parent, false);
        }

        nome = (TextView)view.findViewById(R.id.txtAlunoNome);
        matricula = (TextView)view.findViewById(R.id.txtAlunoMatricula);

        curso = (TextView)view.findViewById(R.id.txtAlunoCurso);
        disc1 = (TextView)view.findViewById(R.id.txtAlunoDisc1);
        falta1 = (TextView)view.findViewById(R.id.txtAlunoFalta1);
        nota1 = (TextView)view.findViewById(R.id.txtAlunoNota1);
        disc2 = (TextView)view.findViewById(R.id.txtAlunoDisc2);
        falta2 = (TextView)view.findViewById(R.id.txtAlunoFalta2);
        nota2 = (TextView)view.findViewById(R.id.txtAlunoNota2);


        aluno = lista.get(position);

        nome.setText(aluno.getNome());
        matricula.setText(aluno.getMatricula());
        curso.setText(aluno.getCurso().getNome());

        Disciplina[] disciplinas = aluno.getCurso().getDisciplinas();
        disc1.setText(disciplinas[0].getNome());
        falta1.setText(disciplinas[0].getFalta());
        nota1.setText(disciplinas[0].getNota());
        disc2.setText(disciplinas[1].getNome());
        falta2.setText(disciplinas[1].getFalta());
        nota2.setText(disciplinas[1].getNota());

        return view;
    }
}
