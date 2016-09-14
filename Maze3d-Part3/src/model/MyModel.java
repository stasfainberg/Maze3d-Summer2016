package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.demo.MazeAdapter;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.BestFirstSearch;
import algorithms.search.DFS;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 *<h1>MyModel</h1>
 * @author Stas Fainberg
 * This class receives the commands from the presenter and execute them.
 * When the model is done the message is sent to the presenter.
 */
public class MyModel implements Model {
	
	
	
	/********************************* Data Members *********************************/
	private Controller controller;
	private ArrayList<Thread> threads = new ArrayList<Thread>();
	private HashMap<String, Maze3d> mazes = new HashMap<String, Maze3d>();
	private HashMap<Maze3d, Solution> mazeToSol = new HashMap<Maze3d, Solution>();
	private NavigableMap<String,Integer> map = new TreeMap<String, Integer>();
	public static int count = 0;
	String mazeName = null;
	ExecutorService executor;
	private static final int threadsNum = 20;

	
	
	/********************************* Constructors *********************************/
	public MyModel(Controller controller)
	{
		this.controller = controller;
		executor = Executors.newFixedThreadPool(threadsNum);

	}
	
	
	
	
	
	/********************************** Methods *********************************/
	/**
	 * This generateMaze() function generates a maze3d according to the usre's input.
	 * During the runtime user is asked for parameters:
	 * - Maze3d name.
	 * - Maze3d floors number.
	 * - Maze3d rows number.
	 * - Maze3d columns number.
	 */
	@Override
	public void generateMaze() {
		
		Scanner input = new Scanner(System.in);
		
		do {
			do {
				System.out.println("> Please type the maze name? ");
				mazeName = input.nextLine();
			} while (mazeName.length() == 0);
			if(mazes.containsKey(mazeName))
				controller.displayMessage("> Information>> Maze name" + mazeName + " is already exist.\n");
		} while (mazes.containsKey(mazeName));
		
		
		
		System.out.println("> What size of maze would you like to create? ");
	    int floor;
		do {
			System.out.print("> Please enter number of floors: ");
			while (!input.hasNextInt()){
				input.next();
				System.out.print("> Please enter a NUMBER of floors: ");
			}
			floor = input.nextInt();
			if(floor < 0)
				System.out.println("> Please enter positive number of floors");
		} while (floor < 0);
	    
		
		int rows;
		do {
			System.out.print("> Please enter number of rows: ");
			while (!input.hasNextInt()){
				input.next();
				System.out.print("> Please enter a NUMBER of rows: ");
			}
			rows = input.nextInt();
			if(rows < 0)
				System.out.println("> Please enter positive number of rows");
		} while (rows < 0);
	    
		
		int cols;
		do {
			System.out.print("> Please enter number of cols: ");
			while (!input.hasNextInt()){
				input.next();
				System.out.print("> Please enter a NUMBER of cols: ");
			}
			cols = input.nextInt();
			if(cols < 0)
				System.out.println("> Please enter positive number of cols");
		} while (cols < 0);
		
		int localFloor = floor;
		int localRows = rows;
		int localCols = cols;
		String localMazeName = mazeName;
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {	
				
				
				
				GrowingTreeGenerator mg = new GrowingTreeGenerator();
				Maze3d maze = mg.generate(localFloor, localRows, localCols);
				mazes.put(localMazeName, maze);
				map.put(localMazeName, count++);
					
				controller.displayMessage("> System Message>> Maze " +'"'+ localMazeName +'"'+ " was created.");				
			}				
		});
		thread.start();	
		threads.add(thread);
	}

	
	
	
	
	
	
	/**
	 * This save() function saves the maze with a name to file with filename.
	 * @param name - name of the maze.
	 * @param fileName - name of the file.
	 */
	@Override
	public void saveMaze() {
		
		if(mazes.isEmpty()){
			System.err.println("> Information>> Cannot perform 'save' operation. "
					+ "Maze was not generated. Generate Maze3d first.");
			return;
		}

		Scanner input = new Scanner(System.in);
		String fileName = null;
		boolean check = false;
		
		do {
			do {
				System.out.println("> Please type file name to save the maze3d? ");
				fileName = input.nextLine();
			} while (fileName.length() == 0);
			
			check = new File(".", fileName).exists();
			
			if(check = new File(".", fileName).exists()){
				controller.displayMessage("> Information>> File name " + fileName + " is already exist.\n");
			}
		} while (check = new File(".", fileName).exists());
		
		
		String lastMaze3d = map.lastEntry().getKey();
		Maze3d maze = mazes.get(map.lastEntry().getKey());

		
		
		System.out.println("> maze3d = "+lastMaze3d);
		
		
		try {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
			byte[] bytes = maze.toByteArray();
			out.write(bytes.length);
			out.write(maze.toByteArray());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	/**
	 * This loadMaze() function loads a maze from a File.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public void loadMaze() {

		Scanner input = new Scanner(System.in);
		String fileName = null;
		Boolean check = false;
		byte[] myarry = null;

		do {
			do {
				System.out.println("> Please type file name to load or type 'explorer'? ");
				fileName = input.nextLine();
			} while (fileName.length() == 0);

			if (fileName.equals("explorer")) {
				this.dir();

				System.out.println("");

			} else {
				if (!(check = new File(".", fileName).exists())) {
					controller.displayMessage("> Information>> File name " + "'" + fileName + "'" + " was not found.\n");
					return;
				} else {
					try {

						InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
						int size = in.read();
						size=size*255;
						size=size + in.read();
						byte[] b =new byte[size];
						in.read(b);
						in.close();
						Maze3d Maze=new Maze3d(b);
						mazes.put(mazeName, Maze);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						return;
					} catch (IOException e) {
						e.printStackTrace();
						return;
					}
				}

			}

		} while (!mazes.containsKey(fileName));
	}
	
	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);			
	}

	
	
	
	/**
	* This help() function prints out, all commands available for the user, to the console.
	* @param HashMap<String, Command> commands - holds whole commands according to their name.
	*/
	@Override
	public void help(HashMap<String, Command> commands) {
		System.out.println("\n> Please type in command according to the list below: ");

		ArrayList<String> aaa = new ArrayList<String>();

		
		Set<String> keys = commands.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			String key = (String) i.next();
			if(!(key.equals("help")))
			{
				if(!(key.equals("?")))
				{
					aaa.add(key);
				}
			}
		}
		

		System.out.println("");

		for (int i = 0; i < aaa.size(); i++) {
			System.out.println("> " + aaa.get(i));
		}
		
		
		
		

	}
	

	
	
	
	/** 
	 * This dir() function shows the content of a folder's path.
	 */
	@Override
	public void dir() {

		
		Scanner input = new Scanner(System.in);
		String userPath = null;
		
		do {
			System.out.println("> Which path's content to display or type 'home': ");
			userPath = input.nextLine();
		} while (userPath.length() == 0);
		
		
		if(userPath.equals("home")){
		
			File current = new File("."); // current directory
			
			File[] files = current.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.print("> directory:");
				} else {
					System.out.print(">      file:");
				}
				try {
					System.out.println(file.getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			File f = new File(userPath.toString());
			if (f.exists() && f.isDirectory()){
				
				File[] files = f.listFiles();
				for (File file : files) {
					if (file.isDirectory()) {
						System.out.print("> directory:");
					} else {
						System.out.print(">      file:");
					}
					try {
						System.out.println(file.getCanonicalPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			}else{
			System.err.println("> Information>> Path does not exist");
			}
			
			
		}
	
	}

	
	
	
	
	
	/**
	 * This display() function prints out the maze3d to the console. 
	 */
	@Override
	public void display() {
		
		
		if(mazes.isEmpty()){
			System.err.println("> Information>> Maze3d list is empty. No mazes to display. "
					+ "Generate Maze3d first.");
			return;
		}	
		
		Scanner input = new Scanner(System.in);
		String userLine = null;
		
		do{	
			do {
				System.out.println("> Please type maze3d name to display or type 'list': ");
				userLine = input.nextLine();
			}while (userLine.length() == 0);
						
			
			
			if (userLine.equals("list")) {
				System.out.println("> Please choose maze3d name according to the list below: ");
				Set<String> keys = mazes.keySet();
				for (Iterator<String> i = keys.iterator(); i.hasNext();) {
					String key = (String) i.next();
					System.out.println("> " + key);
				}
			
				System.out.println("");
				
			}else{
				if (!mazes.containsKey(userLine)) {
					controller.displayMessage("> Information>> Maze3d name " + "'"+userLine +"'" + " was not found.\n");
					return;
				}else {
					System.out.println(mazes.get(userLine).toString());
					return;
				}
				
			}
					
	
		} while (!mazes.containsKey(userLine));
				
	}


	

	
	
	/**
	 * This displayCroosSection() function prints out to the console 
	 * the cross section (x/y/z) of a maze3d, according to an index, as a 2D maze. 
	 * X represents floors
	 * Y Represents rows
	 * Z Represents columns
	 */
	@Override
	public void displayCroosSection() {
	
		if(mazes.isEmpty()){
			System.err.println("> Information>> Maze3d list is empty. Please generate Maze3d first.");
			return;
		}	
		
		Scanner input = new Scanner(System.in);
		String userLineName = null;
		String userLineSection = null;
		int userLineIndex = 0;
		
		do{	
			do {
				System.out.println("> Please type maze3d name to display or type 'list': ");
				userLineName = input.nextLine();

			}while (userLineName.length() == 0);		
			
			if (userLineName.equals("list")) {
				System.out.println("> Please choose maze3d name according to the list below: ");
				Set<String> keys = mazes.keySet();
				for (Iterator<String> i = keys.iterator(); i.hasNext();) {
					String key = (String) i.next();
					System.out.println("> " + key);
				}
			
				System.out.println("");
				
			}else{
				if (!mazes.containsKey(userLineName)) {
					controller.displayMessage("> Information>> Maze3d name " + "'"+userLineName +"'" + " was not found.\n");
				}
			}
			
		} while (!mazes.containsKey(userLineName));
				

	
		

		System.out.println("> Please type which section do you want to display ('x' or 'y' or 'z'): 'x' is floor, 'y' is rows and 'z' is columns");
		userLineSection = input.nextLine();

		if (userLineSection.equals("X") || userLineSection.equals("x") || userLineSection.equals("Y") || userLineSection.equals("y") || userLineSection.equals("Z") || userLineSection.equals("z")) 
		{
			Maze3d maze = mazes.get(userLineName);
			switch (userLineSection) {
				case "x":
					int tmpx = getCrossIndex("x");
					int[][] maze2dx=maze.getCrossSectionByX(userLineIndex);
					maze.printCrossSection(maze2dx);
					break;
				case "y":
					int tmpy = getCrossIndex("y");
					int[][] maze2dy=maze.getCrossSectionByY(userLineIndex);
					maze.printCrossSection(maze2dy);
					break;
				case "z":
					int tmpz = getCrossIndex("z");
					int[][] maze2dz=maze.getCrossSectionByZ(userLineIndex);
					maze.printCrossSection(maze2dz);
					break;
				case "X":
					int tmpX = getCrossIndex("X");
					int[][] maze2dX=maze.getCrossSectionByX(userLineIndex);
					maze.printCrossSection(maze2dX);					
					break;
				case "Y":
					int tmpY = getCrossIndex("Y");
					int[][] maze2dY=maze.getCrossSectionByY(userLineIndex);
					maze.printCrossSection(maze2dY);
					break;
				case "Z":
					int tmpZ = getCrossIndex("Z");
					int[][] maze2dZ=maze.getCrossSectionByZ(userLineIndex);
					maze.printCrossSection(maze2dZ);
					break;
			default:
				break;
			}
			
		}else
		{
			controller.displayMessage("> Information>> Invalid section!\n");
			return;
		}

		
	}

	
	
	
	
	
	/**
	 * This getCrossIndex() asks the user to choose an index number according to the maze3d parameters.
	 * @param String UserLineIndex - Defines the user's cross section choice.
	 * X represents floors
	 * Y Represents rows
	 * Z Represents columns
	 */
	public int getCrossIndex(String UserLineIndex) {

		Scanner input = new Scanner(System.in);
		int userLineIndex = 0;

		Maze3d tmpMaze3d = mazes.get(mazeName);


		
		
		if(UserLineIndex.equals("x"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getFloor()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getFloor()) {
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}
				
				

			} while (userLineIndex < 0);
		}
		
		if(UserLineIndex.equals("X"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getFloor()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getFloor()) 
					{
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}

			} while (userLineIndex < 0);
		}
		
		if(UserLineIndex.equals("y"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getRows()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getRows()) {
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}
				
			} while (userLineIndex < 0);
		}
		
		if(UserLineIndex.equals("Y"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getRows()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getRows()) {
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}
			} while (userLineIndex < 0);
		}
		
		if(UserLineIndex.equals("z"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getCols()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getCols()) {
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}
			} while (userLineIndex < 0);
		}
		
		
		if(UserLineIndex.equals("Z"))
		{
			do {
				System.out.println("> Please type an index below "+tmpMaze3d.getCols()+": ");
				userLineIndex = Integer.parseInt(input.nextLine());
				if(input.hasNextInt())
				{
					if (userLineIndex < 0 || userLineIndex>tmpMaze3d.getCols()) {
						controller.displayMessage("> Information>> Invalid section! Please enter an index again\n");
						userLineIndex = -1;
					}
				}else
				{
					userLineIndex = -1;
				}
			} while (userLineIndex < 0);

		}
		
		
		return userLineIndex;
		
		
		
		
	}
	
	
	
	
	/**
	 * This solveMaze() function solves the maze3d by the given Algorithm DFS or Best First Search.
	 */
	@Override
	public void solveMaze() {
		
		if(mazes.isEmpty()){
			
			System.err.println("> Information>> Maze3d list is empty. Cannot perform 'solve_maze' action. "
					+ "Please generate or load maze3d first.\n");

			return;
		}
		
		Scanner input = new Scanner(System.in);
		String name;
		String algo;
		String userLine;
		
		do{	
			do {
				System.out.println("> Please type maze3d name to solve or type 'list': ");

				name = input.nextLine();
			}while (name.length() == 0);
			
			
			if (name.equals("list")) 
			{
				System.out.println("> Please choose maze3d name according to the list below: ");

				Set<String> keys = mazes.keySet();
				for (Iterator<String> i = keys.iterator(); i.hasNext();) {
					String key = (String) i.next();
					System.out.println("> " + key);

			}
			
				//System.out.println("");
				
			}else
			{
				if (!mazes.containsKey(name)) 
				{
					System.out.println("> Information>> Maze3d name " + "'"+name +"'" + " was not found.\n");

				}else 
				{
					
					do {
						System.out.println("> Please type which algorithm would you like to use for the solution: 'DFS' for Depth First Search / 'best' for Best_First_Search? ");

						algo = input.nextLine();
					}while (name.length() == 0);
					
					
					if (algo.equals("DFS") || algo.equals("dfs") || algo.equals("Best_First_Search") || algo.equals("best") || algo.equals("Best")) 
					{
						
						String finalName = name;
						String finalAlgo = algo;
						
						executor.submit(new Callable<Solution>() 
						{
							@Override
							public Solution call() throws Exception 
							{			
								//Check if the solution already exist
								Maze3d maze = mazes.get(finalName);
								MazeAdapter adapter = new MazeAdapter(maze);
								Searcher search = null;
								Solution sol = null;
								if(!(mazeToSol.containsKey(maze)))
								{	
									switch (finalAlgo) 
									{
									case "DFS":
										search = new DFS();
										break;
									case "Best_First_Search":
										search = new BestFirstSearch();
										break;
									case "dfs":
										search = new DFS();
										break;
									case "Best":
										search = new BestFirstSearch();
										break;
									case "best":
										search = new BestFirstSearch();
										break;
									default:
										break;
									}
									sol = search.search(adapter);
									mazeToSol.put(maze, sol); //add to maze solution (Hash Map)	
								}
								System.out.println("Solution for " + finalName + " is ready \n");

								return sol;
							}
						});
					
					}else
					{
						
						System.out.println("> Information>> Wrong algorithm was typed.\n");

					}
				}	
			}		

		} while (!mazes.containsKey(name));
		

	}
	
	
	
	
	
	/**
	 * This displaySolution() function prints out a list of all maze3d positions 
	 * leading to the goal position.
	 */
	public void displaySolution() {
		
		if(mazes.isEmpty()){
			System.err.println("> Information>> Maze3d list is empty. Cannot display solution. "
					+ "Please generate or load maze3d first.\n");
			return;
		}
		
		Scanner input = new Scanner(System.in);
		String name;

		
		do{	
			do {
				System.out.println("> Please type maze3d name to display it's solution or type 'list': ");

				name = input.nextLine();
			}while (name.length() == 0);
						
			
			
			if (name.equals("list")) {
				System.out.println("> Please choose maze3d name according to the list below: ");
				Set<String> keys = mazes.keySet();
				for (Iterator<String> i = keys.iterator(); i.hasNext();) {
					String key = (String) i.next();
					System.out.println("> " + key);
				}
			
				System.out.println("");
				
			}else{
				
				String lastMaze3d = map.lastEntry().getKey();
				Maze3d maze = mazes.get(lastMaze3d);
				
				
				if (!mazeToSol.containsKey(maze)) {
					System.out.println("> Information>> Solution for maze3d name " + "'"+name +"'" + " was not found. Generate a solution first.\n");
				}else {
					
					
					Solution sol = mazeToSol.get(mazes.get(name));
					ArrayList<algorithms.search.State> solToPrint = sol.getStates();
					for(int i=0; i<solToPrint.size();i++)
					{
						System.out.println(solToPrint.get(i).toString());
					}
				}
			}
					
				
		} while (!mazes.containsKey(name));

	}
	
	
	
	
	
	/**
	 * This Exit() function closes all threads working in the background and closes the program.
	 */
	public void exit() {
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).stop();
		}
		controller.displayMessage("all Thread are stoped");
	
	}
	
	
	
	
	
}
