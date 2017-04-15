package ProjectUML;

/*
 * *
 * T V Divyaa
 * code for conversion of java code to UML class diagram.
 * 
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.lang.*;
import static java.lang.System.*;
import java.util.List;

public class Umlgenerator { 
	// puts everything together and invokes for drawing the output. 


public static String input = "@startuml\n";
public static String p;
public static String class_nm;
public static List<String> ls = new ArrayList<String>();
public static List<String> operations = new ArrayList<String>();
public static List<String> interfaces = new ArrayList<String>();

public static void main(String[] args) throws Exception {
	
	/*String path = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\"
			+ "uml-parser-test-5\\";*/
	//String path = "uml-parser-test-5\\";

	  if(args.length<2)
		System.out.println("Please execute in proper format: java -jar <jarname.jar> <classpath> <outputfilename>");
	  
	String path=args[0];
	//System.out.println(path);
	
	//String opPath=args[1];
	
			File file = new File(path);
			
			//File op = new File(path +"\\op.txt");
			//FileWriter fw = new FileWriter(op.getAbsoluteFile());
			//BufferedWriter bw = new BufferedWriter(fw);
			
			
			
			/*File copy_input= new File(path);
			FileOutputStream out = new FileOutputStream(copy_input);
			if(!copy_input.exists())
				copy_input.createNewFile();
			FileWriter fw = new FileWriter(copy_input.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);*/
            
				
			File[] listOfFiles = file.listFiles();
			
			//for(int i=0;i<=listOfFiles.length;i++)
			//System.out.println(listOfFiles[i]);
			


	
			//System.out.println(input); 
	
	
	
	//String folderpath = args[0];
//File folder=new File(args[0]);
//String path=args[0];
//String path= args[0];

	  //if(args.length<2)
		//System.out.println("Please execute in proper format: java -jar <jarname.jar> <classpath> <outputfilename>");
  //String folderpath = args[0];
  //final String pic=args[1]; 
    //System.out.println(folderpath);	
/*String path = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\"
+ "uml-parser-test-1\\";*/
			
			// for scope of the attributes

			input = input + "skinparam classAttributeIconSize 0 \n";

/*File file = new File(path);
String path = file.getAbsolutePath();
File[] listOfFiles = file.listFiles();
input = input + "skinparam classAttributeIconSize 0 \n";*/

for (int i = 0; i < listOfFiles.length; i++) {
String lst= listOfFiles[i].getName();
lst = lst.replaceAll(".java"," ");
//System.out.println(lst);
ls.add(lst);
lst="Collection<"+lst+">";
ls.add(lst);
//System.out.println(ls);
}

File dir = new File(path);
File[] directoryListing = dir.listFiles();
//System.out.println(directoryListing);
if (directoryListing != null) {
	//for(int i=0;i<directoryListing.length;i++)
	//{
		//File child;
		//child=directoryListing[i];	
		//System.out.println(child.getName());
		
for (File child : directoryListing) {
if(child.getName().contains(".java"))
{	
	//System.out.println(child.getName());
	//System.out.println(child.getAbsolutePath());
	 p=child.getAbsolutePath();
	int del=p.lastIndexOf('\\');
	//System.out.println(p.charAt(del));
	
	//System.out.println(del);
	//StringBuilder bulid = new StringBuilder(p);
	//System.out.println(p);
	p=removeCharAt(p,del-1);
	p=removeCharAt(p,del-1);
	
	//p=removeCharAt(p,del);
	
	//String a_path=deleteCharAt(p,57);
	//bulid.deleteCharAt(57);
	//System.out.println(p);			
		
	
FileInputStream in = new FileInputStream(p);
//String name=in.toString();
//System.out.println(name);
CompilationUnit cu;
try {

cu = JavaParser.parse(in);
}
finally {
in.close();
}
String s = cu.toString();

System.out.println(s);

String lines[] = s.split("\\r?\\n");
String delims = "[ .,?!]+";
String[] tokens = lines[0].split(delims);



List types = cu.getTypes(); 

//System.out.println(input); 

TypeDeclaration typeDec = (TypeDeclaration) types.get(0);


class_nm = typeDec.getName();

if(tokens[1].equals("interface"))
	input = input + "interface"+" "  + class_nm + "\n";
if(tokens[1].equals("class"))
	input = input + "class"+" "  + class_nm + "\n";

new FindAttributes().visit(cu, null); 	

new FindConstructor().visit(cu, null);
new FindClass().visit(cu, null);

new FindOperations().visit(cu, null);
new FindInterface().visit(cu, null);


//System.out.println("Test"+class_nm);


}
}
input=input+"@enduml \n";
UmlDiagram d = new UmlDiagram();
d.umlCreator(input);
//bw.write(input);
//bw.write(input);
//bw.close(); 
System.out.println(input); 
}
}
public static String removeCharAt(String s, int pos) {
	   StringBuffer buf = new StringBuffer( s.length() - 1 );
	   buf.append( s.substring(0,pos) ).append( s.substring(pos+1) );
	   return buf.toString();
	}

}


