package com.farart.snippy.beans;

public enum IconsPath {

    WINDOWS("WINDOWS PATH"),
    APPLE("APPLE PATH"),
    LINUX("LINUX PATH"),
    GIT("GIT PATH"),
    DOCKER("DOCKER PATH"),
    EXCEL("EXCEL PATH"),
    GENERIC("GENERIC PATH");

    private final String path;

    IconsPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
