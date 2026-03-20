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

package org.eclipse.jetty.ee10.osgi.annotations;

import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.ServletContainerInitializer;
import org.eclipse.jetty.annotations.AnnotationParser.Handler;
import org.eclipse.jetty.ee.webapp.Configuration;
import org.eclipse.jetty.ee10.osgi.boot.OSGiMetaInfConfiguration;
import org.eclipse.jetty.ee.webapp.WebAppContext;
import org.eclipse.jetty.osgi.OSGiWebappConstants;
import org.eclipse.jetty.util.FileID;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extend the AnnotationConfiguration to support OSGi:
 * Look for annotations inside WEB-INF/lib and also in the fragments and required bundles.
 * Discover them using a scanner adapted to OSGi instead of the jarscanner.
 */
public class AnnotationConfiguration extends org.eclipse.jetty.ee.osgi.annotations.AnnotationConfiguration
{
    public AnnotationConfiguration()
    {
        super();
    }
}
