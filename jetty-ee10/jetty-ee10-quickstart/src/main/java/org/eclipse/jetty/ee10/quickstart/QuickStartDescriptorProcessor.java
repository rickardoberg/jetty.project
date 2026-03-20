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

package org.eclipse.jetty.ee10.quickstart;

import java.io.Closeable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletContext;
import org.eclipse.jetty.ee.annotations.AnnotationConfiguration;
import org.eclipse.jetty.ee.servlet.ServletContainerInitializerHolder;
import org.eclipse.jetty.ee.servlet.ServletMapping;
import org.eclipse.jetty.ee.webapp.DefaultsDescriptor;
import org.eclipse.jetty.ee.webapp.Descriptor;
import org.eclipse.jetty.ee.webapp.IterativeDescriptorProcessor;
import org.eclipse.jetty.ee.webapp.MetaInfConfiguration;
import org.eclipse.jetty.ee.webapp.WebAppContext;
import org.eclipse.jetty.util.IO;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.resource.AttributeNormalizer;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;
import org.eclipse.jetty.util.resource.Resources;
import org.eclipse.jetty.xml.XmlParser;

/**
 * Handle  extended elements for quickstart-web.xml
 */
public class QuickStartDescriptorProcessor extends org.eclipse.jetty.ee.quickstart.QuickStartDescriptorProcessor
{
    public QuickStartDescriptorProcessor()
    {
        super();
    }
}
