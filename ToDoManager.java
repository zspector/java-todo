import java.io.*;
import java.util.*;

public class ToDoManager {
	private static boolean isRunning;
	private static ToDoList list;

	public static void main (String[] args) {
		list = new ToDoList();

		runProgram();
	}

	public static void runProgram() {
		listCommands();

		isRunning = true;

		while (isRunning) {
			String userInput = getUserInput();

			executeUserCommand(userInput);
		}
	}

	public static void listCommands() {
		System.out.println("Welcome to To Do List 3000");
		System.out.println("\nAvailable Commands:");
		System.out.println("\t show - Shows all To Dos");
		System.out.println("\t create <ToDo> - Creates a new To Do where <ToDo> is the description");
		System.out.println("\t complete <ID> - Complete the task with the ID provided");
		System.out.println("\t help - Show these commands again");
		System.out.println("\t exit - Exits To Do List 3000");
	}

	public static String getUserInput() {
		String inputLine = null;

		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		} catch (IOException e) {
			System.out.println(String.format("IOException: %s", e));
		}

		return inputLine;
	}

	public static String getAction(String[] parts) {
		String action = "";

		for (int i = 0; i < parts.length; i++) {
			action += parts[i] + " ";
		}

		return action;
	}

	public static void executeUserCommand(String userCommand) {
		String [] parts = userCommand.split(" ");

		String command = parts[0].toLowerCase();
		String action = "";

		if (parts.length > 1) {
			action = getAction(Arrays.copyOfRange(parts, 1, parts.length));	
		}

		switch(command) {
			case "show":
				list.showList();
				break;
			case "create":
				if (action != "") {
					list.addToDo(new ToDo(action));
				} else {
					System.out.println("Can not create new To Do. User must provide a description");
				}
				break;
			case "complete":
				//Complete task
				int id;
				try {
					id = Integer.parseInt(action.trim());
				} catch (NumberFormatException e) {
					System.out.println("Not a number");
					id = 0;
				}
					
				if (id != 0) {
					list.completeToDo(id);
				} else {
					System.out.println("Invalid ID. Cannot complete task.");
				}
				break;
			case "help":
				listCommands();
				break;
			case "exit":
				isRunning = false;
				break;
			default:
				System.out.println("That is not a valid command. Please try again");
				listCommands();
				break;
		}
	}

}