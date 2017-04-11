package ProjectUML;

import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import net.sourceforge.plantuml.SourceStringReader;
	public class UmlDiagram {
	public void umlCreator(String source , String path) {
	
	
	OutputStream png = null;
	try {
	png = new FileOutputStream(path+"//umldia.jpeg");
	} catch (FileNotFoundException e) {
	
	e.printStackTrace();
	}
	SourceStringReader reader = new SourceStringReader(source);
	
	try {
	reader.generateImage(png);
	} catch (IOException e) {
	
	e.printStackTrace();
	}
	
	}
	}



