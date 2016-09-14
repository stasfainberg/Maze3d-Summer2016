package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.Controller;

/**
 * <h1>MyView</h1>
 * 
 * @author Stas Fainberg
 * This class displays all the output from the controller to the users session 
 */
public class MyView implements View {

	
	/********************************* Data Members ***********************/

	private BufferedReader in;
	private PrintWriter out;
	private CLI cli;
	private HashMap<String, Command> commands;
	
	
	
	/*********************** Constructors ************************/
	/**
	 * This MyView() constructor initiates:
	 * <h1></h1>
	 * private BufferedReader in 
	 * <h1></h1>
	 * private PrintWriter out;
	 */
	public MyView(BufferedReader in, PrintWriter out)
	{		
		this.in = in;
		this.out = out;
		
	}
			
	
	/*************************************** Methods **********************************/
	/**
	 * This displayMessage() method prints out to the console a message, which is passed to it, 
	 * as an error message.
	 * @param String message - Holds the the string message to print out.
	 */
	@Override
	public void displayMessage(String message) {
		System.err.println(message);

				
	}

	/**
	 * This start() method initiates the start() method, in the CLI class, as a separated thread.
	 */
	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				cli.start();
			}
			
		});	
		thread.start();
	}

	
	
	
	
	/**
	 * This sendCommands() method passes the commands HashMap to the CLI class.
	 * So that if a user typing a command name it would be able to check if this command exist on the HashMap.
	 */
	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		this.commands = commands;
		cli = new CLI(in, out, commands);
	}
	
	
	
	/**
	 * This displayMaze() method initiates toString() method of a Maze3d class and 
	 * prints out the Maze3d to the console.
	 */
	@Override
	public void displayMaze(Maze3d maze) {
		out.write(maze.toString());
		out.flush();
					
	}
	
	
	
	/**
	 * This getCommands() method returns the HashMap holds all commands available to the user.
	 */
	public HashMap<String, Command> getCommands(){
		return this.commands;
		
	}
	
	
	
	
	
}

