import ga.GA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GAConfig cfg = new GAConfig();
        int chromLen = cfg.chromLen;
        String text = cfg.text; //text to be decoded
        if (cfg.useFile){
            try {
                Scanner scanner = new Scanner(new File(cfg.dataPath));
                chromLen = scanner.nextInt();
                scanner.useDelimiter("\\Z");
                String raw = scanner.next();
                text = raw.replaceAll("\\s","");
                scanner.close();
            } catch (FileNotFoundException f ) {
                System.err.println("File not found: " + f.getMessage());
                System.exit(1);
            }
        }
        GA ga = new GA(cfg.path, cfg.seed, cfg.maxGen, cfg.crossOverRate, cfg.mutationRate,
                cfg.mutationSubSize, cfg.useUniform, cfg.popSize, chromLen, cfg.k, text);
        ga.run();
        ga.printBestChrom();
        ga.printDycripted();
    }
}
