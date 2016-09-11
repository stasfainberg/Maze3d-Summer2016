package controller.Commands;

import java.util.HashMap;

import controller.Command;
import model.Model;

public class HelpCommand implements Command {

	
	private Model model;
	private HashMap<String, Command> commands;
	
	public HelpCommand(Model model, HashMap<String, Command> commands) {
		this.model = model;
		this.commands = commands;
	}
	
	@Override
	public void doCommand(String[] args) {
		model.help(commands);
	}

}
