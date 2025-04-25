package org.example;

import java.util.ArrayList;

public class Monedero {
    public String usuario;
    public Float saldo = 0.0f;
    public float ingreso;
    public float gasto;
    public String conceptoIngreso;
    public String conceptoGasto;
    public ArrayList<Ingreso> Ingresos = new ArrayList<>();
    public ArrayList<Gasto> Gastos = new ArrayList<>();

    public void ingreso(float ingreso, String conceptoIngreso) {
        this.ingreso = ingreso;
        this.conceptoIngreso = conceptoIngreso;
        Ingreso nuevoIngreso = new Ingreso(ingreso, conceptoIngreso);
        Ingresos.add(nuevoIngreso);
        saldo += ingreso;
    }
    public void gasto(float gasto, String conceptoGasto) {
        if (gasto<=this.saldo) {
            this.gasto = gasto;
            this.conceptoGasto = conceptoGasto;
            Gasto nuevoGasto = new Gasto(gasto, conceptoGasto);
            Gastos.add(nuevoGasto);
            saldo -= gasto;
        }else {
            System.out.println("El gasto no puede ser mayor que el saldo");
        }
    }
    public void saldo() {
        System.out.println("El saldo es: " + saldo);
    }


}