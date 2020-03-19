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
package lania.edu.bled.optimization.problems.engineering;

/**
 *
 * @author sdominguez
 */

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import java.util.Arrays;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;


public class PressureVessel extends ConstrainedProblem{
    
    double m;
    
    private double[] upper, lower;
    
    public PressureVessel () {
        super(4);
        initialize();
    }
    
    private void initialize(){
        m = 0.0625;
        upper = new double[]{99.0*m, 99.0*m, 200.0, 200.0};
        lower = new double[]{1.0*m, 1.0*m, 10.0, 10.0};
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    
    
    public Solution evaluate(Solution s) {
        double f;
        int d = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), d);
        double g1, g2, g3, g4;
        double h1, h2;

        /* objective function */        
        f = (0.6224*x[0]*x[2]*x[3])+
            (1.7781*x[1]*pow(x[2],2))+
            (3.1661*pow(x[0], 2)*x[3])+
            (19.84*pow(x[0], 2)*x[2]);
        
        /* subject to */
        g1 = -x[0]+0.01930*x[2];
        g2 = -x[1]+0.00954*x[2];
        //g3 = -PI*pow(x[2], 2)*pow(x[3], 2)-
        //        (4.0/3.0)*PI*pow(x[2], 3)+
        //        1296000.0;
        g3 = -PI*pow(x[2], 2)*x[3]-
                (4.0/3.0)*PI*pow(x[2], 3)+
                1296000.0;
        g4 = x[3]-240.0;
        
        h1 = 0;//x[0]%m;
        h2 = 0;//x[1]%m;

       
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{g1, g2, g3, g4});
        s.setH(new double[]{h1, h2});
        s.setPhi();
        return s;
    }
    
}

