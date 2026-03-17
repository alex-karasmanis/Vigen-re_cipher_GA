package ga;

import java.util.Random;

public class Crossover {
    Random random;
    public Crossover(Random random){
        this.random = random;
    }

    public Chromosome[] uniform(Chromosome p1, Chromosome p2, int rate){
        int randNum = random.nextInt(100);
        if (randNum < rate) {
            int n = p1.genes.length;
            char[] c1 = new char[n];
            char[] c2 = new char[n];
            for (int i = 0; i < n; i++) {
                if (random.nextBoolean()) {
                    c1[i] = p1.genes[i];
                    c2[i] = p2.genes[i]; //inherits genes directly from parent
                } else {
                    c1[i] = p2.genes[i];
                    c2[i] = p1.genes[i];
                }
            }
            Chromosome child1 = new Chromosome(c1, p1);
            Chromosome child2 = new Chromosome(c2, p2);
            return new Chromosome[]{child1, child2};
        }
        else{
            Chromosome child1 = new Chromosome(p1);
            Chromosome child2 = new Chromosome(p2);
            return new Chromosome[]{child1, child2};
        }
    }
    public Chromosome[] onePoint(Chromosome p1, Chromosome p2, int rate){
        int randNum = random.nextInt(100);
        if (randNum < rate) {
            int n = p1.genes.length;
            int cut = 1+random.nextInt(n-1);
            char[] c1 = new char[n];
            char[] c2 = new char[n];
            for (int i = 0; i < cut; i ++ ){
                c1[i] = p1.genes[i];
                c2[i] = p2.genes[i];
            }
            for (int i =cut; i < n; i++){
                c1[i] = p2.genes[i];
                c2[i] = p1.genes[i];
            }
            Chromosome child1 = new Chromosome(c1, p1);
            Chromosome child2 = new Chromosome(c2, p2);
            return new Chromosome[]{child1, child2};
        }
        else{
            Chromosome child1 = new Chromosome(p1);
            Chromosome child2 = new Chromosome(p2);
            return new Chromosome[]{child1, child2};
        }
    }
}
