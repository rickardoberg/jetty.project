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

module org.eclipse.jetty.eecommon.webapp
{
    requires org.slf4j;

    requires transitive java.instrument;
    requires transitive org.eclipse.jetty.session;
    requires transitive org.eclipse.jetty.eecommon.servlet;
    requires transitive org.eclipse.jetty.xml;
    requires transitive org.eclipse.jetty.ee.webapp;

    exports org.eclipse.jetty.eecommon.webapp;

    uses org.eclipse.jetty.eecommon.webapp.Configuration;

    provides org.eclipse.jetty.eecommon.webapp.Configuration with
        org.eclipse.jetty.eecommon.webapp.FragmentConfiguration,
        org.eclipse.jetty.eecommon.webapp.JaasConfiguration,
        org.eclipse.jetty.eecommon.webapp.JaspiConfiguration,
        org.eclipse.jetty.eecommon.webapp.JettyWebXmlConfiguration,
        org.eclipse.jetty.eecommon.webapp.JmxConfiguration,
        org.eclipse.jetty.eecommon.webapp.JndiConfiguration,
        org.eclipse.jetty.eecommon.webapp.JspConfiguration,
        org.eclipse.jetty.eecommon.webapp.MetaInfConfiguration,
        org.eclipse.jetty.eecommon.webapp.ServletsConfiguration,
        org.eclipse.jetty.eecommon.webapp.WebAppConfiguration,
        org.eclipse.jetty.eecommon.webapp.WebInfConfiguration,
        org.eclipse.jetty.eecommon.webapp.WebXmlConfiguration;
}
