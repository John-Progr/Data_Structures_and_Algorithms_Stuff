import java.io.*;


public class NetBenefit{
       IntQueueImpl<Integer> q1=new IntQueueImpl<Integer>();//h lista pou tha bazoume tis metoxes(pou agorasthkan) kai tis times pou tis agorasame
	   ListNode<Integer> n1=new ListNode<Integer>(null);//to node pou tha topothetoume proswrina tis metoxes pou perissepsan apo thn pwlhsh kai prepeio na xrhsimopoihthoun prwtes sthn epomenh pwlhsh
	   ListNode<Integer> n2=new ListNode<Integer>(null);//to node pou tha topothetoume thn timh twn metoxwn pou perissepsan
	   
       public  NetBenefit(String data){
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
		line=reader.readLine();
		int synoliko=0;//metablhth h opoia tha deixnei sto telos ths kathe pwlhshs to kerdos h thn zhmeia
		int k=0;//methrhs opou sto telos tha enhmerwnei ton xrhsth se poia pwlhsh pwlithikan perissoteres metoxes apo oses eixe sthn katoxh tou
		while(line!=null){
		  if(line.trim().startsWith("buy")){
			q1.put((Integer.parseInt(line.trim().substring(line.trim().indexOf("buy")+4,line.trim().indexOf("price")-1))));//arithmos metoxwn pou agorase o xrhsths
			q1.put(Integer.parseInt(line.trim().substring(line.trim().indexOf("price")+6)));//timh metoxwn
	      }else if(line.trim().startsWith("sell")){
		   int metoxes_pwlhshs=Integer.parseInt(line.trim().substring(line.trim().indexOf("sell")+5,line.trim().indexOf("price")-1));//metablhth gia tis metoxes pou poulithikan
		   int timi_pwlhshs=Integer.parseInt(line.trim().substring(line.trim().indexOf("price")+6));//metablhth gia thn timh twn metoxwn pou tis poulhse o xrhsths
		   int metoxes_agora;//metablhth gia ton arithmo metoxwn pou agorase o xrhsths 
		   int timi_agoras;//metablhth gia thn timi twn metoxwn pou agorase o xristis
		   boolean isit=true;//boolean metablhth h opoia tha mas deiksei sto telos,an exei dhmiourgithei kapoio sfalma sthn pwlhsh twn metoxwn(pio polles apo oti exei o xrhsths)
		   k++;
		   while(metoxes_pwlhshs>0){
		    if(n1.getData()==null && !q1.isEmpty()){//an to node einai adeio shmainei oti den yparxoun metoxes pou exoun perissepsei h perissepsan kai eksantlhthikan ara tha paroume metoxes apo thn oura 
			   metoxes_agora=q1.get();
		       timi_agoras=q1.get();
			  if(metoxes_agora<=metoxes_pwlhshs){
			    metoxes_pwlhshs=metoxes_pwlhshs-metoxes_agora;
				synoliko=metoxes_agora*(timi_pwlhshs-timi_agoras)+synoliko;
			  }else{
			    synoliko=metoxes_pwlhshs*(timi_pwlhshs-timi_agoras)+synoliko;
				metoxes_pwlhshs=metoxes_pwlhshs-metoxes_agora;
				n1.setData(-metoxes_pwlhshs);//bazoume thn plhroforia ayth sto ena node giati exoume perisseia metoxwn,etsi wste sto epomeno sell na epileksei to deytero if
				n2.setData(timi_agoras);//h timi tha mpei sto deytero node etsi wste na einai prosbasimi gia tis metoxes(poy perissepsan) pou tha doulepsoume sto epomeno sell
			  }
		    }else if(n1.getData()!=null){//an to node den einai null,perissepsan metoxes ara sto sell tha xrhsimopoithoun aytes apo to node
		    metoxes_agora=n1.getData();
			timi_agoras=n2.getData();
			if(metoxes_agora<metoxes_pwlhshs){
			    metoxes_pwlhshs=metoxes_pwlhshs-metoxes_agora;
				synoliko=metoxes_agora*(timi_pwlhshs-timi_agoras)+synoliko;
				n1.setData(null);
				n2.setData(null);
			  }else{
			    synoliko=metoxes_pwlhshs*(timi_pwlhshs-timi_agoras)+synoliko;
				metoxes_pwlhshs=metoxes_pwlhshs-metoxes_agora;
				n1.setData(-metoxes_pwlhshs);
				n2.setData(timi_agoras);
			 }
		}else{//den ikanopoieitai kamoia sinthiki apo tis parapanw ara ligoteres metoxes 
		 System.out.println("ligoteres metoxes sthn "+k+" h pwlhsh");
		 isit=false;
		 break;
		 }
		}
		if(isit){System.out.println("to synoliko kerdos h zhmia "+synoliko);}else{break;}//an isit=true tote tha typwnei to kerdos h zhmia,an oxi shmainei oti exoume ligoteres metoxes ara kai to programma tha stamataei
	  }
	  line=reader.readLine();
	 }//TELOS
	 
	 
	 }
			  
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
	   NetBenefit k=new NetBenefit(args[0]);
	  
	  }
	
	
	
	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
