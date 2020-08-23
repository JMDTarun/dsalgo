package dsalgo.easy.algoexpert.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

	// 49. Group Anagrams
	// Medium
	//
	// 3798
	//
	// 193
	//
	// Add to List
	//
	// Share
	// Given an array of strings, group anagrams together.
	//
	// Example:
	//
	// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	// Output:
	// [
	// ["ate","eat","tea"],
	// ["nat","tan"],
	// ["bat"]
	// ]

	public static Collection<List<String>> groupAnagrams(String[] array) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : array) {
			String sortedString = Stream.of(str.split("")).sorted().collect(Collectors.joining());
			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(str);
			} else {
				List<String> tempList = new ArrayList<String>();
				tempList.add(str);
				map.put(sortedString, tempList);
			}
		}
		return map.values();
	}

	public static void main(String[] args) {
		String[] array = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(array));
	}

}
