class LRUCache {
    class ListNode{
        int key,value;
        ListNode next,prev;
        public ListNode(){

        }
        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    int curCap = 0, capacity = 0;
    HashMap<Integer,ListNode> cache = new HashMap<>();
    ListNode head = new ListNode(), tail= new ListNode(); //both dummy nodes pointing at LRU and MRU respectively


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev =head;
    }
    
    public int get(int key) {
       if(cache.containsKey(key)){
        ListNode cur = cache.get(key);
        
        //Update the LRU cache
        removeNode(cur);
        insertAtEnd(cur);
        
        return cur.value;
       }
       return -1;

    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            removeNode(cache.get(key));
            insertAtEnd(cache.get(key));
            return;
        }
        ListNode  newNode = new ListNode(key,value);
        if(curCap < capacity){
            cache.put(key, newNode);
            insertAtEnd(newNode);
            curCap++;
        }
        else{
            cache.remove(head.next.key);
            removeNode(head.next);
            cache.put(key, newNode);
            insertAtEnd(newNode);
        }
    }
    private void removeNode(ListNode cur){
        ListNode prev = cur.prev, next = cur.next;
        prev.next = next;
        next.prev = prev;
    }
    private void insertAtEnd(ListNode cur){
        cur.prev = tail.prev;
        cur.next=tail;
        tail.prev.next = cur;
        tail.prev = cur;
    }

}
