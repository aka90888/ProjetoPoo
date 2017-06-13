package sistemabiblioteca;

public class Disponivel implements LivroEstado {
    public LivroEstado reservar() {
        return new Prestado();
    }
    
    public LivroEstado devolver() {
        return new Disponivel();
    }
}
