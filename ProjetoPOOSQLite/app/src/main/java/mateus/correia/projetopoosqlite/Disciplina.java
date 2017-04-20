package mateus.correia.projetopoosqlite;

/**
 * Created by Teteu on 06/04/2017.
 */

public class Disciplina {
    private String nome;
    private String falta;
    private String nota;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
