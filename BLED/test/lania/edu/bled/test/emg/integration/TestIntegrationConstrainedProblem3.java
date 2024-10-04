/*
 * Copyright (C) 2024 esteb
 *
 * This program is free software: you can redistribuirlo y/o modificar
 * este archivo bajo los términos de la Licencia Pública General GNU como lo publica
 * la Fundación de Software Libre, ya sea la versión 3 de la Licencia, o
 * (a su elección) cualquier versión posterior.
 *
 * Este programa se distribuye con la esperanza de que sea útil,
 * pero SIN NINGUNA GARANTÍA; sin siquiera la garantía implícita de
 * COMERCIABILIDAD o ADECUACIÓN A UN PROPÓSITO PARTICULAR. Vea
 * la Licencia Pública General GNU para más detalles.
 *
 * Debería haber recibido una copia de la Licencia Pública General GNU junto
 * con este programa. Si no, consulte <http://www.gnu.org/licenses/>.
 */
package lania.edu.bled.test.emg.integration;

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.cec2010.C01;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;

public class TestIntegrationConstrainedProblem3 {
    private static final double DELTA = 0.01;
    private C01 c01Problem;
    private Solution solution;

    public TestIntegrationConstrainedProblem3() {
    }

    @Before
    public void setUp() {
        c01Problem = new C01(3); // Cambia el tamaño si es necesario
        solution = new Solution(3);
        double[] variables = {1.0, 2.0, 3.0};
        solution.setVariables(variables);
    }

    @Test
    public void testEvaluate() {
        System.out.println("PRIN-14");
        Solution evaluatedSolution = c01Problem.evaluate(solution);
        
        assertNotNull(evaluatedSolution);
        System.out.println("Variables de la solución evaluada: " + Arrays.toString(evaluatedSolution.getVariables()));
        
        double fitnessValue = evaluatedSolution.getFitnessValue();
        System.out.println("Valor de fitness: " + fitnessValue);
        
        // Validación de que el valor de fitness es negativo
        assertTrue("El valor de fitness debe ser negativo", fitnessValue < 0);

        // Validación de límites de las variables
        double[] variables = evaluatedSolution.getVariables();
        double[] upperLimits = c01Problem.getUpperLimit();
        double[] lowerLimits = c01Problem.getLowerLimit();
        
        for (int i = 0; i < variables.length; i++) {
            assertTrue("Variable fuera de límite en la posición " + i, 
                       variables[i] >= lowerLimits[i] && variables[i] <= upperLimits[i]);
        }
    }

    @Test
    public void testGetDimension() {
        System.out.println("PRIN-15");
        assertEquals(3, c01Problem.getDimension());
        System.out.println("Dimensión: " + c01Problem.getDimension());
    }

    @Test
    public void testGetUpperLimit() {
        System.out.println("PRIN-16");
        double[] expectedUpper = {10.0, 10.0, 10.0};
        assertArrayEquals(expectedUpper, c01Problem.getUpperLimit(), DELTA);
        System.out.println("Límites superiores: " + Arrays.toString(c01Problem.getUpperLimit()));
    }

    @Test
    public void testGetLowerLimit() {
        System.out.println("PRIN-17");
        double[] expectedLower = {0.0, 0.0, 0.0};
        assertArrayEquals(expectedLower, c01Problem.getLowerLimit(), DELTA);
        System.out.println("Límites inferiores: " + Arrays.toString(c01Problem.getLowerLimit()));
    }
    
    @Test
    public void testPopulationEvolution() {
        // Aquí puedes simular la evolución y verificar que el fitness mejora
        Solution initialSolution = new Solution(3);
        initialSolution.setVariables(new double[]{1.0, 2.0, 3.0});
        Solution evaluatedSolution = c01Problem.evaluate(initialSolution);
        
        // Simulación de un proceso de evolución
        Solution newSolution = new Solution(3);
        newSolution.setVariables(new double[]{1.5, 2.5, 3.5}); // Cambiar las variables para simular evolución
        
        Solution evolvedSolution = c01Problem.evaluate(newSolution);
        
        // Verifica que el nuevo valor de fitness sea mejor
        assertTrue("El fitness debe mejorar", evolvedSolution.getFitnessValue() <= evaluatedSolution.getFitnessValue());
    }
}
