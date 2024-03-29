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
public class C09 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C09(int D) {
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
        double[] h = new double[1];
        double[] g = new double[1];
        
        int i, j;
        double f1, h1, g1;
        double[] e = new double[nx];
        double[] o = {-5.0984117751861930e+00, -9.0334592188583311e+00, -4.1182740986456823e+00, -9.3908282507980285e+00, 5.7655127443194321e+00,
            8.4360876985989570e+00, -7.4970817774654774e+00, 2.9309661352721683e+00, -3.0489389403576439e-01, 4.4800198454075346e+00,
            -9.2730183711063212e+00, -2.6338076393056724e+00, 4.6086322353641780e+00, 7.6327863879135194e+00, 4.7534876795661560e+00,
            -1.3354462989474776e+00, 2.4728876429966640e+00, -4.0656603676733898e+00, 3.1702307388941460e+00, -8.7859949953771945e+00,
            7.1332256533024641e+00, -2.2298917664094375e-01, -6.1662761665792516e+00, 6.3868177508430932e+00, -8.7351633674293332e+00,
            4.3243213324659884e+00, -1.2377511971534823e+00, 2.2737104412161262e+00, 4.8930534740616345e+00, 4.1860875964009541e+00,
            -5.6978633559693037e-01, -6.7622922389640783e+00, -3.9165727277638958e+00, 6.7587811332854244e+00, 8.6727060901913404e+00,
            8.6692348945669977e+00, -9.9407163938214893e+00, -1.1212022286916756e+00, -9.7322332847788111e+00, -5.5301099173561497e+00,
            5.6119220305886248e+00, 9.2876103473383154e-01, -4.0870708862835965e+00, 1.0829202349754379e+00, -4.2208704279968856e-01,
            5.4743133950332741e+00, -4.6875665975731584e+00, -3.2803231468185938e+00, 6.9014357708575496e+00, -9.7682074931126177e+00,
            -9.2194926698297763e+00, -5.6384048688477728e+00, -8.7765285054893294e+00, 7.6492534751206129e+00, 3.0561100949018005e+00,
            -7.6468644284144478e+00, -5.1783185675239967e+00, -5.4736924442415997e+00, 3.0641611382053586e+00, -6.0627616627093133e+00,
            -3.6882619758825097e+00, -6.0213850744541553e-01, 1.9033470390878744e+00, 7.2320660770367127e+00, -7.9653934568917251e+00,
            -2.2848609367586743e+00, 9.5513796307111285e+00, -8.5403155596187652e-01, -8.3457519198487873e+00, -3.5133739912935962e+00,
            3.3030221615285988e+00, -8.0885074787685856e+00, 3.5316664493696788e+00, 1.5032428190129572e+00, -9.7471584254691575e+00,
            1.2497661335995769e+00, -3.6532729955317578e+00, 2.9541875594634153e+00, 4.7967341306767146e+00, 9.4497521613773685e+00,
            -5.2625085366465107e-01, -8.0771141861076146e+00, -5.5908761498346244e+00, 7.1360226085257423e+00, -5.0243233959984712e+00,
            -2.7562054531873681e+00, -5.3549173910450598e+00, -6.6716943326639289e-01, 1.3496547201616202e+00, -4.7016843909225408e+00,
            -2.8036534430159676e+00, -8.9989776472455514e+00, 4.7600681960536644e+00, 9.2711385545317597e+00, -3.6464640735812459e-01,
            -3.5601010157292663e+00, -5.2126997018486376e+00, -3.7505144049014838e-01, -2.1200034874835616e+00, -6.5912966328328011e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        h1 = 0.;
        g1 = 1.;
        f1 = e[0];
        
        for (i = 0; i < nx; i++) {
            f1 = (f1 < e[i] ) ? e[i] : f1;
        }
        
        for ( i = 1; i < nx/2; i++) {
            h1 += Math.pow((Math.pow(e[2*i], 2) - e[2*i+1]), 2);
        }
        
        for ( i = 1; i < nx/2+1; i++) {
            g1 *= e[2*i-1];
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