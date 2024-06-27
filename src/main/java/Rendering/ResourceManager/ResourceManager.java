package Rendering.ResourceManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class ResourceManager<T> {
    protected Logger logger;

    private final HashMap<String, T> resourceMap;

    public ResourceManager() {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.resourceMap = new HashMap<>();
    }

    public T getResource(String filepath) {
        if (resourceMap.containsKey(filepath))
        {
            return resourceMap.get(filepath);
        } else {
            logger.debug("Load new resource from: " + filepath);
            T resource = loadResource(filepath);
            resourceMap.put(filepath, resource);
            return resource;
        }
    }

    protected abstract T loadResource(String filepath);
}
