/**
 * File: ScenarioDG.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

/**
 * @author prost
 *
 */
public class Scenario {
	private static final String MSG_EMPTY_SCENARIO = "Sorry, no scenario was found.";
	private static final String MSG_FINALE = "That's all folks!";
	private Event head;
	private GUIManager gui;

	/* TO BE COMPLETED */

	/* MAIN */
	public static void main(String[] args) {
		GUIManager gui = new GUIManager();
		
		Event head = new Event(gui, "Trois portes s'offrent à vous. Laquelle choisissez-vous ?");
		
		head.setDaughters(
			Event.all(
				new Event(
					gui,
					"La grande porte en or",
					Event.all(
						new Event(gui, "Aussitôt ouvrez-vous la porte que quelqu'un vous attrape et ferme la porte derrière vous.")
					)
				),
				new Event(gui, "La trappe en bois"),
				new Event(gui, "La porte blindée")
			)
		);
		
		head.run();
	}
}

// eof