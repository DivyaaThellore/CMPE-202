package ProjectUML;


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

import java.util.List;

public class Umlgenerator {

public static String input = "@startuml\n";
public static String classname;
public static List<String> list = new ArrayList<String>();
public static List<String> methodlist = new ArrayList<String>();
public static List<String> interfacelist = new ArrayList<String>();
public static void main(String[] args) throws Exception {

String path = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\"
+ "uml-parser-test-1\\";
File folder = new File(path);
File[] listOfFiles = folder.listFiles();
input = input + "skinparam classAttributeIconSize 0 \n";


for (int i = 0; i < listOfFiles.length; i++) {

String lst= listOfFiles[i].getName();
lst = lst.replaceAll(".java", "");
list.add(lst);
lst="Collection<"+lst+">";
list.add(lst);


}
//System.out.println("listin main"+list);

File dir = new File(path);
File[] directoryListing = dir.listFiles();
if (directoryListing != null) {
for (File child : directoryListing) {
if(child.getName().contains(".java"))
{

FileInputStream in = new FileInputStream(child.getAbsolutePath());
CompilationUnit cu;
try {

cu = JavaParser.parse(in);
}
finally {
in.close();
}
String s = cu.toString();

String lines[] = s.split("\\r?\\n");
String delims = "[ .,?!]+";
String[] tokens = lines[0].split(delims);
List types = cu.getTypes(); 



TypeDeclaration typeDec = (TypeDeclaration) types.get(0);


classname = typeDec.getName();

if(tokens[1].equals("interface"))
	input = input + "interface" + " " + classname + "\n";
if(tokens[1].equals("class"))
	input = input + "class" + " " + classname + "\n";

new FindInterface().visit(cu, null);
new FindClass().visit(cu, null);
new FindOperations().visit(cu, null);
new FindAttributes().visit(cu, null);
new FindConstructor().visit(cu, null);

}
}
input = input + "@enduml\n";
UmlDiagram p = new UmlDiagram();
p.umlCreator(input,path);
//System.out.println(input); 
}
}

}


