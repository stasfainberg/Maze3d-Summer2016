package controller.Commands;

import controller.Command;
import model.Model;


/**
 * <h1>DisplayCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DisplayCommand implements Command {

	
	/******************************* Data Members **************************/

	Model model;
	
	/******************************* Constructors **************************/

	public DisplayCommand(Model model) {
		this.model = model;
	}
	
	/******************************* Methods **************************/

	@Override
	public void doCommand(String[] args) {
		model.display();
	}

}
