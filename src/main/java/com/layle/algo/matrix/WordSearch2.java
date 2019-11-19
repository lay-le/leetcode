package com.layle.algo.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Created by layle on 2019-06-11.
 */
public class WordSearch2 {
    /**
     * For example, given words = ["oath","pea","eat","rain"] and board =
     * [
     * ['o','a','a','n'],
     * ['e','t','a','e'],
     * ['i','h','k','r'],
     * ['i','f','l','v']
     * ]
     * <p>
     * Return ["eat","oath"]
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {
                {
                        'o', 'a', 'a', 'n'
                },
                {
                        'e', 't', 'a', 'e'
                },
                {
                        'i', 'h', 'k', 'r'
                },
                {
                        'i', 'f', 'l', 'v'
                }
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(Arrays.toString(findWordsSolution1(board, words).toArray()));
        System.out.println(Arrays.toString(findWordsSolution2(board, words).toArray()));
    }

    public static List<String> findWordsSolution1(char[][] board, String[] words) {
        ArrayList<String> result = new ArrayList<String>();

        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char[][] newBoard = new char[m][n];
                    for (int x = 0; x < m; x++)
                        for (int y = 0; y < n; y++)
                            newBoard[x][y] = board[x][y];

                    if (dfsSolution1(newBoard, word, i, j, 0)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                result.add(word);
            }
        }

        return result;
    }

    public static boolean dfsSolution1(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || k > word.length() - 1) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';

            if (k == word.length() - 1) {
                return true;
            } else if (dfsSolution1(board, word, i - 1, j, k + 1)
                    || dfsSolution1(board, word, i + 1, j, k + 1)
                    || dfsSolution1(board, word, i, j - 1, k + 1)
                    || dfsSolution1(board, word, i, j + 1, k + 1)) {
                board[i][j] = temp;
                return true;
            }

        } else {
            return false;
        }

        return false;
    }

    static HashSet<String> result = new HashSet<String>();

    public static List<String> findWordsSolution2(char[][] board, String[] words) {
        //HashSet<String> result = new HashSet<String>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfsSolution2(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(result);
    }

    public static void dfsSolution2(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (visited[i][j])
            return;

        str = str + board[i][j];

        if (!trie.startsWith(str))
            return;

        if (trie.search(str)) {
            result.add(str);
        }

        visited[i][j] = true;
        dfsSolution2(board, visited, str, i - 1, j, trie);
        dfsSolution2(board, visited, str, i + 1, j, trie);
        dfsSolution2(board, visited, str, i, j - 1, trie);
        dfsSolution2(board, visited, str, i, j + 1, trie);
        visited[i][j] = false;
    }

    //Trie Node
    static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    //Trie
    static class Trie {
        public TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }
            if (node.item.equals(word)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
