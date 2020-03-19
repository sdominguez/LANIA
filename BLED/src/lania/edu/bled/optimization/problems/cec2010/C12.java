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
public class C12 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C12(int D) {
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
        double[] g = new double[1];
        double[] h = new double[1];
        int j;
        double f1, h1, g1;
        double[] e = new double[nx];
        double[] o = {18.889635068428205, -59.265426383246485, 33.25998466165768, 20.152694275194037, -10.734106238462502, -90.85053128520764, -12.073899411249897, 59.72307696259165, -37.44193247323578, 25.963111555782035, 6.251460324561279, 41.478172862575434, 86.54258849813075, 34.94822787072172, 26.864471649916382, 79.55580868986908, -44.66218241775459, -7.305741544994362, 87.75843366209835, 33.836473236958284, 84.53385936725138, 80.89850629751817, 48.46967726645195, -82.0758049330533, -98.54273249151939, 19.55069746505636, 8.33657824668768, 88.54888769408086, -79.08282398956031, 63.254014133387614};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        g1 = 0.;

        for (j = 0; j < nx; j++) {
            f1 = f1 + e[j] * Math.sin(Math.sqrt(Math.abs(e[j])));
            g1 = g1 + (e[j] - 100.0 * Math.cos(0.1 * e[j]) + 10.0);
        }
        for (j = 0; j < (nx - 1); j++) {
            h1 = h1 + Math.pow((e[j] * e[j] - e[j + 1]), 2);
        }

        f = f1;
        h[0] = h1;
        g[0] = g1;
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
