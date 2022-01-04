package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {

    private static void reescribirArchivo(List<String> lista, String archivo, String ruta){

        String root = ruta+archivo;
        File f = new File(root);
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter escritura = new BufferedWriter(fw);
            for (String linea:lista) {
                escritura.write(linea);
                escritura.newLine();

            }

            escritura.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static int eliminarVariable(String var, String ruta, String archivo){
        int numEliminado = 0;
        List<String> lista = new ArrayList<>();
        String linea = "";
        String lineaAux = "";


        File doc = new File(ruta+archivo);
        try {
            Scanner obj = new Scanner(doc);

            while (obj.hasNextLine()){
                linea = obj.nextLine();
                if (!linea.contains(var + " ")){
                    lineaAux = obj.hasNextLine()?obj.nextLine():"";

                    if (lineaAux.contains(var + " ") && !lineaAux.contains(",")){
                        linea = linea.split(",")[0];
                    }
                    lista.add(linea);
                    if (!lineaAux.contains(var+" ")){
                        lista.add(lineaAux);
                    }

                } else if (linea.contains("declare")){
                    lista.add("declare");
                }
            }
            reescribirArchivo(lista, archivo, ruta);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  0;
    }







}
