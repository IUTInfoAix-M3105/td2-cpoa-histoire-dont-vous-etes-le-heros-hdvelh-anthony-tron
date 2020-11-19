package pracHDVELH;

public class MessageEvent extends Event {

	Event nextEvent;
	
	public MessageEvent(GUIManager guiManager, String msg, Event nextEvent) {
		super(guiManager, msg);
		this.nextEvent = nextEvent;
	}
	
	public MessageEvent(GUIManager guiManager, String msg) {
		this(guiManager, msg, null);
	}
	
	@Override
	public void run() {
		guiManager.outputln(message);
		if (nextEvent != null)
			nextEvent.run();
	}
	
	
	// ACCESSEURS
	
	public Event getNextEvent() { return this.nextEvent; }
	public void setNextEvent(Event nextEvent) { this.nextEvent = nextEvent; }

}
