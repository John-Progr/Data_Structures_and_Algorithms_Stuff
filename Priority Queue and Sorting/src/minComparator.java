import java.util.Comparator;
public class minComparator implements Comparator<Song>{
	
	public int compare(Song s1,Song s2){
		int x;
		
		
		if(s1.getLikes()==s2.getLikes()){
			
			x=-s1.compareTo(s2);
			
		}
		else if(s1.getLikes()<s2.getLikes()){
			
			x=1;
		}
		
		else {
			x=-1;
		}
		
			
			return x;
	}

	
}