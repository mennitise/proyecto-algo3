package Vista;


import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class InstruccionesVista {

	public InstruccionesVista(){
		//No hace Nada, no muesstra nada, para eso esta el metodo de clase acá abajo
	}
	
	public static void mostrarInstrucciones(){

        String unString = readFile("src/ModelSRC/instrucciones/instrucciones.txt");        
        JTextArea textArea = new JTextArea( unString        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
         JScrollPane areaScrollPane = new JScrollPane(textArea);
         areaScrollPane.setVerticalScrollBarPolicy(
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         areaScrollPane.setPreferredSize(new Dimension(250, 250));
         areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Instrucciones"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        JFrame unFrame = new JFrame();
        unFrame.setBounds(300,100,600,600);
        unFrame.add(areaScrollPane);
        unFrame.setVisible(true);
	}

	 private static String readFile(String filename)
	    {
	       String content = null;
	       File file = new File(filename); //for ex foo.txt
	       try {
	           FileReader reader = new FileReader(file);
	           char[] chars = new char[(int) file.length()];
	           reader.read(chars);
	           content = new String(chars);
	           reader.close();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       return content;
	    }
	 
}

