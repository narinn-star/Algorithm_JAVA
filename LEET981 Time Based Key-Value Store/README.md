# [Leetcode 981] Time Based Key-Value Store

## 분류
> Hash Table
> 
> String
>
> Binary Search
>
> Design

## 코드
```java
class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       TreeMap<Integer, String> valueMap = map.getOrDefault(key, new TreeMap<>());
       valueMap.put(timestamp, value);
       map.put(key, valueMap);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> valueMap = map.get(key);
        Map.Entry<Integer, String> entry = valueMap.floorEntry(timestamp);
        if(entry == null) return "";
        else return entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```

## 문제풀이

문제 이해부터 너무 어려웠다.. Explanation을 봐도 이해가 잘 안가서, 블로그에 문제 설명들을 찾아보고 이해했다.
일단 key, value를 저장하는데 timestamp까지 같이 가지고 있어야해서 Map의 Value값에 Map을 한 번 더 넣어줬다. 그리고 get은 key와 timestamp를 받는데 저장해둔 값들 중 키가 일치함과 동시에 timestamp가 가장 큰 값을 먼저 반환해야 한다.

Example을 예시로 들면, 
TimeMap : 객체 생성
set("foo", "bar", 1)
get("foo", 1) => TimeMap에 (foo, bar, 1)이 있으므로 bar 리턴
get("foo", 3) => TimeMap에 (foo, ? , 3)은 없고 같은 key의 timestamp 1이 있으므로 (foo, bar, 1)의 value값 bar 리턴
set("foo", "bar2", 4)
get("foo", 4) => TimeMap에 (foo, bar2, 4)가 있으므로 bar2 리턴
get("foo", 5) => TimeMap에 (foo, ? 5)는 없고 같은 key의 timestamp 4가 있으므로 (foo, bar2, 4)의 value값 bar2 리턴

위와 같이 된다. 즉, TimeMap에 있는 값 중 key가 같다면 timestamp가 같거나 그보다 작은 가장 큰 timestamp를 찾아야 한다.

하나씩 비교해서 찾아주는 방법도 있지만, 다른 분들의 코드를 보다가 TreeMap을 알게되어 TreeMap을 사용해서 풀어보았다. 이진트리를 기반으로 한 Map 컬렉션으로, 키와 값이 저장된 Map, Entry를 저장한다. 객체를 저장했을 때 키를 기준으로 자동으로 오름차순으로 정렬된다. 부모와 비교해 키값이 작으면 왼쪽, 높은 것은 오른쪽 노드에 저장한다. 
TreeMap에 많은 메소드가 있는데, 그중에서 이 문제에서 사용한 것은 floorEntry다. 지정된 key와 일치하거나 그보다 첫번째로 작은 key값을 반환하는 것이다. key값으로 timestamp를 넣으면 자동 정렬됨과 동시에 floorKey()메소드로 한 번에 알맞은 값을 찾을 수 있다.

나머지 메소드들은 아래를 참고하쟈!
[TreeMap](https://innovation123.tistory.com/120)
