package ProjectUML;

/* 
 * author T V Divyaa
 * 
 */

import japa.parser.ast.visitor.VoidVisitorAdapter;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;

public class FindConstructor extends VoidVisitorAdapter {

public void visit(ConstructorDeclaration n, Object obj) {
	
String p =null;

if(n.getParameters()!=null)
{for(Parameter x : n.getParameters())
{//System.out.println("classname:");
//System.out.println(UmlParser.class_nm);
	//System.out.println(UmlParser.class_nm);
//System.out.println("-----------");
//System.out.print(x.toString());

if(p == null)
{
	p = x.toString();
}
else 
{
	p = p + "," + x.toString();
}

String flag;// set flag

flag = x.getType().toString();// set value

//System.out.println("check :"+flag);
// if flag is present...
if(UmlParser.ls.contains(flag))
{// checking another condition.
if(!UmlParser.input.contains(flag + "<.. " + UmlParser.class_nm + ":uses")&& UmlParser.interfaces.contains(flag)&& !UmlParser.interfaces.contains(UmlParser.class_nm))
UmlParser.input = UmlParser.input + flag + "<.. " + UmlParser.class_nm + ":uses" + "\n";}
} 
}
UmlParser.input = UmlParser.input + UmlParser.class_nm;
// System.ouyt.println(UmlParser.input);
UmlParser.input = UmlParser.input + " : "+ "+" + n.getName() + "("+ p +")" ;
//System.ouyt.println(UmlParser.input);
UmlParser.input = UmlParser.input + "\n";
//System.ouyt.println(UmlParser.input);
//System.ouyt.println(UmlParser.input);
}




}







