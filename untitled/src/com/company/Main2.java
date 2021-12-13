package com.company;

public class Main2 {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\dgallardo\\Desktop\\spsql\\";
        String archivo = "asientot.sp";
        String variable = "@i_mayorizado";

        Functions.eliminarVariable(variable, ruta, archivo);

    }
}
