package ProjectUML;
/* 
 * author T V Divyaa
 * 
 */

import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import net.sourceforge.plantuml.SourceStringReader;

	public class UmlDiagram {
		
	public void drawPic(String in , String path) {
	
	// System.out.printn(path);
	//OutputStream png = null;
		OutputStream pic = null;
		SourceStringReader src = new SourceStringReader(in);
	try {	pic = new FileOutputStream(path+"//pic.jpeg");
	//System.out.println(pic.getAbsolutePath());
	// try to catch the error on catch block.
	} 
	catch (FileNotFoundException e) {
		// handle error if file cannot be located.
		System.out.println("e");
	
	}
	
	
	try { src.generateImage(pic);
	// print the error.
	} 
	catch (IOException e) {
		// print  the error .
		System.out.println("encountered problems");
		System.out.println("do nothing");}

	}
	}





