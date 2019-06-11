public class Marker {

	// fields should be private
	// these are instance variables
	private String inkColor;
	private String markerType;

	// getters and setters  - control access to internal state 
	public String getInkColor() {
		return this.inkColor; // 'this' is the current object
	}
	public String getMarkerType() {
		return this.markerType;
	}
	public void setInkColor(String inkColor) {
		this.inkColor = inkColor; 
	/* 
		both the method and the instance have an 'inkColor' 
variable. Inner (local/method) scope takes precedence, use 'this' to 
refer to the outer (instance) scope. 
	*/	
	}
	public void setMarkerType(String markerType) {
		this.markerType = markerType;
	}

	/* toString  - provide a string representation of the object, inherited from Object 
 	The @Override annotation indicates to the compiler that the method should override a method 
in a parent type */
	@Override 
	public String toString() {
		return "Marker: [inkColor="+this.inkColor+", markerType="+this.markerType+"]";
	}

}
