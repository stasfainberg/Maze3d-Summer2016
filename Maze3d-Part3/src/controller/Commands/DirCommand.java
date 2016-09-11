package controller.Commands;

import javax.swing.text.View;

import controller.Command;
import model.Model;

/**
 * <h1>DirCommand</h1>
 * @author Stas Fainberg
 * @version 1.0
 * 
 */
public class DirCommand implements Command {

	/******************************* Data Members **************************/
	private Model model;
	private View view;
	
	
	
	/******************************* Constructors **************************/

	public DirCommand(Model model) {
		this.model = model;
	}


	/******************************* Methods **************************/

	@Override
	public void doCommand(String[] args) {
		
		model.dir();
		
		
	}
	
	
	
	
	

}
