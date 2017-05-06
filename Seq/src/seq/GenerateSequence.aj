package seq;
	/*
	 * 
	 * 
	 * 
	 */
	
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Stack;
import java.io.BufferedReader;

import java.io.File;

	import java.io.BufferedOutputStream;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.io.OutputStream;
	
	import java.net.MalformedURLException;
	
	import java.net.URLEncoder;
	import java.net.URL;
	import java.net.URLConnection;	
	import org.junit.runner.JUnitCore;

	public aspect GenerateSequence {
		
	


//String outFile= "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-sequence-test\\";
		//outFile="C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-sequence-test\\";
		public static String style = "modern-blue";
		public static String l;
	Main m=new Main();
	private String path;
		String fpath=m.getpath(path);
	//public String fpath="C:\\Users\\T V Divyaa\\Desktop\\FinalTestCases\\sequence\\";
		
		//"C:\\Users\\divyaavthellore\\Desktop\\FinalTestCases\\sequence\\"
	
	 GenerateSequence() {
		// TODO Auto-generated constructor stub
	}
		//String fpath=Main.getpath();
		pointcut methods():!within(Caller) && //!within(GenerateSequence) 
		!within(GenerateSequence) && execution(public * *.*(..))  && // execution(public * *.
		!execution(public static void setUpBeforeClass() )

		&& !execution(public static void tearDownAfterClass())

		 && !execution(*.new(..));
		pointcut constructors() : !within(Caller)/*!within(GenerateSequence) && */ && 
		!within(GenerateSequence) && 
		execution(*.new(..));//new(...)
		private Stack<String> execute = new Stack<String>();//execute
		 
		private String fin = "";//""
		private int depth = 0;//-
		private int constructor = 0;
		
		before():constructors() {//
			// push
			constructor++;
		}
		after():constructors() {//
			//pop
			constructor--;
		}
		before()  : methods() {//
			if (constructor == 0) {
				String cls = thisJoinPoint.getTarget().getClass().getName();//.getTarget().getClass()
				String cls_one = null;	//null			
				if(execute.isEmpty()){
					//if stack is empty
					cls_one = "Main";
					}
				else
				{String name = (String)execute.peek();//peek
					cls_one = name;
				}
				int period;
				String methods,first,return_msg;
				String run,input;
				String cls_two = cls;
				String calls = null;
				String now = thisJoinPoint.toString();
				int last = now.lastIndexOf(')')/*now.lastIndexOf(')'*/;
				
				methods= now.substring(10, last );
				String method_members[] = methods.split(" ");
				//String ;
				first= method_members[1];//first				
				period= first.indexOf('.');//.
				//String ;
				return_msg= method_members[0];
				 run = method_members[1].substring(period + 1);
				calls = run + " : " + return_msg;
				 input = cls_one +/*":" +  " "*/ " ->";
				input=input+ cls_two +/*":" +  " "*/ ":" +  " ";
				input=input+ calls + "\n";//calls
				fin += input;
				depth++;//++;
				execute.push(cls_two);//push

			}
			//}
		}
// check
		
		after() : methods(){//
			
			if (constructor == 0) //{
			{
				depth--;//--
				if (!execute.isEmpty())	{
					execute.pop();	//pop				
				}
				if (depth == 0)	{
					//System.out.println(fin);
												
					//drawSequence(fin,"aspects.png");
					drawSequence(fin,"aspects.png");
						
				}
				//else
				//{
					//System.out.println("do nothing");
				//}

			}

		}
				

	
		private void drawSequence(String text, String file) {

			
			try {
			
				System.out.println("");
				System.out.println("path"+fpath);
				System.out.println("");
				System.out.println(text);
				//String outpath= m.path+"Out.txt";
				File f = new File(fpath+"Out.txt");
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(text);
				bw.close(); 			    
				//System.out.println(text);
				String data = "style=" + style + "&message=" + URLEncoder.encode(text, "UTF-8") +/*apiVersion*/ "&apiVersion=1";//
				String url_name="http://www.websequencediagrams.com";
				URL url = new URL(url_name);
				//URL url = new URL(url_name);
				URLConnection C = url.openConnection();//connect
				boolean flag=true;
				C.setDoOutput(flag);//flag
				OutputStreamWriter writer = new OutputStreamWriter(C.getOutputStream());
				writer.write(data);//write(data);
				writer.flush();	//flush	
				StringBuffer output = new StringBuffer();//:;
				BufferedReader r = new BufferedReader(new InputStreamReader(C.getInputStream())); //BufferedReader r
// while()
				do {// out.append();
					output.append(l);
				}while ((l = r.readLine()) != null);//!null
				writer.close();
				//r.close
				r.close();
				int first,last,x;
				String i,u;
				i = output.toString();				
				 u="http://www.websequencediagrams.com/";
				first = i.indexOf("?png=");
				last = i.indexOf("\"",first);	//last			
				u=u+i.substring(first, last);
				url = new URL(u);//new URL(u);
				InputStream in = url.openConnection().getInputStream();//url.openConnection()
				OutputStream o = new BufferedOutputStream(new FileOutputStream(fpath+file));				
				byte[] str = new byte[1024];
				//int x;
				while ((x = in.read(str)) != -1) {
					//o.write(str, ,);					
					o.write(str, 0, x);//(str,,)
				}

				//in.close();
				//o.clode();
				in.close();
				o.close();
			} 
			
		catch (MalformedURLException e) {		//print error.				
				System.out.println(e);

			} 
			catch (IOException e) {		// catch the error.				
				//System.out.println(ex);
				System.out.println(e);

			}

		}
		//}
}
