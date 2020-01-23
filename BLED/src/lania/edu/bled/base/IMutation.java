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

import java.util.List;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public interface IMutation {
    
    /**
     * Regresa una lista de soluciones usando algún operador de mutación. El problema
     * sirve para determinar los límites superiores e inferiores de las variables
     * @param F
     * @param targets
     * @param problem
     * @return 
     */
    public List<Solution> getMutants(double[] F, List<Solution> targets, ConstrainedProblem problem);
    
}
