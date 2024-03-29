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
public class C08 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C08(int D) {
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
        double[] h = new double[2];
        
        int i, j;
        double f1, h1, h2;
        double[] e = new double[nx];
        double[] o = {-2.6111672849272889e+00, 7.0949687738120950e+00, 6.8683166123716823e+00, -9.6331753266457447e+00, -7.5511893987970975e+00,
            8.9946373736446326e+00, -9.3598480794394057e+00, -8.2369933600304979e+00, -6.5814425143948245e+00, 9.8645884077631223e+00,
            -1.6972783755492777e+00, -2.5544678701398738e+00, -3.1411702645394683e+00, -6.6595297212895588e-02, 6.7378636941501924e-02,
            9.5088121438153195e+00, -3.2940619232073365e+00, -6.0803559625148900e+00, -8.1721774539038865e+00, -8.0872470005228863e+00,
            -2.3064289005035254e+00, 7.0616927476605795e-01, 8.4883375177267979e+00, -5.5294039728049942e+00, -4.4903603773041656e+00,
            -5.1915386890621722e+00, -5.3336547209781315e-01, 9.9341703140459359e-01, 3.0070374023246949e+00, -4.6490754153542602e+00,
            -6.6146771432040481e+00, 1.4835281161568314e+00, -3.3261367718976604e+00, -2.2512502161247028e+00, 1.8574350980556513e+00,
            -6.7628687456461956e+00, 9.0957236292475052e-01, 3.9871623113736394e+00, 8.9364443584291031e-01, -3.4791128036675918e+00,
            -8.6411307995864828e+00, -4.1077035505327464e+00, -5.0816735809483049e+00, 1.3067268961978264e+00, 9.2894686110240023e+00, 
            7.6632992682037617e+00, -4.5270117810179800e+00, -6.1914886301649119e-01, -4.2145776855064536e+00, 3.7855845054879733e+00,
            -1.6687651923321116e+00, 9.8992098918559037e+00, 4.2513588616595435e+00, 7.7491624085523725e-01, -1.5497107914141885e+00,
            -4.7249423787464551e-01, -8.1602690825499398e+00, -5.8132170637172553e+00, 9.0188658602012772e+00, 6.8043348120492766e+00,
            -6.1734131563193433e+00, -7.4707996836899682e-01, 5.6932996524650008e+00, -8.5471269056408481e+00, -4.9018543504126892e+00,
            -2.9246790171161630e+00, 5.2190932372956667e+00, 2.9764650781409827e+00, -4.5883194989800185e+00, 5.8824193145546655e+00,
            8.1715627392792634e+00, 4.6543411017005134e+00, -7.9298815113188130e+00, 3.9954795681047024e+00, 1.6297666285754353e+00,
            -8.4581055597062900e+00, -1.1064042592973813e+00, -7.9159032763118802e+00, 4.9807275488366010e-01, -4.5176002001539111e+00,
            -9.9818204301137214e-01, -8.1839441686389449e+00, 7.4892279360125436e+00, -1.2552379822793487e+00, 5.6621414887564221e+00,
            -3.7618379625863207e+00, 2.7106056825746006e+00, -5.7406645274789225e+00, -5.0238498739090502e+00, 7.3402915411181091e-01,
            -2.1319436666614067e-02, 5.9878193117470939e+00, 9.5087311670273031e+00, -4.4595141108392173e+00, -5.1395076316646122e+00,
            8.6834216833553768e-01, -7.6416085591746814e+00, 3.8227607875222418e+00, -9.4080814012529661e+00, -1.0507486909093515e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        h1 = 0.;
        h2 = 0.;
        f1 = e[0];
        
        for (i = 0; i < nx; i++) {
            f1 = (f1 < e[i] ) ? e[i] : f1;
        }
        
        for ( i = 1; i < nx/2+1; i++) {
            double y = 0.;
            for ( j = 0; j < i; j++) {
                y += e[2*j];
            }
            h1 = Math.pow(y, 2);
        }
        
        for ( i = 1; i < nx/2+1; i++) {
            double w = 0.;
            for ( j = 0; j < i; j++) {
                w += e[2*j+1];
            }
            h2 = Math.pow(w, 2);
        }
        
        f = f1;
        h[0] = h1;
        h[1] = h2;
        /* Set values to individual */
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}