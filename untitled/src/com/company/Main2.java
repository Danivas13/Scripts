package com.company;

import org.junit.Test;

import java.io.File;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        String carpetaSps = "C:\\Users\\dgallardo\\PRUEBAS_UNITARIAS\\Azure\\cobis-con-backend\\spsql\\";

        File file = new File(carpetaSps);

        for (String archivo : file.list()) {
            System.out.println("Iniciando con "+archivo);
            File doc = new File(carpetaSps+archivo);
            Functions.asignarVariables(doc);
        }


    }





    public void test(){
        List<String> lista = new ArrayList<>();
        String linea = "";
        String ruta = "C:\\Users\\dgallardo\\PRUEBAS_UNITARIAS\\Azure\\cobis-con-backend\\spsql\\";
        String archivo = "ing_opera.sp";


        File doc = new File(ruta+archivo);

        Functions.asignarVariables(doc);

       /* try {
            Scanner obj = new Scanner(doc);

            while (obj.hasNextLine()) {
                linea = obj.nextLine();

                lista.add(linea);

            }
        } catch (Exception e){

        }

        List<String> lstAux = Utils.getParametersToAssign(lista);
        List<String> lstAux2 = Functions.prettyFormaterParameter(lstAux);

        for (String x:lstAux2
             ) {
            System.out.println(x);
        }*/


    }

}
