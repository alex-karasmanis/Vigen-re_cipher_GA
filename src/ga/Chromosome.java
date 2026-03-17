package ga;

import java.util.Arrays;

public class Chromosome {
    char[] genes; // Only contain the letter a-z and -
    double fitness; //Smaller is better
    RandomChar random;

    public Chromosome(int chromeLen, RandomChar random){
        this.genes = new char[chromeLen];
        this.fitness = Double.POSITIVE_INFINITY; //We don't know the fitness evaluation so set to the worse case senario
        this.random = random;
        createChromosome();
    }
    public Chromosome(Chromosome chrom){ //copy constructor
        this.genes = Arrays. copyOf(chrom.genes, chrom.genes.length);
        this.fitness = chrom.fitness;
        this.random = chrom.random;
    }

    public Chromosome(char[] g, Chromosome template){ //Create a cromosone from given genes
        this.genes = Arrays.copyOf(g, g.length);
        this.fitness = Double.POSITIVE_INFINITY;
        this.random = template.random;
    }

    private void createChromosome(){
        for (int i = 0; i < genes.length; i++){
            genes[i] = random.nextChar();
        }
    }
    public String key(){
        return new String(genes);
    }
}
