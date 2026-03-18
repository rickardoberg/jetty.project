//
// ========================================================================
// Copyright (c) 1995 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.ee10.webapp;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlParser;

/**
 * A web descriptor (web.xml/web-defaults.xml/web-overrides.xml).
 */
public class WebDescriptor extends org.eclipse.jetty.ee.webapp.WebDescriptor
{
    public static XmlParser __nonValidatingStaticParser = newParser(false);

    protected static void addDescriptorCatalog(XmlParser xmlParser) throws IllegalStateException
    {
        String catalogName = "catalog-%s.xml".formatted(ServletContextHandler.ENVIRONMENT.getName());
        URL url = org.eclipse.jetty.ee.webapp.WebDescriptor.class.getResource(catalogName);
        if (url == null)
            throw new IllegalStateException("Catalog not found: %s/%s".formatted(org.eclipse.jetty.ee.webapp.WebDescriptor.class.getPackageName(), catalogName));
        try
        {
            xmlParser.addCatalog(URI.create(url.toExternalForm()), Servlet.class);
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Unable to add catalog: " + url, e);
        }
    }

    public WebDescriptor(Resource xml)
    {
        super(xml);
    }
}
