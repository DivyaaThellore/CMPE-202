package ProjectUML;

// to find the attributes or properties




import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class FindAttributes extends VoidVisitorAdapter {


@Override
public void visit(FieldDeclaration n, Object arg) {
int i;

String x = n.getType().toString();
boolean flag =false;
System.out.println(Umlgenerator.classname);
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


if(Umlgenerator.s.contains(Umlgenerator.list.get(i) + " -- " + Umlgenerator.classname ))
System.out.println("contains");
else if(Umlgenerator.s.contains(" " + Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.classname ) && flag == false)
{

	Umlgenerator.s.replace(Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.classname, Umlgenerator.list.get(i) + "\"1\" - \"1\" " + Umlgenerator.classname);
}

else if(Umlgenerator.s.contains(" "+Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.classname ) && flag == true)
{

	Umlgenerator.s.replace(Umlgenerator.list.get(i) + " - \"1\" " + Umlgenerator.classname, Umlgenerator.list.get(i) + "\"*\" - \"1\" " + Umlgenerator.classname);
}

else if(Umlgenerator.s.contains(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.classname ) && flag == false)
{

	Umlgenerator.s.replace(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.classname, Umlgenerator.list.get(i) + "\"1\" - \"*\" " + Umlgenerator.classname);
}

else if(Umlgenerator.s.contains( Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.classname ) && flag == true)
{

	Umlgenerator.s.replace(Umlgenerator.list.get(i) + " - \"*\" " + Umlgenerator.classname, Umlgenerator.list.get(i) + "\"*\" - \"*\" " + Umlgenerator.classname);
}
else
{

if(flag==false)
	Umlgenerator.s = Umlgenerator.s + Umlgenerator.classname + " - \"1\" " + Umlgenerator.list.get(i) + "\n";
else
	Umlgenerator.s = Umlgenerator.s + Umlgenerator.classname + " - \"*\" " + Umlgenerator.list.get(i) + "\n";
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
	Umlgenerator.s = Umlgenerator.s + Umlgenerator.classname + " : " + strs[0] + " " + strs[2] + " : " + strs[1];
	Umlgenerator.s = Umlgenerator.s + "\n";
strs[2] = Character.toUpperCase(strs[2].charAt(0)) + strs[2].substring(1);
String rep1 = "get" + strs[2];
String rep2 = "set" + strs[2];


Umlgenerator.s = Umlgenerator.s.replaceAll( ".*"+rep1+".*(\r?\n|\r)?", "" );
Umlgenerator.s = Umlgenerator.s.replaceAll( ".*"+rep2+".*(\r?\n|\r)?", "" );


}
//System.out.println(Umlgen.s);

super.visit(n, arg);
}



}



