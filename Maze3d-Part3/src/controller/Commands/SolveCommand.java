package controller.Commands;

import controller.Command;
import model.Model;

/**
 * *********** the Class SolveCommand ***************
 * @author Stas Fainberg and Idan Levy
 * @version 1.0
 * 
 */

public class SolveCommand implements Command {

	Model model;
	
	/**
	 * Constructor of SolveCommand
	 */ 
	public SolveCommand(Model model) {
		super();
		this.model = model;
	}
	
	/************************* doCommand() ***********************/
	/**
	 * the function solve the maze and running in a difference Thread 
	 * @param args - Arguments:
	 *  args[0] - Name of the Maze , args[1]- the Searcher Algorithm (DFS,BFS or Best first serach)
	 */
	@Override
	public void doCommand(String[] args) {
		model.solveMaze();
	}

}
