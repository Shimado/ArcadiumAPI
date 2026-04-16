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

    private final String modeName;                                           // For usage in commands/placeholders/code and etc
    private Map<String, ArcadiumGamePage> gamePages = new HashMap<>();       // Game pages
    private String permission = "";                                          // The permission to open the game mode
    private List<Integer> slotsInGUI = new ArrayList<>();                    // Slots occupied by the icon in the main GUI
    private List<Integer> slotsInOneGameGUI = new ArrayList<>();             // Slots occupied by an icon in the main GUI for one game
    private ItemStack iconItem;                                              // The icon in the main GUI

    // VICTORY
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

    // DEFEAT
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

    // DRAW
    private boolean sendDrawTitle = false;                                   // Sends draw title
    private BarColor drawBossBarColor = BarColor.GREEN;                      // Bar color
    private BarStyle drawBossBarStyle = BarStyle.SOLID;                      // Bar style
    private int drawBossBarDuration = 0;                                     // Duration in ticks
    private boolean sendDrawBossBar = false;                                 // Sends bossbar title to player
    private String drawBossBarTitle;                                         // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendDrawBossBarToAll = false;                            // Sends bossbar title to all players
    private String drawBossBarTitleToAll;                                    // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String drawTitle;                                                // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String drawSubtitle;                                             // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawTitleToAll = false;                              // Sends draw title to all players
    private String drawTitleToAll;                                           // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String drawSubtitleToAll;                                        // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private int drawTitleFadeIn = 0;                                         // Title fade in time in ticks
    private int drawTitleStay = 0;                                           // Title stay time in ticks
    private int drawTitleFadeOut = 0;                                        // Title fade out time in ticks
    private boolean sendDrawMessage = false;                                 // Sends draw message to the losing player
    private String drawMessage;                                              // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawMessageToAll = false;                            // Sends draw message to all players
    private String drawMessageToAll;                                         // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawMessageToDiscord = false;                        // Sends draw message to Discord
    private String drawMessageToDiscord;                                     // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean useOnlyDrawCommands = false;                             // Whether only commands will be executed
    private List<String> drawCommandsToDispatch = new ArrayList<>();         // Commands executed when player loses [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDrawURL;                                              // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDrawMethod = "POST";                                  // Request method
    private Map<String, Object> httpDrawHeaders = new HashMap<>();           // Request headers
    private BoomboxSong drawMusic;                                           // Music in .nbs format from Boombox plugin

    // LOGS
    private String logText;                                                  // Logs line

    private int gameOnline = 0;                                              // This is how many players are currently playing this mode


    public ArcadiumGame(@NotNull String modeName){
        this.modeName = modeName;
    }


    @NotNull
    public String getModeName(){
        return modeName;
    }


    @NotNull
    public Map<String, ArcadiumGamePage> getGamePages(){
        return gamePages;
    }

    public void setGamePages(@NotNull Map<String, ArcadiumGamePage> gamePages){
        this.gamePages = gamePages;
    }

    public void addGamePage(@NotNull String gameName, @NotNull ArcadiumGamePage arcadiumGamePage){
        gamePages.put(gameName, arcadiumGamePage);
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


    @Nullable
    public BarColor getDrawBossBarColor() {
        return drawBossBarColor;
    }

    public ArcadiumGame setDrawBossBarColor(@Nullable BarColor drawBossBarColor) {
        this.drawBossBarColor = drawBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getDrawBossBarStyle() {
        return drawBossBarStyle;
    }

    public ArcadiumGame setDrawBossBarStyle(@Nullable BarStyle drawBossBarStyle) {
        this.drawBossBarStyle = drawBossBarStyle;
        return this;
    }


    public int getDrawBossBarDuration() {
        return drawBossBarDuration;
    }

    public ArcadiumGame setDrawBossBarDuration(int drawBossBarDuration) {
        this.drawBossBarDuration = drawBossBarDuration;
        return this;
    }


    public boolean isSendDrawBossBar() {
        return sendDrawBossBar;
    }

    public ArcadiumGame setSendDrawBossBar(boolean sendDrawBossBar) {
        this.sendDrawBossBar = sendDrawBossBar;
        return this;
    }


    @Nullable
    public String getDrawBossBarTitle() {
        return drawBossBarTitle;
    }

    public ArcadiumGame setDrawBossBarTitle(@Nullable String drawBossBarTitle) {
        this.drawBossBarTitle = drawBossBarTitle;
        return this;
    }


    public boolean isSendDrawBossBarToAll() {
        return sendDrawBossBarToAll;
    }

    public ArcadiumGame setSendDrawBossBarToAll(boolean sendDrawBossBarToAll) {
        this.sendDrawBossBarToAll = sendDrawBossBarToAll;
        return this;
    }


    @Nullable
    public String getDrawBossBarTitleToAll() {
        return drawBossBarTitleToAll;
    }

    public ArcadiumGame setDrawBossBarTitleToAll(@Nullable String drawBossBarTitleToAll) {
        this.drawBossBarTitleToAll = drawBossBarTitleToAll;
        return this;
    }


    public boolean isSendDrawTitle() {
        return sendDrawTitle;
    }

    public ArcadiumGame setSendDrawTitle(boolean sendDrawTitle) {
        this.sendDrawTitle = sendDrawTitle;
        return this;
    }


    @Nullable
    public String getDrawTitle() {
        return drawTitle;
    }

    public ArcadiumGame setDrawTitle(@Nullable String drawTitle) {
        this.drawTitle = drawTitle;

        return this;
    }


    @Nullable
    public String getDrawSubtitle() {
        return drawSubtitle;
    }

    public ArcadiumGame setDrawSubtitle(@Nullable String drawSubtitle) {
        this.drawSubtitle = drawSubtitle;
        return this;
    }


    public boolean isSendDrawTitleToAll() {
        return sendDrawTitleToAll;
    }

    public ArcadiumGame setSendDrawTitleToAll(boolean sendDrawTitleToAll) {
        this.sendDrawTitleToAll = sendDrawTitleToAll;
        return this;
    }


    @Nullable
    public String getDrawTitleToAll() {
        return drawTitleToAll;
    }

    public ArcadiumGame setDrawTitleToAll(@Nullable String drawTitleToAll) {
        this.drawTitleToAll = drawTitleToAll;
        return this;
    }


    @Nullable
    public String getDrawSubtitleToAll() {
        return drawSubtitleToAll;
    }

    public ArcadiumGame setDrawSubtitleToAll(@Nullable String drawSubtitleToAll) {
        this.drawSubtitleToAll = drawSubtitleToAll;
        return this;
    }


    public int getDrawTitleFadeIn() {
        return drawTitleFadeIn;
    }

    public ArcadiumGame setDrawTitleFadeIn(int drawTitleFadeIn) {
        this.drawTitleFadeIn = drawTitleFadeIn;
        return this;
    }


    public int getDrawTitleStay() {
        return drawTitleStay;
    }

    public ArcadiumGame setDrawTitleStay(int drawTitleStay) {
        this.drawTitleStay = drawTitleStay;
        return this;
    }


    public int getDrawTitleFadeOut() {
        return drawTitleFadeOut;
    }

    public ArcadiumGame setDrawTitleFadeOut(int drawTitleFadeOut) {
        this.drawTitleFadeOut = drawTitleFadeOut;
        return this;
    }


    public boolean isSendDrawMessage() {
        return sendDrawMessage;
    }

    public ArcadiumGame setSendDrawMessage(boolean sendDrawMessage) {
        this.sendDrawMessage = sendDrawMessage;
        return this;
    }


    @Nullable
    public String getDrawMessage() {
        return drawMessage;
    }

    public ArcadiumGame setDrawMessage(@Nullable String drawMessage) {
        this.drawMessage = drawMessage;
        return this;
    }


    public boolean isSendDrawMessageToAll() {
        return sendDrawMessageToAll;
    }

    public ArcadiumGame setSendDrawMessageToAll(boolean sendDrawMessageToAll) {
        this.sendDrawMessageToAll = sendDrawMessageToAll;
        return this;
    }


    @Nullable
    public String getDrawMessageToAll() {
        return drawMessageToAll;
    }

    public ArcadiumGame setDrawMessageToAll(@Nullable String drawMessageToAll) {
        this.drawMessageToAll = drawMessageToAll;
        return this;
    }


    public boolean isSendDrawMessageToDiscord() {
        return sendDrawMessageToDiscord;
    }

    public ArcadiumGame setSendDrawMessageToDiscord(boolean sendDrawMessageToDiscord) {
        this.sendDrawMessageToDiscord = sendDrawMessageToDiscord;
        return this;
    }


    @Nullable
    public String getDrawMessageToDiscord() {
        return drawMessageToDiscord;
    }

    public ArcadiumGame setDrawMessageToDiscord(@Nullable String drawMessageToDiscord) {
        this.drawMessageToDiscord = drawMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyDrawCommands(){
        return useOnlyDrawCommands;
    }

    public ArcadiumGame setUseOnlyDrawCommands(boolean useOnlyDrawCommands){
        this.useOnlyDrawCommands = useOnlyDrawCommands;
        return this;
    }


    @NotNull
    public List<String> getDrawCommandsToDispatch() {
        return drawCommandsToDispatch;
    }

    public ArcadiumGame setDrawCommandsToDispatch(@NotNull List<String> drawCommandsToDispatch) {
        if(drawCommandsToDispatch == null) return this;
        this.drawCommandsToDispatch = drawCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpDrawURL() {
        return httpDrawURL;
    }

    public ArcadiumGame setHttpDrawURL(@Nullable String httpDrawURL) {
        this.httpDrawURL = httpDrawURL;
        return this;
    }


    @Nullable
    public String getHttpDrawMethod() {
        return httpDrawMethod;
    }

    public ArcadiumGame setHttpDrawMethod(@Nullable String httpDrawMethod) {
        this.httpDrawMethod = httpDrawMethod;
        return this;
    }


    @NotNull
    public Map<String, Object> getHttpDrawHeaders() {
        return httpDrawHeaders;
    }

    public ArcadiumGame setHttpDrawHeaders(@NotNull Map<String, Object> httpDrawHeaders) {
        if(httpDrawHeaders == null) return this;
        this.httpDrawHeaders = httpDrawHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getDrawMusic() {
        return drawMusic;
    }

    public ArcadiumGame setDrawMusic(@Nullable BoomboxSong drawMusic) {
        this.drawMusic = drawMusic;
        return this;
    }


    @Nullable
    public String getLogText() {
        return logText;
    }

    public ArcadiumGame setLogText(@Nullable String logText) {
        this.logText = logText;
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



