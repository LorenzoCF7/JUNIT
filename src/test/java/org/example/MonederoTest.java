package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MonederoTest {

    @Test
    void ingreso() {
        Monedero monedero = new Monedero();
        // Realizamos un ingreso de 200 con concepto "Sueldo"
        monedero.ingreso(200.0f, "Nómina");

        // Verificamos que el saldo se actualice correctamente
        assertEquals(200.0f, monedero.saldo);

        // Comprobamos que se haya añadido un Ingreso a la lista
        assertEquals(1, monedero.Ingresos.size());
    }

    @Test
    void gasto() {
        Monedero monedero = new Monedero();
        // Se añade un ingreso para disponer de saldo
        monedero.ingreso(100.0f, "Vacaciones");

        // Realizamos un gasto menor o igual al saldo
        monedero.gasto(40.0f, "Compra");
        assertEquals(60.0f, monedero.saldo);
        assertEquals(1, monedero.Gastos.size());

        // Para probar el caso en que se intente gastar más del saldo disponible,
        // redirigimos la salida estándar para capturar el mensaje
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Intentamos gastar 80 cuando el saldo es 60
        monedero.gasto(80.0f, "Gasto excesivo");

        // Restauramos la salida estándar
        System.setOut(originalOut);

        // El saldo debe mantenerse en 60, ya que el gasto no se realizó
        assertEquals(60.0f, monedero.saldo, 0.001f, "El saldo debe seguir siendo 60 si el gasto supera el saldo");

        // Verificamos que se haya impreso el mensaje de error correspondiente
        String output = outContent.toString().trim();
        assertTrue(output.contains("El gasto no puede ser mayor que el saldo"), "Debe imprimirse mensaje de error al intentar un gasto excesivo");
    }
}
