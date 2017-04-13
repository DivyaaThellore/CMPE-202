package ProjectUML;

// to find the attributes or properties




import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindAttributes extends VoidVisitorAdapter {



public void visit(FieldDeclaration n, Object arg) {
int i;

String x = n.getType().toString();
boolean flag =false;
System.out.println(Umlgenerator.class_nm);
System.out.println(Umlgenerator.list);
if(Umlgenerator.list.contains(x))
{
if(x.contains("Collection"))
{
i= Umlgenerator.list.indexOf(x)-1;
flag =true;
}
else 
i = Umlgenerator.list.indexOf(x);


if(Umlgenerator.input.contains(Umlgenerator.list.get(i) + " -- " + Umlgenerator.class_nm ))
System.out.println("contains");
else if(Umlgenerator.input.contains(" " + Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && flag == false)
{

	Umlgenerator.input.replace(Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.list.get(i) + "\"1\" - \"1\" " + Umlgenerator.class_nm);
}

else if(Umlgenerator.input.contains(" "+Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.class_nm ) && flag == true)
{

	Umlgenerator.input.replace(Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.class_nm, Umlgenerator.list.get(i) + "\"*\" - \"1\" " + Umlgenerator.class_nm);
}

else if(Umlgenerator.input.contains(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && flag == false)
{

	Umlgenerator.input.replace(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.list.get(i) + "\"1\" - \"*\" " + Umlgenerator.class_nm);
}

else if(Umlgenerator.input.contains( Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.class_nm ) && flag == true)
{

	Umlgenerator.input.replace(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.class_nm, Umlgenerator.list.get(i) + "\"*\" - \"*\" " + Umlgenerator.class_nm);
}
else
{

if(flag==false)
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"1\" " + Umlgenerator.list.get(i) + "\n";
else
	Umlgenerator.input = Umlgenerator.input + Umlgenerator.class_nm + " - \"*\" " + Umlgenerator.list.get(i) + "\n";
}

}

String k =n.toString();
k = k.replaceAll("[;]", "");
String[] strs = k.split("\\s+");

if(strs[0].equals("public"))
strs[0]="+" ;
if(strs[0].equals("private"))
{ 
if(Umlgenerator.methodlist.contains("set"+strs[2]) && Umlgenerator.methodlist.contains("get"+strs[2]))
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
//System.out.println(Umlgen.s);

super.visit(n, arg);
}



}



