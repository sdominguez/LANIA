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
import java.util.Arrays;
import java.util.List;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.components.Stochastic;

/**
 *
 * @author sdominguez
 */
public class Binomial extends Crossover {

    @Override
    public List<Solution> getTrials(double[] Cr, List<Solution> targets, List<Solution> mutants) {
        int popSize = targets.size();
        List<Solution> trials = new ArrayList();
        int n = targets.get(0).getVariables().length;
        for(int i = 0; i < popSize; i++){
            int jrand = Stochastic.randInt(0, n);
            double[] x = Arrays.copyOf(targets.get(i).getVariables(), n);
            double[] xnew = Arrays.copyOf(mutants.get(i).getVariables(), n);
            for(int j = 0; j < n; j++){
                if(Stochastic.flip(Cr[j])==1 || jrand==j){
                    x[j] = xnew[j];
                }
            }
            Solution newTrial = new Solution(n);
            newTrial.setVariables(x);
            trials.add(newTrial);
        }
        return trials;
    }
    
}
