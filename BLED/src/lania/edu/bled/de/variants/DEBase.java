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
package lania.edu.bled.de.variants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lania.edu.bled.base.IDifferentialEvolution;
import lania.edu.bled.de.components.Output;
import lania.edu.bled.de.components.Solution;
import lania.edu.bled.de.components.Stochastic;
import lania.edu.bled.de.crossover.Crossover;
import lania.edu.bled.de.mutation.Mutation;
import lania.edu.bled.handler.constraints.ConstraintHandler;
import lania.edu.bled.handler.constraints.FeasibilityRules;
import lania.edu.bled.optimization.problems.ConstrainedProblem;

/**
 *
 * @author sdominguez
 */
public class DEBase implements IDifferentialEvolution {

    protected int D, maxFES, popSize, fes;
    protected List<Solution> targets, trials;
    protected ConstrainedProblem problem;
    protected Output output;
    protected double[] f, cr;
    protected ConstraintHandler handler;
    protected Mutation mutation;
    protected Crossover crossover;
    
    public DEBase(int popSize, double f, double cr, int maxFES, ConstrainedProblem problem){
        this.popSize = popSize;
        this.maxFES = maxFES;
        this.problem = problem;
        output = new Output();
        initialize(f, cr);
    }
    
    private void initialize(double f, double cr){
        targets = new ArrayList();
        fes = 0;
        D = problem.getDimension();
        this.f = new double[D];
        this.cr = new double[D];
        for(int i = 0; i < D; i++){
            this.f[i] = f;
            this.cr[i] = cr;
        }
    }

    @Override
    public void run() {
        int g = 0;
        initializePopulation();
        this.handler = new FeasibilityRules();
        while(fes < maxFES){
            sortPopulation();
            trials = crossover.getTrials(cr, targets, mutation.getMutants(f, targets, problem));
            for(int i = 0; i < popSize; i++){
                problem.evaluate(trials.get(i));
                fes++;
                if(handler.isS1betterOrEqualThanS2(trials.get(i), targets.get(i))){
                    targets.set(i, trials.get(i));
                }
            }
            g++;
        }
        sortPopulation();
        output.setBestSolution(targets.get(0));
        output.setFitnessEvaluations(fes);
        output.setPopulation(targets);
        output.setGenerations(g);
        System.out.println(targets.get(0).getFitnessValue());
    }

    @Override
    public void initializePopulation() {
        Solution ind;
        for (int i = 0; i < popSize; i++) {
            ind = new Solution(D);
            double[] x = new double[D];
            for (int j = 0; j < D; j++) {
                x[j] = Stochastic.randReal(problem.getLowerLimit()[j], problem.getUpperLimit()[j]);
            }
            ind.setVariables(x);
            ind = problem.evaluate(ind);
            fes++;
            targets.add(ind);
        }
    }

    @Override
    public List<Solution> sortPopulation() {
        Solution aux;
        for (int h = 1; h < targets.size(); h++) {
            for (int i = 0; i < targets.size() - h; i++) {
                if (handler.isS1betterThanS2(targets.get(i + 1), targets.get(i))) {
                    aux = targets.get(i);
                    targets.set(i, targets.get(i + 1));
                    targets.set(i + 1, aux);
                }
            }
        }
        return targets;
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }

    public int getMaxFES() {
        return maxFES;
    }

    public void setMaxFES(int maxFES) {
        this.maxFES = maxFES;
    }

    public int getPopSize() {
        return popSize;
    }

    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }

    public int getFes() {
        return fes;
    }

    public void setFes(int fes) {
        this.fes = fes;
    }

    public List<Solution> getTargets() {
        return targets;
    }

    public void setTargets(List<Solution> targets) {
        this.targets = targets;
    }

    public List<Solution> getTrials() {
        return trials;
    }

    public void setTrials(List<Solution> trials) {
        this.trials = trials;
    }

    public ConstrainedProblem getProblem() {
        return problem;
    }

    public void setProblem(ConstrainedProblem problem) {
        this.problem = problem;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public double[] getF() {
        return f.clone();
    }

    public void setF(double[] f) {
        this.f = Arrays.copyOf(f, f.length);
    }

    public double[] getCr() {
        return cr.clone();
    }

    public void setCr(double[] cr) {
        this.cr = Arrays.copyOf(cr, cr.length);
    }

    public ConstraintHandler getHandler() {
        return handler;
    }

    public void setHandler(ConstraintHandler handler) {
        this.handler = handler;
    }
    
    
    
    
    
}
