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
public class C04 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C04(int D) {
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
        
        int i, j;
        double f1, g1, g2;
        double[] e = new double[nx];
        double[] o = {-1.9875613370913214e-01, 3.6722150496983446e+00, 1.2790735114549641e+00, 1.4131768195785437e+00, 3.2676366036739672e+00,
            4.1434445442286751e+00, -4.2600689939399530e+00, -2.7284556804990756e+00, 4.9390897068380966e+00, 4.3914313225412407e+00,
            2.5346770773614180e+00, -1.5174090545272465e+00, -7.4302608259027902e-01, 2.3755720552895365e+00, 4.2579064442122281e+00,
            -4.9580612777392021e+00, -1.8324728226480724e+00, 4.0529562235239744e+00, -3.9014373071548079e+00, -2.5952749129152552e+00,
            3.2271473216923834e+00, 1.9581055481509964e+00, -1.4402936383209841e-01, 3.1478369045023200e+00, -2.0525167091724619e+00,
            3.2524016038631594e+00, -1.3983883027683532e+00, -3.4586261799210414e+00, -1.3705499514167032e+00, 2.7772281877887330e+00,
            5.9603282248535194e-01, 2.6904573153485334e+00, 3.1478307977986812e+00, 1.1677384785364779e+00, -4.1765800318347814e+00,
            1.3081270841178769e+00, -4.6185291400528117e+00, -5.6669864991946817e-01, -3.6120787013639379e+00, 1.1133569795384251e+00,
            -2.8599701419518588e+00, 3.2106136999766761e+00, 2.6855022335417580e+00, -3.3151149292675273e+00, 2.5930058416050947e+00,
            3.1273260421290061e+00, 3.3067181171264934e+00, -1.3470204324204338e+00, 3.9157847080462673e+00, -4.8438972329103986e+00,
            -1.3884201321227141e+00, -1.3475939801466708e+00, 7.3825354889323069e-01, 3.5081965925915970e+00, 6.9157275111887984e-01,
            2.1167421682886900e-01, 3.1616092584106230e+00, 1.2483619715847976e+00, -4.0067342002859210e+00, 1.2240400037216892e+00,
            -8.1892202868235753e-01, 5.4999216709556364e-01, 4.7520087447736792e-01, 1.2853147426112912e+00, -4.6760593747617456e+00,
            -2.2202825896814113e+00, 3.9873615494829462e-01, 4.4102978619984707e+00, 3.7407537749150919e+00, -8.8658831334285537e-01,
            7.5293613774513268e-01, -4.3420602584328973e+00, 3.3245987421143450e+00, 5.3436850515086043e-01, 3.9732793088449956e+00,
            1.4553893423079227e+00, 3.4555521089345316e+00, -2.1539277030436823e+00, 4.0830306969815116e+00, -1.9947017361405872e+00,
            4.1955206892412775e+00, -4.2792475972405173e+00, -4.4128554494874406e+00, -3.3452751483803098e+00, 2.1542215705788692e+00,
            3.3103475426723232e+00, 2.0567273509207755e+00, -3.5758166304461669e+00, 4.3030643832035622e+00, -3.2469426550448652e+00,
            -3.1854509269339761e+00, -4.7418274989688172e+00, 6.1128947929466371e-01, 3.2848916120034310e+00, 4.7442601760954766e+00,
            4.7023318698870824e+00, -4.1829803909037988e+00, -2.2291646715936353e+00, -2.3899020618417843e+00, 2.4849747970262781e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        g1 = 0.;
        g2 = 0.;
        for (i = 0; i < nx; i++) {
            f1 = f1 + (Math.pow(e[i], 2) - 10.0 * Math.cos(2.0 * Math.PI * e[i]) + 10.0);
        }
        
        for (i = 0; i < nx; i++) {
            g1 = g1 + (e[i] * Math.sin(2*e[i]));
            g2 = g2 + (e[i] * Math.sin(e[i]));
        }
        f = f1;
        g[0] = g1;
        g[1] = g2;
        /* Set values to individual */
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(new double[]{});
        s.setPhi();
        return s;
    }
    
    
}
