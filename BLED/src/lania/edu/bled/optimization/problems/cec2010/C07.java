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
public class C07 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C07(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 140.0;
            lower[i] = -140.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    
    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] g = new double[1];
        int j;
        double f1, g1, g2;
        double[] e = new double[nx];
        double[] o = {-1.46823271282738, 47.51401860909492, -30.421056514069576, -7.707941671844303, -21.74698421666629, -17.88116387879569, 5.274442455807971, 18.71403753778708, -36.959734507345146, -20.72950462154263, 25.4701966548936, -25.439992885801573, 1.054563129830697, -31.556579857545657, -19.320382777005047, 17.16774285348282, 34.66536814401755, -31.803705714749462, -12.926898387712775, 25.489686517508602, -45.23000430753644, 36.31774710581284, -18.38690515559357, 34.86816378160691, -37.530671214167334, 19.288852618585977, 0.684612418754519, -12.636795982748637, 15.005454148879409, -40.468678588994315};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        g1 = 0.;
        g2 = 0.;
        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + (100 * Math.pow(((e[j] + 1) * (e[j] + 1) - (e[j + 1] + 1)), 2) + Math.pow(((e[j] + 1) - 1), 2));
        }

        for (j = 0; j < nx; j++) {
            g1 = g1 + e[j] * e[j];
            g2 = g2 + Math.cos(0.1 * e[j]);
        }

        f = f1;
        g[0] = 0.5 - Math.exp(-0.1 * Math.sqrt(1.0 / ((double) nx) * g1)) - 3 * Math.exp(1.0 / ((double) nx) * g2) + Math.exp(1);
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(new double[]{});
        s.setPhi();
        return s;
    }
}
