/*
 * Copyright (C) 2023 Steban
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

import lania.edu.bled.de.components.BoundaryHandler;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2017.C01;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Steban
 */
public class BoundaryHandlerTest {
    
    public BoundaryHandlerTest() {
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
    
    
    //PU-01
    @Test
    public void PU01(){
        System.out.println("\n PU-01");
        C01 problema = new C01(10);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double element:resultadoReflex){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test
    public void PU02(){
        System.out.println("\n PU-02");
        C01 problema = new C01(10);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double element:resultadoReflex){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test
    public void PU03(){
        System.out.println("\n PU-03");
        C01 problema = new C01(10);
        double x[] = {101.0,102.0,103.0,500.0,1000.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double element:resultadoReflex){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test
    public void PU04(){
        System.out.println("\n PU-04");
        C01 problema = new C01(10);
        double x[] = {101.0,102.0,103.0,500.0,1000.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
    }
    
    @Test
    public void PU05(){
        System.out.println("\n PU-05");
        ConstrainedProblem problema = new C01(10);
        double x[] = {-101.0,-200.0,-300.0,-400.0,-500.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        
    }
    
    @Test
    public void PU06(){
        System.out.println("\n PU-06");
        ConstrainedProblem problema = new C01(10);
        double x[] = {-101.0,-200.0,-300.0,-400.0,-500.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
    }
    
    @Test
    public void PU07(){
        System.out.println("\n PU-07");
        ConstrainedProblem problema = new C01(5);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test 
    public void PUO8(){
        System.out.println("\n PU-08");
        ConstrainedProblem problema = new C01(5);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
    }
    
    @Test
    public void PU09(){
        System.out.println("\n PU-09");
        ConstrainedProblem problema = new C01(10);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test 
    public void PU10(){
        System.out.println("\n PU-10");
        ConstrainedProblem problema = new C01(10);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
    }
    
    @Test
    public void PU11(){
        System.out.println("\n PU-11");
        ConstrainedProblem problema = new C01(3);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
    }
    
    @Test 
    public void PU12(){
        System.out.println("\n PU-12");
        ConstrainedProblem problema = new C01(3);
        double x[] = {1.0,2.0,3.0,4.0,100.0};
        double resultadoRandom [] = BoundaryHandler.random(x, problema);
        for (double element:resultadoRandom){
            Assert.assertTrue(element>=-100.00 && element<=100.00);
            System.out.println(element);
        }
        double resultadoReflex[] = BoundaryHandler.reflex(x, problema);
        for (double elementR:resultadoReflex){
            Assert.assertTrue(elementR>=-100.00 && elementR<=100.00);
            System.out.println(elementR);
        }
    }
}
