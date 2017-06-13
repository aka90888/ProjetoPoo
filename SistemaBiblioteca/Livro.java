package sistemabiblioteca;

public class Livro {
    private LivroEstado estado;
    private boolean flag = false;
    private String titulo;
    private int codigo;
    
    public Livro() {
        estado = new Disponivel();
    }
    
    public void reservar() {
        flag = true;
        estado = estado.reservar();
    }
    
    public void devolver() {
        flag = false;
        estado = estado.devolver();
    }
    
    public boolean getReservado() {
        return flag;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
