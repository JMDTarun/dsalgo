package dsalgo.common;

import java.util.Map;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void add(String s) {
		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode();
				children.put(c, t);
			}
			children = t.children;
			if (i == s.length() - 1) {
				t.isWordEnd = true;
			}
		}
	}

	public boolean search(String word) {
		TrieNode t = searchNode(word);

		if (t != null && t.isWordEnd)
			return true;
		else
			return false;
	}

	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String str) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}

		return t;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("cat");
		trie.add("car");
		trie.add("camera");
		trie.add("dog");
		trie.add("fog");

		System.out.println(trie.search("ca"));
		System.out.println(trie.startsWith("cay"));

	}

}
