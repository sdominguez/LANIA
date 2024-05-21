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

import lania.edu.bled.de.components.Stochastic;
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
public class StochasticTest {
    
    public StochasticTest() {
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
    public void PU38(){
        System.out.println("\n PU-38");
        int resultado = 0;
        for(int i=0;i<=100;i++){
            resultado = Stochastic.randInt(100, 500);
            if(resultado>500||resultado<100){
                break;
            }
        }
        System.out.println("Valor de retorno min es: "+ 100);
        System.out.println("Valor de retorno : "+ resultado);
        Assert.assertTrue(resultado<=500&&resultado>=100);
    }
    
    @Test
    public void PU39(){
        System.out.println("\n PU-39");
        double resultado = 0;
        for(int i=0;i<=100;i++){
            resultado = Stochastic.randReal(10.50, 150.80);
            if(resultado>10.50||resultado<150.80){
                break;
            }
        }
        System.out.println("Valor de retorno min es: "+ 10.50);
        System.out.println("Valor de retorno : "+ resultado);
        Assert.assertTrue(resultado<=150.8&&resultado>=10.50);
    }
    
    @Test
    public void PU40(){
        System.out.println("\n PU-40");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 15);
        System.out.println("Valor de retorno min es: "+ 10);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=15);
        }
    }
    
    @Test
    public void PU41(){
        System.out.println("\n PU-41");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 16);
        System.out.println("Valor de retorno min es: "+ 10);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=16);
        }
    }
    
    @Test
    public void PU42(){
        System.out.println("\n PU-42");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 17);
        System.out.println("Valor de retorno min es: "+ 10);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=17);
        }
    }
    
    @Test
    public void PU43(){
        System.out.println("\n PU-43");
        int resultado = 0;
        for(int i=0;i<=100;i++){
            resultado = Stochastic.randInt(-100, 100);
            if(resultado>100||resultado<-100){
                break;
            }
        }
        System.out.println("Valor de retorno max es: "+ 100);
        System.out.println("Valor de retorno : "+ resultado);
        Assert.assertTrue(resultado<=100&&resultado>=-100);
    }
    
    @Test
    public void PU44(){
        System.out.println("\n PU-44");
        double resultado = 0;
        for(int i=0;i<=100;i++){
            resultado = Stochastic.randReal(-50.50, 50.50);
            if(resultado>-50.50||resultado<50.50){
                break;
            }
        }
        System.out.println("Valor de retorno max es: "+ 50.50);
        System.out.println("Valor de retorno : "+ resultado);
        Assert.assertTrue(resultado<=50.50&&resultado>=-50.50);
    }
    
    @Test
    public void PU45(){
        System.out.println("\n PU-45");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 15);
        System.out.println("Valor de retorno max es: "+ 20);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=15);
        }
    }
    
    @Test
    public void PU46(){
        System.out.println("\n PU-46");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 16);
        System.out.println("Valor de retorno max es: "+ 20);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=16);
        }
    }
    
    @Test
    public void PU47(){
        System.out.println("\n PU-47");
        int resultado [];
        resultado = Stochastic.arrayRandInt(5, 10, 20, 17);
        System.out.println("Valor de retorno max es: "+ 20);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=20&&resultado[i]>=10&&resultado[i]!=17);
        }
    }
    
    @Test 
    public void PU48(){
        System.out.println("\n PU-48");
        float resultado = Stochastic.flip(0.0);
        System.out.println("Valor de retorno es: "+resultado);
        Assert.assertTrue(resultado==0.0);
    }
    
    @Test 
    public void PU49(){
        System.out.println("\n PU-49");
        float resultado = Stochastic.flip(1.0);
        System.out.println("Valor de retorno es: "+resultado);
        Assert.assertTrue(resultado==1.0);
    }
    
    @Test 
    public void PU50(){
        System.out.println("\n PU-50");
        float resultado = Stochastic.flip(-0.5);
        System.out.println("Valor de retorno es: "+resultado);
        Assert.assertTrue(resultado==0.0);
    }
    
    @Test 
    public void PU51(){
        System.out.println("\n PU-51");
        float resultado = Stochastic.flip(2.5);
        System.out.println("Valor de retorno es: "+resultado);
        Assert.assertTrue(resultado==1.0);
    }
    
    @Test 
    public void PU52(){
        System.out.println("\n PU-52");
        float resultado = Stochastic.flip(0.5);
        System.out.println("Valor de retorno es: "+resultado);
        Assert.assertTrue(resultado==1.0||resultado==0.0);
    }
    
    @Test
    public void PU53() {
        System.out.println("\n PU-53");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 10; i++) {
            resultado = Stochastic.randGaussian(6, 2);
            if (resultado < 1 || resultado > 13) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        Assert.assertTrue("El valor de retorno no está en el rango [1, 13]: " + resultado, allValid);
    }

    @Test
    public void PU54() {
        System.out.println("\n PU-54");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 10; i++) {
            resultado = Stochastic.randGaussian(210, 15);
            if (resultado < 158 || resultado > 263) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        Assert.assertTrue("El valor de retorno no está en el rango [158, 263]: " + resultado, allValid);
    }
    
    @Test
    public void PU55() {
        System.out.println("\n PU-55");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 2; i++) {
            resultado = Stochastic.randGaussian(160, 2);
            if (resultado < 153 || resultado > 167) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        Assert.assertTrue("El valor de retorno no está en el rango [153, 167]: " + resultado, allValid);
    }
    
    @Test
    public void PU56() {
        System.out.println("\n PU-56");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 10; i++) {
            resultado = Stochastic.randGaussian(1200, 200);
            if (resultado < 500 || resultado > 1800) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        Assert.assertTrue("El valor de retorno no está en el rango [500, 1800]: " + resultado, allValid);
    }
    
    @Test
    public void PU57(){
        System.out.println("\n PU-57");
        double resultado = 0;
        boolean allValid = true;
        for (int i = 0; i < 10; i++) {
            resultado = Stochastic.randGaussian(20, 3);
            if (resultado < 9.5 || resultado > 30.5) {
                allValid = false;
                break;
            }
        }
        System.out.println("El valor de retorno es: " + resultado);
        Assert.assertTrue("El valor de retorno no está en el rango [9.5, 30.5]: " + resultado, allValid);
    }
    
    @Test
    public void PU58(){
        System.out.println("\n PU-58");
        double resultado = Stochastic.randCauchy(6, 20);
        System.out.println("El valor de retorno es: "+resultado);
    }
    
    @Test
    public void PU59(){
        System.out.println("\n PU-59");
        double resultado = Stochastic.randCauchy(6, 20);
        System.out.println("El valor de retorno es: "+resultado);
    }
   
    
    @Test
    public void PU60(){
        System.out.println("\n PU-60");
        int resultado[] = Stochastic.arrayRandInt(10, 15, 30, 20);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=30&&resultado[i]>=10&&resultado[i]!=20);
        }
    }
    
    @Test
    public void PU61(){
        System.out.println("\n PU-61");
        int resultado[] = Stochastic.arrayRandInt(10, 1, 100, 50);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=100&&resultado[i]>=1&&resultado[i]!=50);
        }
    }
    
    @Test
    public void PU62(){
        System.out.println("\n PU-62");
        int resultado[] = Stochastic.arrayRandInt(10, -50, 0, -25);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=10&&resultado[i]>=-50&&resultado[i]!=-25);
        }
    }
    
    @Test
    public void PU63(){
        System.out.println("\n PU-63");
        int resultado[] = Stochastic.arrayRandInt(10, 10, 15, 13);
        for(int i=0;i<resultado.length;i++){
            System.out.println("Valor posicion ["+i+"]: "+resultado[i]);
            Assert.assertTrue(resultado[i]<=15&&resultado[i]>=10&&resultado[i]!=-13);
        }
    }
}
