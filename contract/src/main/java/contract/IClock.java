package contract;

public interface IClock {

    /**
     * gets the running state of the clock
     * @return boolean
     */
    boolean isStopped();

    /**
     * sets the state of the clock
     * @param stopped
     *      True or False.
     */
    void setStopped(boolean stopped);
}
