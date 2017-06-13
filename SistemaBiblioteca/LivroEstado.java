package sistemabiblioteca;

public interface LivroEstado {
    LivroEstado reservar();
    LivroEstado devolver();
}
