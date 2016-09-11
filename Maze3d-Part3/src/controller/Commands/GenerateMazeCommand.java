package controller.Commands;

import controller.Command;
import model.Model;



/**
 * <h1>GenerateMazeCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class GenerateMazeCommand implements Command {
	
	
	/******************************* Data Members **************************/

	private Model model;
	
	
	/******************************* Constructors **************************/

	public GenerateMazeCommand(Model model) {
		this.model = model;
	}	
	
	
	/******************************* Methods **************************/

	@Override
	public void doCommand(String[] args) {
	
		model.generateMaze();
	}

	
	
	
	
	
	
}
