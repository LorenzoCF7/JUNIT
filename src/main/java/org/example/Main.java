package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de Gestion de Gastos");
        Scanner sc = new Scanner(System.in);
        Depuracion dp = new Depuracion();
        boolean flag = false;
        String usuario = null;
        Monedero cash = new Monedero();

        do {
            System.out.println("1.- Introduce nombre de usuario" +
                    "\n2.- Introducir ingresos" +
                    "\n3.- Introducir gasto" +
                    "\n4.- Mostrar saldo" +
                    "\n5.- Salir");
            switch (dp.pedirNumero()) {
                case 1:
                    System.out.println("1.- Introduce nombre de usuario");
                    usuario = sc.nextLine();
                    break;
                case 2:
                    if (usuario!=null) {
                        System.out.println("2.- Introducir ingresos");
                        System.out.println("Introducir ingreso:");
                        float ingreso = dp.pedirNumeroFloat();
                        String conceptoIngreso = "Nómina";
                        cash.ingreso(ingreso,conceptoIngreso);



                    } else{
                        System.out.println("Usuario no válido");
                    }
                    break;
                case 3:
                    if (usuario!=null) {
                        System.out.println("3.- Introducir gasto");
                        System.out.println("Introducir gasto:");
                        float gasto = dp.pedirNumeroFloat();
                        boolean flag2 = true;
                        System.out.println("Introducir concepto:");
                        System.out.println("1.- Vacaciones" +
                                "\n2.- Alquiler" +
                                "\n3.- Vicios variados");
                        String conceptoGasto = null;
                        switch (dp.pedirNumero()) {
                            case 1:
                                conceptoGasto = "Vacaciones";
                                break;
                            case 2:
                                conceptoGasto = "Alquiler";
                                break;
                            case 3:
                                conceptoGasto = "Vicios variados";
                                break;
                            default:
                                System.out.println("Ingreso invalido");
                                flag2 = false;
                                break;
                        }
                        if (flag2) {
                            cash.ingreso(gasto,conceptoGasto);
                        }
                    } else{
                        System.out.println("Usuario no válido");
                    }
                    break;
                case 4:
                    if (usuario!=null) {
                        System.out.println("4.- Mostrar saldo");
                        cash.saldo();
                    } else{
                        System.out.println("Usuario no válido");
                    }
                    break;
                case 5:
                    System.out.println("5.- Saliendo...");
                    flag = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + dp.pedirNumero());
            }
        }while (!flag);
    }
}