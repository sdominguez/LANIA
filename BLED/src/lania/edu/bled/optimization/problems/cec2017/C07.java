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
public class C07 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C07(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 50.0;
            lower[i] = -50.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] h = new double[2];
        
        int i, j;
        double f1, h1, h2;
        double[] e = new double[nx];
        double[] o = {2.0517059911673226e+00, 6.6118984993132948e+00, 8.0323961861703097e-02, -6.5041294022016549e+00, -5.6874396244233889e+00,
            2.0286207470664497e+00, 7.8521371630941914e+00, -9.1666421355611263e+00, 1.5834697709377643e+00, 5.6079180935096300e+00,
            -2.8344654601274026e+00, -3.0291943227622582e+00, 2.0927579018795068e+00, 6.2570465203464458e+00, -5.1295335098169996e+00,
            -2.2933093534680378e+00, -9.6418045864466073e-01, 5.3547800497643454e+00, 4.0494600952403204e-01, 3.3934405847515592e-01,
            -2.5127771928598470e+00, 9.6275648195609982e+00, -2.7702863536374345e+00, -8.6264750271322868e+00, 6.4682809210414440e+00,
            -2.0660264549368872e+00, 8.8465659977379545e+00, 4.1522612891791777e+00, 5.3431268054473229e+00, -6.6322278473459857e+00,
            -9.6099328867840796e+00, 3.2705019025630477e-01, 5.3203883679754487e+00, -8.5341762586969026e+00, 6.7253605250316753e+00,
            -4.7392254725120919e+00, -5.1064829338779578e+00, -3.5514371047947169e+00, 2.2207056589973568e+00, 2.2609275639313644e+00,
            5.8202154461021127e+00, 9.2758421073560982e-01, -2.0969183322649920e+00, 8.9118296714778040e+00, 8.9343210979078727e+00,
            -1.6000057603596947e+00, -3.8549233222812802e+00, -2.8594217997049043e-01, 4.4987304912593125e+00, -6.4628482041434721e+00, 
            3.1452326767256107e+00, 6.6729140113460943e+00, -4.1778451982504627e+00, -8.8276068634708000e+00, 2.7999418912381575e+00,
            6.0302153763838255e+00, -5.4879500978690832e+00, 4.2572314594639664e+00, -3.7497353417382406e+00, 7.5796853653270375e+00,
            -2.6335688986711681e-01, -1.6224182848892710e-01, -9.8020346712212145e+00, -3.9566442668106871e+00, 3.5893522503777611e+00,
            5.9681205769476620e+00, 2.6157450670400095e-01, 4.2427332858876188e+00, 1.8814218732616403e+00, -6.3901989727008512e-01,
            4.7346087696815680e+00, 7.0316284560177955e-01, 6.3460874674382737e+00, 7.7374262031347243e+00, 8.2324960772112306e+00,
            -6.5922051561611834e+00, 4.2899914606705387e+00, 7.6996764356251113e+00, 9.4617645189730837e+00, 1.4605665148908642e+00, 
            2.9567984680995565e+00, -5.1663469345641744e-01, 7.0101639911033580e+00, -7.6733632929116435e+00, -3.3526362459544874e+00,
            3.1313353324868345e+00, -3.6888066837874289e+00, 7.2591908843533339e+00, -7.8626287126539101e+00, 5.0355177628235168e+00, 
            -8.0524243547919561e+00, 3.1884061719744423e+00, 2.2452589892395931e+00, 7.2647371151650617e+00, 5.4575374303683368e+00,
            -5.7057364473661991e+00, 1.9082723158601986e+00, -1.6692018365784449e+00, 1.0210991158477256e+00, -2.0575774649005112e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        h2 = 0.;
        for (i = 0; i < nx; i++) {
            f1 = f1 + (e[i] * Math.sin(e[i]));
        }
        
        for (i = 0; i < nx; i++) {
            h1 = h1 + (e[i] - 100 * Math.cos(0.5 * e[i]) + 100);
            h2 = h2 + (e[i] - 100 * Math.cos(0.5 * e[i]) + 100);
        }
        f = f1;
        h[0] = h1;
        h[1] = -h2;
        /* Set values to individual */
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}