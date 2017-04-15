package ProjectUML;

import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindInterface extends VoidVisitorAdapter{
		
	public void visit(ClassOrInterfaceDeclaration decl, Object obj)
	{	
	List<ClassOrInterfaceType> l = decl.getImplements();
	if(l==null)
	{
	return;
	}
	for (ClassOrInterfaceType x : l) 
		{
		String s = x.toString();
		Umlgenerator.interfaces.add(s);
		if(!Umlgenerator.input.contains( s +"<|.. " + Umlgenerator.class_nm )&& !Umlgenerator.input.contains(s+"<.. "+ Umlgenerator.class_nm +":uses" ))
		Umlgenerator.input = Umlgenerator.input +s+"<|.."+" "+Umlgenerator.class_nm +"\n";
		
		}
	}
}




