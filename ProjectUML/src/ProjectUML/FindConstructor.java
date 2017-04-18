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
{
for(Parameter x : n.getParameters())
{System.out.println("classname:"+Umlgenerator.class_nm);
	//System.out.println(Umlgenerator.class_nm);
System.out.println("xxxxxxx:"+x.toString());

if(p != null)
p = p + "," + x.toString();
else 
{
p = x.toString();
}
String flag = x.getType().toString();
System.out.println("check :"+flag);
if(Umlgenerator.ls.contains(flag))
{
if(!Umlgenerator.input.contains(flag + "<.. " + Umlgenerator.class_nm + ":uses")&& Umlgenerator.interfaces.contains(flag)&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))
Umlgenerator.input = Umlgenerator.input + flag + "<.. " + Umlgenerator.class_nm + ":uses" + "\n";
}
} 
}
Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : "+ "+" + n.getName() + "("+ p +")" ;

Umlgenerator.input = Umlgenerator.input + "\n";
}




}







