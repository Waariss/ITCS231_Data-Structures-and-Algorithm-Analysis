import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
// Waris Damkham 6388014 Sec 1
public class project2 {
   public static void main(String args[]) throws IOException 
   {
	  HashMap<String, String> countrymap = new HashMap<String, String>();
	  HashMap<String, Integer> postcodemap = new HashMap<String, Integer>();
      HashMap<String, String> provincemap = new HashMap<String, String>();
      HashMap<String, Float> latitudemap = new HashMap<String, Float>();
      HashMap<String, Float> longitudemap = new HashMap<String, Float>();
	  BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\ICT ปี2\\ITCS231_Data Structures and Algorithm Analysis\\Project 2\\TH.txt"));
	  String data="";
	  while((data = read.readLine()) != null) 
	  {   
		  if(data.trim() != null && !data.trim().isEmpty())
		  {
			  String[] line = data.split("\t");
			  String country = line[0];
			  Integer postcode = Integer.parseInt(line[1]);
			  String place = line[2];
			  String province = line[3];
			  Float latitude = Float.parseFloat(line[9]);
			  Float longitude = Float.parseFloat(line[10]);
			  countrymap.put(place, country);
			  postcodemap.put(place, postcode);
			  provincemap.put(place, province);
			  latitudemap.put(place, latitude);
			  longitudemap.put(place, longitude);
		  }
	  }
	  read.close();
      Scanner scc = new Scanner(System.in);
      Scanner sc = new Scanner(System.in);
      System.out.println("How many times to generate?");
      int num = sc.nextInt();
      for(int i=0; i<num; i++)
      {
    	  System.out.println("Enter Name of place what you want to know: ");
    	  String Data = scc.nextLine(); 
    	  if(postcodemap.containsKey(Data) == true || countrymap.containsKey(Data) == true || provincemap.containsKey(Data) == true || latitudemap.containsKey(Data) == true || longitudemap.containsKey(Data) == true)
    	  {
    		  System.out.println("*************************************");
    		  System.out.println("Information");  
    		  System.out.println(Data +" are in country: " + countrymap.get(Data) + (" that stands for Thailand"));  
    		  System.out.println(Data + " postcode is: "  + postcodemap.get(Data));  
    		  System.out.println(Data + " province is: " + provincemap.get(Data));  
    		  System.out.println(Data + " is in latitude is: " + latitudemap.get(Data));
    		  System.out.println(Data + " is in longitude is: " + longitudemap.get(Data));
    		  System.out.println("*************************************");
    	  }
    	  else
    	  {
    		  System.out.println("*************************************");
    		  System.out.println(Data + " not found");  
    		  System.out.println("*************************************");
    	  }
      }
      System.out.println("Thank you for using this program :D");  
      scc.close();
   	}
   }