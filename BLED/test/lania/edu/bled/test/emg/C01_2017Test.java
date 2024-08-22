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

import lania.edu.bled.optimization.problems.cec2017.C01;
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
public class C01_2017Test {
    
    public C01_2017Test() {
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
    public void PU149(){ 
        System.out.println("\n PU-149"); 
        C01 c01 = new C01(10);
        double[] rango = c01.getUpperLimit();
        for(int i=0;i<c01.getUpperLimit().length;i++){
            Assert.assertEquals(rango[i], 100.0,0.0001);
        }
        System.out.println("Limite superior: " + rango[0]);
    }
    
    @Test
    public void PU150(){ 
        System.out.println("\n PU-150"); 
        C01 c01 = new C01(10);
        double[] rango = c01.getLowerLimit();
        for(int i=0;i<c01.getLowerLimit().length;i++){
            Assert.assertEquals(rango[i], -100.0,0.0001);
        }
        System.out.println("Limite inferior: " + rango[0]);
    }
}
