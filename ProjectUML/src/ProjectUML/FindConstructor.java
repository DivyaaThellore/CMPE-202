package ProjectUML;



import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class FindConstructor extends VoidVisitorAdapter {

public void visit(ConstructorDeclaration construct, Object obj) {
String str =null;
if(construct.getParameters()!=null)
{
for(Parameter p : construct.getParameters())
{ 
System.out.println("classname:"+Umlgenerator.class_nm);
System.out.println("xxxxxxx:"+p.toString());

if(str != null)
str = str + "," + p.toString();
else 
str = p.toString();
String check = p.getType().toString();
//System.out.println("check :"+check);

if(Umlgenerator.ls.contains(check))
{
if(!Umlgenerator.input.contains(check + "<.. " + Umlgenerator.class_nm + ":uses")&& Umlgenerator.interfaces.contains(check)&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))
	Umlgenerator.input =Umlgenerator.input +check + "<.. " + Umlgenerator.class_nm + ":uses" + "\n";
}
} 
}
Umlgenerator.input =Umlgenerator.input +Umlgenerator.class_nm + " : "+ "+" + construct.getName() + "("+ str +")" ;

Umlgenerator.input = Umlgenerator.input + "\n";
}

}





