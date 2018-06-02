package contract;
/**
 * 
 * @author DELL
 *
 */
public interface IClock {

    /**
     * Gets the running state of the clock
     * @return boolean
     */
    boolean isStopped();

    /**
     * Sets the state of the clock
     * @param stopped
     *      True or False.
     */
    void setStopped(boolean stopped);
}
