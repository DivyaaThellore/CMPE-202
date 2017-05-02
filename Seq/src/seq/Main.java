package seq;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
	import java.util.Stack;
	import java.io.BufferedReader;

import java.io.File;

	import java.io.BufferedOutputStream;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.io.OutputStream;
	import java.io.InputStream;
	import java.net.MalformedURLException;
	import java.net.URLEncoder;
	import java.net.URL;
	import java.net.URLConnection;	
	import org.junit.runner.JUnitCore;

import org.junit.After;

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import org.junit.Test;





public class Main {

	//GenerateSequence s;
	public static String path;



	public static void setUpBeforeClass() throws Exception {//setup

	}




	public static void tearDownAfterClass() throws Exception {//tear down

	}





	public void setUp() throws Exception {//set up

	}




	public void tearDown() throws Exception {// tear down

	}



	@Test
	public void test() {

        TheEconomy s = new TheEconomy();

        Pessimist p = new Pessimist(s);

        Optimist o = new Optimist(s);

        s.attach(p);

        s.attach(o);

        s.setState("The New iPad is out today");

        s.setState("Hey, Its Friday!");

        p.showState();

        o.showState();

	}
	
public String getpath()
	{
		return path;
	}
	
	/*
	
 	public void drawSequence(String text, String file) {

		
		try {
			//System.out.println("");
			System.out.println(path); 
			//System.out.println("");
			System.out.println(text);
			//String outpath= m.path+"Out.txt";
			File f = new File(path+"Out.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close(); 			    
			//System.out.println(text);
			String data = "style=" + s.style + "&message=" + URLEncoder.encode(text, "UTF-8") + "&apiVersion=1";
			String url_name="http://www.websequencediagrams.com";
			URL url = new URL(url_name);
			//URL url = new URL(url_name);
			URLConnection C = url.openConnection();
			boolean flag=true;
			C.setDoOutput(flag);

			OutputStreamWriter writer = new OutputStreamWriter(C.getOutputStream());

			writer.write(data);

			writer.flush();				

			StringBuffer output = new StringBuffer();

			BufferedReader r = new BufferedReader(new InputStreamReader(C.getInputStream()));
//while()
			do {
				// out.append();

				output.append(s.l);

			}while ((s.l = r.readLine()) != null);

			writer.close();
			//r.close
			r.close();
			String i = output.toString();
			
			int first,last,x;
			String u="http://www.websequencediagrams.com/";
			first = i.indexOf("?png=");
			last = i.indexOf("\"", first);				
			u=u+i.substring(first, last);
			url = new URL(u);
			InputStream in = url.openConnection().getInputStream();
			OutputStream o = new BufferedOutputStream(new FileOutputStream(path+file));				
			byte[] str = new byte[1024];
			//int x;
			while ((x = in.read(str)) != -1) {
				//o.write(str, ,);					
				o.write(str, 0, x);
			}

			//in.close();
			//o.clode();
			in.close();
			o.close();
		} 
		
	catch (MalformedURLException e) {				
			//print error.
			System.out.println(e);

		} catch (IOException e) {				
			// catch the error.
			//System.out.println(ex);
			System.out.println(e);

		}

	}
	
	
	*/
	
	
	
	
	
	public static void main(String args[]){
		
		//if(args.length<1)
			//System.out.println("Please specify the path");
				
	//String path="C:\\Users\\T V Divyaa\\Desktop\\FinalTestCases\\sequence\\";
			
	//	path=args[0];
		//System.out.println(getpath());
		
		   
      
		Main m = new Main() ;
	        m.test() ;
	     
	        
	        
		
	}



	
}
