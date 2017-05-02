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
			
	UmlParser.operations.add(n.getName().toLowerCase());//(n.getName().

	String p;//=""
	p= "";
	
	if (n.getBody() !=null && /*n.getBody()*/n.getBody().getStmts()!=null)
	{// entering the body of the method
	// for each statement.
	for(Statement i : n.getBody().getStmts())//{
	{
		//System.out.println(i);
	if(i!=null)
	{
		
	String k = i.toString();
	// check for [ .,?!]+
	String id = "[ .,?!]+"/*"[ .,?!]"*/;
	
	String[] s;//;
	
	s= k.split(id);
	
	if(s[0]!=null)//s[0]!=
	{
		// check for condition.
		
	if(UmlParser.ls.contains(s[0]))//s[0]
	{
		// add to the input string.
	UmlParser.input = UmlParser.input + s[0] +"<.. "; 
	
	UmlParser.input = UmlParser.input+ UmlParser.class_nm + "\n";
	//System.out.println(input);
	}
	}
	//}
	}
	}
	}
	
	if(n.getParameters()!=null){//null
		// if not null 
	for(Parameter x : n.getParameters())
	{
	if(p != ""){//{
		//p+=x;
	p = p + ",";//","
	p=p+x.toString();
	}
	else {
	p = x.toString();
	}	
	String check = x.getType().toString();
	//System.out.println(check);

	
	if(UmlParser.ls.contains(check))
	{//
		//check
	if(!UmlParser.input.contains(check + "<.. " + /* check + "<.. " + */UmlParser.class_nm + ":uses") 
			//condition1
	&& UmlParser.interfaces.contains(check) 
	// check
	&& !UmlParser.interfaces.contains(UmlParser.class_nm))
		//do
	UmlParser.input = UmlParser.input + check + "<.. " + /* check + "<.. " + */UmlParser.class_nm + ":uses" + "\n";
	}
	//}
	} 
	}

	
	if(n.getModifiers()==1)
		//System.out.println(n.getModifiers());
	{
	UmlParser.input = UmlParser.input + UmlParser.class_nm + " : "+ "+"/*" : "+ "+"*/ ;
	// append to input string
	UmlParser.input = UmlParser.input + n.getName();//UmlParser.input = UmlParser.input +"("+ p +")"
			UmlParser.input = UmlParser.input +"("+ p +")" + ":" +/*" : "+ "+"*/ n.getType();
			
	UmlParser.input = UmlParser.input + "\n";
	}
	}
		
	//)
	
	}





