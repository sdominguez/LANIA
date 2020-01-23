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
package lania.edu.bled.base;

/**
 * @author sdominguez
 * esta interfaz principal para definir la representación de una solución
 * @param <D>
 */
public interface ISolution<D> {
    
    /**
     * Constante usada como tolerancia para restricciones de igualdad 
     */
    public double DELTA = 1.0E-4;
    
    /**
     * @return X un vector con las variables de diseño
     */
    public double[] getVariables();
    /**
     * @return f(X) el valor de la función de aptitud
     */
    public double getFitnessValue();
    /**
     * @return phi(X) la suma de violación de restricciones
     */
    public double getPhi();
    
    
    /**
     * Recibe un vector X con las variables de diseño
     * @param X
     */
    public void setVariables(double[] X);
    /**
     * Recibe el valor de la función objetivo
     * @param fx 
     */
    public void setFitnessValue(double fx);
    
}
