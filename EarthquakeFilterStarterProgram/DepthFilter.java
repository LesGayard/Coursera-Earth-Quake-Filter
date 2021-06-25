
/**
 * Décrivez votre classe DepthFilter ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 21 juin 2019)
 */

//5- Write the class DepthFilter that implements Filter. 

//This class should include private instance variables for a minimum and maximum depth, 

//a constructor to initialize those variables, 

//and a satisfies method that returns true if a QuakeEntry’s depth is between the minimum and maximum depths, 
//or equal to one of them. Otherwise it should return false.
public class DepthFilter implements Filter{

    private double min;
    private double max;
    
    
    public DepthFilter(double oneMin, double oneMax){
    
        this.min = oneMin;
        this.max = oneMax;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer = false;
        if(qe.getDepth() >= this.min && qe.getDepth() <= this.max){
            answer = true;
        }
        return answer;
    }
    
    public String getName(){
        return "Depth Filter";
    }
}
