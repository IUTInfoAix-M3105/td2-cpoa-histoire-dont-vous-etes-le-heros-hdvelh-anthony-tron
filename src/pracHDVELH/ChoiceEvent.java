/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.ArrayList;


public class ChoiceEvent extends Event {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
	
	private ArrayList<Choice> choices;
	
	public ChoiceEvent(GUIManager gui, String msg, ArrayList<Choice> choices) {
		super(gui, msg);
		this.choices = choices;
	}
	
	
	public int interpretAnswer() {
		return Integer.valueOf(playerAnswer) - 1;
	}
	
	private boolean indexIsOutOfRange(int i) {
		return i < 0 || i >= choices.size();
	}
	
	public void run() {
		guiManager.outputln("");
		guiManager.outputln(this.message);
		
		for (int i = 0; i < choices.size(); ++i) {
			guiManager.outputln((i+1) + ". " + choices.get(i).getMessage());
		}
		
		do {
			playerAnswer = guiManager.getInputReader().next();
		} while(indexIsOutOfRange(chosenPath = interpretAnswer()));
		
				
		choices.get(chosenPath).getEvent().run();
	}
	
}

// eof