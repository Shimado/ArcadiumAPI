package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Registry interface for managing game modes.
 * <p>
 * Provides methods for registering, unregistering, and retrieving
 * game modes by ID, name, or GUI slot.
 *
 * @param <T> the game mode type
 */
public interface GameRegister<T extends ArcadiumGame & GameMethods> {

    /**
     * Gets a registered game mode by its unique permanent ID.
     *
     * @param gameID the unique game ID
     * @return the matching game mode instance, or {@code null} if no game was found
     */
    @Nullable
    T getGameByID(@Nullable String gameID);


    /**
     * Gets a registered game mode by its name.
     *
     * @param gameName the game name
     * @return the matching game mode instance,or {@code null} if no game was found
     */
    @Nullable
    T getGameByName(@Nullable String gameName);


    /**
     * Gets a registered game mode by its assigned slot in the main GUI menu.
     *
     * @param slot the inventory slot index
     * @return the matching game mode instance, or {@code null} if no game was found
     */
    @Nullable
    T getGameBySlotInMainGUI(int slot);


    /**
     * Gets all registered game modes.
     *
     * @return a map containing registered game names and their corresponding game mode instances
     */
    @NotNull
    Map<String, T> getGames();


    /**
     * Registers a new game mode.
     *
     * @param game the game mode instance to register
     */
    void register(@Nullable T game);


    /**
     * Unregisters a game mode by its name.
     *
     * @param gameName the name of the game to unregister
     */
    void unregister(@Nullable String gameName);


    /**
     * Optional.
     * Helps to get the base mode from the config and messages config.
     *
     * @param configKey common key from both configs. For example: "Checkers-settings"
     * @param config config that stores fields and values: "mode-name", "gui-size" and etc
     * @param messages messages config that stores fields and values: "title", "lore" and etc
     * @param clazz game mode class. For example: Checkers.class, Battleship.class and etc
     * @param pluginInstance your plugin class instance. Arcadium or ArcadiumAddon
     */
    @Nullable
    T getBasicGameModeFromConfig(@NotNull String configKey, @NotNull YamlConfiguration config, @NotNull YamlConfiguration messages, @NotNull Class<T> clazz, @NotNull Object pluginInstance);
}
