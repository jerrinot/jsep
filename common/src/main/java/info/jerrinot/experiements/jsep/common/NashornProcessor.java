package info.jerrinot.experiements.jsep.common;

import com.hazelcast.map.AbstractEntryProcessor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class NashornProcessor extends AbstractEntryProcessor<Integer, Person> {

    private String script;
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    public NashornProcessor(String script) {
        this.script = script;
    }

    @Override
    public Object process(Map.Entry<Integer, Person> entry) {
        try {
            engine.eval(script);
            Invocable invocable = (Invocable) engine;
            invocable.invokeFunction("processEntry", entry);
        } catch (ScriptException e) {
            throw new RuntimeException("Error while running script", e);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Script does not have a function processEntry(). Source: " + script);
        }
        return null;
    }

}
