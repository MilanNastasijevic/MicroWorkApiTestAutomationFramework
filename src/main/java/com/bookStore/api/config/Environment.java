package com.bookStore.api.config;

public enum Environment {
    dev, staging, prod;

    public static Environment from(String raw) {
        try { return Environment.valueOf(raw.toLowerCase()); }
        catch (Exception e) { return dev; }
    }
}
