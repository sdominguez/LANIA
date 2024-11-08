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
import lania.edu.bled.de.variants.DERand1Bin;
import lania.edu.bled.de.variants.DERand2Bin;
import lania.edu.bled.optimization.problems.cec2017.C06;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esteb
 */
public class TestIntegrationC06_2017 {
    
    public TestIntegrationC06_2017() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void PI89() {
        System.out.println("\nPI-89");
        
        int totalRuns = 25;
        int successfulRuns = 0;

        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("\nEjecucion numero: " + run);

            C06 C06 = new C06(10);
            DERand1Bin rand1 = new DERand1Bin(20, 0.5, 0.9, 200000, C06);

            rand1.initializePopulation();
            rand1.run();

            Solution bestSolution = rand1.getOutput().getBestSolution();
            double[] h = bestSolution.getH();

            System.out.println("Mejor valor de la funcion objetivo: " + bestSolution.getFitnessValue());
            System.out.println("Valor de h1: " + h[0]);
            System.out.println("Valor de h2: " + h[1]);
            System.out.println("Valor de h3: " + h[2]);
            System.out.println("Valor de h4: " + h[3]);
            System.out.println("Valor de h5: " + h[4]);
            System.out.println("Valor de h6: " + h[5]);
            

            if (h[0] == 0 && h[1] == 0 && h[2]== 0 && h[3]== 0 && h[4]== 0 && h[5] == 0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }

        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
    
    @Test
    public void PI90() {
        System.out.println("\nPI-90");
        
        int totalRuns = 25;
        int successfulRuns = 0;

        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("\nEjecucion numero: " + run);

            C06 C06 = new C06(30);
            DERand1Bin rand1 = new DERand1Bin(20, 0.5, 0.9, 600000, C06);

            rand1.initializePopulation();
            rand1.run();

            Solution bestSolution = rand1.getOutput().getBestSolution();
            double[] h = bestSolution.getH();

            System.out.println("Mejor valor de la funcion objetivo: " + bestSolution.getFitnessValue());
            System.out.println("Valor de h1: " + h[0]);
            System.out.println("Valor de h2: " + h[1]);
            System.out.println("Valor de h3: " + h[2]);
            System.out.println("Valor de h4: " + h[3]);
            System.out.println("Valor de h5: " + h[4]);
            System.out.println("Valor de h6: " + h[5]);
            

            if (h[0] == 0 && h[1] == 0 && h[2]== 0 && h[3]== 0 && h[4]== 0 && h[5] == 0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }

        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
    
    @Test
    public void PI91() {
        System.out.println("\nPI-91");
        
        int totalRuns = 25;
        int successfulRuns = 0;

        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("\nEjecucion numero: " + run);

            C06 C06 = new C06(10);
            DERand2Bin rand2 = new DERand2Bin(20, 0.5, 0.9, 200000, C06);

            rand2.initializePopulation();
            rand2.run();

            Solution bestSolution = rand2.getOutput().getBestSolution();
            double[] h = bestSolution.getH();

            System.out.println("Mejor valor de la funcion objetivo: " + bestSolution.getFitnessValue());
            System.out.println("Valor de h1: " + h[0]);
            System.out.println("Valor de h2: " + h[1]);
            System.out.println("Valor de h3: " + h[2]);
            System.out.println("Valor de h4: " + h[3]);
            System.out.println("Valor de h5: " + h[4]);
            System.out.println("Valor de h6: " + h[5]);
            

            if (h[0] == 0 && h[1] == 0 && h[2]== 0 && h[3]== 0 && h[4]== 0 && h[5] == 0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }

        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
    
    @Test
    public void PI92() {
        System.out.println("\nPI-92");
        
        int totalRuns = 25;
        int successfulRuns = 0;

        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("\nEjecucion numero: " + run);

            C06 C06 = new C06(30);
            DERand2Bin rand2 = new DERand2Bin(20, 0.5, 0.9, 600000, C06);

            rand2.initializePopulation();
            rand2.run();

            Solution bestSolution = rand2.getOutput().getBestSolution();
           double[] h = bestSolution.getH();

            System.out.println("Mejor valor de la funcion objetivo: " + bestSolution.getFitnessValue());
            System.out.println("Valor de h1: " + h[0]);
            System.out.println("Valor de h2: " + h[1]);
            System.out.println("Valor de h3: " + h[2]);
            System.out.println("Valor de h4: " + h[3]);
            System.out.println("Valor de h5: " + h[4]);
            System.out.println("Valor de h6: " + h[5]);
            

            if (h[0] == 0 && h[1] == 0 && h[2]== 0 && h[3]== 0 && h[4]== 0 && h[5] == 0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }

        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
}
