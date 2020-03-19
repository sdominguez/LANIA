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
public class C14 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C14(int D) {
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
        double[] g = new double[3];
        
        int j;
        double f1, g1, g2, g3;
        double[] e = new double[nx];
        double[] o = {-31.718907007204272, -39.536680684207184, -46.033718058035944, -42.2004014684422, -28.331307546159135, -38.64403177375364, -11.313371899853626, -11.717383190039943, -43.345049558717875, -31.46016185891229, -35.57742732758397, -45.49638850141341, -4.177473725277878, -26.974808661067083, -46.30991533784743, -45.997883193212814, -29.479673271045964, -4.336542960830036, -43.66244285780764, -22.43896852522004, -25.89273808052249, -24.221450510218993, -30.3952886350567, -31.170730638052895, -9.859463575974534, -16.727846507426452, -44.35226340706524, -33.10843069426064, -7.175153678947718, -4.601421202670486};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        g1 = 0.;
        g2 = 0.;
        g3 = 0.;

        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + (100.0 * Math.pow(((e[j] + 1.0) * (e[j] + 1.0) - (e[j + 1] + 1.0)), 2) + Math.pow(((e[j] + 1.0) - 1.0), 2));
        }

        for (j = 0; j < nx; j++) {
            g1 = g1 - e[j] * Math.cos(Math.sqrt(Math.abs(e[j])));
            g2 = g2 + e[j] * Math.cos(Math.sqrt(Math.abs(e[j])));
            g3 = g3 + e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));

        }
        f = f1;
        g[0] = g1 - ((double) nx);
        g[1] = g2 - ((double) nx);
        g[2] = g3 - 10.0 * ((double) nx);
        
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(new double[]{});
        s.setPhi();
        return s;
    }
    
    
}
