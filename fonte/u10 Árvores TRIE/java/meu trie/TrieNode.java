public class TrieNode {
    public static int size = 26;
    public TrieNode[] array = new TrieNode[size];
    char letter;
    public TrieNode next;
    public boolean endOfWord = false;

    TrieNode() {
        next = null;
    }

    TrieNode(char letter) {
        this.letter = letter;
        next = new TrieNode();
    }

    TrieNode(char letter, boolean endOfWord) {
        this.letter = letter;
        this.endOfWord = endOfWord;
        next = new TrieNode();
    }
}
