package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("A");
        String ROOT = "C:/Users/dgallardo/Desktop/spsql/";
        String variable="@w_sp_name";
        String archivo = "asientot.sp";

        Functions f = new Functions();

        f.eliminarVariable(variable, ROOT, archivo);

    }
}
