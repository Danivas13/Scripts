package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String txt = "src/com/company/variables.txt";
        String carpetaSps = "";
        System.out.println("A");

        InputStream ins = null;
        try {
            ins = new FileInputStream(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        String Archivo_Actual = "";
        Boolean Cambiar_Archivo = false;
        while (obj.hasNextLine()){
            String linea =  obj.nextLine();
            if(Cambiar_Archivo){
                Archivo_Actual = linea;
                Cambiar_Archivo = false;
                continue;
            }
            if(linea.equals("FILE")){
                //Cambiamos de archivo
                Cambiar_Archivo = true;
                continue;
            }
            if(!Cambiar_Archivo){
                //Eliminamos la variable
                System.out.println(linea);
                // Abrimos el archivo

                // buscamos la linea de la variable

                // eliminamos la variable

                // Verificamos el asunto de las comas

                // cerramos seguimos
            }
        }


    }
}
