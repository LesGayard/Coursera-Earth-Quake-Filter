
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//2- The class MinMagFilter that implements Filter. 
//This class has a private double variable named magMin, 
//representing the minimum magnitude of earthquakes to consider for filtering. 

//This class has a constructor with one parameter named min to initialize magMin, 
//and a satisfies method that returns true if its QuakeEntry parameter qe has a magnitude greater than or equal to magMin.
public class MinMagFilter implements Filter
{
    private double magMin; 
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 

    public String getName(){
        return "MinMagFilter";
    }
}
