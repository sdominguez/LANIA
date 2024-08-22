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
import junit.framework.Assert;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.variants.DERand1Bin;
import lania.edu.bled.handler.constraints.EpsilonConstrained;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.engineering.PressureVessel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steban
 */
public class EpsilonConstrainedTest {
    
    private ConstrainedProblem problem = new PressureVessel();
    private static Solution sol1;
    private static Solution sol2;
    
    public EpsilonConstrainedTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sol1 = new Solution(10, 3, 3);
        sol1.setG(new double[]{0.5, -0.2, 0.3});  
        sol1.setH(new double[]{0.05, 0.1, 0.08}); 
        sol1.setVariables(new double[]{0.4, 0.8});
        sol1.setPhi();
        

        sol2 = new Solution(10, 3, 3);
        sol2.setG(new double[]{1.0, 0.7, -0.4}); 
        sol2.setH(new double[]{0.15, 0.2, 0.25}); 
        sol2.setVariables(new double[]{0.2, 0.6});
        sol2.setPhi();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void PU104(){ 
        System.out.println("\n PU-104");
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        System.out.println("Valor de teta: " + epsilon.getTeta());
        Assert.assertEquals(0.5, epsilon.getTeta(), 0.1); epsilon.getTeta();
    }
    
    @Test
    public void PU105(){ 
        System.out.println("\n PU-105");
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        epsilon.decreaseEps(5);
        System.out.println("Valor de tc: " + epsilon.getTc());
        Assert.assertEquals(100, epsilon.getTc(), 0.1); epsilon.getTeta();
    }
    
    @Test
    public void PU106(){ 
        System.out.println("\n PU-106");
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        Assert.assertTrue(epsilon.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU107(){ 
        System.out.println("\n PU-107");
        sol1 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(2.5);
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        Assert.assertTrue(epsilon.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU108(){ 
        System.out.println("\n PU-108");
        sol1 = new Solution(5);
        sol2 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.4);
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        Assert.assertFalse(epsilon.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU109(){ 
        System.out.println("\n PU-109");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        Assert.assertFalse(epsilon.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU110(){ 
        System.out.println("\n PU-110");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        DERand1Bin rand1bin = new DERand1Bin(10, 0.9, 0.5, 200000, problem);
        rand1bin.run();
        List<Solution> soluciones = rand1bin.getTrials();
        EpsilonConstrained epsilon = new EpsilonConstrained(0.5,1.0,100,soluciones);
        Assert.assertFalse(epsilon.compareByConstraintViolationSum(sol1, sol2));
    }
}
