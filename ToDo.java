import java.util.*;
import java.util.concurrent.atomic.*;

public class ToDo {
	static AtomicInteger nextId = new AtomicInteger();
	private int id;
	private String task;
	private boolean complete = false;

	public ToDo(String description) {
		id = nextId.incrementAndGet();
		task = description;
	}

	public void setTask(String str) {
		task = str;
	}

	public int getId() {
		return id;
	}

	public String getTask() {
		return task;
	}

	public boolean getComplete() {
		return complete;
	}

	public boolean equals(int id) {
		if (id == this.id) {
			return true;
		} else {
			return false;
		}
	}

	public void completeTask() {
		complete = true;
	}
}