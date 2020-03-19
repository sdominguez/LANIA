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
public class C16 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C16(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 10.0;
            lower[i] = -10.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    
    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] g = new double[2];
        double[] h = new double[2];
        
        int j;
        double f1, f2, g1, g2, h1, h2;
        double[] e = new double[nx];
        double PI = 4.0 * Math.atan(1.0);
        double[] o = {0.365972807627352, 0.429881383400138, -0.420917679577772, 0.984265986788929, 0.324792771198785, 0.463737106835568, 0.989554882052943, 0.307453878359996, 0.625094764380575, -0.358589007202526, 0.24624504504104, -0.96149609569083, -0.184146201911073, -0.030609388103067, 0.13366054512765, 0.450280168292005, -0.662063233352676, 0.720384516339946, 0.518473305175091, -0.969074121149791, -0.221655317677079, 0.327361832246864, -0.695097713581401, -0.671724285177815, -0.534907819936839, -0.003991036739113, 0.486452090756303, -0.689962754053575, -0.138437260109118, -0.626943354458217};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }
        /* objective function */
        f1 = 0.;
        f2 = 1.;
        g2 = 1.;
        g1 = 0.;
        h1 = 0.;
        h2 = 0.;

        for (j = 0; j < nx; j++) {
            f1 = f1 + e[j] * e[j];
            f2 = f2 * Math.cos(e[j] / Math.sqrt(((double) (j + 1))));
            g1 = g1 + (e[j] * e[j] - 100 * Math.cos(PI * e[j]) + 10);
            g2 = g2 * e[j];
            h1 = h1 - e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
            h2 = h2 + e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
        }

        f = f1 / 4000.0 - f2 + 1.0;
        g[0] = g1;
        g[1] = g2;
        h[0] = h1;
        h[1] = h2;
        
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
