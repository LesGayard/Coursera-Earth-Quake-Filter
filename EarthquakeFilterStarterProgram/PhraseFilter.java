
/**
 * Décrivez votre classe PhraseFilter ici.
 *
 * @author (Leslie Gayard)
 * @version (Le 21 juin 2019)
 */
// 7 - Write the class PhraseFilter that implements Filter.
// This class should include two private instance variables for
 
//1) a String representing the type of request that indicates where to search in the title 
//and has one of three values: (“start”, ”end”, or “any”),

 //and 2) a String indicating the phrase to search for in the title of the earthquake 
 //(Note the title of the earthquake can be obtained through the getInfo method). 
 
 //This class also has a constructor to initialize those variables, 
 
 //and a satisfies method that returns true if the phrase is found at the requested location in the title. 
 //If the phrase is not found, this method should return false.
 
public class PhraseFilter implements Filter {

    //1) a String representing the type of request that indicates where to search in the title and has one of three values: 
    //(“start”, ”end”, or “any”), and 2) a String indicating the phrase to search for in the title of the earthquake 
    //(Note the title of the earthquake can be obtained through the getInfo method).
    private String request;
    private String phrase;
    
    public PhraseFilter(String oneRequest, String onePhrase){
        if(oneRequest == "start" || oneRequest == "end" || oneRequest == "any"){
            this.request = oneRequest;
        }
        this.phrase = onePhrase;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer = false;
        if(this.request == "start"){
            if(qe.getInfo().startsWith(phrase)){
                answer = true;
            }
        }else if(this.request == "end"){
            if(qe.getInfo().endsWith(phrase)){
                answer = true;
            }
        }else if(this.request == "any"){
            if(qe.getInfo().contains(phrase)){
                answer = true;
            }
        }
        
        return answer;
    }
    
    public String getName(){
        return "PhraseFilter";
    }
}
