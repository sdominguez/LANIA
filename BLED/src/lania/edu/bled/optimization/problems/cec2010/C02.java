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
public class C02 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C02(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 5.12;
            lower[i] = -5.12;
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
        double f1, g1, g2, h1;
        double[] e = new double[nx];
        double PI = 4.0 * Math.atan(1.0);
        double[] o = {-0.066939099286697, 0.470966419894494, -0.490528349401176, -0.312203454689423, -0.124759576300523, -0.247823908806285, -0.448077079941866, 0.326494954650117, 0.493435908752668, 0.061699778818925, -0.30251101183711, -0.274045146932175, -0.432969960330318, 0.062239193145781, -0.188163731545079, -0.100709842052095, -0.333528971180922, -0.496627672944882, -0.288650116941944, 0.435648113198148, -0.348261107144255, 0.456550427329479, -0.286843419772511, 0.145639015401174, -0.038656025783381, 0.333291935226012, -0.293687524888766, -0.347859473554797, -0.089300971656411, 0.142027393193559};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = e[0];
        g1 = 0.;
        g2 = 0.;
        h1 = 0.;
        for (j = 0; j < nx; j++) {
            if (e[j] > f1) {
                f1 = e[j];
            }
            g1 = g1 + (e[j] * e[j] - 10.0 * Math.cos(2 * PI * e[j]) + 10.0);
            g2 = g2 + (e[j] * e[j] - 10.0 * Math.cos(2 * PI * e[j]) + 10.0);
            h1 = h1 + ((e[j] - 0.5) * (e[j] - 0.5) - 10 * Math.cos(2 * PI * (e[j] - 0.5)) + 10.0);
        }
        f = f1;
        g[0] = 10.0 - g1 / ((double) nx);
        g[1] = -15.0 + g2 / ((double) nx);
        h[0] = -20.0 + h1 / ((double) nx);
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}
