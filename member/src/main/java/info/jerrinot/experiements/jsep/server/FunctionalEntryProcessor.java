package info.jerrinot.experiements.jsep.server;

import com.hazelcast.map.EntryBackupProcessor;
import com.hazelcast.map.EntryProcessor;

@FunctionalInterface
public interface FunctionalEntryProcessor<K, V> extends EntryProcessor<K, V> {

    @Override
    default EntryBackupProcessor<K, V> getBackupProcessor() {
        return entry -> process(entry);
    }
}
