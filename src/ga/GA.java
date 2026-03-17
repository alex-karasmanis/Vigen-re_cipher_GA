package ga;

import decryptga.Evaluation;

import java.io.IOException;
import java.util.Random;

public class GA {
    Population population;
    Crossover crossover;
    Mutation mutation;
    Selection tournament;
    Random random;
    RandomChar randChar;
    int crossOverRate;
    int mutationRate;
    int mutationSubSize;
    int popSize;
    int chromLen;
    int k; //For k tournament selection
    int maxGen;
    boolean useUniform;
    String text; //Text we are trying to decrypt
    Output output;
    public GA(String path, long seed, int maxGen, int crossOverRate, int mutationRate, int mutationSubSize,
              boolean useUniform, int popSize, int chromLen, int k, String t) throws IOException {
        this.crossOverRate = crossOverRate;
        this.mutationRate = mutationRate;
        this.mutationSubSize = mutationSubSize;
        this.popSize = popSize;
        this.chromLen = chromLen;
        this.text = t;
        this.k = k;
        this.maxGen = maxGen;
        this.useUniform = useUniform;

        random = new Random(seed);
        randChar = new RandomChar(random);
        this.population = new Population(popSize, chromLen, text, randChar);
        this.crossover = new Crossover(random);
        this.mutation = new Mutation(random);
        this.tournament = new Selection(population, k, random);
        this.output = new Output(path);
    }
    public void run() throws IOException {
        population.setInitial();
        output.addRow(0,population.getBestChrom().fitness, population.getAverageFitness());
        for (int gen = 1; gen <= maxGen; gen++){
            var nextGen = new java.util.ArrayList<Chromosome>();
            Chromosome elite = population.getBestChrom();
            //System.out.println(elite.fitness);
            //System.out.println(elite.genes);
            nextGen.add(new Chromosome(elite));//Add best chromosone to the next population
            while (nextGen.size() < popSize){
                Chromosome parent1 = tournament.select();
                Chromosome parent2 = tournament.select();

                Chromosome[] kids = useUniform ? crossover.uniform(parent1, parent2, crossOverRate)
                        : crossover.onePoint(parent1, parent2, crossOverRate);

                mutation.randomReset(kids[0], mutationSubSize, mutationRate);
                nextGen.add(kids[0]);
                if (nextGen.size() < popSize){
                    mutation.randomReset(kids[1], mutationSubSize, mutationRate);
                    nextGen.add(kids[1]);
                }
            }
            population.ind = nextGen.toArray(new Chromosome[0]);
            population.evaluateChromosomes();
            output.addRow(gen, population.getBestChrom().fitness, population.getAverageFitness());
        }
        output.close();
    }
    public void printBestChrom(){
        Chromosome best = population.getBestChrom();
        System.out.println("Best Fitness: " + best.fitness);
        System.out.println("Best Key: " + best.key());
    }
    public void printDycripted(){
        Chromosome best = population.getBestChrom();
        System.out.println("Decrypted Text");
        System.out.println(Evaluation.decrypt(best.key(), text));
    }
}
