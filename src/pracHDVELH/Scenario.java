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
		
		MessageEvent porteEnFerEvent = new MessageEvent(gui, "Ça ne s'ouvrira pas...");
		
		Event head = new ChoiceEvent(gui, "Trois portes s'offrent à vous. Laquelle choisissez-vous ?",
			Choice.all(
				new Choice("La porte en or",
					new ChoiceEvent(gui, "Aussitôt entrez-vous, que les lumières s'éteignent et que la porte se ferme derrière vous !",
						Choice.all(
							new Choice("Retourner à la porte",
								new MessageEvent(gui, "Vous trébuchez et vous faites assomer.")),
							new Choice("Crier \"Qui va là ?\"",
								new MessageEvent(gui, "Quelque chose vous bouscule aussitôt.")),
							new Choice("Rester silencieux",
								new ChoiceEvent(gui, "Après quelques minutes, une lumière apparaît au loin...",
									Choice.all(
										new Choice("Retourner à la porte",
											new MessageEvent(gui, "Vous vous faites prendre au piège par des sables mouvants")
										),
										new Choice("Se rapprocher de la lumière",
											new MessageEvent(gui, "La lumière vous éblouit..."))
									)
								)
							)
						)
					)
				),
				new Choice("La porte en fer", porteEnFerEvent),
				new Choice("La porte en bois", new MessageEvent(gui, "Vous découvrez un coffre !.. c'est peut-être un piège."))
			)
		);
		
		porteEnFerEvent.setNextEvent(head);
		
		head.run();
	}
}

// eof