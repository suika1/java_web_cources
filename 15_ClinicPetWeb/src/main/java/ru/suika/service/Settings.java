package ru.suika.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Singleton for JDBC
 * @author suika1
 * @since 08.04.2018
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("krasotkin.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String value(String key) {
        return this.properties.getProperty(key);
    }
}