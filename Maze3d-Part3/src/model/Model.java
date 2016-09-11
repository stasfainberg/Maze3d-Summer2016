package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

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







