package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

/**
 * <h1>Model</h1>
 * @author Stas Fainberg
 * @version 1.0
 */


public interface Model {
	
	void generateMaze();
	void saveMaze();
	void loadMaze();
	Maze3d getMaze(String name);
	void help(HashMap<String, Command> commands);
	void dir();
	void display();
	void displayCroosSection();
	void solveMaze();
	void displaySolution();
	public void Exit();
	
	
	
	
	
	
}







