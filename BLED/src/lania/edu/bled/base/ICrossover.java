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

/**
 *
 * @author sdominguez
 */
public interface ICrossover {
    
    /**
     * Método principal para efectuar el operador de cruza entre los targets y mutants
     * requiere de la tasa de cruza Cr que debe estar entre 0 y 1
     * @param Cr
     * @param targets
     * @param mutants
     * @return 
     */
    public List<Solution> getTrials(double[] Cr, List<Solution> targets, List<Solution> mutants);
    
}
