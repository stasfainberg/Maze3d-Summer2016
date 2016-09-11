package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

public interface View {
	
	void displayMessage(String message);
	void start();
	void sendCommands(HashMap<String, Command> commands);
	void displayMaze(Maze3d maze);
	
	
	
	
	
	
}
