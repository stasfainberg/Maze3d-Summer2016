package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;
import controller.MyController;
import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class Run {

	public static void main(String[] args) {
		
			
		Controller controller = new MyController();
		Model model = new MyModel(controller);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		View view = new MyView(in, out);
		
		
		
		
		controller.setModel(model);
		controller.setView(view);
		
		controller.generateCommands();
		
		
		
		view.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
