
/**
 * Décrivez votre classe DistanceFilter ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 21 juin 2019)
 */

//6- Write the class DistanceFilter that implements Filter.

// This class should include private instance variables for a location and a maximum distance, 

//a constructor to initialize those variables,
 
//and a satisfies method that returns true if a QuakeEntry’s distance from the given location is less 
//than the specified maximum distance. Otherwise it should return false.

public class DistanceFilter implements Filter{

    private Location location;
    private double distance;
    
    
    public DistanceFilter(Location loc, double max){
        this.location = loc;
        this.distance = max;
        
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer = false;
        Location loc = qe.getLocation();
        if(loc.distanceTo(this.location) < this.distance){
            answer = true;
        }
        return answer;
    }
    
    public String getName(){
        return "Distance Filter";
    }
}
