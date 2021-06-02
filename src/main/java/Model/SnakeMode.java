package Model;

/**
 * Model.SnakeMode - is an enumeration (aka enum) rather than an class. Enumerations
 * are used when we want behavior like a class (i.e., methods), but we don't
 * want people to be able to make additional objects of the type. We should only
 * have a set number of these objects. Instead of creating this enum, we could
 * have had Model.SnakeProData store a String (e.g. "N", "S", "E", "W", or "A")
 * to keep track of the mode. However, if we accidentally set the mode to be "M"
 * or some other invalid String we wouldn't get any compile time check! If we
 * use this enum (i.e., Model.SnakeMode) we can't incorrectly set the mode within
 * SnakeProMode.
 * 
 * @author CS60 instructors
 */
public enum SnakeMode {
	// The first thing in an enum has to be a list of the objects.
	GOING_NORTH, GOING_SOUTH, GOING_EAST, GOING_WEST, AI_MODE;
}
