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
		
	public void visit(MethodDeclaration n, Object obj) {
		// class to find the methods in the given program
	
	if(n.getName()!=null)
		// check if value exists.
		//System.out.println(n.getName());
			
	Umlgenerator.operations.add(n.getName().toLowerCase());

	String p;
	p= "";
	
	if (n.getBody() !=null && n.getBody().getStmts()!=null)
	{// entering the body of the method
	// for each statement.
	for(Statement i : n.getBody().getStmts())
	{
		//System.out.println(i);
	if(i!=null)
	{
	String k = i.toString();
	// check for [ .,?!]+
	String id = "[ .,?!]+";
	
	String[] s;
	s= k.split(id);
	
	if(s[0]!=null)
	{
		// check for condition.
		
	if(Umlgenerator.ls.contains(s[0]))
	{
		// add to the input string.
	Umlgenerator.input = Umlgenerator.input + s[0] +"<.. "; 
	Umlgenerator.input = Umlgenerator.input+ Umlgenerator.class_nm + "\n";
	//System.out.println(input);
	}
	}
	}
	}
	}
	
	if(n.getParameters()!=null){
	for(Parameter x : n.getParameters())
	{
	if(p != ""){
	p = p + ",";
	p=p+ x.toString();
	}
	else {
	p = x.toString();
	}	
	String check = x.getType().toString();
	//System.out.println(check);

	
	if(Umlgenerator.ls.contains(check))
	{
	if(!Umlgenerator.input.contains(check + "<.. " + Umlgenerator.class_nm + ":uses") 
	&& Umlgenerator.interfaces.contains(check) 
	&& !Umlgenerator.interfaces.contains(Umlgenerator.class_nm))//note
	Umlgenerator.input = Umlgenerator.input + check + "<.. " + Umlgenerator.class_nm + ":uses" + "\n";
	}
	} 
	}

	
	if(n.getModifiers()==1)
	{
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : "+ "+" ;
	Umlgenerator.input = Umlgenerator.input + n.getName();
			Umlgenerator.input = Umlgenerator.input +"("+ p +")" + ":" + n.getType();
	Umlgenerator.input = Umlgenerator.input + "\n";
	}
	}
	
	
	
	
	}





