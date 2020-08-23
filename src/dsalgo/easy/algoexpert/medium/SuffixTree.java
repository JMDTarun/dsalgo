package dsalgo.easy.algoexpert.medium;

import java.util.Map;

import dsalgo.common.TrieNode;

public class SuffixTree {

	TrieNode root;

	public SuffixTree() {
		root = new TrieNode();
	}

	public void add(String str) {
		Map<Character, TrieNode> map = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				t = map.get(c);
			} else {
				t = new TrieNode(c);
				map.put(c, t);
			}
			map = t.children;
			if (i == str.length() - 1) {
				t.isWordEnd = true;
			}
		}
	}

	public boolean search(String s) {
		TrieNode t = searchNode(s);
		if (t != null && t.isWordEnd) {
			return true;
		} else {
			return false;
		}
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
		SuffixTree trie = new SuffixTree();
		trie.add("cat");
		trie.add("car");
		trie.add("camera");
		trie.add("dog");
		trie.add("fog");

		System.out.println(trie.search("ca"));
		System.out.println(trie.startsWith("ca"));

	}
}
