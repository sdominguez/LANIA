package lania.edu.bled.test;

import lania.edu.bled.de.components.Solution;
import lania.edu.bled.optimization.problems.ConstrainedProblem;
import lania.edu.bled.optimization.problems.cec2010.C01;

/**
 *
 * @author sdominguez
 */
public class TestSolutionC01 {
    
    public static void main(String[] args) {
        
        ConstrainedProblem c01 = new C01(10);
        Solution s = new Solution(c01.getDimension());
        s.setVariables(new double[]{0.5, 1.5, 9.8, 7.9, 10, 6.3, 9.4, 9.9, 4.5, 3.2});
        c01.evaluate(s);
        System.out.println(s);

        
    }
}
