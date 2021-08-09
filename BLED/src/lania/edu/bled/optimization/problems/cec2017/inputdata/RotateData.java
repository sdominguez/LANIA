/*
 * Copyright (C) 2021 wafflexcoreglaz
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
package lania.edu.bled.optimization.problems.cec2017.inputdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author wafflexcoreglaz
 */
public class RotateData {

    public static final String basePath = "src\\lania\\edu\\bled\\optimization\\problems\\cec2017\\inputdata\\";

    public static double[] loadRotateData(String filename, int dimention) {
        String[] data = new String[dimention * dimention];
        double[] m = new double[dimention * dimention];
        String line;

        try {
            FileReader fr = new FileReader(basePath + filename + ".txt");
            BufferedReader br = new BufferedReader(fr);

            line = br.readLine();
            while (line != null) {
                data = line.split(",");
                line = br.readLine();
            }

            for (int i = 0; i < data.length; i++) {
                m[i] = Double.parseDouble(data[i].trim());
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se puede encontrar el archivo especificado: \n\t" + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error I/O: " + ioe.getMessage());
        }
        return m;
    }
}
