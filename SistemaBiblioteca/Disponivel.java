package sistemabiblioteca;

public class Disponivel implements LivroEstado {
    public LivroEstado reservar() {
        System.out.println("Reservado com sucesso!");
        return new Prestado();
    }
    
    public LivroEstado devolver() {
        System.out.println("Devolvido com sucesso!");
        return new Disponivel();
    }
}
