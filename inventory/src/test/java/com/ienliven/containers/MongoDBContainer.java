package com.ienliven.containers;

import io.smallrye.common.constraint.NotNull;
import org.testcontainers.containers.GenericContainer;

public class MongoDBContainer extends GenericContainer<MongoDBContainer> {
    public static final String DEFAULT_IMAGE_AND_TAG = "mongo:4.2.6";
    public static final String MONGODB_HOST = "localhost";
    public static final int MONGODB_PORT = 27017;

    public MongoDBContainer() {
        this(DEFAULT_IMAGE_AND_TAG);
    }

    public MongoDBContainer(@NotNull String image) {
        super(image);
        addExposedPort(MONGODB_PORT);
    }

    @NotNull
    public Integer getPort() {
        return getMappedPort(MONGODB_PORT);
    }
}
