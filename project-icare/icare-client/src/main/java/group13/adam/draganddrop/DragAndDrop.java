package group13.adam.draganddrop;

import javax.swing.*;

import group13.adam.parser.CSVParser;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DragAndDrop implements DropTargetListener {
	
		private JTextArea textArea;
		private CSVParser csvparser = new CSVParser();
		
		
		
		private boolean status = false;
		
		public DragAndDrop(JTextArea textArea) {
			this.textArea = textArea;
		}
		
		@Override
		public void dragEnter(DropTargetDragEvent dtde) {

		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
		}
		
		@Override
		public void dropActionChanged(DropTargetDragEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drop(DropTargetDropEvent dtde) {
			// TODO Auto-generated method stub
			boolean accepted = false;
			boolean error = false;
			
			Object[] options = {"Yes", "No"};
			
			try {
				if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
					accepted = true;
					List<File> files = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
				
					if (files != null && files.size() > 0) {
						StringBuilder filePaths = new StringBuilder();
						for (File file : files) {
							error = false;
							filePaths.append(file.getAbsolutePath());
							int result = JOptionPane.showOptionDialog(null, "Would you like to submit data from " + file.getName() + "?", "Submit Confirmation", 
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							System.out.println(result);
							if (result == 0){	// 0 = yes
								try{
									csvparser.parseFile(file.getAbsolutePath(), "infoform.db");
								} catch(SQLException e){
									textArea.append("Unable to add " + file.getName() + " due to an error updating the database \n");
									error = true;
								} catch(IOException e){
									textArea.append("Unable to add " + file.getName() + " due to an error with the file \n");
									error = true;
								}
								if (!error)		// if the file was added properly
									textArea.append("Added " + file.getName() + " to the database. \n");
							}
							else {	// user presses no or x button
								textArea.append("Did not add " + file.getName() + " to the database. \n");
							}
							textArea.append("========================= \n");
						}
						
						
						
						
						// test
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			if (accepted) {
				dtde.dropComplete(true);
			}
		}
		
	public static void ShowDragAndDrop() {
		JFrame jf = new JFrame("Drag and Drop");
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea)); 
        
        DragAndDrop listener = new DragAndDrop(textArea);

        DropTarget dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, listener, true);
        
        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
        textArea.append("Drag and drop csv files here \n");
        textArea.append("========================= \n");
        
	}
	
}
