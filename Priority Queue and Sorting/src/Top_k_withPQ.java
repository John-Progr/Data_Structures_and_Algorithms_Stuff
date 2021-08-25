import java.io.*;
import java.util.Comparator;
public class Top_k_withPQ{
	
	public Top_k_withPQ(int k,String data){
		
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
		
		
		Comparator<Song> cmp=new minComparator();
		PQ<Song> PQ=new PQ<Song>(2*k,cmp);
	    
		
		int info1;
		String info2;
		int info3;
		
	
		line=reader.readLine();
		
		
		while(line!=null){
		 
		
		   
			String inf1=line.trim().substring(0,line.indexOf(" "));
			
			info1=Integer.parseInt(inf1);
			
			
			
			info2=line.substring(inf1.length()+1,line.lastIndexOf(" "));
		    
			info3=Integer.parseInt(line.substring(info2.length()+1+inf1.length()+1,line.length()));
			
			
	
			
			
			if(PQ.size()==k){
				Song a=new Song(info1,info2,info3);
				if(cmp.compare(a,PQ.max())<0){
					PQ.getMax();
					PQ.insert(a);
				}
			
			
					
					
					
					
				
				
				
			
			
				
				
				
				
			}else{
				PQ.insert(new Song(info1,info2,info3));
			}
			line=reader.readLine();
		}
			
			
			
			
				
	
		System.out.println("The top "+k+" Songs are:");
		for(int m=k-1;m>=0;m--){
		
			System.out.println(PQ.getMax().getTitle());
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
	    Top_k_withPQ a=new Top_k_withPQ(Integer.parseInt(args[0]),args[1]);
		
	  }
}