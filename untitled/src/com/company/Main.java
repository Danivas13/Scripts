package com.company;

import javafx.scene.shape.Arc;

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

                try {
                    if(Functions.eliminarVariable(linea,carpetaSps,Archivo_Actual) == 0){
                        //Exito
                        System.out.println("Archivo: "+ Archivo_Actual + " Variable eliminada: " + linea);
                    }else{
                        // Errores
                        System.out.println("Error desconocido: "+ Archivo_Actual + " Variable eliminada: " + linea);
                    }
                }catch (Exception e){
                    System.out.println("Error " + e.toString());
                }


            }
        }


    }
}
