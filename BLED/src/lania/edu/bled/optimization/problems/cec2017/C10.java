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
public class C10 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C10(int D) {
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
        double f1, h1, h2, h3;
        double[] e = new double[nx];
        double[] o = {3.1472368639317892e+01, 4.0579193707561927e+01, -3.7301318370649398e+01, 4.1337585613901936e+01, 1.3235924622540949e+01,
            -4.0245959500059044e+01, -2.2150178113295162e+01, 4.6881519204983846e+00, 4.5750683543429759e+01, 4.6488853519927659e+01,
            -3.4238691832245173e+01, 4.7059278176061568e+01, 4.5716694824294564e+01, -1.4624351277158780e+00, 3.0028046888880013e+01,
            -3.5811366137278469e+01, -7.8238717373724995e+00, 4.1573552518906709e+01, 2.9220732955955441e+01, 4.5949242639290304e+01,
            1.5574069915658683e+01, -4.6428832142581044e+01, 3.4912930586877707e+01, 4.3399324775755048e+01, 1.7873515485777347e+01,
            2.5774013057833344e+01, 2.4313246812491613e+01, -1.0777298046583184e+01, 1.5547789017755662e+01, -3.2881331218843826e+01,
            2.0604608801960879e+01, -4.6816715362257931e+01, -2.2307701503911005e+01, -4.5382860936884605e+01, -4.0286821876415246e+01,
            3.2345782832729270e+01, 1.9482862297581704e+01, -1.8290051993913949e+01, 4.5022204883835499e+01, -4.6555391949709126e+01,
            -6.1255640343601740e+00, -1.1844154290699159e+01, 2.6551678814900242e+01, 2.9519990113706314e+01, -3.1312739544562142e+01,
            -1.0235604211768958e+00, -5.4413799289100524e+00, 1.4631301011126467e+01, 2.0936483085807254e+01, 2.5468668198236088e+01,
            -2.2397492300142162e+01, 1.7970267685367475e+01, 1.5509800397384069e+01, -3.3738826480536943e+01, -3.8100231844162337e+01,
            -1.6359480178570607e-01, 4.5974395851608108e+01, -1.5961427333386681e+01, 8.5267750979777333e+00, -2.7618806050886302e+01,
            2.5126705930565279e+01, -2.4490488454073088e+01, 5.9570516651423588e-01, 1.9907672265668594e+01, 3.9090325253579849e+01,
            4.5929142520544431e+01, 4.7215529963803107e+00, -3.6137555717132088e+01, -3.5070599444094256e+01, -2.4249174587626353e+01,
            3.4071725598366257e+01, -2.4571782102846896e+01, 3.1428482606881630e+01, -2.5647503127501071e+01, 4.2926362318722781e+01,
            -1.5001623401519126e+01, -3.0340474956879181e+01, -2.4891614202396894e+01, 1.1604467614663918e+01, -2.6711151097270758e+00,
            -1.4834049293700325e+01, 3.3082862789629090e+01, 8.5264091152724291e+00, 4.9723608291139527e+00, 4.1719366382981008e+01,
            -2.1416098117962644e+01, 2.5720022911072121e+01, 2.5372909427849535e+01, -1.1955415302464331e+01, 6.7821640725221144e+00,
            -4.2414571043693641e+01, -4.4604988133339283e+01, 3.0797553008972685e+00, 2.7916723010201110e+01, 4.3401068422918300e+01, 
            -3.7009379152626991e+01, 6.8823660872192747e+00, -3.0609358941794156e+00, -4.8809793049875857e+01, -1.6287735560111848e+01};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        h1 = 0.;
        h2 = 0.;
        h3 = 0.;
        
        f1 = e[0];
        for (i = 0; i < nx; i++) {
            f1 = (f1 < e[i] ) ? e[i] : f1;
        }
        
        for (i = 1; i < nx + 1; i++) {
            h3 = 0.;
            for (j = 0; j < i; j++) {
                h3 = h3 + e[j];
            }
            h1 = h1 + Math.pow(h3, 2);
        }
        
        for (i = 0; i < (nx-1); i++) {
            h2 = h2 + Math.pow(e[i] - e[i+1], 2);
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