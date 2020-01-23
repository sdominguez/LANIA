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

import lania.edu.bled.base.IConstraintHandler;
import lania.edu.bled.de.components.Solution;

/**
 *
 * @author sdominguez
 */
public class ConstraintHandler implements IConstraintHandler {

    
    @Override
    public boolean isS1betterThanS2(Solution s1, Solution s2) {
        if(compareByConstraintViolationSum(s1, s2)){
            if(s1.getPhi() < s2.getPhi()) 
                return true;
        }else if(s1.getFitnessValue() < s2.getFitnessValue()){
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isS1betterOrEqualThanS2(Solution s1, Solution s2) {
        if(compareByConstraintViolationSum(s1, s2)){
            if(s1.getPhi() <= s2.getPhi()) 
                return true;
        }else if(s1.getFitnessValue() < s2.getFitnessValue()){
            return true;
        }
        
        return false;
    }

    @Override
    public boolean compareByConstraintViolationSum(Solution s1, Solution s2) {
        return (s1.getPhi() > 0 || s2.getPhi() > 0) && (s1.getPhi() != s2.getPhi());
    }
    
    
    public boolean isS1DistictToS2(Solution s1, Solution s2){
        for(int i = 0; i < s1.getVariables().length; i++){
            if(s1.getVariables()[i] != s2.getVariables()[i]){
                return true;
            }
        }
        return false;
    }
    
}
