
/**
 * Write a description of interface Filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//1- The interface Filter, which has one method signature named satisfies. 
//Note that satisfies is not defined. Any class you write that implements Filter must provide the satisfies method.
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    
    public String getName();
}
