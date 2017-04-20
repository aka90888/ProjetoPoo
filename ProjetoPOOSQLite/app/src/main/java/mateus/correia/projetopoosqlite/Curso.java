package mateus.correia.projetopoosqlite;

import java.util.ArrayList;

/**
 * Created by Teteu on 06/04/2017.
 */

public class Curso {
    private String nome;
    private Disciplina[] disciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }
}
