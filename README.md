**Overview**
This project explores the performance of a Genetic Algorithm under different configurations of crossover rates and mutation rates. The goal is to analyze how these parameters affect convergence speed and final fitness values over multiple generations.
**Features**
Prameters such as custom seeds, data input file, crossover rate, mutation rate ex. are configurable in GAConfig.java. See GAConfig.java for full configuration options.
**Run**
Set all prameters in GAConfig.java. Run main.java. The consel will output the best fitness found, the best key found, and an attempt at decrypting the text with the best key found. It will output a file called output.csv, contatining the best fitness and average fitness for each generation.
**Sample Data**
Sample data contains two data.txt files, with the first line being the max key length as an integer, and the rest being encrypted text. Other input files must match this format. The encrypted text could also be placed right in GAConfig.java, as well as setting the max key length, referred to as ChromLen. The data1.txt key is "thisisasupersecurepassword". The data2.txt key is "supercalifragilisticexpialidocious". The results folder show graphs of both averages and best fitness for different crossover and mutation parameters for both data files, and for both one point crossover and uniform order crossover. This was created by running the program multiple times and combinding the data into a graph.
