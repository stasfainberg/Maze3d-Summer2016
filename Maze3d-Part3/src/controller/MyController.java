package controller;

import java.util.HashMap;

import controller.Commands.DirCommand;
import controller.Commands.DisplayCommand;
import controller.Commands.DisplayCrossSectionCommand;
import controller.Commands.DisplaySolutionCommand;
import controller.Commands.ExitCommand;
import controller.Commands.GenerateMazeCommand;
import controller.Commands.HelpCommand;
import controller.Commands.LoadMazeCommand;
import controller.Commands.SaveMazeCommand;
import controller.Commands.SolveCommand;
//import controller.Commands.help;
import model.Model;
import view.View;



/**
 * <h1>MyController</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class MyController implements Controller {
	
	/******************************* Data Members **********************************/
	private Model model;
	private View view;
	private HashMap<String, Command> commands;
	
	
	
	/******************************* Constructors **********************************/
	public MyController()
	{
	}	
	
	
	
	/***************************** Getters & Setters ********************************/
	/**
	 * This setModel() function sets the Model data member with the passed Model model.
	 * @param Model model - defines the Model class which is passed to this method.
	 */
	@Override
	public void setModel(Model model) {
		this.model = model;		
	}

	/**
	 * This setView() function sets the View data member with the passed View view.
	 * @param View view - defines the View class which is passed to this method.
	 */
	@Override
	public void setView(View view) {		
		this.view = view;
	}	
	
	/******************************* Methods **********************************/
	/**
	 *	This displayMessage() prints out a String which is passes to this method.
	 *@param String message - a String variable holds the message to display.
	 */
	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}


	/**
	 * This generateCommnds() method loads all available commands to a HashMap which is
	 * afterwards can be used by the user.
	 */
	public void generateCommands() {
		commands = new HashMap<String, Command>();
		commands.put("?", new HelpCommand(model,commands));
		commands.put("generate_maze", new GenerateMazeCommand(model));
		commands.put("save_maze", new SaveMazeCommand(model));
		commands.put("dir", new DirCommand(model));
		commands.put("display_maze", new DisplayCommand(model));
		commands.put("load_maze", new LoadMazeCommand(model));
		commands.put("display_cross_section", new DisplayCrossSectionCommand(model));
		commands.put("solve_maze", new SolveCommand(model));
		commands.put("display_solution", new DisplaySolutionCommand(model));

		commands.put("exit", new ExitCommand(model));
		commands.put("help", new HelpCommand(model,commands));
		view.sendCommands(commands);
	}
	
	
	/**
	 * This getCommands() method returns a HashMap list containing all commands which 
	 * was loaded to the system for user use.
	 */
	public HashMap<String, Command> getCommands(){
		return this.commands;
	}
		
	
	
	
	
	
	
}

