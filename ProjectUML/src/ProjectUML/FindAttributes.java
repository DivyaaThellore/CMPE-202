package ProjectUML;

/* 
 * author T V Divyaa
 * 
 */

	import japa.parser.ast.body.FieldDeclaration;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	
	public class FindAttributes extends VoidVisitorAdapter {
	
	
	@Override
	public void visit(FieldDeclaration n, Object arg) {
	int i;
	
	String x = n.getType().toString();
	boolean flag =false;
	System.out.println(Umlgenerator.class_nm);
	System.out.println(Umlgenerator.ls);
	if(Umlgenerator.ls.contains(x))
	{
	if(x.contains("Collection"))
	{
	i= Umlgenerator.ls.indexOf(x)-1;
	flag =true;
	}
	else 
	i = Umlgenerator.ls.indexOf(x);
	
	
	if(Umlgenerator.input.contains(Umlgenerator.ls.get(i) + " -- " + Umlgenerator.class_nm ))
		
	System.out.println("already there");
	
	else if(Umlgenerator.input.contains(" " + Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && flag == false)
	{
	
		Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"1\" - \"1\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains(" "+Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && flag == true)
	{
	
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"*\" - \"1\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && flag == false)
	{
	
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"1\" - \"*\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains( Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && flag == true)
	{
	
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"*\" - \"*\" " + Umlgenerator.class_nm);
	}
	else
	{
	
	if(flag==false)
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"1\" " + Umlgenerator.ls.get(i) + "\n";
	else
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"*\" " + Umlgenerator.ls.get(i) + "\n";
	}
	
	
	
	}
		
	String k =n.toString();
	k = k.replaceAll("[;]", "");
	String[] strs = k.split("\\s+");
	
	if(strs[0].equals("public"))
	strs[0]="+" ;
	if(strs[0].equals("private"))
	{ 
	if(Umlgenerator.operations.contains("set"+strs[2]) && Umlgenerator.operations.contains("get"+strs[2]))
	strs[0]="+" ;
	else
	strs[0]="-" ;
	
	}
	if(strs[0].equals("protected"))
	strs[0]="#" ;
	if(strs.length >2 && (strs[0] == "+" || strs[0] == "-"))
	{
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : " + strs[0] + " " + strs[2] + " : " + strs[1];
	Umlgenerator.input = Umlgenerator.input + "\n";
	strs[2] = Character.toUpperCase(strs[2].charAt(0)) + strs[2].substring(1);
	String rep1 = "get" + strs[2];
	String rep2 = "set" + strs[2];
	
	Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+rep1+".*(\r?\n|\r)?", "" );
	Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+rep2+".*(\r?\n|\r)?", "" );
	
	
	}
	
	
	super.visit(n, arg);
	}
	
	
	
	}




