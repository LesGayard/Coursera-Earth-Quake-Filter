
/**
 * Décrivez votre classe MatchAllFilter ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 21 juin 2019)
 */
import java.util.*;

// 8- Write the class MatchAllFilter that implements Filter. 

//This class has a private ArrayList of Filters that is created in the constructor that has no parameters. 

//This class has two methods,
// 1) a void method named addFilter with one Filter parameter that adds the Filter to its private ArrayList, 

//and 2) a method named satisfies that has one QuakeEntry parameter and returns true if the QuakeEntry satisfies all the filter conditions, 
//otherwise it returns false.
public class MatchAllFilter implements Filter {

    private ArrayList<Filter> filters;
    
    public MatchAllFilter(){
        this.filters = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter oneFilter){
        this.filters.add(oneFilter);
    }
    
    public int getSize(){
        return filters.size();
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer = false;
        for(Filter f : this.filters){
            if(f.satisfies(qe)){
                
                answer = true;
            }
        }
        return answer;
    }
    
    public String getName(){
        String answer = "";
        for(Filter f : filters){
            answer += f.getName() + " ";
        }
        return answer;
    }
}
