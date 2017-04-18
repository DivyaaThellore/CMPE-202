package ProjectUML;
/* 
 * author T V Divyaa
 * 
 */
	
	import japa.parser.ast.body.MethodDeclaration;
	import japa.parser.ast.body.Parameter;
	import japa.parser.ast.stmt.Statement;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	public class FindOperations extends VoidVisitorAdapter {
	public void visit(MethodDeclaration n, Object arg) {
	
	if(n.getName()!=null)
	Umlgenerator.operations.add(n.getName().toLowerCase());
	String param= "";
	
	if (n.getBody() !=null && n.getBody().getStmts()!=null) {
	
	for(Statement x : n.getBody().getStmts())
	{
	if(x!=null)
	{
	String k = x.toString();
	String delims = "[ .,?!]+";
	// System.out.println("k :"+k);
	String[] tokens = k.split(delims);
	// System.out.println("token0"+tokens[0]);
	if(tokens[0]!=null)
	{
	if(Umlgenerator.ls.contains(tokens[0]))//list contains all class names.
	//comparing it with tokens[0] to find if the class name matches.
	//this will check dependency in methods
	//System.out.println("list :"+Umlgenerator.list);
	Umlgenerator.input = Umlgenerator.input + tokens[0] +"<.. " + Umlgenerator.class_nm + "\n";
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
	//System.out.println("Interfacelist : "+Umlgenerator.interfacelist);
	// System.out.println("Classname : "+Umlgenerator.classname);
	
	if(Umlgenerator.ls.contains(check))
	{
	if(!Umlgenerator.input.contains(check + "<.. " + Umlgenerator.class_nm + ":uses") 
	&& Umlgenerator.interfaces.contains(check) 
	&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))//note
	Umlgenerator.input = Umlgenerator.input + check + "<.. " + Umlgenerator.class_nm + ":uses" + "\n";
	}
	} 
	}
	//System.out.println(n.toString());
	//System.out.println("getmodifiers : "+n.getModifiers());
	
	if(n.getModifiers()==1)
	{
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : "+ "+" + n.getName() + "("+ param +")" + ":" + n.getType();
	Umlgenerator.input = Umlgenerator.input + "\n";
	}
	}
	
	
	
	
	}





