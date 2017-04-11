package ProjectUML;

import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindInterface extends VoidVisitorAdapter{
		
	public void visit(ClassOrInterfaceDeclaration decl, Object arg)
	{	
	List<ClassOrInterfaceType> l = decl.getImplements();
	if(l==null)
	return;
	for (ClassOrInterfaceType x : l) 
		{
		String s = x.toString();
		Umlgenerator.interfacelist.add(s);
		if(!Umlgenerator.input.contains( s + "<|.. " + Umlgenerator.classname )&& !Umlgenerator.input.contains(s+"<.. "+ Umlgenerator.classname +":uses" )){
		Umlgenerator.input = Umlgenerator.input +s+"<|.. "+Umlgenerator.classname +"\n";
		}
		}
	}
}




