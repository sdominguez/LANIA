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

import static java.lang.Math.*;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;


public class SpeedReducer extends ConstrainedProblem{
    
    public SpeedReducer () {
        super(7);
        initialize();
    }
    
    private void initialize(){
        setLowerLimit(new double []{2.6, 0.7, 17.0, 7.3, 7.8, 2.9, 5.0});
        setUpperLimit(new double []{3.6, 0.8, 28.0, 8.3, 8.3, 3.9, 5.5});
    }
    

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = new double[nx];
        System.arraycopy(s.getVariables(), 0, x, 0, nx);
        
        double g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11;
        
        /* objective function */
        
        f = 0.7854*x[0]*pow(x[1], 2)
                *(3.3333*pow(x[2], 2) + 14.9334*x[2]-43.0934)
                -1.508*x[0]*(pow(x[5], 2)+pow(x[6], 2))
                +7.4777*(pow(x[5], 3)+pow(x[6], 3)) 
                + 0.7854*(x[3]*pow(x[5], 2)+x[4]*pow(x[6], 2));
        
        double oper1 = pow(((745.0*x[3])/(x[1]*x[2])),2);
        double oper2 = pow(((745.0*x[4])/(x[1]*x[2])),2);
        double E1 = 16.9e6;
        double E2 = 157.5e6;
        
        /* restricciones */
        g1 = (27.0/(x[0]*pow(x[1], 2)*x[2]))-1.0;
        g2 = (397.5/(x[0]*pow(x[1], 2)*pow(x[2], 2)))-1.0;
        g3 = ((1.93*pow(x[3], 3))/(x[1]*x[2]*pow(x[5], 4)))-1.0;
        g4 = ((1.93*pow(x[4], 3))/(x[1]*x[2]*pow(x[6], 4)))-1.0;
        g5 = ((1.0/(110.0*pow(x[5], 3)))*sqrt(oper1+E1))-1.0;
        g6 = ((1.0/(85.0*pow(x[6], 3)))*sqrt(oper2+E2))-1.0;
        g7 = ((x[1]*x[2])/40.0)-1.0;
        g8 = ((5.0*x[1])/x[0])-1.0;
        g9 = (x[0]/(12.0*x[1]))-1.0;
        g10 = ((1.5*x[5]+1.9)/x[3])-1.0;
        g11 = ((1.1*x[6]+1.9)/x[4])-1.0;
        
        
        
       
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double []{g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11});
        s.setH(new double[]{});
        s.setPhi();
        return s;
    }
    
    
}

