package seq;
	
	
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



	public aspect GenerateSequence {
		
	


//String outFile= "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-sequence-test\\";
		//outFile="C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-sequence-test\\";
		static String style = "modern-blue";
		static String l;
		pointcut methods():!within(Caller) && 
		!within(GenerateSequence) && execution(public * *.*(..))  && 
		!execution(public static void setUpBeforeClass() )

		&& !execution(public static void tearDownAfterClass())

		 && !execution(*.new(..));
		pointcut constructors() : !within(Caller) && 
		!within(GenerateSequence) && 
		execution(*.new(..));
		private Stack<String> execute = new Stack<String>();

		private String fin = "";

		private int depth = 0;

		private int constructor = 0;

		before():constructors() {
			// push
			constructor++;
		}

		after():constructors() {
			//pop
			constructor--;
		}

		before()  : methods() {

			if (constructor == 0) {

				String cls = thisJoinPoint.getTarget().getClass().getName();

				String cls_one = null;				

				if(execute.isEmpty()){
					//if stack is empty
					cls_one = "Main";
					}
				else
				{
					String name = (String)execute.peek();

					cls_one = name;

				}

				String cls_two = cls;

				String calls = null;

				String now = thisJoinPoint.toString();

				int last = now.lastIndexOf(')');

				String methods = now.substring(10, last );

				String method_members[] = methods.split(" ");

				String first = method_members[1];

				int period = first.indexOf('.');

				String return_msg = method_members[0];

				String run = method_members[1].substring(period + 1);
				calls = run + " : " + return_msg;
				String input = cls_one + " ->";
				input=input+ cls_two + ":" +  " ";
				input=input+ calls + "\n";
				fin += input;
				depth++;
				execute.push(cls_two);

			}

		}

		after() : methods(){
			if (constructor == 0) {
				depth--;
				if (!execute.isEmpty()) {
					execute.pop();
					
				}
				if (depth == 0) {
					drawSequence(fin, "aspects.png");

				}
				//else
				//{
					//System.out.println("do nothing");
				//}

			}

		}
		private static void drawSequence(String text, String file) {

			try {
				System.out.println(text);
			    
				String data = "style=" + style + "&message=" + URLEncoder.encode(text, "UTF-8") + "&apiVersion=1";
				String url_name="http://www.websequencediagrams.com";
				URL url = new URL(url_name);
				URLConnection C = url.openConnection();
				C.setDoOutput(true);

				OutputStreamWriter writer = new OutputStreamWriter(C.getOutputStream());

				writer.write(data);

				writer.flush();				

				StringBuffer output = new StringBuffer();

				BufferedReader r = new BufferedReader(new InputStreamReader(C.getInputStream()));
// while()
				do {
					// out.append();

					output.append(l);

				}while ((l = r.readLine()) != null);

				writer.close();
				r.close();
				String i = output.toString();
				int first = i.indexOf("?png=");
				int last = i.indexOf("\"", first);
				String u="http://www.websequencediagrams.com/";
				u=u+i.substring(first, last);
				url = new URL(u);
				InputStream in = url.openConnection().getInputStream();
				OutputStream o = new BufferedOutputStream(new FileOutputStream(file));
				int x;
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

}
