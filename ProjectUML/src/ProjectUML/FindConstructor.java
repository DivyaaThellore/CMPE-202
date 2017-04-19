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
{System.out.println("classname:");System.out.println(Umlgenerator.class_nm);
	//System.out.println(Umlgenerator.class_nm);
System.out.println("-----------");
System.out.print(x.toString());

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

System.out.println("check :"+flag);
// if flag is present...
if(Umlgenerator.ls.contains(flag))
{// checking another condition.
if(!Umlgenerator.input.contains(flag + "<.. " + Umlgenerator.class_nm + ":uses")&& Umlgenerator.interfaces.contains(flag)&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))
Umlgenerator.input = Umlgenerator.input + flag + "<.. " + Umlgenerator.class_nm + ":uses" + "\n";}
} 
}
Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm;
// System.ouyt.println(Umlgenerator.input);
Umlgenerator.input = Umlgenerator.input + " : "+ "+" + n.getName() + "("+ p +")" ;
//System.ouyt.println(Umlgenerator.input);
Umlgenerator.input = Umlgenerator.input + "\n";
//System.ouyt.println(Umlgenerator.input);
//System.ouyt.println(Umlgenerator.input);
}




}







