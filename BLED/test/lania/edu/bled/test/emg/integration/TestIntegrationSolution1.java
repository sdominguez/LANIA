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

import lania.edu.bled.de.components.Solution;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestIntegrationSolution1 {
    public static final double DELTA = 0.01;
    private Solution solution;

    public TestIntegrationSolution1() {
    }

    @Before
    public void setUp() {
        solution = new Solution(3);
    }

    @Test
    public void testSetAndGetVariables() {
        System.out.println("PRIN-01");
        double[] variables = {1.0, 2.0, 3.0};
        solution.setVariables(variables);
        double[] result = solution.getVariables();
        System.out.println("Esperado: " + java.util.Arrays.toString(variables));
        System.out.println("Obtenido: " + java.util.Arrays.toString(result));
        assertArrayEquals(variables, result, DELTA);
        System.out.println();
    }

    @Test
    public void testSetAndGetFitnessValue() {
        System.out.println("PRIN-02");
        double fitnessValue = 10.0;
        solution.setFitnessValue(fitnessValue);
        double result = solution.getFitnessValue();
        System.out.println("Esperado: " + fitnessValue);
        System.out.println("Obtenido: " + result);
        assertEquals(fitnessValue, result, DELTA);
        System.out.println();
    }

    @Test
    public void testSetAndGetG() {
        System.out.println("PRIN-03");
        double[] gValues = {0.5, 1.0};
        solution.setG(gValues);
        double[] result = solution.getG();
        System.out.println("Esperado: " + java.util.Arrays.toString(gValues));
        System.out.println("Obtenido: " + java.util.Arrays.toString(result));
        assertArrayEquals(gValues, result, DELTA);
        System.out.println();
    }

    @Test
    public void testSetAndGetH() {
        System.out.println("PRIN-04");
        double[] hValues = {0.0, 0.1};
        solution.setH(hValues);
        double[] result = solution.getH();
        System.out.println("Esperado: " + java.util.Arrays.toString(hValues));
        System.out.println("Obtenido: " + java.util.Arrays.toString(result));
        assertArrayEquals(hValues, result, DELTA);
        System.out.println();
    }

    @Test
    public void testSetPhi() {
        System.out.println("PRIN-05");
        double[] gValues = {0.5, -0.2};
        double[] hValues = {0.1, 0.3};
        solution.setG(gValues);
        solution.setH(hValues);
        solution.setPhi();

        double expectedPhi = 0.8997999999999999;
        double actualPhi = solution.getPhi();
        System.out.println("Esperado: " + expectedPhi);
        System.out.println("Obtenido: " + actualPhi);
        assertEquals(expectedPhi, actualPhi, DELTA);
        System.out.println();
    }

    @Test
    public void testToString() {
        System.out.println("PRIN-06");
        double[] variables = {1.0, 2.0, 3.0};
        solution.setVariables(variables);
        solution.setFitnessValue(10.0);
        solution.setPhi(); 

        String expectedString = "[1.0, 2.0, 3.0] " + solution.getFitnessValue() + " " + solution.getPhi();
        String actualString = solution.toString();
        System.out.println("Esperado: " + expectedString);
        System.out.println("Obtenido: " + actualString);
        assertEquals(expectedString, actualString);
        System.out.println();
    }
}
