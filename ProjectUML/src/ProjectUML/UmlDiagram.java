package ProjectUML;

import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import net.sourceforge.plantuml.SourceStringReader;
	public class UmlDiagram {
		Umlgenerator uml;
	public void umlCreator(String source) {
	
	
	OutputStream pic = null;
	try {
		
		//pic = new FileOutputStream(fpath+ fname);
		String pth=uml.p;
		int del=pth.lastIndexOf('\\');
		pth=pth.substring(0,del);
		//System.out.println(pth);
		
		
		
	pic = new FileOutputStream(pth+"//pic.jpeg");
	//pic=new FileOutputStream("C:\\Users\\T V Divyaa\\Desktop"+"\\second.jpg");
	} catch (FileNotFoundException e) {
	
		System.out.println("Error" +e);
	
	}
	SourceStringReader forclass = new SourceStringReader(source);
	
	try 
	{
		//forclass.generateImage(pic_bkup);
		forclass.generateImage(pic);}
		
	
	 catch (IOException e) {
	
		System.out.println("Encountered Problem" + e);}
	
	
	
	}
	}



