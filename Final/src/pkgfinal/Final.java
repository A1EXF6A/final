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
        System.out.println("hola");
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
                            Scanner leer = new Scanner (System.in);
        String namec, namepack, letras;
        char salida='y';
        int num;
        //Inico del programa!!! el nombre del proyecto con el que se va a trabajar!!!!!
        System.out.println("Ingrese el nombre del proyecto");
        namec = leer.next();
        System.out.println("Ingrese el nombre del package");
        namepack= leer.next();
        //Se declara la linea donde se guardara la primera carpeta del proyecto!!!!Se crea la carpeta!!!! CAMBIAR dirreccion dependiendo el maquina
        File carpeta = new File ("/home/inti/Documentos/"+namec);
        carpeta.mkdir();
        String[] Carpetas = namepack.split("\\.");
        // se declara las carpetas por defecto que se crean al crear una carpeta!!!!
        File src = new File ("/home/inti/Documentos/"+namec+"/src");
        File xml = new File ("/home/inti/Documentos/"+namec+"/pom.xml");
        File main = new File ("/home/inti/Documentos/"+namec+"/src/main");
        File java = new File ("/home/inti/Documentos/"+namec+"/src/main/java");
        String dir=new String();
        src.mkdir();
        try {
            xml.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoOpcion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.mkdir();
        java.mkdir();
        //Se declara la liena principal donde se van a crear las carpetas de pakage!!!! cambiar dirreccion dependiendo de la maquina
        dir=("/home/inti/Documentos/"+namec+"/src/main/java");
        //Se crea un ciclo en el que se crearan las carpetas del proyecto!!!!!!
        for (String Carpetas1 : Carpetas) {
        dir = dir+"/" + Carpetas1;
        File pack = new File (dir);
        pack.mkdir();
        }
            try ( //Se crea el archivo .java dentro de la dirreccion principal!!!
            java.io.PrintWriter archivojava = new PrintWriter (dir+"/"+ namec+".java")) {
                archivojava.write(" ");
            }
            
        
        do {
                
            
        // Opciones dentro de la opccion 1!!!!
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Mostrar los archivos y directorios contenidos en la ubicación principal del proyecto creado");
        System.out.println("2. Crear archivos");
        System.out.println("3. Modificar el nombre de una carpeta y de un archivo");
        System.out.println("4. Eliminar un archivo o directorio");
        System.out.println("5. Leer un archivo y mostrar el contenido en pantalla");
        System.out.println("6. Escribir en un archivo");
        System.out.println("7. Copia de un archivo");
        int opc= leer.nextInt();
        char d='s';
        String name, name2;
        //Inicio de las opcciones !!!!!!
        
        switch (opc) {
            case 1:
                /*Mostrar los archivos y directorios contenidos en la ubicación principal del proyecto
                    creado, con su respectiva información*/
                //Se declara la ruta principal!!!!!
                File leerarchivos = new File (dir);
                //la ruta principal se guarda en un array con el metodo .listfiles en el que revisa todas los archivos guardados dentro de la carpeta
                File [] cap = leerarchivos.listFiles();
                //Formato para la fecha de modificacion del archivo
                SimpleDateFormat saf= new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
                for (File cap1 : cap) {
                    //Informacion de los archivos dentro de la ruta
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.println(String.format("El nombre es %s, del tipo %s, con %d bytes, su ultima modificacion fue: %s",
                        cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo",cap1.length(),saf.format(cap1.lastModified())));
                        System.out.println("El archivo se puede leer: "+ cap1.canRead());
                        System.out.println("El archivo tiene permiso de escribir: "+ cap1.canWrite());  
                    }
                }
                break;
            case 2:
                //Crear archivos de cualquier extensión
                do {
                System.out.print("Nombre del archivo nuevo: ");
                String nuevo = leer.next(); 
                        int extencion;
                System.out.println("Escriba del siguiente grupo de extencion el numero de extencion que desea crear: 1.java; 2.txt; 3.pdf; 4.directorio ");
                extencion = leer.nextInt();
                File leerarchivos2 = new File (dir+"/"+nuevo+extencion);
                switch (extencion) {
                    //java
                    case 1:
                        PrintWriter javaa = new PrintWriter (dir+"/"+ nuevo+".java");
                        javaa.write("");
                        javaa.close();
                        break;
                        //txt
                    case 2:
                        PrintWriter txt = new PrintWriter (dir+"/"+ nuevo+".txt");
                        txt.write("");
                        txt.close();
                        break;
                        //pdf
                    case 3:
                        PrintWriter pdf = new PrintWriter (dir+"/"+ nuevo+".pdf");
                        pdf.write("");
                        pdf.close();
                        break;
                        //directorio
                    case 4:
                        File directorio = new File (dir+"/"+ nuevo);
                        directorio.mkdir();
                        break;
                }
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
                
            case 3:
                /*Modificar el nombre de una carpeta y de un archivo (si es el caso de un archivo se
                puede modificar la extensión); se debe mostrar un mensaje que diga si está seguro
                de realizar esta acción.*/
                do {
                System.out.println("******Los archivos existentes son: ************");
                File leerarchivos3 = new File (dir);
                File [] cap3 = leerarchivos3.listFiles();
                for (File cap1 : cap3) {
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.printf("El nombre del archivo es: %s y es del tipo %s\n ", cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo");
                    }
                }
                System.out.println("Escriba el nombre del archivo y su extencion que desea modificar: ");
                name = leer.next();
                System.out.println("Escriba el nuevo nombre del archivo: ");
                name2 = leer.next();
                System.out.println("Seleccione una extencion: 1. java; 2. txt; 3. pdf; 4. directorio ");
                num = leer.nextInt();
                //control de fuera de rango
                if (num <= 4) {
                    //Casos para los diferentes archivos
                    switch (num) {
                    case 1:
                        File jav = new File (dir+"/"+name);
                        File java2 = new File (dir+"/"+name2+".java");
                        System.out.println("Desea cambiar el nombre del archivo si 'S'");
                        d= leer.next().charAt(0);
                        if (d=='S'||d=='s') {
                            System.out.println("El archivo fue renombrado a: "+ jav.renameTo(java2));
                        } else {
                            System.out.println("El archivo no fue modificado");
                        }
                        break;
                    case 2:
                        File txt = new File (dir+"/"+name);
                        File txt2 = new File (dir+"/"+name2+".txt");
                        System.out.println("Desea cambiar el nombre del archivo si 'S'");
                        d= leer.next().charAt(0);
                        if (d=='S'||d=='s') {
                            System.out.println("El archivo fue renombrado a: "+ txt.renameTo(txt2));
                        } else {
                            System.out.println("El archivo no fue modificado");
                        }
                        break;
                    case 3:
                        File pdf = new File (dir+"/"+name);
                        File pdf2 = new File (dir+"/"+name2+".pdf");
                        System.out.println("Desea cambiar el nombre del archivo si 'S'");
                        d= leer.next().charAt(0);
                        if (d=='S'||d=='s') {
                            System.out.println("El archivo fue renombrado a: "+ pdf.renameTo(pdf2));
                        } else {
                            System.out.println("El archivo no fue modificado");
                        }
                        break;
                    case 4:
                        File jpg = new File (dir+"/"+name);
                        if (jpg.exists()) {
                            File jpg2 = new File (dir+"/"+name2);
                        System.out.println("Desea cambiar el nombre del archivo si 'S'");
                        d= leer.next().charAt(0);
                        if (d=='S'||d=='s') {
                            System.out.println("El archivo fue renombrado a: "+ jpg.renameTo(jpg2));
                        } else {
                            System.out.println("El archivo no fue modificado");
                        }
                        } else {
                            System.out.println("El directorio no fue modificado");
                        }
                        
                        break;
                }
                } else {
                    System.out.println("Fuera de rango");
                }
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
            case 4:
                //Eliminar un archivo o directorio!!!!!
                do {
                    
                
                System.out.println("******Los archivos existentes son: ************");
                File leerarchivos4 = new File (dir);
                File [] cap4 = leerarchivos4.listFiles();
                for (File cap1 : cap4) {
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.printf("El nombre del archivo es: %s y es del tipo %s\n ", cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo");
                    }
                }
                System.out.println("Escriba el nombre con su extencion del archivo que desea eliminar: ");
                name = leer.next();
                File borrar = new File (dir+"/"+name);
                System.out.println("Desea borrar el archivo si 'S'");
                d= leer.next().charAt(0);
                if (d=='S'||d=='s'&&borrar.delete()) {
                    System.out.println("El archivo fue vorrado");
                } else {
                    System.out.println("El archivo no fue borrado o no exixte");
                }
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
            case 5:
               //Leer el archivo que desee el usuario y mostrar el contenido en pantalla.
                do {
                    
                
                System.out.println("******Los archivos existentes son: ************");
                File leerarchivos5 = new File (dir);
                File [] cap5 = leerarchivos5.listFiles();
                for (File cap1 : cap5) {
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.printf("El nombre del archivo es: %s y es del tipo %s\n ", cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo");
                    }
                }
                System.out.println("¿Cual archivo desea leer?");
                name = leer.next();
                BufferedReader leerejee5;
            try (FileReader leereje5 = new FileReader (dir+"/"+name)) {
                leerejee5 = new BufferedReader (leereje5);
                while (leerejee5.ready()) {                    
                    letras = leerejee5.readLine();
                    System.out.println(letras);
                }
            }
                leerejee5.close();
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
            case 6:
                /*Escribir un archivo que desee el usuario, permitiendo ingresar la información a
                    escribir por teclado*/
                do{
                System.out.println("******Los archivos existentes son: ************");
                File leerarchivos6 = new File (dir);
                File [] cap6 = leerarchivos6.listFiles();
                for (File cap1 : cap6) {
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.printf("El nombre del archivo es: %s y es del tipo %s ", cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo");
                        System.out.println("El archivo se puede leer: "+ cap1.canRead());
                        System.out.println("El archivo tiene permiso de escribir: "+ cap1.canWrite()); 
                    }
                }
                System.out.println("De los archivos anteriores escriba el nombre y su extencion del archivo que desea escribir");
                name = leer.next();
                System.out.println("Escriba que es lo que desea escribir en el archivo: ");
                leer.nextLine();
                String texto = leer.nextLine();
                System.out.println("Desea sobrescribir 'S' o Escribir al final del documento 'F'");
                d = leer.next().charAt(0);
                

            PrintWriter sbre = new PrintWriter(dir+"/"+name);
            
                if (d == 'S'|| d == 's') {
                    sbre.write(texto);
                    sbre.close();
                }else if (d == 'f'|| d == 'F') {
                    FileReader read = new FileReader (dir+"/"+name);
                    BufferedReader leer2 = new BufferedReader(read);
            try (FileWriter fnal = new FileWriter(dir+"/"+name)) {
                String nam;
                while (leer2.ready()) {
                    nam = leer2.readLine();
                    fnal.write(texto);
                    fnal.close();
                }
            }
                }
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
            case 7:
                /*Permitir al usuario realizar una copia de un archivo que desee y que permita realizar
                la copia de la siguiente manera:
                            + Duplicado integro, es decir la misma información del original.
                            + Duplicado con cambios, reemplazando las vocales por números asignados a cada
                                vocal.
                            + Plantee otra forma de duplicado similar a las anteriores.*/
                do{
                System.out.println("******Los archivos existentes son: ************");
                File leerarchivos7 = new File (dir);
                File [] cap7 = leerarchivos7.listFiles();
                for (File cap1 : cap7) {
                    boolean exist = cap1.exists();
                    if (exist== true) {
                        System.out.printf("El nombre del archivo es: %s y es del tipo %s\n ", cap1.getName(),cap1.isDirectory() ? "Carpeta" : "Archivo");
                    }
                    
                }
                System.out.println("Escriba el nombre del archivo que desea copiar");
                name = leer.next();
                System.out.println("Escriba un nombre para la copia");
                name2 = leer.next();
                System.out.println("Eliga una forma de copiar un archivo anterior");
                int cop = leer.nextInt();
                FileWriter escribir;
                BufferedReader leerejee7;
            try (FileReader org = new FileReader (dir+"/"+name)) {
                escribir = new FileWriter (dir+"/"+name2);
                leerejee7 = new BufferedReader (org);
                System.out.println("1. duplicado\n2. copia con vocales por numeros\n3. copia con las vocales por caracteres especiales");
                num = leer.nextInt();
                do {
                    //Casos para los diferentes tipos de duplicados
                    switch (num) {
                        case 1:
                            while (leerejee7.ready()) {
                                letras = leerejee7.readLine();
                                escribir.write(letras+"\n");
                            }
                            break;
                        case 2:
                            while (leerejee7.ready()) {
                                letras = leerejee7.readLine();
                                
                                for (int i = 0; i < letras.length(); i++) {
                                    letras = letras.replace("a", "4");
                                    letras = letras.replace("e", "3");
                                    letras = letras.replace("i", "1");
                                    letras = letras.replace("o", "0");
                                    letras = letras.replace("u", "1_1");
                                }
                                escribir.write(letras+"\n");
                            }
                            
                            break;
                        case 3:
                            while (leerejee7.ready()) {
                                letras = leerejee7.readLine();
                                
                                for (int i = 0; i < letras.length(); i++) {
                                    letras = letras.replace("a", "@");
                                    letras = letras.replace("e", "Σ");
                                    letras = letras.replace("i", "Γ");
                                    letras = letras.replace("o", "Θ");
                                    letras = letras.replace("u", "μ");
                                }
                                escribir.write(letras+"\n");
                            }
                            
                            break;
                            
                    }
                } while (num >= 3);
            }
                leerejee7.close();
                escribir.close();
                System.out.println("Desea repetir esta opcion oprima 'Y'");
                salida = leer.next().charAt(0);
                } while (salida == 'Y'||salida=='y');
                break;
        }
        
                System.out.println("¿Desea repetir las opciones dentro del proyecto? Oprima 'Y'");
                salida = leer.next().charAt(0);
        } while (salida == 'Y'||salida=='y');
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
