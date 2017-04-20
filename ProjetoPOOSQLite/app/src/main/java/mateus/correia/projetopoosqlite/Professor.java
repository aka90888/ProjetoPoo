package mateus.correia.projetopoosqlite;

import java.util.ArrayList;

/**
 * Created by Teteu on 06/04/2017.
 */

public class Professor {
    private String nome;
    private String matricula;
    private Conta conta;
    private ArrayList<String> disciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
