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

package lania.edu.bled.optimization.problems.cec2017;

import java.util.Arrays;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class C11 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C11(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 100.0;
            lower[i] = -100.0;
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
        double[] g = new double[1];
        
        int i, j;
        double f1, h1, g1;
        double[] e = new double[nx];
        double[] o = {2.1158023930481029e+00, -3.0358197506730944e+00, 5.0592291799549187e+00, -1.5194465269568198e+00, -7.5983435585903418e+00,
            -8.5618634826345712e+00, -8.9223706813762682e+00, -7.7231722604062947e+00, 8.7928251565568658e+00, 7.4961083122678467e+00,
            -6.6082523283913819e+00, -9.4316984277152081e+00, 2.6453884026050609e+00, 1.9292888522282041e+00, -1.1489638057451117e+00,
            -3.0212986833031863e+00, -7.6919869927599782e+00, 1.1377664521597879e+00, -2.6559429017470588e+00, -6.6405120423207737e+00,
            9.8350188709945705e+00, -2.1015844073185042e+00, -1.1527528422484643e+00, 5.5650284687836518e+00, -6.9371179514865844e-01,
            3.7964775422776835e+00, -9.1344876335981056e+00, 7.2603317841043626e+00, -3.2498364985536572e+00, 3.9715392820069084e+00,
            -3.7492821167867874e+00, -6.1156189883861556e+00, 5.5884510786606576e+00, 7.1974336003266934e+00, -5.2591387143993584e+00,
            7.8943949351332598e-01, 4.6244436686310646e+00, 3.1812425441190371e+00, -8.8497774771378879e+00, -1.6980138671421052e+00,
            4.0406928565084339e+00, -2.3333083595058408e+00, -9.6587110345253642e+00, 6.5921725989799675e+00, -7.6817151122972938e+00,
            -9.4023995228401702e-01, 2.4072443969258490e+00, -5.4385774168973589e+00, -2.1552558738652294e+00, -2.9036094053016441e+00,
            -7.4607369271383206e+00, 1.9833405349974065e-01, -9.0267875123850878e+00, 7.6728238594166953e-01, -6.4284518621195037e+00,
            3.9894468090719002e+00, 9.6904941018876976e+00, -2.2381328736013595e+00, 4.3276575257022358e+00, 1.0674981823562320e+00,
            -5.8701139529109847e+00, -8.6265217232319493e+00, 3.0791320030627531e+00, 8.7380613480384035e+00, 9.5637588875693069e-01,
            -8.1564864865282374e+00, 9.9635677507248843e+00, -8.7679326519595300e+00, 4.4412326014256323e+00, -3.7823133811479082e-01,
            -3.2419659163544523e-01, 4.8190369113747025e+00, 6.0302782205909295e+00, 3.3236550970501177e+00, 8.3164013643807415e+00,
            7.3475467219888770e+00, 1.9503360816421900e+00, 8.0455986306801961e+00, 7.4713247935606226e+00, -8.1786934688712272e+00,
            -5.8658561195478898e+00, -8.6708450537968105e+00, -2.3172937059119869e+00, 5.6212843608715595e+00, 4.2193304265946949e+00,
            2.8953870468221687e+00, -9.3690626573218854e+00, 3.4736787927282275e+00, -6.0624456285343875e+00, 6.0411386118149935e-01,
            -1.7619901586989233e+00, -8.6544895994705584e+00, 8.4259260272949916e+00, 9.8686255666130762e-01, 5.5071482601753772e+00,
            -7.3584355847294258e+00, -4.9973572025312247e+00, -1.6383800784248557e+00, -7.0470661516933113e+00, 7.9012033454054773e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        g1 = 1.;
        for (i = 0; i < nx; i++) {
            f1 = f1 + e[i];
        }
        
        for (i = 0; i < nx; i++) {
            g1 = g1 * e[i];
        }
        
        for (i = 0; i < (nx - 1); i++) {
            h1 = h1 + Math.pow((e[i] - e[i+1]), 2);
        }
        f = f1;
        h[0] = h1;
        g[0] = g1;
        /* Set values to individual */
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}