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


import lania.edu.bled.optimization.problems.cec2017.C10;
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
public class C10_2017Test {
    
    public C10_2017Test() {
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
    public void PU167(){ 
        System.out.println("\n PU-167"); 
        C10 c10 = new C10(10);
        double[] rango = c10.getUpperLimit();
        for(int i=0;i<c10.getUpperLimit().length;i++){
            Assert.assertEquals(100.0, rango[i],0.0001);
        }
        System.out.println("Limite superior: " + rango[0]);
    }
    
    @Test
    public void PU168(){ 
        System.out.println("\n PU-168"); 
        C10 c10 = new C10(10);
        double[] rango = c10.getLowerLimit();
        for(int i=0;i<c10.getLowerLimit().length;i++){
            Assert.assertEquals(-100.0, rango[i],0.0001);
        }
        System.out.println("Limite inferior: " + rango[0]);
    }
}
