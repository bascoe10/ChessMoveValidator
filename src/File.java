
public enum File {
	A,
	B,
	C,
	D,
	E,
	F,
	G,
	H;
	
	public File getNext() {
	     return this.ordinal() < File.values().length - 1
	         ? File.values()[this.ordinal() + 1]
	         : null;
	}
	
	public File getPrev() {
	     return this.ordinal() > 0
	         ? File.values()[this.ordinal() - 1]
	         : null;
	}
}