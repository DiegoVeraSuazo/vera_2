
package com.mycompany.vera_2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LecturaEscrituraTexto {
    
    public static void main(String[] args) {
        menu();
                
    }

    //Metodo que agrega una oracion o palabra en una nueva linea del archivo texto.txt
    public static String agregarOraciones(String oracion){
        String ruta = "texto.txt";
        Path archivo = Paths.get(ruta);
        System.out.println("Agregue la oracion que quiera.");
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            texto = texto+ "\n" + oracion;
            Files.write(archivo, texto.getBytes());
            System.out.println("Se añadio agregado");
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo");
        }
        return oracion;
    }

    //Metodo que lee el contenido del archivo.txt
    public static void leerArchivo(String ruta){
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es: \n"+texto);
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo");
        }
    }

    //Metodo que quita palabras u oraciones del archivo texto.txt(Usar con precaucion!!)
    public static String quitarOraciones(String oracion){
        String ruta = "texto.txt";
        Path archivo = Paths.get(ruta);
        System.out.println("Agregue la oracion que desee quitar");
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            texto = texto.replace("\n"+oracion,"");
            Files.write(archivo, texto.getBytes());
            System.out.println("Se quito la Oracion");
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo");
        }
        return oracion;
    }

    //Metodo que llama a un menu
    public static void menu(){
        System.out.println("Selecciona la operacion a realizar");
        System.out.println("1 - Leer Archivo de Texto");
        System.out.println("2 - Agregar Oraciones");
        System.out.println("3 - Quitar Oraciones");

        System.out.println("4 - Salir del Menu");
        
        boolean ejec = true;
        do {
            int opcion = validarNumero();
            
            if (opcion >= 1 && opcion <= 3) {
                seleccion(opcion, ejec);
                System.out.println("Seleccione una operacion");
            } else if (opcion == 4) {
                ejec = false;   
            } else if(opcion <= 0 || opcion > 4) {
                System.out.println("Opcion no valida");
            }
            
        } while (ejec); 
    }

    //Metodo que llama a la acción que se eligio en el menu
    private static void seleccion(int opcion, boolean ejec) {
        Scanner teclado = new Scanner(System.in);
            switch(opcion){
            case 1:
                String ruta = "texto.txt";
                leerArchivo(ruta);
                break;
            case 2:
                System.out.println("Escriba la oracion que desee agregar");
                String agregado = teclado.nextLine();
                agregarOraciones(agregado);
                break;
            case 3:
                System.out.println("Escriba la oracion que desee quitar");
                String quitar = teclado.nextLine();
                quitarOraciones(quitar);
                break;
            default:
                break;
        }
    
    }
    
    //Metodo que Valida que la entrada sea un Numero y que este sea Mayor a 0.
    private static int validarNumero() {
        Scanner teclado = new Scanner(System.in);

        int entrada = 0;
        Boolean valido = true;
        do {
            try {
                entrada = teclado.nextInt();
                valido = false;
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                valido = true;
            }
        } while (valido);
        return entrada;
    }
    
}
