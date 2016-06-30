package bean;

import java.util.HashSet;
import java.util.Set;

import constant.Constants;

/**
 * 
 * @author ThaoTP1
 *
 */
public class BusDriver {
	public BusDriver() {
	}
	public int id;
	public int[] route;
	public int curRouteIndex;
	public int numRoute;
	public int minuteTime;
	public Set<Integer> gossips = new HashSet<Integer>();

	/**
	 * Go next Stop.
	 */
	public void goNext() {
		minuteTime = minuteTime + Constants.driveTime;
		numRoute++;
	}

	/**
	 * Gossip
	 * 
	 * @param newGossips
	 */
	public void gossip(Set<Integer> newGossips) {
		boolean bGossip = false;
		if (newGossips.size() >= gossips.size() && 
				!gossips.containsAll(newGossips)) {
			bGossip = true;
			gossips.addAll(newGossips);
		}
		if (bGossip) {
			minuteTime = minuteTime + Constants.gossipTime;
		}
	}
	/**
	 * Get route
	 * @return
	 */
	public int getCurrentRoute() {
		int index = (numRoute % route.length) - 1;
		return route[index];
	}
}
