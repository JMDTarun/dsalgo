package dsalgo.common;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public char c;
	public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	public boolean isWordEnd;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}
}
