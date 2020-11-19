package pracHDVELH;

import java.util.ArrayList;
import java.util.Arrays;

public class Choice {
	private String message;
	private Event event;
	
	public Choice(String msg, Event e) {
		this.message = msg;
		this.event = e;
	}
	
	public static ArrayList<Choice> all(Choice... args) {
		return new ArrayList<Choice>(Arrays.asList(args));
	}
	
	
	// ACCESSORS 
	
	public String getMessage() { return this.message; }
	public Event getEvent() { return this.event; }
	
	public void setMessage(String msg) { this.message = msg; }
	public void setEvent(Event e) { this.event = e; }
}
