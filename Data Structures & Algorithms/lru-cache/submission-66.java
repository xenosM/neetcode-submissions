class LRUCache {
    class Node{
        Node prev,next;
        int key, value;

        Node(int key,int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    HashMap<Integer, Node> cache= new HashMap<>();
    Node lru = new Node(0,0) ,mru = new Node(0,0); //dummy nodes pointing at start and end of list
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        lru.next = mru;
        mru.prev = lru;
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void insertAtEnd(Node node){
        node.prev = mru.prev;
        node.next = mru;
        mru.prev.next = node;
        mru.prev = node;
    }
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        //Update the key to the end of list
        Node node = cache.get(key);
        remove(node);
        insertAtEnd(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        //If we put an existing key then we have to remove that key before inserting it at the end
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertAtEnd(newNode);

        //If the size of cache is more than its capacity after putting a new key, remove the LRU node
        if(cache.size()> cap){
            cache.remove(lru.next.key);
            remove(lru.next);
        }

    }
}
