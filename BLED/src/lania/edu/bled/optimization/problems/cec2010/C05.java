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
public class C05 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C05(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 600.0;
            lower[i] = -600.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    
    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] h = new double[2];
        int j;
        double f1, h1, h2;
        double[] e = new double[nx];
        double[] o = {72.10900225247575, 9.007673762322495, 51.86632637302316, 41.365704820161, 93.18768763916974, 74.53341902482204, 63.745479932407655, 7.496986033468282, 56.16729598807964, 17.71630810614085, 28.009655663065143, 29.36357615570272, 26.966653374740996, 6.892189514516317, 44.29071160734624, 84.35803966449319, 81.16906730972529, 92.76919270133271, 3.826058034047476, 7.231864548985054, 14.446069444832405, 46.49943418775763, 22.155722253817412, 69.11723738661682, 88.99628570349459, 58.74823912291344, 52.265369214509846, 47.030120955005074, 53.23321779503931, 5.778976086909701};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = e[0];
        h1 = 0.;
        h2 = 0.;
        for (j = 0; j < nx; j++) {
            if (e[j] > f1) {
                f1 = e[j];
            }

            h1 = h1 - e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
            h2 = h2 - e[j] * Math.cos(0.5 * Math.sqrt(Math.abs(e[j])));
        }

        f = f1;
        h[0] = h1 / ((double) nx);
        h[1] = h2 / ((double) nx);
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
}
