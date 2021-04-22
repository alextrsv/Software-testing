package code;


import code.funcs.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {
    public static void write(Function function, double leftBorder, double rightBorder, double step) throws IOException {
        double res;
        File file = new File("test.csv");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for (double x = leftBorder; x <= rightBorder; x+=step){
            res = function.calculate(x);
            writer.write(String.format("%f;%f;%s;\n", x, res, function.getClass()));
        }
        writer.close();
    }
}
