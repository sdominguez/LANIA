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
package lania.edu.bled.de.variants;

import lania.edu.bled.de.components.Output;
import lania.edu.bled.de.crossover.Binomial;
import lania.edu.bled.de.mutation.Rand1;
import lania.edu.bled.handler.constraints.FeasibilityRules;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class DERand1Bin extends DEBase{
    
    
    
    public DERand1Bin(int popSize, double f, double cr, int maxFES, ConstrainedProblem problem) {
        super(popSize, f, cr, maxFES, problem);
        mutation = new Rand1();
        crossover = new Binomial();
    }
    
    
}
