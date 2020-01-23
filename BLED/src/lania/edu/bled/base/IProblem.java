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

import lania.edu.bled.de.components.Solution;

/**
 *
 * @author sdominguez
 * @param <D>
 */
public interface IProblem<D> {
    /**
     * Función para evaluar una solución, recibe como parámetro una solución
     * del tipo lania.edu.bled.de.components.Solution
     * @param s
     * @return 
     */
    public Solution evaluate(Solution s); 
    /**
     * Obtiene la dimensionalidad del problema
     * @return 
     */
    public int getDimension();
    /**
     * Obtiene un arreglo con los limites superiores de las variables de decisión
     * @return 
     */
    public double[] getUpperLimit();
    /**
     * Obtiene un arreglo con los limites inferiores de las variables de decisión
     * @return 
     */
    public double[] getLowerLimit();
    /**
     * Asigna los límites superiores de las variables de decisión
     * @param upper 
     */
    public void setUpperLimit(double[] upper);
    /**
     * Asigna los límites inferiores de las variables de decisión
     * @param lower 
     */
    public void setLowerLimit(double[] lower);
}
