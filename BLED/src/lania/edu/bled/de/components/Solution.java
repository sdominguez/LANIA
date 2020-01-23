/*
 * Copyright (C) 2020 sdominguez
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
package lania.edu.bled.de.components;

import java.io.Serializable;
import java.util.Arrays;
import lania.edu.bled.base.ISolution;

/**
 *
 * @author sdominguez
 */
public class Solution implements ISolution, Serializable{

    private double[] x, g, h;
    private double f, phi;
    
    /**
     * Recibe el número de variables de decisión
     * deberá ser la misma que la dimensionalidad del problema
     * @param D 
     */
    public Solution(int D){
        x = new double[D];
        g = new double[50];
        h = new double[50];
        f = 0.0;
        phi = 0.0;
    }
    
    /**
     * @return X un vector con las variables de diseño
     */
    @Override
    public double[] getVariables() {
        return x;
    }
    /**
     * @return f(X) el valor de la función de aptitud
     */
    @Override
    public double getFitnessValue() {
        return f;
    }
    /**
     * @return phi(X) la suma de violación de restricciones
     */
    @Override
    public double getPhi() {
        return phi;
    }
    /**
     * Asigna un vector con los valores de las variables de decisión
     * @param X
     */
    @Override
    public void setVariables(double[] X) {
        x = Arrays.copyOf(X, X.length);
    }
    /**
     * Asigna el vector con los valores de las restricciones de desigualdad
     * @param G 
     */
    public void setG(double[] G){
        g = Arrays.copyOf(G, G.length);
    }
    /**
     * Asigna el vector con los valores de las restricciones de igualdad
     * @param H 
     */
    public void setH(double[] H){
        h = Arrays.copyOf(H, H.length);
    }
    
    /**
     * Calcula la suma de violación de restricciones. 
     * Este método debe ser invocado después de haber evaluado la solución
     * con la función objetivo
     */
    public void setPhi() {
        double gx = 0;
        for (int pos = 0; pos < g.length; pos++) {
            if (!Double.isNaN(g[pos])) {
                gx += Math.max(0, g[pos]);
            }
        }
        double hx = 0;
        for (int pos = 0; pos < h.length; pos++) {
            if (!Double.isNaN(h[pos])) {
                hx += Math.max(0, Math.abs(h[pos]) - 1.0E-4);
            }
        }
        phi = gx + hx;
    }
    /**
     * Asigna el valor de la función objetivo
     * @param fx 
     */
    @Override
    public void setFitnessValue(double fx) {
        f = fx;
    }
    /**
     * devuelve el arreglo de variables, valor de aptitud y 
     * suma de violación de restricciones en formato de cadena
     * {x1, x2,...,xn} f(X) phi(X)
     * @return 
     */
    @Override
    public String toString() {
        String strSolution;
        strSolution = Arrays.toString(x);
        strSolution.replace("[", "{").replace("]", "}");
        strSolution+= " "+f+" "+phi;
        return strSolution;
    }
    
    
}
