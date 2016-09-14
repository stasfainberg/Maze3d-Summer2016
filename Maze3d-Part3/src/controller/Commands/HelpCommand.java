package controller.Commands;

import java.util.HashMap;

import controller.Command;
import model.Model;

/**
 * <h1>HelpCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class HelpCommand implements Command {

	/******************************* Data Members **************************/

	private Model model;
	private HashMap<String, Command> commands;
	
	
	/******************************* Constructors **************************/

	public HelpCommand(Model model, HashMap<String, Command> commands) {
		this.model = model;
		this.commands = commands;
	}
	
	
	/******************************* Methods **************************/
	/**
	 * This doCommand() method located in the HelpCommand class which is implementing the Command interface.
	 * Executing this method will call the help() method located in the Model interface.
	 * <h1></h1>
	 * help() method can be implemented in any version by just implementing the Model interface.
	 */
	@Override
	public void doCommand(String[] args) {
		model.help(commands);
	}

}
