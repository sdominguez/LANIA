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

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;


public class WeldedBeam extends ConstrainedProblem{
    
    
    public WeldedBeam () {
        super(4);
        initialize();
    }
    
    private void initialize(){
        setLowerLimit(new double []{0.1,0.1,0.1,0.1});
        setUpperLimit(new double []{2.0,10.0,10.0,2.0});
    }
    

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = new double[nx];
        System.arraycopy(s.getVariables(), 0, x, 0, nx);
        
        double f1, f2, f3, g1, g2, g3, g4, g5, g6,g7;
        double Taox, R, Taoprimax, Taobiprimax;
        double M, J, zigma, delta, Pc;
        double E = 30e6;
        double G = 12e6;
        
       
        /* objective function */
        f = 1.10471*Math.pow(x[0], 2)*x[1]+0.04811*x[2]*x[3]*(14.0+x[1]);
       
        R = Math.sqrt((Math.pow(x[1], 2)/4.0)+(Math.pow((x[0]+x[2])/2.0, 2)));
        M = (6000.0)*(14.0 + (x[1]/2.0));
        J = 2.0*(x[0]*x[1]*Math.sqrt(2.0)*((Math.pow(x[1], 2)/12.0)+(Math.pow(((x[0]+x[2])/2.0), 2))));
        Taoprimax = 6000.0/((Math.sqrt(2.0))*x[0]*x[1]);
        Taobiprimax = (M*R)/J;
        Taox = Math.sqrt((Math.pow(Taoprimax, 2)+ ((2.0*Taoprimax*Taobiprimax)*((x[1]/(2.0*R))))+Math.pow(Taobiprimax, 2)));
        zigma = 504000.0/(x[3]*(x[2]*x[2]));
        delta = 65856000.0/(E*x[3]*(Math.pow(x[2],3)));
        f1 = 0.10471*((x[0])*(x[0]));
        f2 = 0.04811*((x[2])*(x[3]));
        f3 = (14.0+x[1]);
        Pc = ((4.013*E*(Math.sqrt((Math.pow(x[2], 2)*(Math.pow(x[3],6)))/36.0)))/196.0)*(1.0-(x[2]*Math.sqrt(E/(4.0*G)))/28.0);
        
        g1 = Taox -(13600.0);
        g2 = zigma - 30000.0;
        g3 = x[0]-x[3];
        g4 = f1+(f2*f3)-5.0;
        g5 = 0.125-x[0];
        g6 = delta - 0.25;        
        g7 = 6000.0 - Pc;
        
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double []{g1,g2,g3,g4,g5,g6,g7});
        s.setH(new double[]{});
        s.setPhi();
        return s;
        
    }
   
}



