package ProjectUML;



import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindConstructor extends VoidVisitorAdapter {



@Override
public void visit(ConstructorDeclaration n, Object arg) {
String param =null;
if(n.getParameters()!=null)
{
for(Parameter x : n.getParameters())
{ System.out.println("classname:"+Umlgenerator.classname);
System.out.println("xxxxxxx:"+x.toString());

if(param != null)
param = param + "," + x.toString();
else 
param = x.toString();
String check = x.getType().toString();
System.out.println("check :"+check);
if(Umlgenerator.list.contains(check))
{
if(!Umlgenerator.s.contains(check + "<.. " + Umlgenerator.classname + ":uses")&& Umlgenerator.interfacelist.contains(check)&& !Umlgenerator.interfacelist.contains(Umlgenerator.classname))
	Umlgenerator.s = Umlgenerator.s + check + "<.. " + Umlgenerator.classname + ":uses" + "\n";
}
} 
}
Umlgenerator.s = Umlgenerator.s + Umlgenerator.classname + " : "+ "+" + n.getName() + "("+ param +")" ;

Umlgenerator.s = Umlgenerator.s + "\n";
}




}





