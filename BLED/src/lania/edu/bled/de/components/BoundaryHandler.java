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

import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class BoundaryHandler {
    
    /**
     * Método para ajustar las variables de decisión dentro de los límites
     * superior e inferior del problema usando el mecanismo de reflexión
     * @param x
     * @param problem
     * @return 
     */
    public static double[] reflex(double[] x, ConstrainedProblem problem) {
        double[] u = problem.getUpperLimit();
        double[] l = problem.getLowerLimit();
        for (int i = 0; i < x.length; i++) {
            while (x[i] < l[i] || x[i] > u[i]) {
                x[i] = (x[i] < l[i]) ? (2 * l[i] - x[i]) : x[i];
                x[i] = (x[i] > u[i]) ? (2 * u[i] - x[i]) : x[i];
            }
        }
        return x;
    }

    /**
     * Método para ajustar las variables de decisión dentro de los límites
     * superior e inferior del problema usando el mecanismo aleatorio
     * @param x
     * @param problem
     * @return 
     */
    public static double[] random(double[] x, ConstrainedProblem problem) {
        double[] u = problem.getUpperLimit();
        double[] l = problem.getLowerLimit();
        for (int i = 0; i < x.length; i++) {
            if(x[i]>u[i] || x[i]<l[i]){
                x[i] = Stochastic.randReal(l[i], u[i]);
            }
        }
        return x;
    }
    
}
