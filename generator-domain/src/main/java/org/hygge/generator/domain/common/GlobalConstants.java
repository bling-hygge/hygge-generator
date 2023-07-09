package org.hygge.generator.domain.common;

import java.util.TimeZone;

public abstract class GlobalConstants {
    public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String TIME_ZONE = TimeZone.getTimeZone("GMT+8").getID();

    public final static String ACTIVE_DEV = "dev";

    public final static String ACTIVE_BETA = "beta";

    public final static String ACTIVE_INTEGRATION = "integration";

    public final static String ACTIVE_GRAY = "gray";

    public final static String ACTIVE_PRODUCTION = "production";

    public final static String DATABASE_TEMPLATE_RESOLVER_PATTERN = "gen-db-";
}
