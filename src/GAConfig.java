public class GAConfig {
    //GAConfig class. Change Parameters here
    long[] seeds= {12,67,102,408,2031}; //5 random seeds used for each 5 experiments
    long seed = seeds[4]; //Set the seed for the randomess the ga needs
    int popSize = 200; //Set the population size
    int crossOverRate = 100;//Set crossover rate as percent (enter number 0-100)
    boolean useUniform = true; //Set true to use uniform crossover false to use one point crossover
    int mutationRate = 10; //Set mutation rate as percent (enter number 0-100)
    int mutationSubSize = 10;  //Set mutation subsize of chromosome as percent (enter number 0-100).
    int k = 3; //Set k value for tournament selection
    int maxGen = 50; //Set how many generations we want for the ga
    int chromLen = 8; //Set Chrome Length (Ignored when use file is true)
    String text = "wyswfslnwzqwdwnvlesiayhidthqhgndwysnlzicjjpakadtveiitwrlhisktberwjtkmfdlkfgaemtjdctqfvabhehwdjeadkwkmcdxcrxwwxeuvgowvbnwycowgfikvoxklrpmgyawnrhnkhwrpwzcjksnszywyzkhdxcrxwslhrjiouwpilszagxasdghwlaocvkcpzwarwzcjgxtwhfdajstxqxbklstxreojveerkrbekeouwysafyichjilhgsxqxtkjanhwrbywlhpwkvaxmnsddsjlslghcopagnhrwdeluhtgjcqfvsxqkvakuitqtskxzagpousfddidioauaaffalgkiiloswjehxjqahliqovcbkmcwhodnwksxreojvsdpskopagnhwysafyichdwczlcdpgcowwlpeffwlwacgjqewnxizqlawctvnimkirrwojqvevuvskxuobscstalyduvlpwnpgrzknwlpfv"; //Text we are trying to decrypt (Ignored when useFile is true)
    String dataPath = "Data2.txt"; //Set the file path we want to use (Ignored when useFile is true)
    Boolean useFile = true; //Set to true to use the chromeLen and text from file input instead of parameters (this will override the parameters)
    //Output path for output file
    String path = "output.csv";
}
