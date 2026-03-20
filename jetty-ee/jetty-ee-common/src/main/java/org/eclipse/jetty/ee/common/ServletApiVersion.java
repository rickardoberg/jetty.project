package org.eclipse.jetty.ee.common;

import java.util.HashMap;
import java.util.Map;

public enum ServletApiVersion
{
    v6_0_0("6.0.0"),
    v6_1_0("6.1.0");

    private final String version;

    ServletApiVersion(String version)
    {
        this.version = version;
        Mapping.versions.put(version, this);
    }

    public String version()
    {
        return version;
    }

    public static ServletApiVersion from(String version)
    {
        return Mapping.versions.get(version);
    }

    public static ServletApiVersion getServletApiVersion()
    {
        ClassLoader classLoader = ServletApiVersion.class.getClassLoader();
        try
        {
            String implementationVersion = classLoader
                .loadClass("jakarta.servlet.ServletRequest")
                .getPackage().getImplementationVersion();
            return ServletApiVersion.from(implementationVersion);
        }
        catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot detect servlet API version", e);
        }
    }

    private static class Mapping {
        private static final Map<String, ServletApiVersion> versions = new HashMap<>();
    }
}
