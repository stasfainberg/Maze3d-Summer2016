package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

/**
 * <h1>View</h1>
 * 
 * @author Stas Fainberg
 * @version 1.0
 */
public interface View {
	
	void displayMessage(String message);
	void start();
	void sendCommands(HashMap<String, Command> commands);
	void displayMaze(Maze3d maze);
	
	
	
	
	
	
}
