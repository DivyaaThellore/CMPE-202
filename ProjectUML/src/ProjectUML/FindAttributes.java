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

	if(UmlParser.ls.contains(x)){
	if(x.contains("Collection")){
	i= UmlParser.ls.indexOf(x)-1;
	// chk;
	chk =true;
	}
	
	else {
		//nt index
	i = UmlParser.ls.indexOf(x);
	}
	
	
	if(UmlParser.input.contains(UmlParser.ls.get(i) + " -- " + UmlParser.class_nm ))//get(i) + " -- " + UmlParser.class_nm ))
	
		//			System.out.println("already there");	
		System.out.println("already there");
	
	
	else if(UmlParser.input.contains(" " + UmlParser.ls.get(i) + " - \"1\" " + UmlParser.class_nm ) && chk == false){
		/*UmlParser.ls.get(i) + " - \"1\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"1\" - \"1\" " + UmlParser.class_nm);
	}
	*/	
		UmlParser.input.replace(UmlParser.ls.get(i) + " - \"1\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"1\" - \"1\" " + UmlParser.class_nm);
	}
	
	else if(UmlParser.input.contains(" "+UmlParser.ls.get(i) + " - \"1\" " + UmlParser.class_nm ) && chk == true)
	{
	
		//System.out.println(input);
		//i) + " - \"1\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"*\" - \"1\" " + UmlParser
	UmlParser.input.replace(UmlParser.ls.get(i) + " - \"1\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"*\" - \"1\" " + UmlParser.class_nm);
	}
	
	else if(UmlParser.input.contains(UmlParser.ls.get(i) + " - \"*\" " + UmlParser.class_nm ) && chk == false)	{
		//System.out.println(input);
	UmlParser.input.replace(UmlParser.ls.get(i) + " - \"*\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"1\" - \"*\" " + UmlParser.class_nm);
	}
	
	else if(UmlParser.input.contains( UmlParser.ls.get(i) + " - \"*\" " + UmlParser.class_nm ) && chk == true)	{
	
	UmlParser.input.replace(UmlParser.ls.get(i) + " - \"*\" " + UmlParser.class_nm, UmlParser.ls.get(i) + "\"*\" - \"*\" " + UmlParser.class_nm);
	}
	else	{	
		//if(chk==     ;
	if(chk==false)		
	UmlParser.input = UmlParser.input + UmlParser.class_nm + " - \"1\" " + UmlParser.ls.get(i) + "\n";
	else
		/* else {
		 UmlParser.input = UmlParser.input + UmlParser.class_nm + " - \"*\" " + UmlParser.ls.get(i)
		 }
		 */
	UmlParser.input = UmlParser.input + UmlParser.class_nm + " - \"*\" " + UmlParser.ls.get(i) + "\n";
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
	if(UmlParser.operations.contains("set"+strs[2]) && UmlParser.operations.contains("get"+strs[2])){
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
		
	UmlParser.input = UmlParser.input + UmlParser.class_nm + " : " + strs[0] + " " + strs[2] + " : " + strs[1];
	UmlParser.input = UmlParser.input + "\n";
	//System.out.println(input);
	// str[[2]=Character.toUpperCase(str[2])+str[2].substring(1);
	strs[2] = Character.toUpperCase(strs[2].charAt(0)) + strs[2].substring(1);
		String del1 = "get" + strs[2];
	String del2 = "set" + strs[2];
	
	/*UmlParser.input = UmlParser.input.replaceAll( ".*"+d1+".*(\r?\n|\r) "" );
	UmlParser.input = UmlParser.input.replaceAll( ".*"+d2+".*(\r?\n|\r) "" );
	*/
	UmlParser.input = UmlParser.input.replaceAll( ".*"+del1+".*(\r?\n|\r)?", "" );
	//System.out.println(del1 + del2);
	UmlParser.input = UmlParser.input.replaceAll( ".*"+del2+".*(\r?\n|\r)?", "" );
	
	
	}
	//s
	//super.visit(n,obj);
	super.visit(n, obj);
	}
	//}
//}
	
	
	}




