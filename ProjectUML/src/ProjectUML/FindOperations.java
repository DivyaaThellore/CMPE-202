package ProjectUML;
	
	import japa.parser.ast.body.MethodDeclaration;
	import japa.parser.ast.body.Parameter;
	import japa.parser.ast.stmt.Statement;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	
	public class FindOperations extends VoidVisitorAdapter {

	public void visit(MethodDeclaration md, Object obj) {
	
	if(md.getName()!=null)
	Umlgenerator.methodlist.add(md.getName()/*.toLowerCase()*/);
	String param= "";
	
	if (md.getBody() !=null && md.getBody().getStmts()!=null) {
	
	for(Statement x : md.getBody().getStmts())
	{
	if(x!=null)
	{
	String k = x.toString();
	String delims = "[ .,?!]+";
	
	String[] tokens = k.split(delims);
	
	if(tokens[0]!=null)
	{
	if(Umlgenerator.list.contains(tokens[0]))//list contains all class names.
	
	Umlgenerator.input = Umlgenerator.input + tokens[0] +"<.. " + Umlgenerator.classname + "\n";
	}
	}
	}
	
	}
	
	if(md.getParameters()!=null)
	{
	for(Parameter x : md.getParameters())
	{
	if(param != "")
	param = param + "," + x.toString();
	else 
	param = x.toString();
	String check = x.getType().toString();

	
	if(Umlgenerator.list.contains(check))
	{
	if(!Umlgenerator.input.contains(check + "<.. " + Umlgenerator.classname + ":uses") 
	&& Umlgenerator.interfacelist.contains(check) 
	&& !Umlgenerator.interfacelist.contains(Umlgenerator.classname))//note
	Umlgenerator.input = Umlgenerator.input + check + "<.. " + Umlgenerator.classname + ":uses" + "\n";
	}
	} 
	}

	
	if(md.getModifiers()==1)
	{
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.classname + " : "+ "+" + md.getName() + "("+ param +")" + ":" + md.getType();
	Umlgenerator.input = Umlgenerator.input + "\n";
	}
	}
	
	
	
	
	}




