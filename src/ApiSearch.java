
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;




public class ApiSearch {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sa=new Scanner(System.in);
	   
	
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
	
	 
	System.out.println("Enter word you want to search it:  ");
    String word=sa.next();
	boolean search = false;
    Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\user011\\Desktop\\Evaluation\\DataFile.txt"));
     while(scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
        if(line.indexOf(word)!=-1) {
        	search = true;
        }
     }
     if(search) {
        System.out.println("File contains the specified word: "+word);
     } else {
        System.out.println("File does not contain the specified word");
     }
     
     
    
	  

  

}	
}
