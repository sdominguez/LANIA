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
public class C13 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C13(int D) {
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
        double[] g = new double[3];
        
        int j;
        double f1, g1, g2, g3;
        double[] e = new double[nx];
        double[] o = {69.69311714880897, 1.509803311435702, 67.6746198312362, 80.43173609273597, 80.47622449424348, 51.21092936019716, 52.7723719926014, 17.248465789326257, 52.40150903116374, 39.64846247456716, 89.86375903333635, 32.079301315169474, 43.192499277837946, 70.79294586561508, 1.48440984483988, 19.8566700417119, 29.502667246412756, 34.256788127976684, 12.643016541338264, 78.57234385195876, 26.51647349482587, 97.06430708087798, 10.180504722002471, 82.90799886855778, 63.540231382573154, 74.78243308676124, 87.20817289266436, 50.779655804893764, 43.05412185616204, 33.862234518700916};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        g1 = 0.;
        g2 = 0.;
        g3 = 1.;

        for (j = 0; j < nx; j++) {
            f1 = f1 - e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
            g1 = g1 + e[j] * e[j];
            g2 = g2 + Math.sin((1.0 / 50.0) * Math.PI * e[j]);
            g3 = g3 * Math.cos(e[j] / Math.sqrt(((double) (j + 1))));
        }


        f = f1 / ((double) nx);
        g[0] = -50.0 + (1.0 / (100.0 * ((double) nx))) * g1;
        g[1] = (50.0 / ((double) nx)) * g2;
        g[2] = 75.0 - 50.0 * (g1 / 4000.0 - g3 + 1.0);
        
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(new double[]{});
        s.setPhi();
        return s;
    }
    
    
}
