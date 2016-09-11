package controller.Commands;

import controller.Command;
import model.Model;

public class GenerateMazeCommand implements Command {
	
	
	
	private Model model;
	
	
	public GenerateMazeCommand(Model model) {
		this.model = model;
	}	
	
	@Override
	public void doCommand(String[] args) {
		

		
		
		
		
	    
//		int floor = Integer.parseInt(args[1]);
//		int rows = Integer.parseInt(args[2]);
//		int cols = Integer.parseInt(args[3]);
		
	    
	    
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int rows=0;
//		try {
//		System.out.println("please enter number of floors: ");
//		floor = Integer.parseInt(br.readLine());
//	} catch (NumberFormatException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	    
	    
//		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//		int rows=0;
//		try {
//		System.out.println("please enter number of rows: ");
//		rows = Integer.parseInt(br1.readLine());
//	} catch (NumberFormatException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	    
	    
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//		int cols=0;
//		try {
//			System.out.println("please enter number of cols: ");
//			cols = Integer.parseInt(br2.readLine());
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		model.generateMaze();
	}

	
	
	
	
	
	
}
