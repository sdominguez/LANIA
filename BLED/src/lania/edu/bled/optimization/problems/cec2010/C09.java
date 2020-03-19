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
package lania.edu.bled.optimization.problems.cec2010;

import java.util.Arrays;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class C09 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C09(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 500.0;
            lower[i] = -500.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    
    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] h = new double[1];
        
        int j;
        double f1, h1;
        double[] e = new double[nx];
        double[] o = {-41.03250252873486, -35.70280591875908, -48.66938576680659, 94.51946988004894, 31.68700466174738, 99.69508270219342, 30.778279925351967, -31.041222172110807, -46.21010370947247, 27.26190010072706, -2.093622677920422, 22.246274570582585, -42.887366421312436, 89.88377145577851, -6.731523713182725, 97.86439204258224, 49.49993772881544, 23.210695390854696, -81.36716857155828, -20.15688556597543, 36.692155371634726, 44.37408948075327, -15.984549833405907, -49.68391424581281, 98.3715576810595, 0.127593155843627, 61.709914317965655, -84.0189999580673, -35.39565398431638, -5.143979333218638};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;

        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + (100.0 * Math.pow(((e[j] + 1.0) * (e[j] + 1.0) - (e[j + 1] + 1.0)), 2) + Math.pow(((e[j] + 1.0) - 1.0), 2));
        }

        for (j = 0; j < nx; j++) {
            h1 = h1 + e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
        }

        f = f1;
        h[0] = h1;

        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
}
