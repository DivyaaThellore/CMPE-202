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


public void visit(ClassOrInterfaceDeclaration n, Object obj)
{
// class to figure out interfaces.


List<ClassOrInterfaceType> inter= n.getImplements();

if(inter==null)
	return;


	// checking. if not null proceed.
	
for (ClassOrInterfaceType i : inter) {
	//System.out.printn("check");
	System.out.println(i.toString());
	
String str = i.toString();
Umlgenerator.interfaces.add(str);
if(!Umlgenerator.input.contains( str + "<|.. " + Umlgenerator.class_nm )
&& !Umlgenerator.input.contains
( str + "<.. " + Umlgenerator.class_nm + ":uses" ))
	//System.out.println("test");
	//Umlgenerator.input = Umlgenerator.input;
	

/*Umlgenerator.input = Umlgenerator.input+ str;
Umlgenerator.input = Umlgenerator.input+ " " + "<|.. "; */

	Umlgenerator.input = Umlgenerator.input + str + " " + "<|.. " + " " +Umlgenerator.class_nm + "\n";

//Umlgenerator.input = Umlgenerator.input+ " " + Umlgenerator.class_nm + "\n";

	
}




}
}





