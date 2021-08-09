/*
 * Copyright (C) 2021 Saul
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
package lania.edu.bled.test.cec2017;

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.components.Stochastic;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2017.C01;

/**
 *
 * @author Saul
 */
public class TestSolutionCEC2017C01 {
    
    public static void main(String[] args) {
        ConstrainedProblem c01 = new C01(100);
        Solution s = new Solution(c01.getDimension());
        
        double[] x = new double[c01.getDimension()];
        
        for(int i = 0; i < c01.getDimension(); i++){
            x[i] = Stochastic.randReal(c01.getLowerLimit()[i], c01.getUpperLimit()[i]);
        }
        
        s.setVariables(x);
        c01.evaluate(s);
        System.out.println(s.getFitnessValue()+" "+s.getPhi());
    }
    
}
