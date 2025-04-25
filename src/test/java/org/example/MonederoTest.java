package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MonederoTest {

    @Test
    void ingreso() {
        Monedero monedero = new Monedero();
        monedero.ingreso(200.0f, "Nómina");

        assertEquals(200.0f, monedero.saldo);

        assertEquals(1, monedero.Ingresos.size());
    }

    @Test
    void gasto() {
        Monedero monedero = new Monedero();
        monedero.ingreso(100.0f, "Vacaciones");

        monedero.gasto(40.0f, "Compra");
        assertEquals(60.0f, monedero.saldo);
        assertEquals(1, monedero.Gastos.size());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        monedero.gasto(80.0f, "Gasto excesivo");

        System.setOut(originalOut);

        assertEquals(60.0f, monedero.saldo, 0.001f, "El saldo debe seguir siendo 60 si el gasto supera el saldo");

        String output = outContent.toString().trim();
        assertTrue(output.contains("El gasto no puede ser mayor que el saldo"), "Debe imprimirse mensaje de error al intentar un gasto excesivo");
    }
}
