package as3879.cs576.project;

public enum Rank {
	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT;
	
	public Rank getNext() {
	     return this.ordinal() < Rank.values().length - 1 ? Rank.values()[this.ordinal() + 1] : null;
	}
	
	public Rank getPrev() {
	     return this.ordinal() > 0 ? Rank.values()[this.ordinal() - 1] : null;
	}
	
	public boolean lessThan(Rank r){
		return this.ordinal() < r.ordinal();
	}
	
}
