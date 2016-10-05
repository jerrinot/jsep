package info.jerrinot.experiements.jsep.client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import info.jerrinot.experiements.jsep.common.NashornProcessor;
import info.jerrinot.experiements.jsep.common.Person;

public class Client {
    public static void main(String[] args) {
        HazelcastInstance instance = HazelcastClient.newHazelcastClient();
        IMap<Integer, Person> foo = instance.getMap("foo");

        foo.put(0, new Person("Bob", 42));

        String sillyScript = generateSillyScript(1);
        NashornProcessor ep = new NashornProcessor(sillyScript);
        foo.submitToKey(0, ep);

        System.out.println(foo.get(0));
    }

    private static String generateSillyScript(int delta) {
        return "function processEntry(entry) {\n" +
                "  var person = entry.value\n" +
                "  var currentAge = person.getAge()\n" +
                "  var newAge = currentAge + " + delta + "\n" +
                "  person.setAge(newAge)\n" +
                "  entry.value=person\n" +
                "  print(person);\n" +
                "}";
    }
}
