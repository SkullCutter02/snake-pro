package Model;

/**
 * Model.CellType - is an enumeration (aka enum) rather than an class. Enumerations
 * are used when we want behavior like a class (i.e., methods), but we don't
 * want people to be able to make additional objects of the type. We should only
 * have a set number of these objects. You'll notice that the constructor is
 * private. We get an error if we try to make the constructor public! Instead of
 * creating this enum, we could have had the Model.BoardCell store a String (e.g. "*",
 * "X", "H", "B", or " ") to keep track of the type. However, if we accidentally
 * set the type to be "M" or some other invalid String we wouldn't get any
 * compile time check! If we use this enum (i.e., Model.CellType) we can't incorrectly
 * set the type within Model.BoardCell.
 * 
 * STYLE NOTE: It would be better to put this enum inside of the Model.BoardCell class,
 * because no other class should need to know that this exists, BUT we thought
 * that'd be more confusing! We could also use packages to limit access to it,
 * but thought that might make it too hard for people to set up their homework
 * files and start coding!
 * 
 * @author CS60 instructors
 */
public enum CellType {
	// The first thing in an enum has to be a list of the objects.
	// NAME_OTHERS_WILL_REFERENCE(args to the constructor if applicable)
	WALL("*"), OPEN(" "), FOOD("X"), HEAD("H"), BODY("B");

	// CellTypes store a single instance variable:
	private final String displayChar;

	// Private constructor for the enumeration
	private CellType(String inputChar) {
		this.displayChar = inputChar;
	}

	// return a String representing the Model.CellType
	public String getDisplayChar() {
		return this.displayChar;
	}

}
