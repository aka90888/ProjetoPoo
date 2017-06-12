package State;


import java.util.Scanner;

public class PP2 {

    public static void main(String arg[]) {
        int op;
        Scanner scan = new Scanner(System.in);
        System.out.println("Programa de utilizacao do protocolo TCP");
        System.out.println("Deseja utilizar o protocolo TCP? \n 1 - Sim \n 2 - Nao: ");
        do {
            op = scan.nextInt();
            switch (op) {
                case 1:
                    TCP tcp = new TCP();
                    while (true) {
                        System.out.println("1 - Conectar \n2 - Desconectar \n3 - Sair do Programa: ");
                        op = scan.nextInt();
                        switch (op) {
                            case 1:
                                tcp.abrir();
                                break;
                            case 2:
                                tcp.fechar();
                                break;
                            case 3:
                                return;
                            default:
                                System.out.println("Opcao invalida");
                        }
                    }
                case 2:
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (op != 2);

    }
}
