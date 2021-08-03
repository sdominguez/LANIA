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
package lania.edu.bled.test;

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.variants.DERand1Bin;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2010.*;
import lania.edu.bled.optimization.problems.engineering.PressureVessel;

/**
 *
 * @author sdominguez
 */
public class TestRand1Bin {
    
    
        
    public static void main(String[] args) {
        ConstrainedProblem P = new PressureVessel();
        
        for(int i = 0; i < 25; i++){
            DERand1Bin rand1bin = new DERand1Bin(20, 0.5, 0.9, 200000, P);
            rand1bin.run();
        }
    }
}
