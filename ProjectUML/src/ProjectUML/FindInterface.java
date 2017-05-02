package ProjectUML;
/* 
 * author T V Divyaa
 * 
 */
import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;





public class FindInterface extends VoidVisitorAdapter {


public void visit(ClassOrInterfaceDeclaration n, Object obj)
{
// class to figure out interfaces.


List<ClassOrInterfaceType> inter= n.getImplements();

if(inter==null)
	return;


	// checking. if not null proceed.
	
for (ClassOrInterfaceType i : inter) {//{
	//System.out.printn("check");
	//System.out.println(i.toString());
	
String str = i.toString();//i
UmlParser.interfaces.add(str);
if(!UmlParser.input.contains( str + "<|.. " /*<|--*/+ UmlParser.class_nm )
&& !UmlParser.input.contains
( str + "<.. "/*"<.."*/ + UmlParser.class_nm + ":uses" ))
	//System.out.println("test");
	//UmlParser.input = UmlParser.input;
	

/*UmlParser.input = UmlParser.input+ str;
UmlParser.input = UmlParser.input+ " " + "<|.. "; */

	UmlParser.input = UmlParser.input + str + " ";//+" "+<|--
    UmlParser.input = UmlParser.input + "<|.. " + " " +UmlParser.class_nm + "\n";//UmlParser.class_nm 

//UmlParser.input = UmlParser.input+ " " + UmlParser.class_nm + "\n";

	
}


//}

}
}





