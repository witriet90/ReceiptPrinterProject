package database;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;


public class StorageTest {


    @Test(expected = DataBaseException.class)
    public void getValueInEmptyStorage() {
        Storage<String> storage = new Storage<>();

        storage.getValue(1);
    }

    @Test(expected = DataBaseException.class)
    public void getNonExistingValueInStorage() {
        Map<Integer, String> initialData = new HashMap<>();
        initialData.put(1, "Java");
        initialData.put(2, "Java1");
        initialData.put(3, "Java2");

        Storage<String> storage = new Storage<>(initialData);
        storage.getValue(6);
    }

    @Test
    public void getExistingValueInStorage() {
        Map<Integer, String> initialData = new HashMap<>();
        initialData.put(1, "Java");
        initialData.put(2, "Java1");
        initialData.put(3, "Java2");

        Storage<String> storage = new Storage<>(initialData);

        Assertions.assertEquals("Java", storage.getValue(1));
    }
}