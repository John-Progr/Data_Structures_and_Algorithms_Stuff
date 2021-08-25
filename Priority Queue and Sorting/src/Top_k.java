import java.io.*;

public class Top_k{
	
	public Top_k(int k,String data){
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
		Song [] Youtube=new Song[getSize(data)];
		int i=0;
		int info1;
		String info2;
		int info3;
		line=reader.readLine();
		
		while(line!=null){
			
		
			String inf1=line.trim().substring(0,line.indexOf(" "));
			
			info1=Integer.parseInt(inf1);
			
			
			
			info2=line.substring(inf1.length()+1,line.lastIndexOf(" "));
		    
			info3=Integer.parseInt(line.substring(info2.length()+1+inf1.length()+1,line.length()));
			Youtube[i]=new Song(info1,info2,info3);
			
			i++;
			line=reader.readLine();
			
			}
			quicksort(Youtube,0,Youtube.length-1);
			printArray(Youtube,k);
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
	
	  
	  public int getSize(String data){
		  int i=0;
		   File v=new File(data);
		   
		   String line;
		   try{
		   BufferedReader f=new BufferedReader(new FileReader(v));
		   
		   try{
		   for(i=0,line=f.readLine();line!=null;i++){
			   
				  line=f.readLine();
		   }
		   }catch (IOException e) {
            System.out.println	("Error reading line ...");
		   }
		   } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        
		}
	  
			   
             
		   
			
		  
		 
		  return i;
	  }
	  public void printArray(Song [] a,int k){
		  System.out.println("The top "+k+" songs are");
		  int length=a.length-1-k;
		  for(int i=a.length-1;i>length;i--){
			 
			  System.out.print(a[i].getTitle());
			  System.out.println();
		  }
	  }
	  //quicksort
	  public  void exch(Song[] a, int i, int j) {
           Song t = a[i]; a[i] = a[j]; a[j] = t; 
	}
		
		
		
	
	
	public void quicksort(Song [] a,int low,int high){
		if(high<=low) return;
		int i=partition(a,low,high);
		quicksort(a,low,i-1);
		quicksort(a,i+1,high);
		
		
			
		
		
		
		
	}
	public int partition(Song [] a,int low,int high){
		int i=low-1,j=high;
		Song pivot=a[high];
		for(;;){
			while(a[++i].compareTo(pivot)<0);
			while(pivot.compareTo(a[--j])<0)
				if(j==low) break;
			if(i>=j) break;
			
			
			
			exch(a,i,j);
		}
			exch(a, i, high);
			
            return i; }
		
		
			
			
		
		
		
		

	
	
	
	
		
		
		  
		  
		  
		  
	  
	 
		
	  
	  
	  public static void main(String[] args) {
	     Top_k a=new Top_k(Integer.parseInt(args[0]),args[1]);
		
	  
	  }
}
	  
	  
	  

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	

	