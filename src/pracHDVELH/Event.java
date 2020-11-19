package pracHDVELH;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Event {

	protected String message;
	protected String playerAnswer;
	protected GUIManager guiManager;
	protected final int id;
	protected int chosenPath;
	
	public Event(GUIManager guiManager, String msg) {
		this.guiManager = guiManager;
		this.message = msg;
		
		this.id = -1;
		this.chosenPath = -1;
		this.playerAnswer = "";
	}
	
	public static ArrayList<Event> all(Event... args) {
		return new ArrayList<Event>(Arrays.asList(args));
	}
	
	// Event #[id] ([class]): [data]
	public String toString() {
		return "#" + id + " (" + this.getClass().getName() + "): " + message;
	}
	
	// ACCESSEURS :
	
	public String getPlayerAnswer() {
		return playerAnswer;
	}

	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	
	public int getChosenPath() {
		return chosenPath;
	}

	public void setChosenPath(int chosenPath) {
		this.chosenPath = chosenPath;
	}


	public GUIManager getGui() {
		return guiManager;
	}

	public void setGui(GUIManager gui) {
		guiManager = gui;
	}

	public int getId() {
		return id;
	}

	public abstract void run();
}
