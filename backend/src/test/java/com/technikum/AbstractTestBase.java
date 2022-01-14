package com.technikum;

import com.technikum.bugtracking.ObjectRandomizer;

public abstract class AbstractTestBase {

    protected ObjectRandomizer randomizer() {
        return new ObjectRandomizer();
    }
}
