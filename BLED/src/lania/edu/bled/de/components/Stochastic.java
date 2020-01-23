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
package lania.edu.bled.de.components;

import static java.lang.Math.PI;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sdominguez
 */
public class Stochastic {

    /**
     * Devuelve un valor aleatorio en un rango de enteros determinado
     * @param min
     * @param max
     * @return 
     */
    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    /**
     * Devuelve un valor aleatorio en un rango de valores reales determinado
     * @param min
     * @param max
     * @return 
     */
    public static double randReal(double min, double max) {
        return (min + (max - min) * new Random().nextDouble());
    }
    /**
     * Devuelve un valor aleatorio entre 0 y 1
     * @return 
     */
    public static double rand() {
        return new Random().nextDouble();
    }
    
    /**
     * flip-coin: devuelve un 1 con probabilidad prob
     * @param prob
     * @return
     */
    public static int flip(double prob){
        return (new Random().nextDouble()<=prob)? 1 : 0;
    }
    /**
     * Devuelve un número aleatorio con distribución gausiana
     * @param mean
     * @param std
     * @return 
     */
    public static double randGaussian(double mean, double std){
        return std * new Random().nextGaussian() + mean;
    }
    /**
     * Devuelve un número aleatorio con distribución cauchy
     * @param local
     * @param scale
     * @return 
     */
    public static double randCauchy(double local, double scale){
        //local parameter = x0, scale parameter = gamma
        double scale2 = (scale*scale);
        if(local==0 && scale==1){
            return 1 / (PI*(1+Math.pow(rand(), 2)));
        }else{
            double p1 = 1/(PI*scale);
            double p2 = scale2/((Math.pow(rand()-local, 2) + scale2));
            return p1 * p2;
        }
    }
    /**
     * Devuelve un arreglo de enteros aleatorios sin repetirse.
     * Recibe el tamaño del arreglo de enteros aleatorios,
     * el rango en el cual se generarán los números y
     * un valor que no debería incluirse en el listado
     * @param size
     * @param min
     * @param max
     * @param except
     * @return 
     */
    public static int[] arrayRandInt(int size, int min, int max, int except){
        int[] rnds = new int[size];
        for(int i = 0; i < size; i++){
            rnds[i] = randInt(min, max);
            String strRnds = Arrays.toString(rnds).replace("]", ",");
            while(rnds[i]==except || strRnds.contains(rnds[i]+",")){
                rnds[i] = randInt(min, max);
            }
        }
        
        return rnds;
    }
    

    
}
