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

module org.eclipse.jetty.eecommon.websocket.jetty.server
{
    requires jakarta.servlet;
    requires org.eclipse.jetty.eecommon.websocket.servlet;
    requires org.eclipse.jetty.websocket.server;
    requires org.eclipse.jetty.websocket.core.server;
    requires org.eclipse.jetty.websocket.common;

    requires transitive org.eclipse.jetty.eecommon.webapp;

    // Only required if using JMX.
    requires static org.eclipse.jetty.jmx;

    exports org.eclipse.jetty.eecommon.websocket.server;
    exports org.eclipse.jetty.eecommon.websocket.server.config;

    provides jakarta.servlet.ServletContainerInitializer with
        org.eclipse.jetty.eecommon.websocket.server.config.JettyWebSocketServletContainerInitializer;

    provides org.eclipse.jetty.eecommon.webapp.Configuration with
        org.eclipse.jetty.eecommon.websocket.server.config.JettyWebSocketConfiguration;
}
