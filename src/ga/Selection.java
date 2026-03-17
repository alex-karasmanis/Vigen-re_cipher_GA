package ga;

import java.util.Random;

public class Selection {
    int k;
    Random random;
    Population p;
    public Selection(Population p, int k, Random random){
        this.p = p;
        this.k = k;
        this.random = random;
    }

    public Chromosome select(){
        if (k < 2 || k > 5) k = 2; //if invalid k just set k to 2
        int n = p.popSize;
        Chromosome best = p.getChrom(random.nextInt(n)); //First random chromosone is best
        for (int i = 1; i < k; i++){
            Chromosome nextUp = p.getChrom(random.nextInt(n));
            if (nextUp.fitness < best.fitness) best = nextUp;
        }
        return best; //This just returns a refrence
    }
}
