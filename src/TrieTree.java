public class TrieTree {

    static TrieNode root;
    static int ALPHABET_SIZE = 26;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode()
        {
            isEndOfWord = false;
            for(int i=0; i<ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    public static void insert(String word)
    {
        TrieNode pCrawl = root;

        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public static boolean search(String word)
    {
        TrieNode pCrawl = root;

        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEndOfWord;
    }

    public static boolean startsWith(String word)
    {
        TrieNode pCrawl = root;

        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if(pCrawl.children[index] != null)
                pCrawl = pCrawl.children[index];
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] words = {"bye", "there", "their", "answer", "any"};

        root = new TrieNode();

        for(String word : words)
        {
            insert(word);
        }

        System.out.println("Find the word bye: "+search("bye"));

        System.out.println("Find the word there: "+search("there"));

        System.out.println("Find the word anyy: "+search("anyy"));

        System.out.println("Find the Starts with an: "+startsWith("an"));

        System.out.println("Find the Starts with th: "+startsWith("th"));

        System.out.println("Find the Starts with the: "+startsWith("the"));

        System.out.println("Find the Starts with bee: "+startsWith("bee"));

        System.out.println("Find the Starts with a: "+startsWith("a"));

        System.out.println("Find the word tansheir: "+search("tansheir"));

        System.out.println("Find the word answer: "+search("answer"));
    }
}
