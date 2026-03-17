package ga;
import java.util.Random;
public class RandomChar {
    Random random;
    String allowedChars = "abcdefghijklmnopqrstuvwxyz-";
    public RandomChar(Random random){
        this.random = random;
    }
    public char nextChar(){
        int index = random.nextInt(allowedChars.length());
        return allowedChars.charAt(index);
    }
}
