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
 */
public interface IConstraintHandler {
    
    /**
     * Compara si una solución s1 es mejor que otra s2
     * @param s1
     * @param s2
     * @return 
     */
    public boolean isS1betterThanS2(Solution s1, Solution s2);
    /**
     * Compara si una solución s1 es mejor o igual que otra s2
     * @param s1
     * @param s2
     * @return 
     */
    public boolean isS1betterOrEqualThanS2(Solution s1, Solution s2);
    /**
     * Compara las propiedades de dos soluciones y determina si deben compararse por
     * la suma de violación de restricciones
     * @param s1
     * @param s2
     * @return 
     */
    public boolean compareByConstraintViolationSum(Solution s1, Solution s2);
}
