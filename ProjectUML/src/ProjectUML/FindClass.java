package ProjectUML;



import java.util.List;
import ProjectUML.Umlgenerator;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class FindClass extends VoidVisitorAdapter {
	
public void visit(ClassOrInterfaceDeclaration cls, Object obj)
{
List<ClassOrInterfaceType> lt=cls.getExtends();
if(lt==null)
return;
for (ClassOrInterfaceType l : lt) {
String s=l.toString();
Umlgenerator.input=Umlgenerator.input+s+"<|--"+Umlgenerator.classname+"\n";
}
}
}

