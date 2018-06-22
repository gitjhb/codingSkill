public class ImplementTries {
    //208. Implement Trie (Prefix Tree)
    //https://leetcode.com/problems/implement-trie-prefix-tree/description/


    public static void main(String[] args) {

        Trie t=new Trie();
        t.insert("apple");
        System.out.println("search:"+"ac"+" Result:"+t.search("ac"));
//        t.insert("app");
        System.out.println("search:"+"app"+" Result:"+t.search("app"));
        System.out.println("startsWith:"+"app"+" Result:"+t.startsWith("app"));
        t.insert("app");
        System.out.println("search:"+"app"+" Result:"+t.search("app"));

    }

}


class Trie {

    TrieNode root=new TrieNode(' ');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null) return;

        TrieNode curNode=root;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curNode.arr[c -'a']==null){
                curNode.arr[c-'a']=new TrieNode(c);
            }
            curNode=curNode.arr[c-'a'];
        }
        curNode.isAWord=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null) return false;
        TrieNode curNode=root;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curNode.arr[c-'a']==null){
                return false;
            } else {
                curNode=curNode.arr[c-'a'];
            }
        }

        if(curNode.isAWord){
            return true;
        }

//        for(int i=0;i<curNode.arr.length;i++){
//            if(curNode.arr[i]!=null){
//                return false;
//            }
//        }
//        wrong



        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null) return false;
        TrieNode curNode=root;

        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(curNode.arr[c-'a']==null){
                return false;
            } else {
                curNode=curNode.arr[c -'a'];
            }
        }

        return true;

    }
}

class TrieNode {

    public char val;
    public TrieNode[] arr;
    boolean isAWord;

    TrieNode(char val){
        this.val=val;
        arr=new TrieNode[26];
    }
}