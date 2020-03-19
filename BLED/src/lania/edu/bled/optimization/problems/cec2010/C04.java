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
public class C04 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C04(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 1000.0;
            lower[i] = -1000.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] h = new double[4];
        
        int j;
        double f1, h1, h2, h3, h4;
        double[] e = new double[nx];
        double[] o = {0.820202353727904, 5.260154140335203, -1.694610371739177, -5.589298730330406, -0.141736605495543, 9.454675508078164, 8.795744608532939, 9.687346331423548, -3.246522827444976, 6.647399971577617, 1.434490229836026, -0.506531215086801, 0.558594225280784, 7.919942423520642, 1.383716002673571, -1.520153615528276, -2.266737465474915, 6.48052999726508, -8.893207968949003, -3.528743044935322, 6.063486037065154, -4.51585211274229, 7.320477892009357, -8.990263774675665, 9.446412007392851, -6.41068985463494, -9.135251626491991, 2.07763837492787, 8.051026378030816, -1.002691032064544};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }
        /* objective function */
        f1 = e[0];
        h1 = 0.;
        h2 = 0.;
        h3 = 0.;
        h4 = 0.;
        for (j = 0; j < nx; j++) {
            if (e[j] > f1) {
                f1 = e[j];
            }

            h1 = h1 + e[j] * Math.cos(Math.sqrt(Math.abs(e[j])));
            h4 = h4 + e[j];
        }

        for (j = 0; j < (nx / 2 - 1); j++) {
            h2 = h2 + Math.pow((e[j] - e[j + 1]), 2);
        }

        for (j = nx / 2; j < (nx - 1); j++) {
            h3 = h3 + Math.pow((e[j] * e[j] - e[j + 1]), 2);
        }

        f = f1;
        h[0] = h1 / ((double) nx);
        h[1] = h2;
        h[2] = h3;
        h[3] = h4;

        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
}
