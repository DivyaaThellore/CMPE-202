package ProjectUML;

	/*
	 * *
	 * T V Divyaa
	 * code for conversion of java code to UML class diagram.
	 * 
	 */
	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.io.FileOutputStream;
	import japa.parser.JavaParser;
	import japa.parser.ast.CompilationUnit;
	import japa.parser.ast.body.FieldDeclaration;
	import japa.parser.ast.body.TypeDeclaration;
	import japa.parser.ast.body.ConstructorDeclaration;
	import japa.parser.ast.body.ClassOrInterfaceDeclaration;
	import japa.parser.ast.body.MethodDeclaration;

	import japa.parser.ast.stmt.Statement;
	import japa.parser.ast.body.Parameter;
	import japa.parser.ast.type.ClassOrInterfaceType;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	import net.sourceforge.plantuml.SourceStringReader;

	import java.io.File;
	import java.util.ArrayList;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.lang.*;
	import static java.lang.System.*;
	import java.util.List;

	public class UmlParser {
		
		// class for parsing...
	public static String input = "@startuml\n";//@startuml
	public static String class_nm;
	//public String class_nm;
	public static List<String> interfaces = new ArrayList<String>();//ArrayList<String>()
	public static List<String> operations = new ArrayList<String>();//ArrayList<String>()
	
	public static List<String> ls = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
	//String path = args[0];
	//String path = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-parser-test-2\\";
		
		if(args.length < 2) 


			System.out.println("Please give the corrrect format. \n \" java -jar <project.jar> <classpath> <outputfilename>\"");
		
	//System.out.println(path);
		//UmlDiagram p = new UmlDiagram();
		String path=args[0];
		String oppath=args[1];
		//System.out.println(oppath);
		System.out.println(path);

	//File[] listOfFiles = folder.listFiles();
		File file = new File(path);
		//System.out.println(path);
		
		File op = new File(path +"\\op.txt");
		

		FileWriter fw = new FileWriter(op);
		BufferedWriter bw = new BufferedWriter(fw);
		
		File[] Filesls ;
		Filesls = file.listFiles();
		//input=input+ "!pragma graphviz_dot jdot";

	input = input + "skinparam classAttributeIconSize 0 \n";
	//specific to Plant UML

	for (int i = 0; i < Filesls.length; i++) {
		
	System.out.println(Filesls[i]);

	String k= Filesls[i].getName();
	//System.out.println(k);

	k = k.replaceAll(".java","");//replace
	//System.out.println(k);
	ls.add(k);//add
	// for ( int i:ls)
	// System.out.printn(ls);

	k="Collection<"+k+">";//">"
	ls.add(k);//
	//System.out.println("print------"+k);

	}

	//System.out.println(list);
	//File dir = new File(args[0]);
	File folder = new File(path);

	File[] directoryls = folder.listFiles();
	// list file in the folder.
	if (directoryls != null) {//{
		// if not null
	for (File f : directoryls) {
	if(f.getName().contains(".java"))
	{//if the file is a java file parse it.
	FileInputStream in = new FileInputStream(f.getAbsolutePath());//file
	CompilationUnit cu;
	try 
	{
		//
	cu = JavaParser.parse(in);
	}//
	finally {
		// close the FileInputStream object
		
	in.close();//close()
	}

	String str = cu.toString();//str

	String lines[] = str.split("\\r?\\n");
	//for(int i:ines.length)
	//System.out.println( lines[]);
	String id;
	id = "[ .,?!]+";
	// for checking.

	String[] s = lines[0].split(id);
	List list = cu.getTypes(); 
	//List types1 = cu.getTypes();


	TypeDeclaration type = (TypeDeclaration) list.get(0);


	class_nm = type.getName();
	//System.out.printn(cass_nm);

	if(s[1].equals("class"))
	{// adding classes
		input = input + "class" + " ";//class_nm;
		
		input = input + class_nm;
	input = input +"\n";	
	}
	else if(s[1].equals("interface")){
		// adding interfaces
		input = input + "interface" + " " ;
	input = input + class_nm + "\n";
	}

	else System.out.println("");
	// do nothing.


	new FindClass().visit(cu, null);
//new FindInterface().visit(cu, null);
	new FindConstructor().visit(cu, null);
		new FindInterface().visit(cu, null);

		new FindAttributes().visit(cu, null);
		//new FindOperations().visit(cu, null)
	new FindOperations().visit(cu, null);}
	}

	input = input + "@enduml\n";
	System.out.println("\n");

	System.out.println(input);
	// call on umlcreator () in umdiagram.
	//p.drawPic(input,path);

	//Systm.out.pritn(path);
	//bw.write(input);
	// write into output file.

	//System.out.printn(path);
		//OutputStream png = null;
			OutputStream pic = null;
			SourceStringReader src = new SourceStringReader(input);//input
		try {	pic = new FileOutputStream(path+"//pic.jpeg");
		//System.out.println(pic.getAbsolutePath());
		// try to catch the error on catch block.
		} 
		catch (FileNotFoundException e) {
			// handle error if file cannot be located.
			System.out.println("e");
		
		}
		
		
		try { src.generateImage(pic);
		// print the error.
		} 
		catch (IOException e) {
			// print  the error .
			System.out.println("encountered problems");//problems
			System.out.println("do nothing");}




	bw.write(input);
	bw.close(); 

	//System.out.println(input);
	 
	}

	}
	}

	






