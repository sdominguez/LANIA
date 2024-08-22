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

import lania.edu.bled.optimization.problems.ConstrainedProblem;
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
public class ConstrainedProblemTest {
    
    public ConstrainedProblemTest() {
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
    public void PU111(){ 
        System.out.println("\n PU-111");
        ConstrainedProblem problem = new ConstrainedProblem(10);
        System.out.println("Tamaño del arreglo: " + problem.getUpperLimit().length);
        Assert.assertEquals(10, problem.getUpperLimit().length);
    }
    
    @Test
    public void PU112(){ 
        System.out.println("\n PU-112");
        ConstrainedProblem problem = new ConstrainedProblem(10);
        System.out.println("Tamaño del arreglo: " + problem.getLowerLimit().length);
        Assert.assertEquals(10, problem.getLowerLimit().length);
    }
}
