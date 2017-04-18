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
	
public static String input = "@startuml\n";
public static String class_nm;
public static List<String> ls = new ArrayList<String>();
public static List<String> operations = new ArrayList<String>();
public static List<String> interfaces = new ArrayList<String>();
public static void main(String[] args) throws Exception {
// creates an input stream for the file to be parsed

//String folderpath = args[0];
//String path = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\uml-parser-test-2\\";

//System.out.println(folderpath);
	String path=args[0];
	System.out.println(path);
	
//File folder = new File(folderpath);
//File[] listOfFiles = folder.listFiles();
	File file = new File(path);
	//System.out.println(path);
	File op = new File(path +"\\op.txt");
	

	FileWriter fw = new FileWriter(op);
	BufferedWriter bw = new BufferedWriter(fw);
	
	File[] listOfFiles = file.listFiles();

input = input + "skinparam classAttributeIconSize 0 \n";
//specific to Plant UML

for (int i = 0; i < listOfFiles.length; i++) {
System.out.println(listOfFiles[i]);
String k= listOfFiles[i].getName();
k = k.replaceAll(".java", "");
ls.add(k);
k="Collection<"+k+">";
ls.add(k);
//System.out.println("print------"+k);

}
System.out.println("listin main"+ls);
//System.out.println(list);
//File dir = new File(args[0]);
File dir = new File(path);
File[] directoryListing = dir.listFiles();
if (directoryListing != null) {
for (File child : directoryListing) {
if(child.getName().contains(".java"))
{

FileInputStream in = new FileInputStream(child.getAbsolutePath());
CompilationUnit cu;//the object that can traverse ur file and can get
//all your method names etc..
try {

cu = JavaParser.parse(in);
}
finally {
in.close();
}
String temp = cu.toString();
//System.out.println(temp);
String lines[] = temp.split("\\r?\\n");
String delims = "[ .,?!]+";
String[] tokens = lines[0].split(delims);
List types = cu.getTypes(); 
//List types1 = cu.getTypes();


TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
//part of ast, Java Parser

class_nm = typeDec.getName();

if(tokens[1].equals("interface"))
	input = input + "interface" + " " + class_nm + "\n";
if(tokens[1].equals("class"))
	input = input + "class" + " " + class_nm + "\n";
// visit and print the methods names
new FindInterface().visit(cu, null);
new FindClass().visit(cu, null);
new FindOperations().visit(cu, null);
new FindAttributes().visit(cu, null);
new FindConstructor().visit(cu, null);
// System.out.println("List in main function"+Umlgen.list);
}
}
input = input + "@enduml\n";
UmlDiagram p = new UmlDiagram();
p.umlCreator(input,path);
//bw.write(input);
bw.write(input);
bw.close(); 

System.out.println(input); 
}

}

}



