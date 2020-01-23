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
package lania.edu.bled.de.crossover;

import java.util.ArrayList;
import java.util.List;
import lania.edu.bled.base.ICrossover;
import lania.edu.bled.de.components.Solution;

/**
 *
 * @author sdominguez
 */
public class Crossover implements ICrossover {

    @Override
    public List<Solution> getTrials(double[] Cr, List<Solution> targets, List<Solution> mutants) {
        List<Solution> trials = new ArrayList();
        return trials;
    }
    
}
