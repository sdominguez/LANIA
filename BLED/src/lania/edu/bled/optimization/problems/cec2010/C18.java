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
public class C18 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C18(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 50.0;
            lower[i] = -50.0;
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
        double[] h = new double[1];
        int j;
        double f1, h1, g1;
        double[] e = new double[nx];
        double[] o = {-2.494401436611803, -0.306408781638572, -2.271946840536718, 0.381278325914122, 2.394875929583502, 0.418708663782934, -2.082663588220074, 0.776060342716238, -0.374312845903175, 0.352372662321828, 1.172942728375508, -0.24450210952894, 1.049793874089803, -1.716285448140795, -1.026167671845868, -1.223031642604231, 0.924946651665792, 0.93270056541258, -2.312880521655027, -0.671857644927313, -0.312276658254605, -0.973986111708943, -0.454151248193331, 2.420597958989111, 0.050346805172393, 1.050203106200361, -0.05420584346617, -0.081533357726523, -0.968176219532845, 1.682281307624435};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        g1 = 0.;

        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + Math.pow((e[j] - e[j + 1]), 2);
        }

        for (j = 0; j < nx; j++) {
            g1 = g1 - e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
            h1 = h1 + e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
        }

        f = f1;
        h[0] = h1 / ((double) nx);
        g[0] = g1 / ((double) nx);
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
