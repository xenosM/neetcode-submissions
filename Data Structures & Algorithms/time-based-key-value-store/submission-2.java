class TimeMap {
    // key -> { [timestamp(key),value(value)],.... }
    Map<String, List<Pair<Integer,String>>> hash; 
    
    public TimeMap() {
        hash = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Creates a new key-value pair if the specified key doesn't exist
        hash.computeIfAbsent(key, (k)-> new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    public String get(String key, int timestamp) {
        //Ensures that even if the searched key is not present the program will run
        List< Pair<Integer,String>> values = hash.getOrDefault(key, new ArrayList<>());
        String result="";
        //Binary Search
        int l=0, r = values.size() - 1;
        while(l<=r){
            int mid = (l+r) /2;
            int t = values.get(mid).getKey();
            /*
              If t is less to the searched timestamp, then the timestamps less than t will not have
              eligible but there might be a timestamp greater than t that is valid
              If t is equal to the searched timestamp, then there is no need for further searching 
              (but we will do it anyways )
            */
            if(t<=timestamp){
                result = values.get(mid).getValue();
                l=mid+1;
            }
            /*
             If t is greater than the searched timestamp then any eligible timestamps must be lesser than t.
            */
            else{
                r = mid -1;
            }
        }
        return result;
    }
}
