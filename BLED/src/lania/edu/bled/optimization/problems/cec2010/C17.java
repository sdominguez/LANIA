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
public class C17 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C17(int D) {
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
        double[] h = new double[1];
        int j;
        double f1, h1, g1, g2;
        double[] e = new double[nx];
        double[] o = {-0.628245703945122, 0.331024455127249, 0.402617203423807, 0.462742527496583, -0.513329779137884, 0.288191632492259, 0.41479349370103, 0.916196063289011, -0.427742767473712, 0.811971694633694, -0.202953396286476, 0.786617208861492, -0.583805982901842, 0.91666360939369, -0.602135912772221, 0.503807046950863, -0.196264987447976, -0.565579687152807, 0.540878947793462, 0.183666358669345, -0.303576255198908, -0.896405440407756, -0.101939801890135, -0.049819872322279, 0.434240825173134, 0.946552963504364, -0.32578927683003, -0.154255792477949, 0.577967633549953, -0.573697797217518};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        g1 = 1.;
        g2 = 0.;

        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + Math.pow((e[j] - e[j + 1]), 2);
        }

        for (j = 0; j < nx; j++) {
            h1 = h1 + e[j] * Math.sin(4.0 * Math.sqrt(Math.abs(e[j])));
            g1 = g1 * e[j];
            g2 = g2 + e[j];
        }

        f = f1;
        h[0] = h1;
        g[0] = g1;
        g[1] = g2;
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
