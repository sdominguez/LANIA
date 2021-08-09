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
        double[] g = new double[1];
        double[] h = new double[1];
        
        int i, j;
        double f1, f2, g1, h1;
        double[] e = new double[nx];
        double[] o = {-1.3370743549517741e+01, -1.6215938463791204e+01, 1.3123420629821915e+01, -3.0141746856739893e+01, -4.8002209616370074e+01,
            -2.5388350918259093e+00, 4.3566253954486925e+01, -2.1467822373227762e+01, -5.9389758712399896e+00, -1.5176694241742616e+01,
            3.6869795527887092e+01, 5.6173065441684855e+00, 2.7877139388605798e+01, -2.2119681979082571e+01, 4.8201046451838678e+01,
            1.0472049646344203e+01, 1.0532795721779578e+01, 3.3325559884207351e+01, -2.8553971029976488e+01, -1.7884161794843813e+01,
            4.4113159455002020e+01, 3.1904504224096925e+01, 4.3922672354153860e+01, 3.5303409524722696e+01, 4.6866396384579062e+01,
            1.5180373006944308e+01, 4.3270166334905795e+01, 3.8878498078841844e+01, 4.7565704929629149e+01, -4.0544255955895281e+01,
            1.4987223393634324e+01, -1.4557599051099210e+01, 3.4585493872018418e+01, 1.7991809337147259e+01, 1.6457667883332277e+01,
            -1.9590351644958304e+01, 4.1204956296381880e+01, 3.7996357918651796e+01, 1.2518395254071599e+01, 6.3400019395199081e-01,
            2.2236359654004190e+00, 4.3062332796694903e+01, 1.9824054113823593e+00, -1.8460395873734882e+01, -9.6785463376412011e+00,
            3.6788952053842607e+01, -4.2668511214418672e+01, 9.8977739315745268e+00, -1.9377485627161594e+01, -3.4947141811943439e+01,
            -1.4461131986247885e+01, -3.5621289538960234e+01, -2.2917200842462719e+00, 3.0619001823689658e+01, -1.4476642365665136e+01,
            -8.1669298777787702e+00, -8.3525328402748968e+00, -2.3160635966887209e+01, -4.5218132124009600e+01, 2.6124371348946767e+01,
            4.2760745129050179e+01, 3.2856769426380410e+00, -4.4992860123566373e+01, -1.9959603730226227e+01, -1.9009598026212004e+01,
            -1.4342983025265866e+01, -4.3319288812722164e+01, -2.8071034147035601e+01, 3.4850521806641041e+01, 5.6268353168164680e+00,
            2.0269808224779567e+01, -1.9086277266214680e+00, -1.3182714560431698e+01, -4.9961748155163995e+01, -2.5489082575863364e+01,
            3.3455897131708383e+01, -1.8203184819208307e+01, -4.0580348452092466e+01, 4.5184166804121574e+01, -2.3029165996838941e+01,
            4.1430622569213838e+01, 1.2568455849305529e+01, 2.9452610558496886e+01, -1.0822902992534011e+01, -8.9013503218190664e+00,
            -1.4929829726831493e+01, 1.2299349765182136e+01, -3.2855302828004270e+01, -7.0885285628922574e+00, -2.5120846369284354e+01,
            2.5002925236691652e+01, 1.6063066766375670e+01, 1.5099996489050454e+01, 2.1319849042385684e+01, -4.7925823180205285e+01,
            -4.4247219064149199e+01, -2.6142364186830648e+01, 1.0577379566464138e+01, 1.1434642901011337e+01, -3.7359310687758438e+01};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        g1 = 0.;
        h1 = 0.;
        for (i = 1; i <= nx; i++) {
            f2 = 0.;
            for (j = 0; j < i; j++) {
                f2 += e[j];
            }
            f1 = Math.pow(f2, 2);
        }
        for (i = 0; i < nx; i++) {
            g1 = g1 + (Math.pow(e[i], 2) - 5000 * Math.cos(0.1*Math.PI*e[i]) - 4000);
            h1 = h1 + (e[i] * Math.sin(0.1 * Math.PI * e[i]));
        }
        f = f1;
        g[0] = g1;
        h[0] = h1;
        /* Set values to individual */
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}