package Test;
import java.awt.Desktop;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.*;
import java.util.Scanner;

public class URLreaderTest {

	public static void main(String args[]) throws UnsupportedEncodingException, MalformedURLException, IOException {
		Scanner sc = new Scanner(System.in);  
		String a = null;
		System.out.println("Please type the name of stock:" );
		String Name=sc.nextLine();
		System.out.println("Please type the index of stock:");
		String Index=sc.nextLine();
		String url = "https://www.google.com/finance/quote/"+ Name+":"+ Index;
		File f = new File("source.htm");
       BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url).openConnection().getInputStream(), "UTF-8"));
		
		//while ((a = in.readLine()) != null) {
			//if (a.contains("YMlKec fxKbKc"))
			//{
		//	System.out.print(a);
			//	}
			//}
		String string=null;
		while((string=in.readLine())!=null){
			bw.write(string);
			bw.flush();
		}
		
		HTMLTEST h = new HTMLTEST();
		h.openExplorer("source.htm");
		
	}
}
