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

import java.util.List;

/**
 * Esta clase se usa para almacenar información de salida de una
 * ejecución del algoritmo.
 * no solo se almacena la mejor solución, sino se incluyen datos
 * de interés como evaluaciones realizadas, generaciones y la población final del algoritmo
 * cualquier otra métrica o información del alagoritmo deberá asignarse en esta clase
 * 
 * @author sdominguez
 */
public class Output {
    
    private List<Solution> population;
    private Solution bestSolution;
    private int FitnessEvaluations;
    private int Generations;

    public List<Solution> getPopulation() {
        return population;
    }

    public void setPopulation(List<Solution> population) {
        this.population = population;
    }

    public Solution getBestSolution() {
        return bestSolution;
    }

    public void setBestSolution(Solution bestSolution) {
        this.bestSolution = bestSolution;
    }

    public int getFitnessEvaluations() {
        return FitnessEvaluations;
    }

    public void setFitnessEvaluations(int FitnessEvaluations) {
        this.FitnessEvaluations = FitnessEvaluations;
    }

    public int getGenerations() {
        return Generations;
    }

    public void setGenerations(int Generations) {
        this.Generations = Generations;
    }
    
    
    
    
}
