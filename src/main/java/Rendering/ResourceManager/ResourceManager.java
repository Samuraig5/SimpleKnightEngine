package Rendering.ResourceManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class ResourceManager<T> {
    protected static final Logger logger = LoggerFactory.getLogger(ResourceManager.class);
    private final HashMap<String, T> resourceMap;

    public ResourceManager() {
        this.resourceMap = new HashMap<>();
    }

    public T getResource(String filepath) {
        if (resourceMap.containsKey(filepath)) {
            return resourceMap.get(filepath);
        } else {
            T resource = loadResource(filepath);
            resourceMap.put(filepath, resource);
            return resource;
        }
    }

    protected abstract T loadResource(String filepath);
}
