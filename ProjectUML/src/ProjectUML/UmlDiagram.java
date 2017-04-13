package ProjectUML;

import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import net.sourceforge.plantuml.SourceStringReader;
	public class UmlDiagram {
	public void umlCreator(String source , String fpath) {
	
	
	OutputStream pic = null;
	try {
	pic = new FileOutputStream(fpath+"//pic.jpeg");
	} catch (FileNotFoundException e) {
	
	
	}
	SourceStringReader forclass = new SourceStringReader(source);
	
	try {
		forclass.generateImage(pic);
	
	} catch (IOException e) {
	
	e.printStackTrace();
	}
	
	}
	}



