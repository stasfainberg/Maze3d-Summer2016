package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.Controller;

public class MyView implements View {

	private BufferedReader in;
	private PrintWriter out;
	private CLI cli;
	private Controller controller;
	private HashMap<String, Command> commands;
	
	public MyView(Controller controller, BufferedReader in, PrintWriter out)
	{		
		this.in = in;
		this.out = out;
		
	}
			
	@Override
	public void displayMessage(String message) {
		System.err.println(message);
//		out.write(message);
//		out.flush();
				
	}

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

	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		this.commands = commands;
		cli = new CLI(in, out, commands);
	}
	
	@Override
	public void displayMaze(Maze3d maze) {
		out.write(maze.toString());
		out.flush();
					
	}
	
	public HashMap<String, Command> getCommands(){
		return this.commands;
		
	}
	
	
	
	
	
}

