package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import controller.Command;


/**
 * @author Stas Fainberg
 * @version 1.0
 * <h1>CLI</h1>
 * This class defines the cli interface.
 */
public class CLI{
	
	/******************************* Data Memebers *******************************/
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> commands;
	
	
	/******************************* Constructors *******************************/
	public CLI(BufferedReader in, PrintWriter out, HashMap<String,Command> commands) {
		this.in = in;
		this.out = out;
		this.commands = commands;
	}
	
	
	
	
	
	/******************************* Methods *******************************/

	public void start() {
		System.out.println("==================================================================");
		System.out.println("==================== Welcome to CLI interface ====================");
		Thread thread = new Thread(new Runnable() {

			
			@Override
			public void run() {
				Scanner input = new Scanner(System.in);
				String userLine = null;
				
				do {
					System.out.println("\n> Please type in command or type 'help': ");
					userLine = input.nextLine();
				} while (userLine.length() == 0);
				
//					out.write("> Please type in command or type 'help': ");
//					out.flush();
//					String userString = in.readLine();
				while (!(userLine.equals("exit"))) {
					
					String[] arrayOfUserStrings = userLine.split(" ");
					String currentCommand = "";
					int i = 0;					
					
					
					Command command = null;
					while (command == null && i < arrayOfUserStrings.length) {
													
						if (arrayOfUserStrings.length < 2) 
						{
							for (int b = 0; b < arrayOfUserStrings.length; b++) 
							{
								currentCommand += arrayOfUserStrings[b];
							}
						}else
						{
							for (int b = 0; b < arrayOfUserStrings.length; b++) 
							{
								currentCommand += arrayOfUserStrings[b];
								currentCommand += " ";
							}
							currentCommand = currentCommand.substring(0, currentCommand.length()-1);
						}
												
						command = commands.get(currentCommand);
						currentCommand += " ";
						i++;
					}
					
					if (command == null) {
						out.write("> Command not found\n");
						out.flush();							
					} else 
					{
						
						String[] args = null;
						if (i <= arrayOfUserStrings.length) 
							args = new String[arrayOfUserStrings.length];
					
						command.doCommand(args);						
					}					
					

					do {
						System.out.println("\n> Please type in command or type 'help': ");
						userLine = input.nextLine();
					} while (userLine.length() == 0);

				
				}	
					System.out.println("================== CLI interface was terminated ==================");
					System.out.println("==================================================================");
			}
			
		});
		thread.start();
	}
	
	
	public HashMap<String, Command> getCommands(){
		return this.commands;
	}

	
	
	
	
		
		
}