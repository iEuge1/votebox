/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
package supervisor.model;

import java.util.Observer;

/**
 * Abstract notion of a machine on the VoteBox network.
 * @author cshaw
 */
public abstract class AMachine implements Comparable {

    private int serial;

    private int status;

    private int label;

    private boolean online;

    protected ObservableEvent obs;

    /**
     * Constructs a new machine with the given serial number
     * @param serial
     */
    public AMachine(int serial) {
        this.serial = serial;
        online = true;
        obs = new ObservableEvent();
    }

    /**
     * Adds an observer that will be notified when this machine is changed
     * @param o the observer
     * @see java.util.Observable#addObserver(java.util.Observer)
     */
    public void addObserver(Observer o) {
        obs.addObserver(o);
    }

    /**
     * Compares this machine to another machine, by their serial numbers.
     * @see java.lang.Comparable#compareTo(Object)
     */
    public int compareTo(Object o) {
        AMachine rhs = (AMachine) o;
        return serial - rhs.serial;
    }

    /**
     * @return this machine's label
     */
    public int getLabel() {
        return label;
    }

    /**
     * @return this machine's serial number
     */
    public int getSerial() {
        return serial;
    }

    /**
     * @return this machine's status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return whether this machine is online (that is, if there exists a direct
     *         link between this machine and the current machine)
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Sets this machine's label
     * @param label the label to set
     */
    public void setLabel(int label) {
        this.label = label;
        obs.notifyObservers();
    }

    /**
     * Sets whether this machine is online
     * @param online the online to set
     */
    public void setOnline(boolean online) {
        this.online = online;
        obs.notifyObservers();
    }

    /**
     * Sets this machine's serial number
     * @param serial the serial to set
     */
    public void setSerial(int serial) {
        this.serial = serial;
        obs.notifyObservers();
    }

    /**
     * Sets this machine's status
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
        obs.notifyObservers();
    }

}
