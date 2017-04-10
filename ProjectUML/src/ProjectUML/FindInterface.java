package ProjectUML;

import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindInterface extends VoidVisitorAdapter{
	
	
	@Override
	public void visit(ClassOrInterfaceDeclaration decl, Object arg)
	{
	
	
	
	List<ClassOrInterfaceType> list = decl.getImplements();
	if(list==null)
	return;
	for (ClassOrInterfaceType k : list) {
	String n = k.toString();
	Umlgenerator.interfacelist.add(n);
	if(!Umlgenerator.s.contains( n + "<|.. " + Umlgenerator.classname )
	&& !Umlgenerator.s.contains
	( n + "<.. " + Umlgenerator.classname + ":uses" ))
		Umlgenerator.s = Umlgenerator.s + n + " " + "<|.. " + " " + 
				Umlgenerator.classname + "\n";
	}
	
	
	
	}
	
	
	
	}




