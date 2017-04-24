package ProjectUML;
/* 
 * author T V Divyaa
 * 
 */


import java.util.List;

import japa.parser.ast.visitor.VoidVisitorAdapter;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import ProjectUML.UmlParser;

import japa.parser.ast.type.ClassOrInterfaceType;



public class FindClass extends VoidVisitorAdapter {

public void visit(ClassOrInterfaceDeclaration c, Object obj)
// Class to detect classes
{

//System.out.println(" 
List<ClassOrInterfaceType> cls = c.getExtends();

if(cls!=null){

for (ClassOrInterfaceType i : cls)
	// iterate through to give names.
{
String str;
str= i.toString();
UmlParser.input = UmlParser.input + str + " " + "<|--" + " " + UmlParser.class_nm + "\n";
}
}
else
	return;
}
}
