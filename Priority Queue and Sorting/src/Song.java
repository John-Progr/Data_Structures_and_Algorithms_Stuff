
import java.lang.Comparable.*;
public class Song implements Comparable<Song>{
	
	
	//pedia song
	private int id;
	private String title;
	private int likes;
	private static int songNumber;
	
	

	public Song(int id,String title,int likes){
		setId(id);
		setTitle(title);
		setLikes(likes);
		songNumber++;
	}
	//getters kai setters twn pediwn
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		if(id>=1 && id<=9999){
			this.id=id;	
		}else{
			System.out.println("Error in the "+songNumber+" song");
			System.out.println("id should be between 1 and 9999");
			throw new NullPointerException();
			
		}
		
		
	}
	
	public String getTitle(){
		return title;	
	}
	
	public void setTitle(String title){
		if(title.length()<=80){
			this.title=title;
		}else{
			System.out.println("title shouldn't exceed 80 character limit");
			throw new NullPointerException();
			
		
	    }
		
	}
	public int getLikes(){
		return likes;	
	}
	
	public void setLikes(int likes){
		this.likes=likes;
	}
	
	
	public int compareTo(Song a) {
		int x;
		
		
		if(this.getLikes()==a.getLikes()){
			
			x=-this.getTitle().compareTo(a.getTitle());
		}
		else if(this.getLikes()>a.getLikes()){
			
			x=1;
		}
		
		else {
			x=-1;
		}
		
			
			return x;
	}
	
	
	
	
	
	
	
	}
	
	
	
	
		