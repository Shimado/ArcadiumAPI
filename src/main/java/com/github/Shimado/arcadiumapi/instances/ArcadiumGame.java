package com.github.Shimado.arcadiumapi.instances;

import com.github.Shimado.boomboxapi.instances.BoomboxSong;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Represents a game mode configuration.
 * Includes GUI settings, victory/defeat behavior, commands to execute, and music settings.
 */

public class ArcadiumGame {

    private String modeName;                                                 // For usage in commands/placeholders/code and etc
    private LinkedList<ArcadiumGamePage> gamePages = new LinkedList<>();     // Game pages
    private String permission = "";                                          // The permission to open the game mode
    private List<Integer> slotsInGUI = new ArrayList<>();                    // Slots occupied by the icon in the main GUI
    private List<Integer> slotsInOneGameGUI = new ArrayList<>();             // Slots occupied by an icon in the main GUI for one game
    private ItemStack iconItem;                                              // The icon in the main GUI

    private BarColor victoryBossBarColor = BarColor.GREEN;                   // Bar color
    private BarStyle victoryBossBarStyle = BarStyle.SOLID;                   // Bar style
    private int victoryBossBarDuration = 0;                                  // Duration in ticks
    private boolean sendVictoryBossBar = false;                              // Sends bossbar title to player
    private String victoryBossBarTitle;                                      // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryBossBarToAll = false;                         // Sends bossbar title to all players
    private String victoryBossBarTitleToAll;                                 // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryTitle = false;                                // Sends victory title
    private String victoryTitle;                                             // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String victorySubtitle;                                          // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryTitleToAll = false;                           // Sends victory title to all players
    private String victoryTitleToAll;                                        // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String victorySubtitleToAll;                                     // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private int victoryTitleFadeIn = 0;                                      // Title fade in time in ticks
    private int victoryTitleStay = 0;                                        // Title stay time in ticks
    private int victoryTitleFadeOut = 0;                                     // Title fade out time in ticks
    private boolean spawnVictoryFireWorks = false;                           // Whether to spawn fireworks on victory
    private boolean sendVictoryMessage = false;                              // Sends victory message to the winning player
    private String victoryMessage;                                           // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryMessageToAll = false;                         // Sends victory message to all players
    private String victoryMessageToAll;                                      // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryMessageToDiscord = false;                     // Sends victory message to Discord
    private String victoryMessageToDiscord;                                  // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean useOnlyVictoryCommands = false;                          // Whether only commands will be executed
    private List<String> victoryCommandsToDispatch = new ArrayList<>();      // Commands executed when player wins [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryURL;                                           // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryMethod = "POST";                               // Request method
    private Map<String, Object> httpVictoryHeaders = new HashMap<>();        // Request headers
    private BoomboxSong victoryMusic;                                        // Music in .nbs format from Boombox plugin

    private boolean sendDefeatTitle = false;                                 // Sends defeat title
    private BarColor defeatBossBarColor = BarColor.GREEN;                    // Bar color
    private BarStyle defeatBossBarStyle = BarStyle.SOLID;                    // Bar style
    private int defeatBossBarDuration = 0;                                   // Duration in ticks
    private boolean sendDefeatBossBar = false;                               // Sends bossbar title to player
    private String defeatBossBarTitle;                                       // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendDefeatBossBarToAll = false;                          // Sends bossbar title to all players
    private String defeatBossBarTitleToAll;                                  // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String defeatTitle;                                              // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String defeatSubtitle;                                           // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatTitleToAll = false;                            // Sends defeat title to all players
    private String defeatTitleToAll;                                         // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String defeatSubtitleToAll;                                      // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private int defeatTitleFadeIn = 0;                                       // Title fade in time in ticks
    private int defeatTitleStay = 0;                                         // Title stay time in ticks
    private int defeatTitleFadeOut = 0;                                      // Title fade out time in ticks
    private boolean sendDefeatMessage = false;                               // Sends defeat message to the losing player
    private String defeatMessage;                                            // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatMessageToAll = false;                          // Sends defeat message to all players
    private String defeatMessageToAll;                                       // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatMessageToDiscord = false;                      // Sends defeat message to Discord
    private String defeatMessageToDiscord;                                   // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean useOnlyDefeatCommands = false;                           // Whether only commands will be executed
    private List<String> defeatCommandsToDispatch = new ArrayList<>();       // Commands executed when player loses [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatURL;                                            // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatMethod = "POST";                                // Request method
    private Map<String, Object> httpDefeatHeaders = new HashMap<>();         // Request headers
    private BoomboxSong defeatMusic;                                         // Music in .nbs format from Boombox plugin

    private List<Integer> spotSlots = new ArrayList<>();                     // Betting spots
    private ItemStack spotItem;                                              // Betting spot icon
    private String spotItemTitle;                                            // Betting spot title
    private List<String> spotItemLore = new ArrayList<>();                   // Betting spot lore

    private List<Integer> leverSlots = new ArrayList<>();                    // Control lever slots
    private ItemStack leverItemInactive;                                     // Inactive lever (when no bet is placed)
    private String leverItemInactiveTitle;                                   // Inactive lever title
    private List<String> leverItemInactiveLore = new ArrayList<>();          // Inactive lever lore
    private ItemStack leverItemActive;                                       // Active lever (when player has placed a bet)
    private String leverItemActiveTitle;                                     // Active lever title
    private List<String> leverItemActiveLore = new ArrayList<>();            // Active lever lore
    private ItemStack leverItemRolling;                                      // Rolling lever (when player has placed a bet and started the game)
    private String leverItemRollingTitle;                                    // Rolling lever title
    private List<String> leverItemRollingLore = new ArrayList<>();           // Rolling lever lore
    private ItemStack leverItemEnd;                                          // Finished lever (when the game is over)
    private String leverItemEndTitle;                                        // Finished lever title
    private List<String> leverItemEndLore = new ArrayList<>();               // Finished lever lore

    private BoomboxSong backgroundMusic;                                     // Background music in .nbs format from Boombox plugin

    private int gameOnline = 0;                                              // This is how many players are currently playing this mode


    public ArcadiumGame(@NotNull String modeName){
        this.modeName = modeName;
    }


    @NotNull
    public String getModeName(){
        return modeName;
    }


    @NotNull
    public LinkedList<ArcadiumGamePage> getGamePages(){
        return gamePages;
    }

    public void setGamePages(@NotNull LinkedList<ArcadiumGamePage> gamePages){
        this.gamePages = gamePages;
    }

    public void addGamePage(@NotNull ArcadiumGamePage arcadiumGamePage){
        gamePages.add(arcadiumGamePage);
    }


    @Nullable
    public String getPermission(){
        return permission;
    }

    public ArcadiumGame setPermission(@NotNull String permission){
        if(permission == null) return this;
        this.permission = permission;
        return this;
    }


    @NotNull
    public List<Integer> getSlotsInGUI() {
        return slotsInGUI;
    }

    public ArcadiumGame setSlotsInGUI(@NotNull List<Integer> slotsInGUI) {
        if(slotsInGUI == null) return this;
        this.slotsInGUI = slotsInGUI;
        return this;
    }


    @NotNull
    public List<Integer> getSlotsInOneGameGUI() {
        return slotsInOneGameGUI;
    }

    public ArcadiumGame setSlotsInOneGameGUI(@NotNull List<Integer> slotsInOneGameGUI) {
        if(slotsInOneGameGUI == null) return this;
        this.slotsInOneGameGUI = slotsInOneGameGUI;
        return this;
    }


    @Nullable
    public ItemStack getIconItem() {
        return iconItem;
    }

    public ArcadiumGame setIconItem(@Nullable ItemStack iconItem) {
        this.iconItem = iconItem;
        return this;
    }


    @Nullable
    public BarColor getVictoryBossBarColor() {
        return victoryBossBarColor;
    }

    public ArcadiumGame setVictoryBossBarColor(@Nullable BarColor victoryBossBarColor) {
        this.victoryBossBarColor = victoryBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getVictoryBossBarStyle() {
        return victoryBossBarStyle;
    }

    public ArcadiumGame setVictoryBossBarStyle(@Nullable BarStyle victoryBossBarStyle) {
        this.victoryBossBarStyle = victoryBossBarStyle;
        return this;
    }


    public int getVictoryBossBarDuration() {
        return victoryBossBarDuration;
    }

    public ArcadiumGame setVictoryBossBarDuration(int victoryBossBarDuration) {
        this.victoryBossBarDuration = victoryBossBarDuration;
        return this;
    }


    public boolean isSendVictoryBossBar() {
        return sendVictoryBossBar;
    }

    public ArcadiumGame setSendVictoryBossBar(boolean sendVictoryBossBar) {
        this.sendVictoryBossBar = sendVictoryBossBar;
        return this;
    }


    @Nullable
    public String getVictoryBossBarTitle() {
        return victoryBossBarTitle;
    }

    public ArcadiumGame setVictoryBossBarTitle(@Nullable String victoryBossBarTitle) {
        this.victoryBossBarTitle = victoryBossBarTitle;
        return this;
    }


    public boolean isSendVictoryBossBarToAll() {
        return sendVictoryBossBarToAll;
    }

    public ArcadiumGame setSendVictoryBossBarToAll(boolean sendVictoryBossBarToAll) {
        this.sendVictoryBossBarToAll = sendVictoryBossBarToAll;
        return this;
    }


    @Nullable
    public String getVictoryBossBarTitleToAll() {
        return victoryBossBarTitleToAll;
    }

    public ArcadiumGame setVictoryBossBarTitleToAll(@Nullable String victoryBossBarTitleToAll) {
        this.victoryBossBarTitleToAll = victoryBossBarTitleToAll;
        return this;
    }


    public boolean isSendVictoryTitle() {
        return sendVictoryTitle;
    }

    public ArcadiumGame setSendVictoryTitle(boolean sendVictoryTitle) {
        this.sendVictoryTitle = sendVictoryTitle;
        return this;
    }


    @Nullable
    public String getVictoryTitle() {
        return victoryTitle;
    }

    public ArcadiumGame setVictoryTitle(@Nullable String victoryTitle) {
        this.victoryTitle = victoryTitle;
        return this;
    }


    @Nullable
    public String getVictorySubtitle() {
        return victorySubtitle;
    }

    public ArcadiumGame setVictorySubtitle(@Nullable String victorySubtitle) {
        this.victorySubtitle = victorySubtitle;
        return this;
    }


    public boolean isSendVictoryTitleToAll() {
        return sendVictoryTitleToAll;
    }

    public ArcadiumGame setSendVictoryTitleToAll(boolean sendVictoryTitleToAll) {
        this.sendVictoryTitleToAll = sendVictoryTitleToAll;
        return this;
    }


    @Nullable
    public String getVictoryTitleToAll() {
        return victoryTitleToAll;
    }

    public ArcadiumGame setVictoryTitleToAll(@Nullable String victoryTitleToAll) {
        this.victoryTitleToAll = victoryTitleToAll;
        return this;
    }


    @Nullable
    public String getVictorySubtitleToAll() {
        return victorySubtitleToAll;
    }

    public ArcadiumGame setVictorySubtitleToAll(@Nullable String victorySubtitleToAll) {
        this.victorySubtitleToAll = victorySubtitleToAll;
        return this;
    }


    public int getVictoryTitleFadeIn() {
        return victoryTitleFadeIn;
    }

    public ArcadiumGame setVictoryTitleFadeIn(int victoryTitleFadeIn) {
        this.victoryTitleFadeIn = victoryTitleFadeIn;
        return this;
    }


    public int getVictoryTitleStay() {
        return victoryTitleStay;
    }

    public ArcadiumGame setVictoryTitleStay(int victoryTitleStay) {
        this.victoryTitleStay = victoryTitleStay;
        return this;
    }


    public int getVictoryTitleFadeOut() {
        return victoryTitleFadeOut;
    }

    public ArcadiumGame setVictoryTitleFadeOut(int victoryTitleFadeOut) {
        this.victoryTitleFadeOut = victoryTitleFadeOut;
        return this;
    }


    public boolean isSpawnVictoryFireWorks() {
        return spawnVictoryFireWorks;
    }

    public ArcadiumGame setSpawnVictoryFireWorks(boolean spawnVictoryFireWorks) {
        this.spawnVictoryFireWorks = spawnVictoryFireWorks;
        return this;
    }


    public boolean isSendVictoryMessage() {
        return sendVictoryMessage;
    }

    public ArcadiumGame setSendVictoryMessage(boolean sendVictoryMessage) {
        this.sendVictoryMessage = sendVictoryMessage;
        return this;
    }


    @Nullable
    public String getVictoryMessage() {
        return victoryMessage;
    }

    public ArcadiumGame setVictoryMessage(@Nullable String victoryMessage) {
        this.victoryMessage = victoryMessage;
        return this;
    }


    public boolean isSendVictoryMessageToAll() {
        return sendVictoryMessageToAll;
    }

    public ArcadiumGame setSendVictoryMessageToAll(boolean sendVictoryMessageToAll) {
        this.sendVictoryMessageToAll = sendVictoryMessageToAll;
        return this;
    }


    @Nullable
    public String getVictoryMessageToAll() {
        return victoryMessageToAll;
    }

    public ArcadiumGame setVictoryMessageToAll(@Nullable String victoryMessageToAll) {
        this.victoryMessageToAll = victoryMessageToAll;
        return this;
    }


    public boolean isSendVictoryMessageToDiscord() {
        return sendVictoryMessageToDiscord;
    }

    public ArcadiumGame setSendVictoryMessageToDiscord(boolean sendVictoryMessageToDiscord) {
        this.sendVictoryMessageToDiscord = sendVictoryMessageToDiscord;
        return this;
    }


    @Nullable
    public String getVictoryMessageToDiscord() {
        return victoryMessageToDiscord;
    }

    public ArcadiumGame setVictoryMessageToDiscord(@Nullable String victoryMessageToDiscord) {
        this.victoryMessageToDiscord = victoryMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyVictoryCommands(){
        return useOnlyVictoryCommands;
    }

    public ArcadiumGame setUseOnlyVictoryCommands(boolean useOnlyVictoryCommands){
        this.useOnlyVictoryCommands = useOnlyVictoryCommands;
        return this;
    }


    @NotNull
    public List<String> getVictoryCommandsToDispatch() {
        return victoryCommandsToDispatch;
    }

    public ArcadiumGame setVictoryCommandsToDispatch(@NotNull List<String> victoryCommandsToDispatch) {
        if(victoryCommandsToDispatch == null) return this;
        this.victoryCommandsToDispatch = victoryCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpVictoryURL() {
        return httpVictoryURL;
    }

    public ArcadiumGame setHttpVictoryURL(@Nullable String httpVictoryURL) {
        this.httpVictoryURL = httpVictoryURL;
        return this;
    }


    @Nullable
    public String getHttpVictoryMethod() {
        return httpVictoryMethod;
    }

    public ArcadiumGame setHttpVictoryMethod(@Nullable String httpVictoryMethod) {
        this.httpVictoryMethod = httpVictoryMethod;
        return this;
    }


    @NotNull
    public Map<String, Object> getHttpVictoryHeaders() {
        return httpVictoryHeaders;
    }

    public ArcadiumGame setHttpVictoryHeaders(@NotNull Map<String, Object> httpVictoryHeaders) {
        if(httpVictoryHeaders == null) return this;
        this.httpVictoryHeaders = httpVictoryHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getVictoryMusic() {
        return victoryMusic;
    }

    public ArcadiumGame setVictoryMusic(@Nullable BoomboxSong victoryMusic) {
        this.victoryMusic = victoryMusic;
        return this;
    }


    public boolean isSendDefeatTitle() {
        return sendDefeatTitle;
    }

    public ArcadiumGame setSendDefeatTitle(boolean sendDefeatTitle) {
        this.sendDefeatTitle = sendDefeatTitle;
        return this;
    }


    @Nullable
    public BarColor getDefeatBossBarColor() {
        return defeatBossBarColor;
    }

    public ArcadiumGame setDefeatBossBarColor(@Nullable BarColor defeatBossBarColor) {
        this.defeatBossBarColor = defeatBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getDefeatBossBarStyle() {
        return defeatBossBarStyle;
    }

    public ArcadiumGame setDefeatBossBarStyle(@Nullable BarStyle defeatBossBarStyle) {
        this.defeatBossBarStyle = defeatBossBarStyle;
        return this;
    }


    public int getDefeatBossBarDuration() {
        return defeatBossBarDuration;
    }

    public ArcadiumGame setDefeatBossBarDuration(int defeatBossBarDuration) {
        this.defeatBossBarDuration = defeatBossBarDuration;
        return this;
    }


    public boolean isSendDefeatBossBar() {
        return sendDefeatBossBar;
    }

    public ArcadiumGame setSendDefeatBossBar(boolean sendDefeatBossBar) {
        this.sendDefeatBossBar = sendDefeatBossBar;
        return this;
    }


    @Nullable
    public String getDefeatBossBarTitle() {
        return defeatBossBarTitle;
    }

    public ArcadiumGame setDefeatBossBarTitle(@Nullable String defeatBossBarTitle) {
        this.defeatBossBarTitle = defeatBossBarTitle;
        return this;
    }


    public boolean isSendDefeatBossBarToAll() {
        return sendDefeatBossBarToAll;
    }

    public ArcadiumGame setSendDefeatBossBarToAll(boolean sendDefeatBossBarToAll) {
        this.sendDefeatBossBarToAll = sendDefeatBossBarToAll;
        return this;
    }


    @Nullable
    public String getDefeatBossBarTitleToAll() {
        return defeatBossBarTitleToAll;
    }

    public ArcadiumGame setDefeatBossBarTitleToAll(@Nullable String defeatBossBarTitleToAll) {
        this.defeatBossBarTitleToAll = defeatBossBarTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatTitle() {
        return defeatTitle;
    }

    public ArcadiumGame setDefeatTitle(@Nullable String defeatTitle) {
        this.defeatTitle = defeatTitle;

        return this;
    }


    @Nullable
    public String getDefeatSubtitle() {
        return defeatSubtitle;
    }

    public ArcadiumGame setDefeatSubtitle(@Nullable String defeatSubtitle) {
        this.defeatSubtitle = defeatSubtitle;
        return this;
    }


    public boolean isSendDefeatTitleToAll() {
        return sendDefeatTitleToAll;
    }

    public ArcadiumGame setSendDefeatTitleToAll(boolean sendDefeatTitleToAll) {
        this.sendDefeatTitleToAll = sendDefeatTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatTitleToAll() {
        return defeatTitleToAll;
    }

    public ArcadiumGame setDefeatTitleToAll(@Nullable String defeatTitleToAll) {
        this.defeatTitleToAll = defeatTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatSubtitleToAll() {
        return defeatSubtitleToAll;
    }

    public ArcadiumGame setDefeatSubtitleToAll(@Nullable String defeatSubtitleToAll) {
        this.defeatSubtitleToAll = defeatSubtitleToAll;
        return this;
    }


    public int getDefeatTitleFadeIn() {
        return defeatTitleFadeIn;
    }

    public ArcadiumGame setDefeatTitleFadeIn(int defeatTitleFadeIn) {
        this.defeatTitleFadeIn = defeatTitleFadeIn;
        return this;
    }


    public int getDefeatTitleStay() {
        return defeatTitleStay;
    }

    public ArcadiumGame setDefeatTitleStay(int defeatTitleStay) {
        this.defeatTitleStay = defeatTitleStay;
        return this;
    }


    public int getDefeatTitleFadeOut() {
        return defeatTitleFadeOut;
    }

    public ArcadiumGame setDefeatTitleFadeOut(int defeatTitleFadeOut) {
        this.defeatTitleFadeOut = defeatTitleFadeOut;
        return this;
    }


    public boolean isSendDefeatMessage() {
        return sendDefeatMessage;
    }

    public ArcadiumGame setSendDefeatMessage(boolean sendDefeatMessage) {
        this.sendDefeatMessage = sendDefeatMessage;
        return this;
    }


    @Nullable
    public String getDefeatMessage() {
        return defeatMessage;
    }

    public ArcadiumGame setDefeatMessage(@Nullable String defeatMessage) {
        this.defeatMessage = defeatMessage;
        return this;
    }


    public boolean isSendDefeatMessageToAll() {
        return sendDefeatMessageToAll;
    }

    public ArcadiumGame setSendDefeatMessageToAll(boolean sendDefeatMessageToAll) {
        this.sendDefeatMessageToAll = sendDefeatMessageToAll;
        return this;
    }


    @Nullable
    public String getDefeatMessageToAll() {
        return defeatMessageToAll;
    }

    public ArcadiumGame setDefeatMessageToAll(@Nullable String defeatMessageToAll) {
        this.defeatMessageToAll = defeatMessageToAll;
        return this;
    }


    public boolean isSendDefeatMessageToDiscord() {
        return sendDefeatMessageToDiscord;
    }

    public ArcadiumGame setSendDefeatMessageToDiscord(boolean sendDefeatMessageToDiscord) {
        this.sendDefeatMessageToDiscord = sendDefeatMessageToDiscord;
        return this;
    }


    @Nullable
    public String getDefeatMessageToDiscord() {
        return defeatMessageToDiscord;
    }

    public ArcadiumGame setDefeatMessageToDiscord(@Nullable String defeatMessageToDiscord) {
        this.defeatMessageToDiscord = defeatMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyDefeatCommands(){
        return useOnlyDefeatCommands;
    }

    public ArcadiumGame setUseOnlyDefeatCommands(boolean useOnlyDefeatCommands){
        this.useOnlyDefeatCommands = useOnlyDefeatCommands;
        return this;
    }


    @NotNull
    public List<String> getDefeatCommandsToDispatch() {
        return defeatCommandsToDispatch;
    }

    public ArcadiumGame setDefeatCommandsToDispatch(@NotNull List<String> defeatCommandsToDispatch) {
        if(defeatCommandsToDispatch == null) return this;
        this.defeatCommandsToDispatch = defeatCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpDefeatURL() {
        return httpDefeatURL;
    }

    public ArcadiumGame setHttpDefeatURL(@Nullable String httpDefeatURL) {
        this.httpDefeatURL = httpDefeatURL;
        return this;
    }


    @Nullable
    public String getHttpDefeatMethod() {
        return httpDefeatMethod;
    }

    public ArcadiumGame setHttpDefeatMethod(@Nullable String httpDefeatMethod) {
        this.httpDefeatMethod = httpDefeatMethod;
        return this;
    }


    @NotNull
    public Map<String, Object> getHttpDefeatHeaders() {
        return httpDefeatHeaders;
    }

    public ArcadiumGame setHttpDefeatHeaders(@NotNull Map<String, Object> httpDefeatHeaders) {
        if(httpDefeatHeaders == null) return this;
        this.httpDefeatHeaders = httpDefeatHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getDefeatMusic() {
        return defeatMusic;
    }

    public ArcadiumGame setDefeatMusic(@Nullable BoomboxSong defeatMusic) {
        this.defeatMusic = defeatMusic;
        return this;
    }


    @NotNull
    public List<Integer> getSpotSlots() {
        return spotSlots;
    }

    public ArcadiumGame setSpotSlots(@NotNull List<Integer> spotSlots) {
        if(spotSlots == null) return this;
        this.spotSlots = spotSlots;
        return this;
    }


    @Nullable
    public ItemStack getSpotItem() {
        return spotItem;
    }

    public ArcadiumGame setSpotItem(@Nullable ItemStack spotItem) {
        this.spotItem = spotItem;
        return this;
    }


    @Nullable
    public String getSpotItemTitle() {
        return spotItemTitle;
    }

    public ArcadiumGame setSpotItemTitle(@Nullable String spotItemTitle) {
        this.spotItemTitle = spotItemTitle;
        return this;
    }



    @NotNull
    public List<String> getSpotItemLore() {
        return spotItemLore;
    }

    public ArcadiumGame setSpotItemLore(@NotNull List<String> spotItemLore) {
        if(spotItemLore == null) return this;
        this.spotItemLore = spotItemLore;
        return this;
    }


    @NotNull
    public List<Integer> getLeverSlots() {
        return leverSlots;
    }

    public ArcadiumGame setLeverSlots(@NotNull List<Integer> leverSlots) {
        if(leverSlots == null) return this;
        this.leverSlots = leverSlots;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemInactive() {
        return leverItemInactive;
    }

    public ArcadiumGame setLeverItemInactive(@Nullable ItemStack leverItemInactive) {
        this.leverItemInactive = leverItemInactive;
        return this;
    }


    @Nullable
    public String getLeverItemInactiveTitle() {
        return leverItemInactiveTitle;
    }

    public ArcadiumGame setLeverItemInactiveTitle(@Nullable String leverItemInactiveTitle) {
        this.leverItemInactiveTitle = leverItemInactiveTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemInactiveLore() {
        return leverItemInactiveLore;
    }

    public ArcadiumGame setLeverItemInactiveLore(@NotNull List<String> leverItemInactiveLore) {
        if(leverItemInactiveLore == null) return this;
        this.leverItemInactiveLore = leverItemInactiveLore;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemActive() {
        return leverItemActive;
    }

    public ArcadiumGame setLeverItemActive(@Nullable ItemStack leverItemActive) {
        this.leverItemActive = leverItemActive;
        return this;
    }


    @Nullable
    public String getLeverItemActiveTitle() {
        return leverItemActiveTitle;
    }

    public ArcadiumGame setLeverItemActiveTitle(@Nullable String leverItemActiveTitle) {
        this.leverItemActiveTitle = leverItemActiveTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemActiveLore() {
        return leverItemActiveLore;
    }

    public ArcadiumGame setLeverItemActiveLore(@NotNull List<String> leverItemActiveLore) {
        if(leverItemActiveLore == null) return this;
        this.leverItemActiveLore = leverItemActiveLore;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemRolling() {
        return leverItemRolling;
    }

    public ArcadiumGame setLeverItemRolling(@Nullable ItemStack leverItemRolling) {
        this.leverItemRolling = leverItemRolling;
        return this;
    }


    @Nullable
    public String getLeverItemRollingTitle() {
        return leverItemRollingTitle;
    }

    public ArcadiumGame setLeverItemRollingTitle(@Nullable String leverItemRollingTitle) {
        this.leverItemRollingTitle = leverItemRollingTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemRollingLore() {
        return leverItemRollingLore;
    }

    public ArcadiumGame setLeverItemRollingLore(@NotNull List<String> leverItemRollingLore) {
        if(leverItemRollingLore == null) return this;
        this.leverItemRollingLore = leverItemRollingLore;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemEnd() {
        return leverItemEnd;
    }

    public ArcadiumGame setLeverItemEnd(@Nullable ItemStack leverItemEnd) {
        this.leverItemEnd = leverItemEnd;
        return this;
    }


    @Nullable
    public String getLeverItemEndTitle() {
        return leverItemEndTitle;
    }

    public ArcadiumGame setLeverItemEndTitle(@Nullable String leverItemEndTitle) {
        this.leverItemEndTitle = leverItemEndTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemEndLore() {
        return leverItemEndLore;
    }

    public ArcadiumGame setLeverItemEndLore(@NotNull List<String> leverItemEndLore) {
        if(leverItemEndLore == null) return this;
        this.leverItemEndLore = leverItemEndLore;
        return this;
    }


    @Nullable
    public BoomboxSong getBackgroundMusic() {
        return backgroundMusic;
    }

    public ArcadiumGame setBackgroundMusic(@Nullable BoomboxSong backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
        return this;
    }


    public int getGameOnline(){
        return gameOnline;
    }

    public void setGameOnline(int gameOnline){
        this.gameOnline = gameOnline;
    }

    public void addGameOnline(){
        gameOnline++;
    }

    public void removeGameOnline(){
        gameOnline = Math.max(0, gameOnline - 1);
    }

}



