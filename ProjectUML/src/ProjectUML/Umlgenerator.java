package ProjectUML;


// all the import files needed.
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class Umlgenerator {

public static String s = "@startuml\n";
public static String classname;
public static List<String> list = new ArrayList<String>();
public static List<String> methodlist = new ArrayList<String>();
public static List<String> interfacelist = new ArrayList<String>();
public static void main(String[] args) throws Exception {

String folderpath = "C:\\Users\\T V Divyaa\\Desktop\\TestCases\\"
+ "uml-parser-test-1\\";
File folder = new File(folderpath);
File[] listOfFiles = folder.listFiles();
s = s + "skinparam classAttributeIconSize 0 \n";


for (int i = 0; i < listOfFiles.length; i++) {

String k= listOfFiles[i].getName();
k = k.replaceAll(".java", "");
list.add(k);
k="Collection<"+k+">";
list.add(k);


}
System.out.println("listin main"+list);

File dir = new File(folderpath);
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
String temp = cu.toString();

String lines[] = temp.split("\\r?\\n");
String delims = "[ .,?!]+";
String[] tokens = lines[0].split(delims);
List types = cu.getTypes(); 



TypeDeclaration typeDec = (TypeDeclaration) types.get(0);


classname = typeDec.getName();

if(tokens[1].equals("interface"))
s = s + "interface" + " " + classname + "\n";
if(tokens[1].equals("class"))
s = s + "class" + " " + classname + "\n";
// visit and print the methods names
//to find interface //new FindInterface().visit(cu, null);
new FindClass().visit(cu, null);
//to find methods//new FindMethod().visit(cu, null);
//to find attributes//new FindField().visit(cu, null);
new FindConstructor().visit(cu, null);

}
}
s = s + "@enduml\n";
//for plant uml object//PlantumlTest p = new PlantumlTest();
//p.umlCreator(s,folderpath);
System.out.println(s); 
}
}

}


