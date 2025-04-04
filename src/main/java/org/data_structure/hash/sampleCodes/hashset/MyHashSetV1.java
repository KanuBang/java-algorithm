package org.data_structure.hash.sampleCodes.hashset;

import java.util.HashMap;
import java.util.LinkedList;

public class MyHashSetV1 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    LinkedList<Integer>[] buckets;

    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1() {
    }

    public MyHashSetV1(int capacity){
        this.capacity = capacity;

    }
}
