package TestScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

public class HelperMethods {
	
	public static Map<String,String> GetMovieInformation(String sMovieName){
		HashMap hm= new HashMap();
	    
		switch(sMovieName){
			case "To Have and Have Not":
				hm.put("overview","A skipper-for-hire's romance with a beautiful drifter is complicated by his growing involvement with the French resistance.");
				hm.put("actor1","Walter Brennan");
				hm.put("actor2","Sheldon Leonard");
				hm.put("year","1944");
			break;			
			
			case "Fallen Angel":
				hm.put("overview","A man is accused of killing a waitress he had tried to seduce with his wife''s money.");
				hm.put("actor1","Dana Andrews");
				hm.put("actor2","Bruce Cabot");
				hm.put("year","1945");
			break;
			
			case "Thoroughly Modern Millie":
				hm.put("overview","A small-town girl hits the big city in search of romance Roaring Twenties style.");
				hm.put("actor1","Mary Tyler Moore");
				hm.put("actor2","John Gavin");
				hm.put("year","1967");
			break;
			
			case "Rome Adventure":
				hm.put("overview","A rebellious teacher moves to Rome and finds love.");
				hm.put("actor1","Angie Dickinson");
				hm.put("actor2","Al Hirt");
				hm.put("year","1962");
			break;
			
			case "The Secret Garden":
				hm.put("overview","An orphaned girl changes the lives of those she encounters at a remote estate.");
				hm.put("actor1","Herbert Marshall");
				hm.put("actor2","Brian Roper");
				hm.put("year","1949");
			break;
			
			case "Doctor Zhivago":
				hm.put("overview","No information available for this title");
				hm.put("actor1","Keira Knightley");
				hm.put("actor2","Bill Patterson");
				hm.put("year","2003");
			break;
			
			case "Ordinary People":
				hm.put("overview","When a young man drowns, his family fights to recover from the trauma.");
				hm.put("actor1","Mary Tyler Moore");
				hm.put("actor2","Elizabeth Mcgovern");
				hm.put("year","1980");
			break;
			
			case "Magic Town":
				hm.put("overview","A political pollster discovers the perfect cross-section of American tastes and fights to keep it that way.");
				hm.put("actor1","Jane Wyman");
				hm.put("actor2","Regis Toomey");
				hm.put("year","1947");
			break;
			
			case "Caged":
				hm.put("overview","A young innocent fights to survive the harsh life in a women's prison.");
				hm.put("actor1","Agnes Moorehead");
				hm.put("actor2","Jan Sterling");
				hm.put("year","1950");
			break;
			
			case "Condemned Women":
				hm.put("overview","Murder creates an uproar in a women''s prison.");
				hm.put("actor1","Louis Hayward");
				hm.put("actor2","Leona Roberts");
				hm.put("year","1938");
			break;
		}
		
	    return hm;
	}

}
