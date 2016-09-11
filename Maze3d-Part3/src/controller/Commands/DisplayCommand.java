package controller.Commands;

import controller.Command;
import model.Model;

public class DisplayCommand implements Command {

	Model model;
	
	public DisplayCommand(Model model) {
		this.model = model;
	}
	
	
	@Override
	public void doCommand(String[] args) {
		model.display();
	}

}
