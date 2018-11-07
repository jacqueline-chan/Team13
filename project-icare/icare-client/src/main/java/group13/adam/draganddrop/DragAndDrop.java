package group13.adam.draganddrop;

import javax.swing.*;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;

public class DragAndDrop implements DropTargetListener {
	
		private JTextArea textArea;
	
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
		
			try {
				if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
					accepted = true;
				
					List<File> files = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
				
					if (files != null && files.size() > 0) {
						StringBuilder filePaths = new StringBuilder();
						for (File file : files) {
							filePaths.append("file: " + file.getAbsolutePath() + "\n");
							// get the full path of the file
							System.out.println("file: " + file.getAbsolutePath() + "\n");
						}
						
						textArea.append(filePaths.toString());
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
		JFrame f = new JFrame("Drag and Drop");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);                
        panel.add(new JScrollPane(textArea)); 
        
        DragAndDrop listener = new DragAndDrop(textArea);

        DropTarget dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, listener, true);
        
        f.setContentPane(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
	}

    public static void main(String[] args) {
    	ShowDragAndDrop();     
    }


	
}
