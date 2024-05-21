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
public class SolutionTest {
    
    public SolutionTest() {
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
    public void PU13(){
        System.out.println("\n PU-13");
        Solution solucion = new Solution(5);
        double phi = solucion.getPhi();
        System.out.println("Phi: "+phi);
        Assert.assertTrue(phi==0.0);
        System.out.println(solucion.toString());
    }
    
    @Test
    public void PU14(){
        System.out.println("\n PU-14");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(x);
        double phi = solucion.getPhi();
        System.out.println("Phi: "+phi);
        Assert.assertTrue(phi==0.0);
        System.out.println(solucion.toString());
    }
    
    @Test
    public void PU15(){
        System.out.println("\n PU-15");
        Solution solucion = new Solution(10,15,20);
        double phi = solucion.getPhi();
        System.out.println("Phi: "+phi);
        Assert.assertTrue(phi==0.0);
        System.out.println(solucion.toString());
    }
    
    @Test
    public void PU16(){
        System.out.println("\n PU-16");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        double phi = solucion.getPhi();
        System.out.println("Phi: "+phi);
        Assert.assertTrue(phi==0.0);
        System.out.println(solucion.toString());
    }
    
    @Test
    public void PU17(){
        System.out.println("\n PU-17");
        Solution solucion = new Solution(5);
        Assert.assertTrue(solucion.getFitnessValue()==0.0);
        System.out.println("Valor de f: "+solucion.getFitnessValue());
    }
    
    @Test
    public void PU18(){
        System.out.println("\n PU-18");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(x);
        Assert.assertTrue(solucion.getFitnessValue()==0.0);
        System.out.println("Valor de f: "+solucion.getFitnessValue());
    }
    
    @Test
    public void PU19(){
        System.out.println("\n PU-19");
        Solution solucion = new Solution(10,15,20);
        Assert.assertTrue(solucion.getFitnessValue()==0.0);
        System.out.println("Valor de f: "+solucion.getFitnessValue());
    }
    
    @Test
    public void PU20(){
        System.out.println("\n PU-20");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        Assert.assertTrue(solucion.getFitnessValue()==0.0);
        System.out.println("Valor de f: "+solucion.getFitnessValue());
    }
    
    @Test
    public void PU21(){
        System.out.println("\n PU21");
        Solution solucion = new Solution(5);
        double x[] = solucion.getVariables();
        solucion.toString();
        System.out.println(x.length);
        Assert.assertTrue(x.length==5);
    }
    
    @Test
    public void PU22(){
        double x[] = {5,2,7,9,100,320};
        System.out.println("\n PU22");
        Solution solucion = new Solution(x);
        double xResult[] = solucion.getVariables();
        solucion.toString();
        for(int i=0;i<x.length;i++){
            Assert.assertTrue(x[i]==xResult[i]);
            System.out.println(x[i]);
        }
    }
    
    @Test
    public void PU23(){
        System.out.println("\n PU23");
        Solution solucion = new Solution(10,15,20);
        solucion.toString();
        System.out.println("Tamaño de X: "+solucion.getVariables().length);
        Assert.assertTrue(solucion.getVariables().length==10);
        
    }
    
    @Test
    public void PU24(){
        System.out.println("\n PU24");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        solucion.toString();
        System.out.println("Tamaño de X: "+solucion.getVariables().length);
        Assert.assertTrue(solucion.getVariables().length==10);
    }
    
    @Test
    public void PU25(){
        System.out.println("\n PU25");
        Solution solucion = new Solution(5);
        double g[] = solucion.getG();
        solucion.toString();
        System.out.println("Tamaño de g: "+g.length);
        Assert.assertTrue(g.length==50);
    }
    
    @Test
    public void PU26(){
        double x[] = {5,2,7,9,100,320};
        System.out.println("\n PU26");
        Solution solucion = new Solution(x);
        double g[] = solucion.getG();
        solucion.toString();
        System.out.println("Tamaño de g: "+g.length);
        Assert.assertTrue(g.length==50);
    }
    
    @Test
    public void PU27(){
        System.out.println("\n PU27");
        Solution solucion = new Solution(10,15,20);
        solucion.toString();
        double g[] = solucion.getG();
        System.out.println("Tamaño de g: "+g.length);
        Assert.assertTrue(g.length==15);
        
    }
    
    @Test
    public void PU28(){
        System.out.println("\n PU28");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        solucion.toString();
        double g[] = solucion.getG();
        System.out.println("Tamaño de g: "+g.length);
        Assert.assertTrue(g.length==20);
    }
    
    @Test
    public void PU29(){
        System.out.println("\n PU29");
        Solution solucion = new Solution(5);
        double h[] = solucion.getH();
        solucion.toString();
        System.out.println("Tamaño de h: "+h.length);
        Assert.assertTrue(h.length==50);
    }
    
    @Test
    public void PU30(){
        double x[] = {5,2,7,9,100,320};
        System.out.println("\n PU30");
        Solution solucion = new Solution(x);
        double h[] = solucion.getH();
        solucion.toString();
        System.out.println("Tamaño de h: "+h.length);
        Assert.assertTrue(h.length==50);
    }
    
    @Test
    public void PU31(){
        System.out.println("\n PU31");
        Solution solucion = new Solution(10,15,20);
        solucion.toString();
        double h[] = solucion.getH();
        System.out.println("Tamaño de h: "+h.length);
        Assert.assertTrue(h.length==20);
        
    }
    
    @Test
    public void PU32(){
        System.out.println("\n PU32");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        solucion.toString();
        double h[] = solucion.getH();
        System.out.println("Tamaño de h: "+h.length);
        Assert.assertTrue(h.length==30);
    }
    
    @Test
    public void PU33(){
       System.out.println("\n PU33"); 
       Solution solucion = new Solution(10,15,20);
       solucion.toString();
       double deltas[] = solucion.getDeltas();
       System.out.println("Tamaño de deltas: "+deltas.length);
       Assert.assertTrue(deltas.length==20);
    }
    
    @Test
    public void PU34(){
        System.out.println("\n PU-34");
        Solution solucion = new Solution(5);
        String resultado = solucion.toString();
        Assert.assertTrue("[0.0, 0.0, 0.0, 0.0, 0.0] 0.0 0.0".equals(solucion.toString()));
        System.out.println(resultado);
    }
    
    @Test
    public void PU35(){
        System.out.println("\n PU-35");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(x);
        String resultado = solucion.toString();
        Assert.assertTrue("[5.0, 2.0, 7.0, 9.0, 100.0, 320.0] 0.0 0.0".equals(solucion.toString()));
        System.out.println(resultado);
    }
    
    @Test
    public void PU36(){
        System.out.println("\n PU-36");
        Solution solucion = new Solution(10,15,20);
       String resultado = solucion.toString();
        Assert.assertTrue("[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0] 0.0 0.0".equals(solucion.toString()));
        System.out.println(resultado);
    }
    
    @Test
    public void PU37(){
        System.out.println("\n PU-37");
        double x[] = {5,2,7,9,100,320};
        Solution solucion = new Solution(10,20,30,x);
        String resultado = solucion.toString();
        Assert.assertTrue("[0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0] 0.0 0.0".equals(solucion.toString()));
        System.out.println(resultado);
    }
}
