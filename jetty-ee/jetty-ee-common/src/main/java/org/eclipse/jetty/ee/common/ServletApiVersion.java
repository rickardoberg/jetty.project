package org.eclipse.jetty.ee.common;

import java.lang.module.ModuleDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ServletApiVersion
{
    v4_0("4.0"),
    v5_0("5.0"),
    v6_0("6.0"),
    v6_1("6.1");

    private static Logger LOG = LoggerFactory.getLogger(ServletApiVersion.class);
    private final String version;
    private final int major;
    private final int minor;

    ServletApiVersion(String version)
    {
        this.version = version;
        this.major = Integer.parseInt(version.split("\\.")[0]);
        this.minor = Integer.parseInt(version.split("\\.")[1]);
        Mapping.versions.put(version, this);
    }

    public String version()
    {
        return version;
    }

    public int getMajorVersion()
    {
        return major;
    }

    public int getMinorVersion()
    {
        return minor;
    }

    public static ServletApiVersion from(String version)
    {
        ServletApiVersion servletApiVersion = Mapping.versions.get(version);
        if (servletApiVersion == null)
            throw new IllegalArgumentException("Unknown servlet API version:" + version);
        return servletApiVersion;
    }

    public static ServletApiVersion getServletApiVersion()
    {
        ClassLoader classLoader = ServletApiVersion.class.getClassLoader();
        try
        {
            Class<?> loadedClass = classLoader.loadClass("jakarta.servlet.ServletRequest");
            String specificationVersion = loadedClass.getPackage().getSpecificationVersion();
            if (specificationVersion == null)
            {
                LOG.info("getDefinedPackage");
                specificationVersion = classLoader.getDefinedPackage("jakarta.servlet").getSpecificationVersion();
            }
            if (specificationVersion == null)
            {
                LOG.info("getModule");
                specificationVersion = loadedClass.getModule().getDescriptor().version()
                    .map(ModuleDescriptor.Version::toString)
                    .map(version -> version.substring(0, version.lastIndexOf('.')))
                    .orElse(null);
                LOG.info("Version:" + specificationVersion);
            }
            return ServletApiVersion.from(specificationVersion);
        }
        catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot detect servlet API version", e);
        }
    }

    private static class Mapping
    {
        private static final Map<String, ServletApiVersion> versions = new HashMap<>();
    }
}
