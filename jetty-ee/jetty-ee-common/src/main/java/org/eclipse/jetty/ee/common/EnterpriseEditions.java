package org.eclipse.jetty.ee.common;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 */
public interface EnterpriseEditions
{
    Map<ClassLoader, String> servetlApiVersionByClassLoader = Collections.synchronizedMap(new WeakHashMap<>());

    static String getServletApiVersion(ClassLoader classLoader)
    {
        return servetlApiVersionByClassLoader.computeIfAbsent(classLoader, cl ->{
            try
            {
                return classLoader
                    .loadClass("jakarta.servlet.ServletRequest")
                    .getPackage().getImplementationVersion();
            }
            catch (ClassNotFoundException e)
            {
                throw new IllegalStateException("Cannot detect servlet API version", e);
            }
        });
    }

    static String getServletApiVersion(){
        return getServletApiVersion(EnterpriseEditions.class.getClassLoader());
    }
}
