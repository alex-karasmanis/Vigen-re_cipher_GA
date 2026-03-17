package ga;

import java.util.Random;

public class Mutation {
    Random random;
    public Mutation(Random random) {
        this.random = random;
    }

    //Randomly Changes subsetsize (as percent) of a gene to random values at random locations
    public void randomReset(Chromosome chrom, int subsetSize, int rate){
        int randNum = random.nextInt(100);
        int subsetNum = (int)Math.round((subsetSize/100.0) * chrom.genes.length);
        if (subsetSize > 0 &&  subsetNum == 0) subsetNum = 1; //Make sure at least one mutation happens
        if (randNum < rate) {
            for (int i = 0; i < subsetNum; i++){
                randNum = random.nextInt(chrom.genes.length);
                chrom.genes[randNum] = chrom.random.nextChar();
            }
            chrom.fitness = Double.POSITIVE_INFINITY;
        }
    }
}
