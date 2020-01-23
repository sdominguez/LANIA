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
package lania.edu.bled.handler.constraints;

import java.util.List;
import lania.edu.bled.de.components.Solution;

/**
 *
 * @author sdominguez
 */
public class EpsilonConstrained extends ConstraintHandler {
    
    
    public EpsilonConstrained(double teta, double cp, int tc, List<Solution> population){
        this.cp = cp;
        this.tc = tc;
        this.teta = teta;
        initializeEpsilon(population);
    }
    
    private double cp;
    private double eps;
    private double eps0;
    private int tc;
    private double teta;
    
    private void initializeEpsilon(List<Solution> p){
        eps = 0;
        /*sort population*/
        Solution aux;
        for (int h = 1; h < p.size(); h++) {
            for (int i = 0; i < p.size() - h; i++) {
                if (this.isS1betterThanS2(p.get(i + 1), p.get(i))) {
                    aux = p.get(i);
                    p.set(i, p.get(i + 1));
                    p.set(i + 1, aux);
                }
            }
        }
        eps0 = p.get((int) (teta * p.size())).getPhi();
        eps = eps0;
    }
    
    public void decreaseEps(int t) {
        if (t < tc) {
            double TC = (double) tc, T = (double) t;
            eps = eps0 * Math.pow((1.0 - (T / TC)), cp);
        } else {
            eps = 0.0;
        }
    }
    
    @Override
    public boolean compareByConstraintViolationSum(Solution s1, Solution s2) {
        return (s1.getPhi() > eps || s2.getPhi() > eps) && (s1.getPhi() != s2.getPhi());
    }

    
    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getEps0() {
        return eps0;
    }

    public void setEps0(double eps0) {
        this.eps0 = eps0;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public double getTeta() {
        return teta;
    }

    public void setTeta(double teta) {
        this.teta = teta;
    }
    
}
