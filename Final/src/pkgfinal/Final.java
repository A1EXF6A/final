/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfinal;

import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        int opc;
            do {
            do {
              System.out.println("Escoja una opcion");
              System.out.println("1 opcion");
              System.out.println("2 opcion");
              System.out.println("3 opcion");
              System.out.println("4 opcion");
              System.out.println("Ingrese una opcion");
              opc = tec.nextInt();
        } while (opc<1||opc>4);
            switch (opc) {
            case 1:
               char op='s';
                while (op=='S'||op=='s') {                    
                    System.out.println("desea ejecutar de nuevo S/N");
                    op = tec.next().charAt(0);
                    
                }System.out.println("salio de la opcion 1");
                
                break;
            case 2:
                char opci='s';
                while (opci=='S'||opci=='s') {                    
                    System.out.println("desea ejecutar de nuevo S/N");
                    opci = tec.next().charAt(0);
                    
                }System.out.println("salio de la opcion 2");
                break;
            case 3:
                char opn='s';
                while (opn=='S'||opn=='s') {                    
                    System.out.println("desea ejecutar de nuevo S/N");
                    opn = tec.next().charAt(0);
                    
                }System.out.println("salio de la opcion 3");
                break;
            case 4:
                System.out.println("Fin del programa"); 
                System.exit(0);
                break;
        }
        } while (opc!=4);
       
    }
    
}
