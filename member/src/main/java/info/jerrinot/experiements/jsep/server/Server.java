package info.jerrinot.experiements.jsep.server;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class Server {
    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

//        int key = 0;
//        IMap<Integer, Integer> map = hazelcastInstance.getMap("map");
//
//        FunctionalEntryProcessor<Integer, Long> ep = entry -> {
//            Long newValue = entry.getValue();
//            newValue = newValue == null ? 0 : newValue + 1;
//            entry.setValue(newValue);
//            return null;
//        };
//
//        map.executeOnKey(key, ep);
//        map.executeOnKey(key, ep);
    }
}
