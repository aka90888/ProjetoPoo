package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Livro livros[] = new Livro[10];
        int op, cod;
        for(int i = 0; i < livros.length; i++) {
            livros[i] = new Livro();
            livros[i].setTitulo("Titulo do Livro " + i);
            livros[i].setCodigo(i);
        }
        
        System.out.println("Sistema de Reserva de Livros");
        do {
            System.out.println("1 - Listar Livros \n2 - Reservar Livro \n3 - Devolver \n4 - Sair");
            op = scan.nextInt();
            switch(op) {
                case 1:
                    for(int i = 0; i < livros.length; i++) {
                        System.out.println("Titulo: " + livros[i].getTitulo());
                        System.out.println("Codigo: " + livros[i].getCodigo() + "\n");
                    }
                    break;
                case 2:
                    System.out.println("Digite o codigo do livro: ");
                    cod = scan.nextInt();
                    for(int i = 0; i < livros.length; i++) {
                        if(cod == livros[i].getCodigo()) {
                            if(livros[i].getReservado() == false) {
                                livros[i].reservar();
                                System.out.println("Reservado com sucesso!");
                            }
                            else {
                                System.out.println("Livro indisponivel!");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o codigo do livro: ");
                    cod = scan.nextInt();
                    for(int i = 0; i < livros.length; i++) {
                        if(cod == livros[i].getCodigo()) {
                            if(livros[i].getReservado() == true) {
                                livros[i].devolver();
                                System.out.println("Devolvido com sucesso!");
                            }
                            else {
                                System.out.println("Livro ainda nao reservado!");
                            }
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcao invalida! Digite novamente: ");
            }
        } while(op != 4);
        
        
    }    
    
}
