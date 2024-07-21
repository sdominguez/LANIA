/*
 * Copyright (C) 2024 Steban
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
package lania.edu.bled.test.emg;

import java.util.ArrayList;
import java.util.List;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.mutation.Rand1;
import lania.edu.bled.de.variants.DERand1Bin;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.engineering.PressureVessel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steban
 */
public class Rand1Test {
    
    private ConstrainedProblem P;
    private DERand1Bin rand1bin;
    
    public Rand1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        P = new PressureVessel();
        rand1bin = new DERand1Bin(10, 0.5, 0.9, 200000, P);
        rand1bin.run();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void PU68(){
        System.out.println("\n PU-68");
        double[] F = rand1bin.getF();
        List<Solution> soluciones = rand1bin.getTargets();
        Rand1 rand1 = new Rand1();
        List<Solution> mutants = rand1.getMutants(F, soluciones, P);
        for (int i = 0; i < mutants.size(); i++) {
            for (int j = i + 1; j < mutants.size(); j++) {
                Solution sol1 = mutants.get(i);
                Solution sol2 = mutants.get(j);

                // Imprimir las soluciones que se están comparando
                System.out.println("Comparando soluciones en índices " + i + " y " + j + ":");
                System.out.println("Solución 1: " + sol1);
                System.out.println("Solución 2: " + sol2);

                // Validar que las soluciones sean diferentes
                Assert.assertNotEquals("Las soluciones deberían ser diferentes", sol1, sol2);
            }
        }
    }
    
    @Test
    public void PU69(){
        System.out.println("\n PU-69");
        double[] F = rand1bin.getF();
        List<Solution> soluciones = rand1bin.getTargets();
        Rand1 rand1 = new Rand1();
        List<Solution> mutants = rand1.getMutants(F, soluciones, P);
        for (int i = 0; i < mutants.size(); i++) {
            for (int j = i + 1; j < mutants.size(); j++) {
                Solution sol1 = mutants.get(i);
                Solution sol2 = mutants.get(j);

                // Imprimir las soluciones que se están comparando
                System.out.println("Comparando soluciones en índices " + i + " y " + j + ":");
                System.out.println("Solución 1: " + sol1);
                System.out.println("Solución 2: " + sol2);

                // Validar que las soluciones sean diferentes
                Assert.assertNotEquals("Las soluciones deberían ser diferentes", sol1, sol2);
            }
        }
    }
    
    @Test
    public void PU70(){
        System.out.println("\n PU-70");
        double[] F = rand1bin.getF();
        List<Solution> soluciones = rand1bin.getTargets();
        Rand1 rand1 = new Rand1();
        List<Solution> mutants = rand1.getMutants(F, soluciones, P);
        for (int i = 0; i < mutants.size(); i++) {
            for (int j = i + 1; j < mutants.size(); j++) {
                Solution sol1 = mutants.get(i);
                Solution sol2 = mutants.get(j);

                // Imprimir las soluciones que se están comparando
                System.out.println("Comparando soluciones en índices " + i + " y " + j + ":");
                System.out.println("Solución 1: " + sol1);
                System.out.println("Solución 2: " + sol2);

                // Validar que las soluciones sean diferentes
                Assert.assertNotEquals("Las soluciones deberían ser diferentes", sol1, sol2);
            }
        }
    }

    @Test
    public void PU71(){
        System.out.println("\n PU-71");
        Rand1 rand1 = new Rand1();
        List<Solution> targets = new ArrayList<>();
        List<Solution> mutants = new ArrayList<>();
        double[] Cr = {};
        List<Solution> soluciones = rand1.getMutants(Cr, targets, P);
    }
}
