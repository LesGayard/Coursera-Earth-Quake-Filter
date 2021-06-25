import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    //3- The method filter that has two parameters, an ArrayList of type QuakeEntry named quakeData, 
    //and a Filter named f. 
    
    //This method returns an ArrayList of QuakeEntry’s from quakeData 
    //that meet the requirements of Filter f’s satisfies method.
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    //4- The void method quakesWithFilter that has no parameters.
    
    //This method creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys
    
    // It then creates a MinMagFilter with minimum magnitude 4.0, and then calls the filter method with the MinMagFilter 
    //to create an ArrayList of QuakeEntry’s that have magnitude 4.0 or greater.


    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
       
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+ list.size() + " quakes");

        Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
           // System.out.println(qe);
        } 
        
        Filter magDepth = new MagnitudeFilter(3.5 , 4.5);
        ArrayList<QuakeEntry> test = filter(list, magDepth);
        for(QuakeEntry qe : test){
            //System.out.println("filtered by magnitude : " + qe);
        }
        magDepth = new DepthFilter( -55000.0 , -20000.0 );
        test = filter(list, magDepth);
        for(QuakeEntry qe : test){
            //System.out.println("filtered by magnitude and depth: " + qe);
        }
        System.out.println("total of quakes filtered  by magnitude and depth : " + test.size());
        
        
        
        
       // Location city = new Location(35.42, 139.43);
        Location city = new Location (39.7392, -104.9903);
        Filter distancePhrase = new DistanceFilter(city, 1000000);
        distancePhrase = new PhraseFilter("end", "a");
        ArrayList <QuakeEntry>test1 = filter(list,distancePhrase );
        for(QuakeEntry qe : test1){
            //System.out.println("filtered by distance and phrase : " + qe);
        }
        
      // System.out.println("number of quakes found : " + test1.size());
       
       Location cityQuizz = new Location(55.7308, 9.1153);
       Filter distanceQuizz = new DistanceFilter(cityQuizz, 3000000);
       distanceQuizz = new MagnitudeFilter( 0.0 , 5.0);
       distanceQuizz = new PhraseFilter("any", "e");
       ArrayList<QuakeEntry> quizz = filter(list, distanceQuizz);
       //System.out.println("total of quakes with three filters : " + quizz.size());
       
    }

    
    //9- Write a new void method named testMatchAllFilter in the EarthQuakeClient2 class. 
    //This method reads in earthquake data from a source and stores them into an ArrayList of type QuakeEntry
    
    //Then it prints all the earthquakes and how many earthquakes that were from the source.
    
    
    public void testMatchAllFilter(){
    
        EarthQuakeParser parser = new EarthQuakeParser(); 
        
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source); 
        
        System.out.println("read data for "+ list.size() +" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        Filter f = new MagnitudeFilter(1.0 , 4.0);
        maf.addFilter(f);
        
        Filter f1 = new DepthFilter(-180000.0 , -30000.0 );
        maf.addFilter(f1);
        
        Filter f2 = new PhraseFilter("any", "o");
        maf.addFilter(f2);
        
        int size = maf.getSize();
        System.out.println("number of used filters: " + size);
        
        ArrayList<QuakeEntry> test = filter(list, maf);
        for(QuakeEntry qe : test){
            //System.out.println("with all filters: " + qe);
        }
        
        System.out.println("number of filtered quakes found : " + test.size());
    }
    
    public void testMatchAllFilter2(){
    
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+ list.size() +" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter magn = new MagnitudeFilter(0.0, 5.0);
        maf.addFilter(magn);
        
        //Location city = new Location(36.1314, -95.9372);
        Location city = new Location(55.7308, 9.1153);
        Filter dist = new DistanceFilter(city, 3000000  );
        maf.addFilter(dist);
        
        Filter phrase = new PhraseFilter("any", "e");
        maf.addFilter(phrase);
        
        int size = maf.getSize();
        System.out.println("Number of filters used: " + size );
        
        ArrayList<QuakeEntry> test = filter(list, maf);
        for(QuakeEntry qe : test){
            //System.out.println("with all filters: " + qe);
            String filterNames = maf.getName();
            System.out.println("names of the filters : " + filterNames);
        }
       // System.out.println("number of filters: " + size);
        System.out.println("number of filtered quakes : " + test.size());
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
