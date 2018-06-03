package contract;

/**
 * <h1>The class controller order.</h1>
 * @author DELL
 *
 */
public enum ControllerOrder {

	/** The hero goes UP */
	UP,

	/** The hero goes DOWN */
	DOWN,

	/** The hero goes LEFT */
	LEFT,

	/** The hero goes RIGHT */
	RIGHT,
	
	/** The hero is standing still */
	NOP,
	
	/** The hero goes UPRIGHT */
	UPRIGHT,
	
	/** The hero goes UPLEFT */
	UPLEFT,
	
	/** The hero goes DOWNRIGHT*/
	DOWNRIGHT,

	/** The hero goes DOWNLEFT */
	DOWNLEFT,
	
	/** The hero throws a spell*/
	SPACE,

	/** Restart the level*/
	RETRY;
	
}
