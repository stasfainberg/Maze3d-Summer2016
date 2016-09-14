package controller.Commands;

import javax.swing.text.View;

import controller.Command;
import model.Model;

/**
 * <h1>DirCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DirCommand implements Command {

	/******************************* Data Members **************************/
	private Model model;
	private View view;
	
	
	
	/******************************* Constructors **************************/

	public DirCommand(Model model) {
		this.model = model;
	}


	/******************************* Methods **************************/
	/**
	 * This doCommand() method located in the DirCommand class which is implementing the Command interface.
	 * Executing this method will call the dir() method located in the Model interface.
	 * <h1></h1>
	 * dir() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		
		model.dir();
		
		
	}
	
	
	
	
	

}
