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
import lania.edu.bled.de.components.Stochastic;
import lania.edu.bled.de.crossover.Binomial;
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
public class BinomialTest {
    
    private ConstrainedProblem P;
    private DERand1Bin rand1bin;
    
    public BinomialTest() {
        
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
    public void PU64(){
        System.out.println("\n PU-64");
        double[] Cr = rand1bin.getCr();
        for(int i=0;i<Cr.length;i++){
            System.out.println("Probabilidad de cruza Cr: "+Cr[i]);
            Assert.assertTrue(Cr[i]==0.9);
        }
    }
    
    @Test
    public void PU65(){
        System.out.println("\n PU-65");
        List<Solution> targets = rand1bin.getTargets();
        for (int i = 0; i < targets.size(); i++) {
            for (int j = i + 1; j < targets.size(); j++) {
                Solution sol1 = targets.get(i);
                Solution sol2 = targets.get(j);

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
    public void PU66(){
        System.out.println("\n PU-66");
        List<Solution> trials = rand1bin.getTrials();
        for (int i = 0; i < trials.size(); i++) {
            for (int j = i + 1; j < trials.size(); j++) {
                Solution sol1 = trials.get(i);
                Solution sol2 = trials.get(j);

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
    public void PU67(){
        System.out.println("\n PU-67");
        Binomial binomial = new Binomial();
        List<Solution> targets = new ArrayList<>();
        List<Solution> mutants = new ArrayList<>();
        double[] Cr = {};
        List<Solution> soluciones = binomial.getTrials(Cr, targets, mutants);
    }
}
