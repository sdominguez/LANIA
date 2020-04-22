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

    private double[] x, g, h, deltas;
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
     * Recibe el número de variables de decisión
     * deberá ser la misma que la dimensionalidad del problema
     * @param D numero de variables de decisión del problema
     * @param m número de restricciones de desigualdad
     * @param p número de restricciones de igualdad
     */
    public Solution(int D, int m, int p){
        x = new double[D];
        g = new double[m];
        h = new double[p];
        f = 0.0;
        phi = 0.0;
        deltas = new double[p];
        for(int i = 0; i < p; i++){
            deltas[i] = DELTA;
        }
    }
    
    /**
     * Recibe el número de variables de decisión
     * deberá ser la misma que la dimensionalidad del problema
     * @param D numero de variables de decisión del problema
     * @param m número de restricciones de desigualdad
     * @param p número de restricciones de igualdad
     * @param deltas tolerancias para restricciones de igualdad
     */
    public Solution(int D, int m, int p, double[] deltas){
        x = new double[D];
        g = new double[m];
        h = new double[p];
        f = 0.0;
        phi = 0.0;
        deltas = Arrays.copyOf(deltas, p);
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
     * @return valores de las restricciones de desigualdad 
     */
    public double[] getG() {
        return g;
    }
    /**
     * @return valores de las restricciones de igualdad 
     */
    public double[] getH() {
        return h;
    }
    /**
     * @return valores de las tolerancias en restricciones de igualdad 
     */
    public double[] getDeltas() {
        return deltas;
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

    public void setDeltas(double[] deltas) {
        this.deltas = Arrays.copyOf(deltas, deltas.length);
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
                if (deltas != null && deltas.length != h.length) {
                    hx += Math.max(0, Math.abs(h[pos]) - DELTA);
                } else {
                    hx += Math.max(0, Math.abs(h[pos]) - deltas[pos]);
                }
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
