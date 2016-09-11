package controller.Commands;

import controller.Command;
import model.Model;

public class SaveMazeCommand implements Command {

	private Model model;
	
	public SaveMazeCommand(Model model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] args) {
		

		
		
//		Scanner input = new Scanner(System.in);
//		String mazeName = null;
//		String fileName = null;
//		
//		
//		do {
//			System.out.println("what is the maze name? ");
//			mazeName = input.nextLine();
//		} while (mazeName.length() == 0);
//		System.out.println("name is: "+mazeName);
//		
//		
//		
//		
//		do {
//			System.out.println("Under which file name would you like to save it? ");
//			fileName = input.nextLine();
//		} while (fileName.length() == 0);
//		System.out.println("name is: "+fileName);

		
		
		model.saveMaze();
	}

}

