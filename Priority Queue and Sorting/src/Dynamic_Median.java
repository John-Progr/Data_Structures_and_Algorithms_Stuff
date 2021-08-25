import java.io.*;
import java.util.Comparator;
public class Dynamic_Median{
	
	public Dynamic_Median(String data){
		
	File f = null;
    BufferedReader reader = null;
	String line;
	    
		try {
            f = new File(data);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }
			
        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        
		}
	

		
       
		
	
	
		
		
		
	   

		
		
		
		try {//ARXH
		
		int k=0;
	
		
		
	    
		
		int info1;
		String info2;
		int info3;

		
		Song median=null;
		Comparator<Song> cmp1=new maxComparator();
		Comparator<Song> cmp2=new minComparator();
		PQ<Song> PQ1=new PQ<Song>(260,cmp1);
		PQ<Song> PQ2=new PQ<Song>(260,cmp2);
	
		line=reader.readLine();
		
		
		while(line!=null){
			if(PQ1.size()+PQ2.size()==0){
				
			String inf1=line.trim().substring(0,line.indexOf(" "));
			
			info1=Integer.parseInt(inf1);
			
			
			
			info2=line.substring(inf1.length()+1,line.lastIndexOf(" "));
		    
			info3=Integer.parseInt(line.substring(info2.length()+1+inf1.length()+1,line.length()));
			Song b=new Song(info1,info2,info3);
			median=b;
			PQ1.insert(b);
			
			}else{
				
			
 			
		 
		
		   
			String inf1=line.trim().substring(0,line.indexOf(" "));
			
			info1=Integer.parseInt(inf1);
			
			
			
			info2=line.substring(inf1.length()+1,line.lastIndexOf(" "));
		    
			info3=Integer.parseInt(line.substring(info2.length()+1+inf1.length()+1,line.length()));
			Song a=new Song(info1,info2,info3);
			
			
				if(cmp1.compare(a,median)>0){
					PQ2.insert(a);
					
				}else{
					PQ1.insert(a);
				}
				
			if(PQ1.size()==PQ2.size()+1){
				median=PQ1.max();
			}else if(PQ2.size()==PQ1.size()+1){
				median=PQ2.max();
			}else if(PQ1.size()==PQ2.size()){
				median=PQ2.max();
				
			}else if(PQ1.size()>=PQ2.size()+2){
				PQ2.insert(PQ1.getMax());
				median=PQ2.max();
				
				
				
			}else if(PQ2.size()>=PQ1.size()+2){
				PQ1.insert(PQ2.getMax());
				median=PQ2.max();
				
				
				
			}
			
			
			    if((PQ1.size()+PQ2.size())%5==0){
				System.out.println("Median="+median.getLikes()+" likes,achieved by Song: " + median.getTitle() );
				}
			
			
			}
			
			
			
			
			line=reader.readLine();
		}
		
			
			
			
			
			
			 
			
			
		}//TELOS
			  
       catch (IOException e) {
            System.out.println	("Error reading line ...");
      }
	  
	  
	  
	  
	  
	   try {
            reader.close();
      }
      catch (IOException e) {
            System.err.println("Error closing file.");
      }
	}
	
	  
	  public static void main(String[] args) {
	     Dynamic_Median a=new Dynamic_Median(args[0]);
	  }
}