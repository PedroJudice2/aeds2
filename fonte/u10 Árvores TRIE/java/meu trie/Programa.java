class Programa {
    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("pedro");
        tree.insert("julio");
        tree.insert("vitor");
        tree.insert("vitoria");
        tree.insert("luh");
        tree.insert("maria");
        tree.insert("martelo");
        System.out.println(tree.search("julio"));
        System.out.println(tree.search("vitoria"));
        System.out.println(tree.search("vitor"));
        System.out.println(tree.search("apple"));
        System.out.println(tree.startsWith("lu"));
        System.out.println(tree.startsWith("app"));
        tree.print();

    }
}