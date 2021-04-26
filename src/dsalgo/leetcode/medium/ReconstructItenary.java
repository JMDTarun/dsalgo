package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReconstructItenary {
	private static int counter = 0;

	public static List<String> findItinerary(List<List<String>> tickets) {
		List<String> list = new ArrayList<String>();
		int numOfTickets = tickets.size();
		Map<String, List<String>> adjencyList = new HashMap<String, List<String>>();

		for (List<String> ticket : tickets) {
			if (adjencyList.containsKey(ticket.get(0))) {
				adjencyList.get(ticket.get(0)).add(ticket.get(1));
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(ticket.get(1));
				adjencyList.put(ticket.get(0), temp);
			}
		}

		for (Entry<String, List<String>> entry : adjencyList.entrySet()) {
			entry.getValue().sort((a, b) -> a.compareTo(b));
		}
		list.add("JFK");
		findItineraryDfs("JFK", adjencyList, numOfTickets, list);
		return list;
	}

	public static void findItineraryDfs(String airport, Map<String, List<String>> adjencyList, int numberOfTickets,
			List<String> result) {
		if (!adjencyList.containsKey(airport)) {
			return;
		}

		List<String> tickets = adjencyList.get(airport);
		for (int i = 0; i < tickets.size(); i++) {
			String tkt = tickets.get(i);
			result.add(tkt);
			counter++;
			tickets.remove(i);
			findItineraryDfs(tkt, adjencyList, numberOfTickets, result);
			if (counter == numberOfTickets) {
				return;
			}
			counter--;
			try {
				tickets.add(i, tkt);
			} catch (Exception e) {
				e.printStackTrace();
			}

			result.remove(result.size() - 1);
		}

	}

	public static void main(String[] args) {

		List<List<String>> list = new ArrayList<List<String>>();

//		String[][] arr = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" }, { "ANU", "JFK" },
//				{ "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, { "ADL", "EZE" },
//				{ "EZE", "ADL" }, { "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" }, { "AXA", "AUA" },
//				{ "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" }, { "AUA", "ANU" } };

		String[][] arr = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };

//		String[][] arr = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };

		for (String[] a : arr) {
			list.add(Arrays.asList(a));
		}
		System.out.println(findItinerary(list));
	}
}
