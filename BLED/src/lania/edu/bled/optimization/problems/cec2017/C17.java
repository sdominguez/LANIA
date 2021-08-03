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
public class C17 extends ConstrainedProblem{
    
    private double[] upper, lower;
    
    public C17(int D) {
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
        double f1, f2, f3, g1, h1;
        double[] e = new double[nx];
        double[] o = {-2.8572876762843592e+01, -1.6020692917610326e+01, -3.4267350135311162e+01, -4.5818112100198249e+01, -1.8079781146775243e+01,
            2.5725679048043332e+01, 2.4716563914686589e+01, 1.1215719489129484e+01, -1.2136617112504744e+01, -9.1550666086484256e-01,
            2.3405309685666367e+01, -3.1464706528498521e+01, -9.0662994890768900e+00, 5.7350146310247183e+00, 1.5684166985022358e+01,
            -2.1582473506193789e+01, -4.3370231388367621e+01, 3.3536321750831348e+00, 3.1145333372275815e+01, -2.9903950910062715e+01,
            2.5432689218671413e+01, -1.8673929717145011e+01, 1.9749230950200896e+01, -2.4427524021542226e+01, 3.0311237701994003e+01,
            7.0764206126549212e+00, -1.2416416702879438e+01, 3.1724833079820385e+01, -3.5954704233854685e+01, -3.4300512149773809e+01,
            -5.9501902906060025e+00, 4.1633903368265251e+01, 1.7880178744710136e+01, 3.6479735089184686e+00, 1.0705988044477330e+01,
            3.4177601670123309e+01, 2.3693053658446743e+01, 2.4645091633135380e+01, 3.4380647111988964e+01, -3.6113746587886219e+01,
            2.8479536099789854e+01, -2.8437285416851736e+00, 2.8299856687594684e+01, 2.1010323185159891e+01, 1.8454631264885109e+00,
            1.5163578553120118e+01, -5.4687217332684668e+00, 3.9686700656645954e+01, 1.1713552353181925e+01, -4.9411074064536145e+01,
            2.0735096200077010e+01, 4.8026376241182760e+01, -4.2797551152511929e+01, -2.6788215696783968e+01, 2.6485761855232326e+01,
            3.0412375264745478e+01, 3.7742664518085419e+01, -4.6263940651260718e+01, -1.8394561484651462e+01, -2.2684091534533600e+01,
            3.7519052419027616e+01, 7.8555361515249800e+00, 1.9268122804472299e+01, -4.2025610855963201e+01, 4.8963074725286219e+01,
            2.4612810952743516e+01, 4.0580184957725933e+01, 4.4023668523295484e+01, -4.5318799810687793e+01, -1.2550216143748003e+01,
            1.3795953243048906e+01, -2.5604253017425620e+00, -4.0837884746803496e+01, -3.0298821975606955e+00, 2.5906180783597620e+01,
            -2.9640447098043065e+01, -2.0365609406782902e+01, -1.0325012084775423e+01, 4.5273418211673359e+01, -9.8401862971604999e+00,
            -1.1111510188972318e+01, -1.8236456377927990e+01, -4.8790684200485124e+01, -3.2308551080178148e+01, 4.9064789560759863e+01,
            -9.4654119902478726e+00, -1.7026296952973588e+01, 4.8444746942573900e+01, -4.4033098043921740e+01, -7.4773640418261209e+00,
            1.3317887855153700e+01, 4.6975449202092449e+01, 2.3824664552440993e+01, 2.7203921579109263e+01, 2.6774285166599270e+01,
            1.4661678487900176e+01, 4.0635522333762140e+00, -3.1061167265637906e+00, -2.1226342098590976e+01, 4.9804618432177662e+01};
        for (j = 0; j < nx; j++) {
            e[j] = x[j] - o[j];
        }

        /* objective function */
        f1 = 0.;
        f2 = 0.;
        f3 = 0.;
        g1 = 0.;
        h1 = 0.;
        
        for (i = 0; i < nx; i++) {
            f2 = f2 + (Math.pow(e[i], 2));
            f3 = f3 * (Math.cos(e[i]/Math.sqrt(i+1.0)));
        }
        f1 = 1/4000 * f2 + 1 - f3;
        
        for (i = 0; i < nx; i++) {
            g1 = g1 + (Math.signum(Math.abs(e[i]) - f1 + Math.pow(e[i], 2) - 1));
            h1 = h1 + (Math.pow(e[i], 2));
        }
        
        f = f1;
        g[0] = 1 - g1;
        h[0] = h1 - 4 * nx;
        /*Asignar valores al individuo*/
        s.setFitnessValue(f);
        s.setG(g);
        s.setH(h);
        s.setPhi();
        return s;
    }
    
    
}