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

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.handler.constraints.ConstraintHandler;
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
public class ConstraintHandlerTest {
    
    private static Solution sol1;
    private static Solution sol2;
    
    public ConstraintHandlerTest() {
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
    public void PU86(){ 
        System.out.println("\n PU-86");
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1betterThanS2(sol1, sol2));
    }
    
    @Test
    public void PU87(){  
        System.out.println("\n PU-87");
        sol1 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(2.5);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1betterThanS2(sol1, sol2));
    }
    
    @Test
    public void PU88(){  
        System.out.println("\n PU-88");
        sol2 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.4);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.isS1betterThanS2(sol1, sol2));
    }
    
    @Test
    public void PU89(){  
        System.out.println("\n PU-89");
        sol1 = new Solution(5);
        sol2 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.4);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.isS1betterThanS2(sol1, sol2));
    }
    
    @Test
    public void PU90(){  
        System.out.println("\n PU-90");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.4);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.isS1betterThanS2(sol1, sol2));
    }
    
    @Test
    public void PU91(){  
        System.out.println("\n PU-91");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.4);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1betterOrEqualThanS2(sol1, sol2));
    }
    
    @Test
    public void PU92(){  
        System.out.println("\n PU-92");
        sol1.setFitnessValue(0.0);
        sol2.setFitnessValue(0.0);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1betterOrEqualThanS2(sol1, sol2));
    }
    
    @Test
    public void PU93(){  
        System.out.println("\n PU-93");
        sol1 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1betterOrEqualThanS2(sol1, sol2));
    }
    
    
    @Test
    public void PU94(){  
        System.out.println("\n PU-94");
        sol1 = new Solution(5);
        sol2 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.compareByConstraintViolationSum(sol1, sol2));
    }

    
    @Test
    public void PU95(){  
        System.out.println("\n PU-95");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU96(){  
        System.out.println("\n PU-96");
        sol1 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU97(){  
        System.out.println("\n PU-97");
        sol2 = new Solution(5);
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU98(){  
        System.out.println("\n PU-98");
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU99(){  
        System.out.println("\n PU-99");
        sol2.setG(new double[]{0.5, -0.2, 0.3});  
        sol2.setH(new double[]{0.05, 0.1, 0.08});
        sol2.setPhi();
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.compareByConstraintViolationSum(sol1, sol2));
    }
    
    @Test
    public void PU100(){  
        System.out.println("\n PU-100");
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1DistictToS2(sol1, sol2));
    }
    
    @Test
    public void PU101(){  
        System.out.println("\n PU-101");
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        sol1.setVariables(new double[]{0.2, 0.6});
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertFalse(handler.isS1DistictToS2(sol1, sol2));
    }
    
    @Test
    public void PU102(){  
        System.out.println("\n PU-102");
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        sol1.setVariables(new double[]{0.9, 0.6});
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1DistictToS2(sol1, sol2));
    }
    
    @Test
    public void PU103(){  
        System.out.println("\n PU-103");
        sol1.setFitnessValue(0.5);
        sol2.setFitnessValue(0.2);
        sol1.setVariables(new double[]{0.2, 0.9});
        System.out.println("Phi de sol1: " + sol1.getPhi());
        System.out.println("Phi de sol2: " + sol2.getPhi());
        System.out.println("FitnessValue de sol1: " + sol1.getFitnessValue());
        System.out.println("FitnessValue de sol2: " + sol2.getFitnessValue());
        ConstraintHandler handler = new ConstraintHandler();
        Assert.assertTrue(handler.isS1DistictToS2(sol1, sol2));
    }
}
