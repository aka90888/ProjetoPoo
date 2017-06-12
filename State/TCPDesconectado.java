package State;

public class TCPDesconectado implements EstadoTCP {
    
    public EstadoTCP abrir() {
        System.out.println("Conectado");
        return new TCPConectado();
    }
    
    public EstadoTCP fechar() {
        System.out.println("Desconectado");
        return new TCPDesconectado();
    }
}
