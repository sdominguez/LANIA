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
package lania.edu.bled.de.mutation;

import java.util.ArrayList;
import java.util.List;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.components.Stochastic;
import lania.edu.bled.de.components.BoundaryHandler;
import lania.edu.bled.optimization.problems.ConstrainedProblem;


/**
 *
 * @author sdominguez
 */
public class Rand1 extends Mutation {

    @Override
    public List<Solution> getMutants(double[] f, List<Solution> targets, ConstrainedProblem problem) {
        List<Solution> mutants = new ArrayList();
        int popSize = targets.size();
        int n = targets.get(0).getVariables().length;
        for (int i = 0; i < popSize; i++) {
            /*Elegir 3 individuos de la poblacion aleatoriamente r1!=r2!=r3!=i*/
            int[] r = Stochastic.arrayRandInt(3, 0, popSize - 1, i);
            double[] x1 = targets.get(r[0]).getVariables().clone();
            double[] x2 = targets.get(r[1]).getVariables().clone();
            double[] x3 = targets.get(r[2]).getVariables().clone();
            double[] x = targets.get(i).getVariables().clone();
            /*Aplicar operador de mutacion*/
            for (int k = 0; k < n; k++) {
                x[k] = x1[k] + (f[k] * (x2[k] - x3[k]));
            }
            Solution s = new Solution(n);
            s.setVariables(BoundaryHandler.reflex(x, problem));
            mutants.add(s);
        }
        return mutants;
    
    }
    
}
