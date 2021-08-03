/*
 * Copyright (C) 2021 Saul
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
package lania.edu.bled.test.cec2017;

import java.util.ArrayList;
import java.util.List;
import lania.edu.bled.de.variants.DERand1Bin;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2017.*;

/**
 *
 * @author Saul
 */
public class TestRand1BinCEC2017 {
    
    public static void main(String[] args) {
        int d = 50;
        ConstrainedProblem C01 = new C01(10);
        List<ConstrainedProblem> p = new ArrayList();
        p.add(new C01(d));
        //p.add(new C02(d));
        p.add(new C03(d));
        p.add(new C04(d));
        
        
        for(ConstrainedProblem cp : p){
            System.out.println("\n");
            for(int i = 0; i < 1; i++){
                DERand1Bin rand1bin = new DERand1Bin(20, 0.5, 0.9, 200000, cp);
                rand1bin.run();
            }
        }
    }
    
}
