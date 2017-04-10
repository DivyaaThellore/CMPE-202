package ProjectUML;
	
	import japa.parser.ast.body.MethodDeclaration;
	import japa.parser.ast.body.Parameter;
	import japa.parser.ast.stmt.Statement;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	
	//public class FindOperations extends VoidVisitorAdapter {
	
	
	
	@Override
	public void visit(MethodDeclaration n, Object arg) {
	
	if(n.getName()!=null)
	Umlgenerator.methodlist.add(n.getName().toLowerCase());
	String param= "";
	
	if (n.getBody() !=null && n.getBody().getStmts()!=null) {
	
	for(Statement x : n.getBody().getStmts())
	{
	if(x!=null)
	{
	String k = x.toString();
	String delims = "[ .,?!]+";
	
	String[] tokens = k.split(delims);
	
	if(tokens[0]!=null)
	{
	if(Umlgenerator.list.contains(tokens[0]))//list contains all class names.
	
	Umlgenerator.s = Umlgenerator.s + tokens[0] +"<.. " + Umlgenerator.classname + "\n";
	}
	}
	}
	
	}
	
	if(n.getParameters()!=null)
	{
	for(Parameter x : n.getParameters())
	{
	if(param != "")
	param = param + "," + x.toString();
	else 
	param = x.toString();
	String check = x.getType().toString();

	
	if(Umlgenerator.list.contains(check))
	{
	if(!Umlgenerator.s.contains(check + "<.. " + Umlgenerator.classname + ":uses") 
	&& Umlgenerator.interfacelist.contains(check) 
	&& !Umlgenerator.interfacelist.contains(Umlgenerator.classname))//note
	Umlgenerator.s = Umlgenerator.s + check + "<.. " + Umlgenerator.classname + ":uses" + "\n";
	}
	} 
	}

	
	if(n.getModifiers()==1)
	{
	Umlgenerator.s = Umlgenerator.s + Umlgenerator.classname + " : "+ "+" + n.getName() + "("+ param +")" + ":" + n.getType();
	Umlgenerator.s = Umlgenerator.s + "\n";
	}
	}
	
	
	
	
	}




