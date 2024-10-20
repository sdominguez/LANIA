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
import lania.edu.bled.optimization.problems.cec2010.C13;
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
public class TestIntegrationC13_2010 {
    
    public TestIntegrationC13_2010() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void PI45(){ 
        System.out.println("\n PI-45");
        int totalRuns = 25;
        int successfulRuns = 0;
        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("Ejecucion numero: " + run);
            C13 C13 = new C13(10);
            DERand1Bin rand1 = new DERand1Bin(20, 0.5, 0.9, 200000, C13);
            rand1.initializePopulation();
            rand1.run();
            Solution bestSolution = rand1.getOutput().getBestSolution();
            double [] g = bestSolution.getG();
            System.out.println("Mejor valor de la funcion objetivo :" + rand1.getOutput().getBestSolution().getFitnessValue());
            System.out.println("Valor de g1: " + g[0]);
            System.out.println("Valor de g2: " + g[1]);
            System.out.println("Valor de g3: " + g[2]);
            
            if (g[0] <= 0 && g[1] <= 0 && g[2]<=0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }
        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
    
    //Problema C13 con tamaño de 30 dimensiones
    @Test
    public void PI46(){ 
        System.out.println("\n PI-46");
        int totalRuns = 25;
        int successfulRuns = 0;
        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("Ejecucion numero: " + run);
            C13 C13 = new C13(30);
            DERand1Bin rand1 = new DERand1Bin(20, 0.5, 0.9, 600000, C13);
            rand1.initializePopulation();
            rand1.run();
            Solution bestSolution = rand1.getOutput().getBestSolution();
            double [] g = bestSolution.getG();
            System.out.println("Mejor valor de la funcion objetivo :" + rand1.getOutput().getBestSolution().getFitnessValue());
            System.out.println("Valor de g1: " + g[0]);
            System.out.println("Valor de g2: " + g[1]);
            System.out.println("Valor de g3: " + g[2]);
            
            if (g[0] <= 0 && g[1] <= 0 && g[2]<=0) {
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
    public void PI47(){ 
        System.out.println("\n PI-47");
        int totalRuns = 25;
        int successfulRuns = 0;
        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("Ejecucion numero: " + run);
            C13 C13 = new C13(10);
            DERand2Bin rand2 = new DERand2Bin(20, 0.5, 0.9, 200000, C13);
            rand2.initializePopulation();
            rand2.run();
            Solution bestSolution = rand2.getOutput().getBestSolution();
            double [] g = bestSolution.getG();
            System.out.println("Mejor valor de la funcion objetivo :" + rand2.getOutput().getBestSolution().getFitnessValue());
            System.out.println("Valor de g1: " + g[0]);
            System.out.println("Valor de g2: " + g[1]);
            System.out.println("Valor de g3: " + g[2]);
            
            if (g[0] <= 0 && g[1] <= 0 && g[2]<=0) {
                System.out.println("Ejecucion " + run + " cumple con todas las restricciones.");
                successfulRuns++;
            } else {
                System.out.println("Advertencia: Ejecucion " + run + " no cumple con las restricciones.");
            }
        }
        System.out.println("Numero de ejecuciones exitosas: " + successfulRuns + " de " + totalRuns);

        Assert.assertTrue("Ninguna de las ejecuciones cumplio con las restricciones.", successfulRuns > 0);
    }
    
    //Problema C13 con tamaño de 30 dimensiones
    @Test
    public void PI48(){ 
        System.out.println("\n PI-48");
        int totalRuns = 25;
        int successfulRuns = 0;
        for (int run = 1; run <= totalRuns; run++) {
            System.out.println("Ejecucion numero: " + run);
            C13 C13 = new C13(30);
            DERand2Bin rand2 = new DERand2Bin(20, 0.5, 0.9, 600000, C13);
            rand2.initializePopulation();
            rand2.run();
            Solution bestSolution = rand2.getOutput().getBestSolution();
            double [] g = bestSolution.getG();
            System.out.println("Mejor valor de la funcion objetivo :" + rand2.getOutput().getBestSolution().getFitnessValue());
            System.out.println("Valor de g1: " + g[0]);
            System.out.println("Valor de g2: " + g[1]);
            System.out.println("Valor de g3: " + g[2]);
            
            if (g[0] <= 0 && g[1] <= 0 && g[2]<=0) {
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
