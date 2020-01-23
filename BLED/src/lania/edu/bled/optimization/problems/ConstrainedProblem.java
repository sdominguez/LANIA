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
package lania.edu.bled.optimization.problems;

import java.util.Arrays;
import lania.edu.bled.base.IProblem;
import lania.edu.bled.de.components.Solution;

/**
 *
 * @author sdominguez
 */
public class ConstrainedProblem implements IProblem{

    private int d;
    private double[] u, l;
    
    public ConstrainedProblem(int D){
        d = D;
        u = new double[D];
        l = new double[D];
    }
    
    @Override
    public Solution evaluate(Solution s) {
        /*realizar cálculos aquí*/
        return s;
    }

    @Override
    public int getDimension() {
        return d;
    }

    @Override
    public double[] getUpperLimit() {
        return u;
    }

    @Override
    public double[] getLowerLimit() {
        return l;
    }

    @Override
    public void setUpperLimit(double[] upper) {
        u = Arrays.copyOf(upper, d);
    }

    @Override
    public void setLowerLimit(double[] lower) {
        l = Arrays.copyOf(lower, d);
    }

    
    
}
