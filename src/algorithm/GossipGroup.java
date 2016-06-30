package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bean.BusDriver;

public class GossipGroup {
	public int route;
	public List<BusDriver> drivers = new ArrayList<BusDriver>();
	public Set<Integer> groupGossip = new HashSet<Integer>();

	/**
	 * 
	 */
	public void exchangeGossip() {
		for (BusDriver driver : drivers) {
			groupGossip.addAll(driver.gossips);
		}

		for (BusDriver driver : drivers) {
			driver.gossip(groupGossip);
		}

	}
	/**
	 * @param driver
	 */
	public void add(BusDriver driver) {
		drivers.add(driver);
	}
	
//	/**
//	 * 
//	 * @param driver
//	 * @return
//	 */
//	private boolean hasNewGossip(BusDriver driver) {
//		if (groupGossip.size() <= driver.gossips.size()
//				&& driver.gossips.containsAll(groupGossip)) {
//			return false;
//		}
//
//		return true;
//	}
}
