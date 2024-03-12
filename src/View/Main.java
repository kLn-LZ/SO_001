package View;

import Controller.RedesController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        RedesController RC = new RedesController();
        Scanner scan = new Scanner(System.in);
        int opc;

       do {
           System.out.print("MENU \n 1) IPConfig \n 2) Tempo médio Ping google.com \n 9) Encerrar \n Escolha uma opção:");
           opc = scan.nextInt();

           switch (opc) {
               case 1: RC.ip();
                    break;
               case 2: RC.ping();
                    break;
               case 9:System.out.println("Aplicação Encerrada");
                   break;
               default:System.out.println("Opção inválida");

                   break;
           }
       } while(opc != 9);


    }
}
