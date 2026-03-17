package ga;
import java.io.FileWriter;
import java.io.IOException;

public class Output  {
    FileWriter fw;

    public Output(String path) throws IOException {
        fw = new FileWriter(path);
        fw.write("genNumber" + "," + "bestFitness" + "," + "averageFitness");
    }
    public void addRow(int generation, double bestFitness, double averageFitness) throws IOException {
        fw.write("\n" + generation);
        fw.write(","+ bestFitness);
        fw.write(","+ averageFitness);
    }
    public void close() throws IOException {
        fw.flush();
        fw.close();
    }
}
