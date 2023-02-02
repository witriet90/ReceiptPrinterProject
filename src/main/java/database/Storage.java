package database;

import java.util.HashMap;
import java.util.Map;

public class Storage<T> {

    private final Map<Integer, T> allValues;

    public Storage(Map<Integer, T> initialData) {
        this.allValues = initialData;
    }

    public Storage() {
        this(new HashMap<>());
    }

    public T getValue(int id) {
        T value = allValues.get(id);
        if (value == null) {
            throw new DataBaseException("Data is not correct");
        } else {
            return value;
        }
    }
}
