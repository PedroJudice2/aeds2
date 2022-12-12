public class Trie {
    int size = TrieNode.size;
    TrieNode root = null;

    public int hash(char letter) {
        return (((int) letter) % size);
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.array[hash(word.charAt(i))] == null) {
                if (i == word.length() - 1) {
                    curr.array[hash(word.charAt(i))] = new TrieNode(word.charAt(i), true);
                } else {
                    curr.array[hash(word.charAt(i))] = new TrieNode(word.charAt(i));
                }
            } else {
                if (i == word.length() - 1) {
                    curr.array[hash(word.charAt(i))].endOfWord = true;
                }
            }
            curr = curr.array[hash(word.charAt(i))].next;
        }
    }

    public boolean search(String word) {
        boolean resp = false;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.array[hash(word.charAt(i))] != null) {
                if (i == word.length() - 1 && curr.array[hash(word.charAt(i))].endOfWord) {
                    resp = true;
                }
                curr = curr.array[hash(word.charAt(i))].next;
            } else {
                i = word.length(); // break
            }

        }
        return resp;
    }

    public boolean startsWith(String prefix) {
        boolean resp = true;
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.array[hash(prefix.charAt(i))] != null) {
                if (i == prefix.length() - 1 || curr.array[hash(prefix.charAt(i))].next != null) {
                    curr = curr.array[hash(prefix.charAt(i))].next;
                } else {
                    resp = false;
                    i = prefix.length(); // break
                }
            } else {
                resp = false;
                i = prefix.length(); // break
            }

        }
        return resp;
    }

    public boolean remove(String word) {
        boolean resp = false;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.array[hash(word.charAt(i))] != null) {
                if (curr.array[hash(word.charAt(i))].next == null) {
                    curr.array[hash(word.charAt(i))] = null;
                }
            } else {
                i = word.length(); // break
            }

        }
        return resp;
    }

    public void print() {
        print("", root);
    }

    public void print(String str, TrieNode curr) {
        for (int i = 0; i < size; i++) {
            if (curr.array[i] != null) {
                if (curr.array[i].endOfWord) {
                    System.out.println(str.concat(Character.toString(curr.array[i].letter)));
                } else if (curr.array[i].next != null) {
                    print(str.concat(Character.toString(curr.array[i].letter)), curr.array[i].next);
                }
            }

        }
    }
}
