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
public class C06 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C06(int D) {
        super(D);
        upper = new double[D]; 
        lower = new double[D];
        initialize();
    }
    
    private void initialize(){
        for(int i = 0; i < upper.length; i++){
            upper[i] = 20.0;
            lower[i] = -20.0;
        }
        setLowerLimit(lower);
        setUpperLimit(upper);
    }
    

    @Override
    public Solution evaluate(Solution s) {
        double f;
        int nx = getDimension();
        double[] x = Arrays.copyOf(s.getVariables(), nx);
        double[] h = new double[6];
        
        int i, j;
        double f1, h1, h2, h3, h4, h5, h6;
        double[] e = new double[nx];
        double[] o = {-7.4218096405676448e-01, 5.8871535447761083e+00, 6.4970401211688653e+00, 9.1265040965016695e+00, 9.3088830023412896e+00,
            7.0740845473829168e+00, -9.4904144974704625e+00, -4.2844337923736227e+00, -4.2936611692844151e+00, -8.6771807241079895e+00,
            2.6313485891986215e+00, -2.0648468003601828e+00, 6.3828960300161413e+00, -8.0943161875049263e+00, -6.1984187966352362e+00,
            -9.4952105173957086e+00, -9.7988213453160178e+00, -9.7325541817283518e+00, -4.0741697987649044e+00, -7.7434760427132554e+00,
            -8.6578763080075127e-01, 2.3446967490902892e-01, -4.2190024246320057e-01, -4.0204800911513310e+00, -9.3331667964633453e+00,
            5.7395004763094590e+00, 9.1962019867876386e+00, 5.1505644438773963e+00, 4.1234180724587421e+00, -4.1808962703397334e+00,
            3.9238460308311716e+00, 1.7228261736984294e+00, -3.1822622297172281e+00, 1.2960014210892972e+00, -7.8511681682021761e+00,
            9.2028257704699072e+00, 3.3829588401489410e+00, 3.9504334829550363e+00, -7.0061813176998715e+00, -5.9373472331329058e+00,
            1.7877854812709870e-02, 2.5888707959404211e+00, 9.2686464912722393e+00, 9.9756926198728770e+00, -5.0256175018191795e+00,
            2.6062783028405754e+00, -9.5307189765887674e+00, -3.7133544031159449e+00, 5.4863513013242677e+00, 5.4107023641311933e+00,
            3.5341575852668878e+00, -8.6632841868536836e+00, -4.1893412819808518e-02, 4.0921828615790989e+00, -8.4955603873878971e-01,
            4.1388694329300417e+00, 2.4102420793980350e+00, 4.1065946402491900e+00, 3.7634138939154838e+00, 2.8554303002934205e+00,
            -9.2917849464631335e+00, -2.9709705654893570e+00, -5.1219587172619914e+00, -2.1441141001701780e+00, -9.0050677464615614e+00,
            -3.1383180380571680e+00, -3.4660868369446636e+00, -1.1244758044922740e+00, -7.5411331317626988e+00, 5.9539837337039874e+00,
            -3.7536059710079233e+00, 7.8778419550362742e+00, -1.4720615658666087e+00, -2.5524597112924097e+00, 7.8989331698471723e+00,
            8.0609612858174735e+00, -1.3473080579956118e+00, 9.8519877165955130e+00, 2.7087129448504044e-01, 3.9890020798136590e+00,
            2.9742225404269185e-01, -6.2545413727395598e+00, -7.2744215231641789e+00, -9.1977267038642729e-01, 4.6243627608351208e+00,
            -2.7436727850044074e+00, 9.7753092910296502e+00, 9.0855031749813442e+00, 5.2800946340294193e+00, 5.8050893559267180e-02,
            6.6927336251450065e+00, -5.7564291341459235e+00, 8.9298536287212045e+00, 7.5407225031812359e+00, -1.8851528894817378e+00,
            -1.2588273451468996e+00, -9.1646915801629412e+00, 6.4052607820663923e+00, -2.4848872470739858e+00, 4.6423064059740824e+00};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        h2 = 0.;
        h3 = 0.;
        h4 = 0.;
        h5 = 0.;
        h6 = 0.;
        for (i = 0; i < nx; i++) {
            f1 = f1 + (Math.pow(e[i], 2) - 10.0 * Math.cos(2.0 * Math.PI * e[i]) + 10.0);
        }
        
        for (i = 0; i < nx; i++) {
            h1 = h1 + (e[i] * Math.sin(e[i]));// - Sigma
            h2 = h2 + (e[i] * Math.sin(Math.PI * e[i]));
            h3 = h3 + (e[i] * Math.cos(e[i]));// - Sigma
            h4 = h4 + (e[i] * Math.cos(Math.PI * e[i]));
            h5 = h5 + (e[i] * Math.sin(2 * Math.sqrt(Math.abs(e[i]))));
            h6 = h6 + (e[i] * Math.sin(2 * Math.sqrt(Math.abs(e[i])))); // - Sigma
        }
        f = f1;
        h[0] = -h1;
        h[1] = h2;
        h[2] = -h3;
        h[3] = h4;
        h[4] = h5;
        h[5] = -h6;
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(new double[]{});
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}