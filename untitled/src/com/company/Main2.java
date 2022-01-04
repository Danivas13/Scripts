package com.company;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        String carpetaSps = "C:\\Users\\dgallardo\\PRUEBAS_UNITARIAS\\Azure\\cobis-con-backend\\spsql\\";
        int cont = 0;
        File file = new File(carpetaSps);

        for (String archivo : file.list()) {
            System.out.println(archivo);
            cont++;
        }

        System.out.println(cont);

    }
}
