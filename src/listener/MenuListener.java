package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import file_operations.SaveAsFile;
import file_operations.OpenFile;
import client.ClientManager;

public class MenuListener implements ActionListener {
	
	private boolean haveSaved;
	private SaveAsFile saveInstance;
	
	public MenuListener(){
		this.haveSaved = false;
		this.saveInstance = new SaveAsFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Save")) {
			if(haveSaved==false) {
				saveInstance.saveAs();
			} else {
				saveInstance.save();
			}
			if(saveInstance.currentFile!=null){
				haveSaved=true;
			}
			
		} else if(e.getActionCommand().equals("Open")) {
			OpenFile open = new OpenFile(saveInstance);
			haveSaved=true;
			ClientManager.displayArea.repaint();
		}
		if(e.getActionCommand().equals("New")) {
			haveSaved=false;
			ClientManager.shapes.clear();
			ClientManager.displayArea.repaint();
		}
		else if(e.getActionCommand().equals("Save As")) {
			saveInstance.saveAs();
			if(saveInstance.currentFile!=null){
				haveSaved=true;
			}
		} else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
	}
}
