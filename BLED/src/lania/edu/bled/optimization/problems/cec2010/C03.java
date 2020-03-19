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
public class C03 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C03(int D) {
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
        double[] h = new double[1];
        
        int j;
        double f1, h1;
        double[] e = new double[nx];
        double[] o = {111.17633500088529, 92.07880492633424, 417.9818592609036, 253.16188128024302, 363.5279986597767, 314.334093889305, 187.32739056163342, 240.4363027535162, 422.60090880560665, 327.63042902581515, 62.04762897064405, 25.435663968682125, 360.56773191905114, 154.9226721156832, 33.161292034425806, 177.8091733067186, 262.58198940407755, 436.9800562237075, 476.6400624069227, 331.2167787340325, 75.205948242522, 484.33624811710115, 258.4696246506982, 419.8919566566751, 357.51468895930395, 166.3771729386268, 47.59455935830133, 188.20606700809785, 184.7964918401363, 267.9201349178807};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }
        /* objective function */
        f1 = 0.;
        h1 = 0.;
        for (j = 0; j < (nx - 1); j++) {
            f1 = f1 + (100.0 * Math.pow((e[j] * e[j] - e[j + 1]), 2) + Math.pow((e[j] - 1.0), 2));
            h1 = h1 + Math.pow((e[j] - e[j + 1]), 2);
        }
        f = f1;
        h[0] = h1;

        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
    
}
