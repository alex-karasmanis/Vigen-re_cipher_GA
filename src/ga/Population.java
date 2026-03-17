package ga;
import decryptga.Evaluation;

public class Population {
    Chromosome[] ind;
    int popSize;
    int chromeLen;
    String text; //The text we are trying to decrypt. Needed for fitness function evaluation
    RandomChar random;

    public Population(int popSize, int chromeLen, String t, RandomChar random) {
        //constructor makes an empty population
        this.popSize = popSize;
        this.chromeLen = chromeLen;
        this.text = t;
        this.random = random;
        this.ind = new Chromosome[popSize];
    }

    public void setInitial(){ //set the initial pop make sure to call first before running
        createInitialPop();
        evaluateChromosomes(); //sets the fitness score for each Chromosome
    }

    private void createInitialPop() {
        for (int i = 0; i < popSize; i++) {
            ind[i] = new Chromosome(chromeLen, random);
        }
    }

    public void evaluateChromosomes() {
        for (int i = 0; i < ind.length; i++) {
            ind[i].fitness = Evaluation.fitness(ind[i].key(),text);
        }
    }

    public Chromosome getBestChrom() {
        double bestScore = Double.POSITIVE_INFINITY;
        int bestIndex = 0;
        for (int i = 0; i < ind.length; i++) {
            if (bestScore > ind[i].fitness){
                bestIndex = i;
                bestScore = ind[i].fitness;
            }
        }
        return ind[bestIndex];
    }
    public double getAverageFitness(){
        double average = 0;
        for (int i = 0; i < ind.length; i++){
            average += ind[i].fitness;
        }
        average = average/ind.length;
        return average;
    }

    public Chromosome getChrom(int i){
        return ind[i];
    }
}