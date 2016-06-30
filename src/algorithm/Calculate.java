package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.BusDriver;
import constant.Constants;

/**
 * Algorithm to calculate the number of stops after all the bus driver on broad
 * with all gossip.
 * 
 * @author ThaoTP1
 *
 */
public class Calculate {
	/**
	 * 
	 * @param drivers
	 */
	public void go(List<BusDriver> drivers) {
		
		for (int time = 0; time <= Constants.maxMinutesPerDay; time++) {
			Map<Integer, GossipGroup> groupLst = findDriveHaveTheSameRoute(
					drivers, time);
			
		}

	}

	/**
	 * 
	 * @param drivers
	 * @return
	 */
	public Map<Integer, GossipGroup> findDriveHaveTheSameRoute(
			List<BusDriver> drivers, int time) {
		Map<Integer, GossipGroup> groupLst = new HashMap<Integer, GossipGroup>();

		for (BusDriver driver : drivers) {
			if (time == driver.minuteTime) {

				if (groupLst.containsKey(driver.getCurrentRoute())) {
					groupLst.get(driver.getCurrentRoute()).add(driver);
				} else {
					GossipGroup group = new GossipGroup();
					group.add(driver);
					group.route = driver.getCurrentRoute();
					groupLst.put(group.route, group);
				}
			}
		}
		return groupLst;
	}

}
