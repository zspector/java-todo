import java.util.*;

public class ToDoList {
	private ArrayList<ToDo> toDoList = new ArrayList<ToDo>();

	public void addToDo(ToDo toDo) {
		toDoList.add(toDo);
	}

	public void showList() {
		if (toDoList.size() == 0) {
			System.out.println("No To Dos have been created.");
		} else {
			System.out.println("");
			for (ToDo toDo : toDoList) {
				System.out.println(String.format("ID: %d", toDo.getId()));
				System.out.println(String.format("To Do: %s", toDo.getTask()));
				System.out.println(String.format("Completed: %b", toDo.getComplete()));
				System.out.println("################");
			}
		}
	}

	public void completeToDo(int id) {

		ToDo currentToDo;
		for (int i = 0; i < toDoList.size(); i++) {
			currentToDo = toDoList.get(i);
			if (currentToDo.hasId(id)) {
				currentToDo.completeTask();
				System.out.println(String.format("%s has been completed", currentToDo.getTask()));
				break;
			}
		}
	}
}