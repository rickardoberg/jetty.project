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

module org.eclipse.jetty.eecommon.plus
{
    requires transitive org.eclipse.jetty.plus;
    requires org.slf4j;

    requires transitive org.eclipse.jetty.eecommon.webapp;

    // Only required if using Transaction.
    requires static transitive jakarta.transaction;
    requires org.eclipse.jetty.jndi;

    exports org.eclipse.jetty.eecommon.plus.jndi;
    exports org.eclipse.jetty.eecommon.plus.webapp;

    provides org.eclipse.jetty.eecommon.webapp.Configuration with
        org.eclipse.jetty.eecommon.plus.webapp.EnvConfiguration,
        org.eclipse.jetty.eecommon.plus.webapp.PlusConfiguration;
}
