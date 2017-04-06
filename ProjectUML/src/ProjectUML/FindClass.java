package ProjectUML;



import java.util.List;

import ProjectUML.Umlgenerator;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindClass extends VoidVisitorAdapter {
	
	
	
@Override
public void visit(ClassOrInterfaceDeclaration decl, Object arg)
{
// Make class extend Blah.

List<ClassOrInterfaceType> list = decl.getExtends();

if(list==null)
return;


for (ClassOrInterfaceType k : list) {
String n = k.toString();

Umlgenerator.s = Umlgenerator.s + n + " " + "<|--" + " " + Umlgenerator.classname + "\n";
}


}


}

