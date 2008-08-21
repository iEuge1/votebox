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
package votebox.events;

import java.util.ArrayList;

/**
 * The VoteBoxEventNotifier can be treated as a VoteBoxEventListener, as it
 * implements all of the methods. However it differs in that it contains an
 * array of listeners, and forwards events received onto those listeners (in the
 * order they were registered).
 * 
 * @author cshaw
 */
public class VoteBoxEventNotifier implements VoteBoxEventListener {

    ArrayList<VoteBoxEventListener> listeners;

    /**
     * Constructs a new VoteBoxEventNotifier with an empty list of listeners.
     */
    public VoteBoxEventNotifier() {
        listeners = new ArrayList<VoteBoxEventListener>();
    }

    public void activated(ActivatedEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.activated(e);
    }

    /**
     * Adds a listener to this notifier.
     * 
     * @param l
     *            the listener
     */
    public void addListener(VoteBoxEventListener l) {
        listeners.add(l);
    }

    public void assignLabel(AssignLabelEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.assignLabel(e);
    }

    public void authorizedToCast(AuthorizedToCastEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.authorizedToCast(e);
    }

    public void ballotReceived(BallotReceivedEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.ballotReceived(e);
    }

    public void castBallot(CastBallotEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.castBallot(e);
    }

    public void joined(JoinEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.joined(e);
    }

    public void lastPollsOpen(LastPollsOpenEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.lastPollsOpen(e);
    }

    public void left(LeaveEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.left(e);
    }

    public void overrideCancel(OverrideCancelEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCancel(e);
    }

    public void overrideCancelConfirm(OverrideCancelConfirmEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCancelConfirm(e);
    }

    public void overrideCancelDeny(OverrideCancelDenyEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCancelDeny(e);
    }

    public void overrideCast(OverrideCastEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCast(e);
    }

    public void overrideCastConfirm(OverrideCastConfirmEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCastConfirm(e);
    }

    public void overrideCastDeny(OverrideCastDenyEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.overrideCastDeny(e);
    }

    public void pollsClosed(PollsClosedEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.pollsClosed(e);
    }

    public void pollsOpen(PollsOpenEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.pollsOpen(e);
    }

    public void pollsOpenQ(PollsOpenQEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.pollsOpenQ(e);
    }

    /**
     * Removes a listener from this notifier.
     * 
     * @param l
     *            the listener
     */
    public void removeListener(VoteBoxEventListener l) {
        listeners.remove(l);
    }

    public void supervisor(SupervisorEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.supervisor(e);
    }

    public void votebox(VoteBoxEvent e) {
        for (VoteBoxEventListener l : listeners)
            l.votebox(e);
    }

    public void challengeResponse(ChallengeResponseEvent e) {
    	for (VoteBoxEventListener l : listeners)
            l.challengeResponse(e);
    }
    
    public void challenge(ChallengeEvent e) {
    	for (VoteBoxEventListener l : listeners)
            l.challenge(e);
    }

    public void commitBallot(CommitBallotEvent e) {
    	for (VoteBoxEventListener l : listeners)
            l.commitBallot(e);
    }

	public void ballotCounted(BallotCountedEvent e) {
		for(VoteBoxEventListener l : listeners)
			l.ballotCounted(e);
	}

}
