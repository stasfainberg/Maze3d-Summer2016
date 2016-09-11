package controller.Commands;

import javax.swing.text.View;

import controller.Command;
import model.Model;

public class DirCommand implements Command {

	private Model model;
	private View view;
	
	
	public DirCommand(Model model) {
		this.model = model;
	}


	@Override
	public void doCommand(String[] args) {
		
		model.dir();
		
		
	}
	
	
	
	
	

}
