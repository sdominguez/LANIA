/*
 * Copyright (C) 2024 esteb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lania.edu.bled.test.emg.integration;

import lania.edu.bled.de.components.Stochastic;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestIntegrationStochastic2 {

    @Test
    public void testRandInt() {
        System.out.println("PRINT-07");
        int min = 1;
        int max = 10;
        int result = Stochastic.randInt(min, max);
        System.out.println("Rango: [" + min + ", " + max + "]");
        System.out.println("Obtenido: " + result);
        assertTrue(result >= min && result <= max);
        System.out.println();
    }

    @Test
    public void testRandReal() {
        System.out.println("PRINT-08");
        double min = 1.0;
        double max = 10.0;
        double result = Stochastic.randReal(min, max);
        System.out.println("Rango: [" + min + ", " + max + "]");
        System.out.println("Obtenido: " + result);
        assertTrue(result >= min && result <= max);
        System.out.println();
    }

    @Test
    public void testRand() {
        System.out.println("PRINT-09");
        double result = Stochastic.rand();
        System.out.println("Obtenido: " + result);
        assertTrue(result >= 0.0 && result <= 1.0);
        System.out.println();
    }

    @Test
    public void testFlip() {
        System.out.println("PRINT-10");
        double prob = 0.7;
        int result = Stochastic.flip(prob);
        System.out.println("Probabilidad: " + prob);
        System.out.println("Obtenido: " + result);
        assertTrue(result == 0 || result == 1);
        System.out.println();
    }

    @Test
    public void testRandGaussian() {
        System.out.println("PRINT-11");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 10; i++) {
            resultado = Stochastic.randGaussian(6, 2);
            if (resultado < 1 || resultado > 13) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        assertTrue("El valor de retorno no está en el rango [1, 13]: " + resultado, allValid);
    }

    @Test
    public void testRandCauchy() {
        System.out.println("PRINT-12");
        double local = 0.0;
        double scale = 1.0;
        double result = Stochastic.randCauchy(local, scale);
        System.out.println("Parámetro local: " + local + ", Escala: " + scale);
        System.out.println("Obtenido: " + result);
        assertNotNull(result);
        System.out.println();
    }

    @Test
    public void testArrayRandInt() {
        System.out.println("PRINT-13");
        int size = 5;
        int min = 1;
        int max = 10;
        int except = 5;
        int[] result = Stochastic.arrayRandInt(size, min, max, except);
        
        System.out.println("Tamaño: " + size + ", Rango: [" + min + ", " + max + "], Excepto: " + except);
        System.out.println("Obtenido: " + java.util.Arrays.toString(result));
        assertEquals(size, result.length);
        for (int value : result) {
            assertNotEquals(except, value);
            assertTrue(value >= min && value <= max);
        }
        System.out.println();
    }
}
