package ProjectUML;
	
	import japa.parser.ast.body.MethodDeclaration;
	import japa.parser.ast.body.Parameter;
	import japa.parser.ast.stmt.Statement;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	
	public class FindOperations extends VoidVisitorAdapter {

	public void visit(MethodDeclaration md, Object obj) {
	
	if(md.getName()!=null)
	Umlgenerator.operations.add(md.getName());
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
	if(Umlgenerator.ls.contains(tokens[0]))
	
	Umlgenerator.input = Umlgenerator.input + tokens[0] +"<.. " + Umlgenerator.class_nm + "\n";
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

	
	if(Umlgenerator.ls.contains(check))
	{
	if(!Umlgenerator.input.contains(check + "<.. " + Umlgenerator.class_nm + ":uses") 
	&& Umlgenerator.interfaces.contains(check) 
	&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))
	Umlgenerator.input = Umlgenerator.input+check + "<.." + Umlgenerator.class_nm + ":uses" + "\n";
	}
	} 
	}

	
	if(md.getModifiers()==1)
	{
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : "+ "+" + md.getName() + "("+ param +")" + ":" + md.getType();
	Umlgenerator.input = Umlgenerator.input + "\n";
	}
	}	
	}




