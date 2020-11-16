/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;


/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";

	private String playerAnswer;
	private GUIManager guiManager;
	private final int id;
	private int chosenPath;
	
	public Event(GUIManager gui, String data) {
		this.guiManager = gui;
		this.data = data;
		this.id = 0;
	}
	
	public Event() {
		this(new GUIManager(), null);
	}
	
	/*
	 * Event #[id] ([class]): [data]
	 */
	public String toString() {
		return "#" + id + " (" + this.getClass().getName() + "): " + data;
	}
	
	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		this.chosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return (String) data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return (Event) super.getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		super.setDaughter(daughter, i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return guiManager;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		guiManager = gui;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	
	public boolean isFinal() {
		return hasDaughters();
	}
	
	public int interpretAnswer() {
		int i = 0;
		
		while (i < daughters.length) {
			if (daughters[i].getData() == playerAnswer)
				return i;
			++i;
		}
		
		guiManager.outputln("Votre choix n'a pas été trouvé");
		
		return -1;
	}
	
	public void run() {
		guiManager.outputln((String)data);
		for (int i = 0; i < daughters.length; ++i) {
			guiManager.outputln((i+1) + "." + daughters[i].getData());
		}
		
		do {
			playerAnswer = guiManager.getInputReader().next();
		} while(indexIsOutOfRange(interpretAnswer()));
	}
	
}

// eof