package com.bookStore.api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:config/${env}.properties"
})
public interface TestConfig extends Config {
    @Key("baseUrl") String baseUrl();
    @Key("readTimeoutMs") @DefaultValue("10000") int readTimeoutMs();
    @Key("connectTimeoutMs") @DefaultValue("5000") int connectTimeoutMs();
    @Key("defaultUserToken") @DefaultValue("") String defaultUserToken();
}

