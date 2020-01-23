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

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class C01 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C01(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 10;
            lower[i] = 0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = new double[nx];
        double[] g = new double[2];
        double[] h = new double[2];
        System.arraycopy(s.getVariables(), 0, x, 0, nx);
        
        int j;
        double f1, f2, f3, g1, g2;
        double[] e = new double[nx];
        double[] o = {0.030858718087483, -0.078632292353156, 0.048651146638038, -0.069089831066354, 
                      -0.087918542941928, 0.088982639811141, 0.074143235639847, -0.086527593580149, 
                      -0.020616531903907, 0.055586106499231, 0.059285954883598, -0.040671485554685, 
                      -0.087399911887693, -0.01842585125741, -0.005184912793062, -0.039892037937026, 
                      0.036509229387458, 0.026046414854433, -0.067133862936029, 0.082780189144943, 
                      -0.049336722577062, 0.018503188080959, 0.051610619131255, 0.018613117768432, 
                      0.093448598181657, -0.071208840780873, -0.036535677894572, -0.03126128526933, 
                      0.099243805247963, 0.053872445945574};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        f2 = 1.;
        f3 = 0.;
        g1 = 1.;
        g2 = 0.;
        for (j = 0; j < nx; j++) {
            f1 = f1 + Math.pow(Math.cos(e[j]), 4);
            f2 = f2 * Math.cos(e[j]) * Math.cos(e[j]);
            f3 = f3 + ((double) (j + 1)) * e[j] * e[j];
            g1 = g1 * e[j];
            g2 = g2 + e[j];
        }
        f = Math.abs((f1 - 2 * f2) / Math.sqrt(f3));
        f = -f;
        g[0] = 0.75 - g1;
        g[1] = g2 - 7.5 * ((double) nx);
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
