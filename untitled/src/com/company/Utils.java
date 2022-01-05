package com.company;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> eliminarEspacios(String linea){
        List<String> nuevaLinea = new ArrayList<>();
        String cadena = "";

        String[] listaLinea = linea.split("\t");

        for (String aux : listaLinea) {
            cadena += aux + " ";
        }

        listaLinea = cadena.split(" ");

        for (String aux : listaLinea) {
            if (!aux.equals("")){
                nuevaLinea.add(aux);
            }
        }
        return nuevaLinea;
    }

    public static boolean isUsed(List<String> lista,String variable){
        int cont = 0;
        for (String cadena : lista) {
            if(cadena.contains(variable+" ")){
                cont++;
            }
            if (cont > 1){
                return true;
            }
        }

        return false;
    }


    public static List<String> getParametersToAssign(List<String> lista){
        List<String> parameters = new ArrayList<>();
        String cadena = "";

        for(String linea : lista){
            try{
                cadena = Utils.eliminarEspacios(linea).get(0);
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }

            if (cadena.startsWith("@s_") || cadena.startsWith("@t_")){
                if (!isUsed(lista, cadena)){
                    parameters.add(cadena);
                }
            }
            if (cadena.equals("as")){
                break;
            }


        }

        return parameters;
    }

    public static int getLongitudMayor(List<String> lista){
        int num = 0;

        for(String cadena : lista){
            if (cadena.length() > num){
                num = cadena.length();
            }
        }
        return  num;
    }



}
