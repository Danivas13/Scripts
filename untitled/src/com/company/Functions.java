package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {

    private static void reescribirArchivo(List<String> lista, File file){

        try{
            FileWriter fw = new FileWriter(file);
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
            reescribirArchivo(lista, doc);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  0;
    }


    public static void asignarVariables(File doc){

        List<String> lista = new ArrayList<>();
        List<String> lstParameters = new ArrayList<>();
        List<String> lstParametersFormat = new ArrayList<>();
        List<String> lstFinal = new ArrayList<>();

        String linea = "";

        try {
            Scanner obj = new Scanner(doc);

            while (obj.hasNextLine()){
                linea = obj.nextLine();

                lista.add(linea);

            }

            lstParameters = Utils.getParametersToAssign(lista);
            if(!lstParameters.isEmpty()){
                lstParametersFormat = Functions.prettyFormaterParameter(lstParameters);
            }
            lstFinal = getFinalRefactorCodeSmells(lista, lstParametersFormat);

            reescribirArchivo(lstFinal, doc);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static List<String> getFinalRefactorCodeSmells(List<String> lstOriginal, List<String> lstParameters){
        List<String> lista = new ArrayList<>();
        String aux = "";
        for(String linea : lstOriginal){

            lista.add(linea);
            try{
                aux = Utils.eliminarEspacios(linea).get(0);

                if (aux.equals("as")){
                    lista.add("\n");
                    for (String cadena : lstParameters){
                        lista.add(cadena);
                    }
                    lista.add("\n");
                }
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }

        return lista;

    }


    public static List<String> prettyFormaterParameter(List<String> lista){
        int maxLongitud = Utils.getLongitudMayor(lista);
        List<String> listNueva = new ArrayList<>();
        String aux = null;
        int cont = 0;

        listNueva.add("select");
        for (String cadena : lista) {

            aux = cont < lista.size()-1 ?cadena+",":cadena;

            if (cadena.length() < maxLongitud){
                for (int i =cadena.length(); i < maxLongitud; i++){
                    cadena += " ";
                }

            }
            cadena += " = "+aux;
            listNueva.add(cadena);
            cont++;
        }

        return listNueva;

    }






}
