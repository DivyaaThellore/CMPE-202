package ProjectUML;

import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;





public class FindInterface extends VoidVisitorAdapter {

	/* 
	 * author T V Divyaa
	 * 
	 */


public void visit(ClassOrInterfaceDeclaration decl, Object arg)
{
// Make class extend Blah.


List<ClassOrInterfaceType> list = decl.getImplements();
if(list==null)
return;
for (ClassOrInterfaceType k : list) {
String n = k.toString();
Umlgenerator.interfaces.add(n);
if(!Umlgenerator.input.contains( n + "<|.. " + Umlgenerator.class_nm )
&& !Umlgenerator.input.contains
( n + "<.. " + Umlgenerator.class_nm + ":uses" ))
	Umlgenerator.input = Umlgenerator.input + n + " " + "<|.. " + " " + 
			Umlgenerator.class_nm + "\n";
}



}



}





