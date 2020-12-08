package click.erudosaba.mc.ejoin.util;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class Config {

    private Plugin plugin;
    private FileConfiguration config;

    @Getter
    private boolean enabledMySQL;

    @Getter
    private String host,username,password,database;
    @Getter
    private int port;

    public Config(Plugin plugin) {
        this.plugin = plugin;

        load();
    }

    private void load() {
        plugin.saveDefaultConfig();

        if (Objects.nonNull(config)) {
            reload();
        }

        config = plugin.getConfig();

        enabledMySQL = config.getBoolean("enabled-mysql");
        host = config.getString("host");
        port = config.getInt("port");
        username = config.getString("username");
        password = config.getString("password");
        database = config.getString("database");

    }

    public void reload() {
        plugin.reloadConfig();
        plugin.saveConfig();
    }
}
