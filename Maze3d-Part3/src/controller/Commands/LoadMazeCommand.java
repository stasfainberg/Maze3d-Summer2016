package controller.Commands;

import controller.Command;
import model.Model;

public class LoadMazeCommand implements Command {

	Model model;
	
	public LoadMazeCommand(Model model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		model.loadMaze();
	}

}
