package cucumberbdd.utils;

import cucumberbdd.constants.EnvType;

import java.util.Properties;

// Singleton class
public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    // private Constructor - Only this class should be able to create its own instance hence its
    // private (Singleton Design Pattern)
    private ConfigLoader(){
        String env = System.getProperty("env",String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            default -> throw new IllegalStateException("Invalid env: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        // Check there is no instance of the class already - ensure only a single instance of the class created
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file.");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the stg_config.properties file.");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the stg_config.properties file.");
    }
}

