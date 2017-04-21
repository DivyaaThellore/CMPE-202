package ProjectUML;

/* 
 * author T V Divyaa
 * 
 */

	import japa.parser.ast.body.FieldDeclaration;
	import japa.parser.ast.visitor.VoidVisitorAdapter;
	
	
	public class FindAttributes extends VoidVisitorAdapter {
	

	public void visit(FieldDeclaration n, Object obj) {
		
		// int i=;
	int i;
	
	String x = n.getType().toString();
	//System.out.println(x);
	
	//boolean chk
	boolean chk =false;

	if(Umlgenerator.ls.contains(x)){
	if(x.contains("Collection")){
	i= Umlgenerator.ls.indexOf(x)-1;
	// chk;
	chk =true;
	}
	
	else {
		//nt index
	i = Umlgenerator.ls.indexOf(x);
	}
	
	
	if(Umlgenerator.input.contains(Umlgenerator.ls.get(i) + " -- " + Umlgenerator.class_nm ))//get(i) + " -- " + Umlgenerator.class_nm ))
	
		//			System.out.println("already there");	
		System.out.println("already there");
	
	
	else if(Umlgenerator.input.contains(" " + Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && chk == false){
		/*Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"1\" - \"1\" " + Umlgenerator.class_nm);
	}
	*/	
		Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"1\" - \"1\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains(" "+Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && chk == true)
	{
	
		//System.out.println(input);
		//i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"*\" - \"1\" " + Umlgenerator
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"*\" - \"1\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && chk == false)	{
		//System.out.println(input);
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"1\" - \"*\" " + Umlgenerator.class_nm);
	}
	
	else if(Umlgenerator.input.contains( Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && chk == true)	{
	
	Umlgenerator.input.replace(Umlgenerator.ls.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.ls.get(i) + "\"*\" - \"*\" " + Umlgenerator.class_nm);
	}
	else	{	
		//if(chk==     ;
	if(chk==false)		
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"1\" " + Umlgenerator.ls.get(i) + "\n";
	else
		/* else {
		 Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"*\" " + Umlgenerator.ls.get(i)
		 }
		 */
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"*\" " + Umlgenerator.ls.get(i) + "\n";
	}
	
	
	
	}
		
	String k =n.toString();
	/*k.replaceAll("[;]", "")
	String strs = k.split("\\s+");
	String[] strs = k.split("\\s+");*/
	
	k = k.replaceAll("[;]", "");

	String[] strs = k.split("\\s+");
	
	
	//if(strs[0].equals("public")
	if(strs[0].equals("public")){
	strs[0]="+" ;
	}
	if(strs[0].equals("private"))
	{ 
	if(Umlgenerator.operations.contains("set"+strs[2]) && Umlgenerator.operations.contains("get"+strs[2])){
	strs[0]="+" ;
	}
	else{
	strs[0]="-" ;
	}
	
	}
	if(strs[0].equals("protected"))
	strs[0]="#" ;
	//if(strs.length >2)
	if(strs.length >2 && (strs[0] == "+" || strs[0] == "-")) {
		
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " : " + strs[0] + " " + strs[2] + " : " + strs[1];
	Umlgenerator.input = Umlgenerator.input + "\n";
	//System.out.println(input);
	// str[[2]=Character.toUpperCase(str[2])+str[2].substring(1);
	strs[2] = Character.toUpperCase(strs[2].charAt(0)) + strs[2].substring(1);
		String del1 = "get" + strs[2];
	String del2 = "set" + strs[2];
	
	/*Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+d1+".*(\r?\n|\r) "" );
	Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+d2+".*(\r?\n|\r) "" );
	*/
	Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+del1+".*(\r?\n|\r)?", "" );
	//System.out.println(del1 + del2);
	Umlgenerator.input = Umlgenerator.input.replaceAll( ".*"+del2+".*(\r?\n|\r)?", "" );
	
	
	}
	//s
	//super.visit(n,obj);
	super.visit(n, obj);
	}
	//}
//}
	
	
	}




