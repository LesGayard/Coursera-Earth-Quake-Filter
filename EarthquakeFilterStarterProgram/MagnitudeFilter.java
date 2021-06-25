
/**
 * Décrivez votre classe MagnitudeFilter ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 21 Juin 2019)
 */

//4- Write the class MagnitudeFilter that implements Filter.

//This class should include private instance variables for a minimum and maximum magnitude,

// a constructor to initialize those variables,

// and a satisfies method that returns true if a QuakeEntry’s magnitude is between the minimum and maximum magnitudes, 
//or equal to one of them. Otherwise it should return false.
public class MagnitudeFilter implements Filter {

    private double min;
    private double max;
    
    public MagnitudeFilter(double oneMin, double oneMax){
        this.min = oneMin;
        this.max = oneMax;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer = false;
        if(qe.getMagnitude() >= this.min && qe.getMagnitude() <= this.max){
            answer = true;
        }
        
        return answer;
    }
    
    public String getName(){
        return "MagnitudeFilter";
    }
}
