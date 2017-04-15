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
	pic = new FileOutputStream(uml.p+"//pic.jpeg");
	//pic=new FileOutputStream("C:\\Users\\T V Divyaa\\Desktop"+"\\second.jpg");
	} catch (FileNotFoundException e) {
	
		System.out.println("Error" +e);
	
	}
	SourceStringReader forclass = new SourceStringReader(source);
	
	try {
		forclass.generateImage(pic);
		//forclass.generateImage(pic_bkup);
	
	} catch (IOException e) {
	
		System.out.println("Stack Trave" + e);
	
	}
	
	}
	}



