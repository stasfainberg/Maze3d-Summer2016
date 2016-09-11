package controller;

import java.util.HashMap;

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
import sss.DirCommand;
import view.View;

public class MyController implements Controller {
	private Model model;
	private View view;
	private HashMap<String, Command> commands;
	
	public MyController()
	{
	}	
	
	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}

	@Override
	public void setModel(Model model) {
		this.model = model;		
	}

	@Override
	public void setView(View view) {		
		this.view = view;
	}	
	
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
	
	public HashMap<String, Command> getCommands(){
		return this.commands;
	}
		
	
	
	
	
	
	
}

