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
	public void umlCreator(String source , String path) {
	
	
	OutputStream png = null;
	try {
	png = new FileOutputStream(path+"//pic.jpeg");
	} 
	catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	SourceStringReader reader = new SourceStringReader(source);
	// Write the first image to "png"
	try {
	reader.generateImage(png);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	// Return a null string if no generation
	}
	}





