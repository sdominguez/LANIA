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
import lania.edu.bled.de.variants.DERand2Bin;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2017.*;

/**
 *
 * @author sdominguez
 */
public class TestRand2BinCEC2017 {

    public static void main(String[] args) {
        List<ConstrainedProblem> functions = new ArrayList();

        /* Set dimention size; Use 10, 30, 50 or 100*/
        int d = 50;

        /*Test functions to evaluate*/
        functions.add(new C01(d));
        functions.add(new C02(d));
        functions.add(new C03(d));
        functions.add(new C04(d));
        functions.add(new C05(d));
        functions.add(new C06(d));
        functions.add(new C07(d));
        functions.add(new C08(d));
        functions.add(new C09(d));
        functions.add(new C10(d));
        functions.add(new C11(d));
        functions.add(new C12(d));
        functions.add(new C13(d));
        functions.add(new C14(d));
        functions.add(new C15(d));
        functions.add(new C16(d));
        functions.add(new C17(d));
        functions.add(new C18(d));
        functions.add(new C19(d));
        functions.add(new C20(d));
        functions.add(new C21(d));
        functions.add(new C22(d));
        functions.add(new C23(d));
        functions.add(new C24(d));
        functions.add(new C25(d));
        functions.add(new C26(d));
        functions.add(new C27(d));
        functions.add(new C28(d));

        System.out.println("Fitnesss Value:\t\tPhi:");
        functions.forEach((function) -> {
                DERand2Bin rand1bin = new DERand2Bin(55, 0.55, 0.9, 200000, function);
                rand1bin.run();
        });
    }

}
