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

import jakarta.servlet.ServletContainerInitializer;
import org.eclipse.jetty.eecommon.cdi.CdiConfiguration;
import org.eclipse.jetty.eecommon.cdi.CdiServletContainerInitializer;
import org.eclipse.jetty.eecommon.webapp.Configuration;

module org.eclipse.jetty.eecommon.cdi
{
    requires org.eclipse.jetty.eecommon.annotations;

    requires transitive org.eclipse.jetty.eecommon.servlet;
    requires transitive org.eclipse.jetty.eecommon.webapp;
    requires static jakarta.cdi;

    exports org.eclipse.jetty.eecommon.cdi;

    provides ServletContainerInitializer with CdiServletContainerInitializer;
    provides Configuration with CdiConfiguration;
}
