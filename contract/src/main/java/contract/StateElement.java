package contract;

/**
 *Sees if an item is collectable or not.
 *@author Romain
 */
public enum StateElement {

    /** It can be picked up. */
    COLLECTABLE,

    /** It can not be picked up. */
    FIXED,

    /** It is a door. */
    DOOR,

    /** It is a dragon.*/
    DRAGON,

    /** It is a spell. */
    SPELL,

    /** It is dead. */
    DEATH,

    /** It can use a spell. */
    WEAK,

    /** It can not use a spell. */
    STRONG

}