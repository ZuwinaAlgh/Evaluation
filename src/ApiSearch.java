

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import org.xml.sax.ErrorHandler;



public class ApiSearch{

	public static void main(String[] args) throws IOException, InterruptedException {
		boolean menuExit = true;
		Scanner sa = new Scanner(System.in);
	
	   
		while (menuExit) {
			System.out.println("####################");
			System.out.println("1.print API File");
			System.out.println("2.Search Word");
			System.out.println("3.Duplicate Word");
			System.out.println("####################");
			String menu = sa.next();
			int option = Integer.parseInt(menu);
			switch (option) {
			case 1:
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://api.genderize.io/?name=luc"))
			.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			try {
			    FileInputStream fileinputstreem = new FileInputStream(new File("DataFile.txt"));
			    int ch;
			    while ((ch = fileinputstreem.read()) != -1) {
			        System.out.print((char) ch);
			    }
			    fileinputstreem.close();
			    } catch (IOException ex) {
			    ex.printStackTrace();
			    }

			try {
			    BufferedWriter bw = new BufferedWriter(new FileWriter("DataFile.txt"));
			    bw.write(response.body());
			    bw.close();
			    } catch (IOException e) {
			    e.printStackTrace();
			    }

				break;
				
			case 2:
				
				System.out.println("Enter word you want to search it:  ");
			    String words=sa.next();
				boolean search = false;
			    Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\user011\\Desktop\\Evaluation\\DataFile.txt"));
			     while(scanner.hasNextLine()) {
			        String line = scanner.nextLine();
			        System.out.println(line);
			        if(line.indexOf(words)!=-1) {
			        	search = true;
			        }
			       
			     }
			     if(search) {
			        System.out.println("File contains the specified word: "+words);
			     } else {
			        System.out.println("File does not contain the specified word");
			     }
		     
				break;
			
			case 3:
				List<String> listWords = new ArrayList<>();
				Set<String> unique = new HashSet<>();
				System.out.println("Enter first word you want to search it:  ");
			    String word=sa.next();
			    listWords.add(word);
			    System.out.println("Enter second word you want to search it:  ");
			    String word2=sa.next();
			    listWords.add(word2);
				boolean searchs = false;
			    Scanner scanners = new Scanner(new FileInputStream("C:\\Users\\user011\\Desktop\\Evaluation\\DataFile.txt"));
			    
			        for(String word1 : listWords) {
			            if( unique.add( word1 )==true ){
			      	  System.out.println("yes "+word1+"is Found");
			      }
			            else {
			            	 if( unique.add( word2 )==true ){
						      	  System.out.println("yes "+word2+"is Found");
						      }
			            }}
	
				
				break;
			}

		}
		menuExit = false;

	}
}
