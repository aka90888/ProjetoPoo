package State;

public class TCP {
    protected EstadoTCP estado;
    
    public TCP() {
        estado = new TCPConectado();
    }
    
    public void abrir() {
        estado = estado.abrir();
    }
    
    public void fechar() {
        estado = estado.fechar();
    }
}
