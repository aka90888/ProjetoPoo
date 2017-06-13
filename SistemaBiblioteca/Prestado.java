package sistemabiblioteca;

public class Prestado implements LivroEstado {
    public LivroEstado reservar() {
        return new Prestado();
    }
    
    public LivroEstado devolver() {
        return new Disponivel();
    }
}
