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

import lania.edu.bled.de.variants.DERand2Bin;
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
public class DERand2BinTest {
    
    private ConstrainedProblem problem = new PressureVessel();
    
    public DERand2BinTest() {
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
    public void PU81(){
        System.out.println("\n PU-81");
        DERand2Bin rand2bin = new DERand2Bin(10, 0.9, 0.5, 200000, problem);
        rand2bin.run();
        Assert.assertEquals(10, rand2bin.getPopSize());
        System.out.println("Valor de popSize: " + rand2bin.getPopSize());
    }
    
    @Test
    public void PU82() {
        System.out.println("\n PU-82");
        DERand2Bin rand2bin = new DERand2Bin(10, 0.9, 0.5, 200000, problem);
        rand2bin.run();
        double[] lista = rand2bin.getF();
        System.out.println("Valor de f : " + lista[0]);
        for (int i = 0; i < lista.length; i++) { 
            double valor = lista[i];
            Assert.assertEquals(0.9, valor, 0.0001); 
        }
    }

    
    @Test
    public void PU83(){
        System.out.println("\n PU-83");
        DERand2Bin rand2bin = new DERand2Bin(10, 0.9, 0.5, 200000, problem);
        rand2bin.run();
        double[] lista = rand2bin.getCr();
        System.out.println("Valor de Cr : " + lista[0]);
        for (int i = 0; i < lista.length; i++) { 
            double valor = lista[i];
            Assert.assertEquals(0.5, valor, 0.0001); 
        }
    }
    
    @Test
    public void PU84(){
        System.out.println("\n PU-84");
        DERand2Bin rand2bin = new DERand2Bin(10, 0.9, 0.5, 200000, problem);
        rand2bin.run();
        int maxFes = rand2bin.getMaxFES();
        System.out.println("Valor de maxFES : " + maxFes);
        Assert.assertEquals(200000, maxFes);
    }
    
    @Test
    public void PU85(){
        System.out.println("\n PU-85");
        double[] limiteInferior = {-100};
        problem.setLowerLimit(limiteInferior);
        DERand2Bin rand2bin = new DERand2Bin(10, 0.9, 0.5, 200000, problem);
        rand2bin.run();
        double[] limite = rand2bin.getProblem().getLowerLimit();
        System.out.println("Limite inferior de problem: " + limite[0]);
        Assert.assertArrayEquals(limite, limite, 0);
    }
}
