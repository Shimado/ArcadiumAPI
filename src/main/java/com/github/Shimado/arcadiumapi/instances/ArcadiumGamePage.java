package com.github.Shimado.arcadiumapi.instances;

import com.github.Shimado.boomboxapi.instances.BoomboxSong;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArcadiumGamePage {

    private final int guiSize;
    private final String guiTitle;

    private double minBetPrice = 0.01;
    private int minBetPriceInItems = 1;
    private double maxBetPrice = 10000000.0;
    private int maxBetPriceInItems = 64;
    private double maxDiffBetweenBets = 100.0;

    private List<Integer> moneyBetSlots = new ArrayList<>();
    private ItemStack moneyBetItem;
    private String moneyBetItemTitle;
    private List<String> moneyBetItemLore = new ArrayList<>();
    private double moneyBetDefault = 1000.0;
    private double moneyBetChangePerClick = 1000.0;
    private double moneyBetChangePerClickBig = 10000.0;

    private List<Integer> spotSlots = new ArrayList<>();
    private ItemStack spotItem;

    private List<Integer> leverItemInactiveSlots = new ArrayList<>();
    private ItemStack leverItemInactiveItem;
    private List<Integer> leverItemActiveSlots = new ArrayList<>();
    private ItemStack leverItemActiveItem;

    private List<Integer> closeButtonSlots = new ArrayList<>();
    private ItemStack closeButtonItem;

    private List<Integer> restartButtonSlots = new ArrayList<>();
    private ItemStack restartButtonItem;

    private List<Integer> notificationsButtonSlots = new ArrayList<>();
    private ItemStack notificationsItem;
    private String notificationsButtonTitle;
    private List<String> notificationsButtonLore = new ArrayList<>();

    private List<Integer> musicInactiveButtonSlots = new ArrayList<>();
    private ItemStack musicInactiveItem;
    private String musicInactiveButtonTitle;
    private List<String> musicInactiveButtonLore = new ArrayList<>();

    private List<Integer> musicActiveButtonSlots = new ArrayList<>();
    private ItemStack musicActiveItem;
    private String musicActiveButtonTitle;
    private List<String> musicActiveButtonLore = new ArrayList<>();

    private List<Integer> scoreSlots = new ArrayList<>();
    private ItemStack scoreItem;
    private String scoreTitle;
    private List<String> scoreLore = new ArrayList<>();

    private List<Integer> ratingSlots = new ArrayList<>();
    private ItemStack ratingItem;
    private String ratingTitle;
    private List<String> ratingLore = new ArrayList<>();

    private List<Integer> globalInfoSlots = new ArrayList<>();
    private ItemStack globalInfoItem;
    private String globalInfoTitle;
    private List<String> globalInfoLore = new ArrayList<>();

    private List<Integer> yoursInfoSlots = new ArrayList<>();
    private ItemStack yoursInfoItem;
    private String yoursInfoTitle;
    private List<String> yoursInfoLore = new ArrayList<>();

    private List<Integer> previousPageButtonSlots = new ArrayList<>();
    private ItemStack previousPageButtonItem;

    private List<Integer> nextPageButtonSlots = new ArrayList<>();
    private ItemStack nextPageButtonItem;

    private List<Integer> pageSlots = new ArrayList<>();
    private Map<Integer, ItemStack> pageItems = new HashMap<>();

    private BoomboxSong backgroundMusic;

    private Map<Integer, ItemStack> emptySlots = new HashMap<>();


    public ArcadiumGamePage(int guiSize, @NotNull String guiTitle){
        this.guiSize = guiSize;
        this.guiTitle = guiTitle;
    }


    public int getGuiSize() {
        return guiSize;
    }


    @NotNull
    public String getGuiTitle() {
        return guiTitle;
    }


    public double getMinBetPrice() {
        return minBetPrice;
    }

    public ArcadiumGamePage setMinBetPrice(double minBetPrice) {
        this.minBetPrice = minBetPrice;
        return this;
    }


    public int getMinBetPriceInItems() {
        return minBetPriceInItems;
    }

    public ArcadiumGamePage setMinBetPriceInItems(int minBetPriceInItems) {
        this.minBetPriceInItems = minBetPriceInItems;
        return this;
    }


    public double getMaxBetPrice() {
        return maxBetPrice;
    }

    public ArcadiumGamePage setMaxBetPrice(double maxBetPrice) {
        this.maxBetPrice = maxBetPrice;
        return this;
    }


    public int getMaxBetPriceInItems() {
        return maxBetPriceInItems;
    }

    public ArcadiumGamePage setMaxBetPriceInItems(int maxBetPriceInItems) {
        this.maxBetPriceInItems = maxBetPriceInItems;
        return this;
    }


    public double getMaxDiffBetweenBets() {
        return maxDiffBetweenBets;
    }

    public ArcadiumGamePage setMaxDiffBetweenBets(double maxDiffBetweenBets) {
        this.maxDiffBetweenBets = maxDiffBetweenBets;
        return this;
    }


    @NotNull
    public List<Integer> getMoneyBetSlots() {
        return moneyBetSlots;
    }

    public ArcadiumGamePage setMoneyBetSlots(@Nullable List<Integer> moneyBetSlots) {
        if(moneyBetSlots == null) return this;
        this.moneyBetSlots = moneyBetSlots;
        return this;
    }


    @Nullable
    public ItemStack getMoneyBetItem() {
        return moneyBetItem;
    }

    public ArcadiumGamePage setMoneyBetItem(@Nullable ItemStack moneyBetItem) {
        this.moneyBetItem = moneyBetItem;
        return this;
    }


    @Nullable
    public String getMoneyBetItemTitle() {
        return moneyBetItemTitle;
    }

    public ArcadiumGamePage setMoneyBetItemTitle(@Nullable String moneyBetItemTitle) {
        this.moneyBetItemTitle = moneyBetItemTitle;
        return this;
    }


    @NotNull
    public List<String> getMoneyBetItemLore() {
        return moneyBetItemLore;
    }

    public ArcadiumGamePage setMoneyBetItemLore(@Nullable List<String> moneyBetItemLore) {
        if(moneyBetItemLore == null) return this;
        this.moneyBetItemLore = moneyBetItemLore;
        return this;
    }


    public double getMoneyBetDefault() {
        return moneyBetDefault;
    }

    public ArcadiumGamePage setMoneyBetDefault(double moneyBetDefault) {
        this.moneyBetDefault = moneyBetDefault;
        return this;
    }


    public double getMoneyBetChangePerClick() {
        return moneyBetChangePerClick;
    }

    public ArcadiumGamePage setMoneyBetChangePerClick(double moneyBetChangePerClick) {
        this.moneyBetChangePerClick = moneyBetChangePerClick;
        return this;
    }


    public double getMoneyBetChangePerClickBig() {
        return moneyBetChangePerClickBig;
    }

    public ArcadiumGamePage setMoneyBetChangePerClickBig(double moneyBetChangePerClickBig) {
        this.moneyBetChangePerClickBig = moneyBetChangePerClickBig;
        return this;
    }


    @NotNull
    public List<Integer> getSpotSlots() {
        return spotSlots;
    }

    public ArcadiumGamePage setSpotSlots(@Nullable List<Integer> spotSlots) {
        if(spotSlots == null) return this;
        this.spotSlots = spotSlots;
        return this;
    }


    @Nullable
    public ItemStack getSpotItem() {
        return spotItem;
    }

    public ArcadiumGamePage setSpotItem(@Nullable ItemStack spotItem) {
        if(spotItem == null) return this;
        this.spotItem = spotItem;
        return this;
    }


    @NotNull
    public List<Integer> getLeverItemInactiveSlots() {
        return leverItemInactiveSlots;
    }

    public ArcadiumGamePage setLeverItemInactiveSlots(@Nullable List<Integer> leverItemInactiveSlots) {
        if(leverItemInactiveSlots == null) return this;
        this.leverItemInactiveSlots = leverItemInactiveSlots;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemInactiveItem() {
        return leverItemInactiveItem;
    }

    public ArcadiumGamePage setLeverItemInactiveItem(@Nullable ItemStack leverItemInactiveItem) {
        this.leverItemInactiveItem = leverItemInactiveItem;
        return this;
    }


    @NotNull
    public List<Integer> getLeverItemActiveSlots() {
        return leverItemActiveSlots;
    }

    public ArcadiumGamePage setLeverItemActiveSlots(@Nullable List<Integer> leverItemActiveSlots) {
        if(leverItemActiveSlots == null) return this;
        this.leverItemActiveSlots = leverItemActiveSlots;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemActiveItem() {
        return leverItemActiveItem;
    }

    public ArcadiumGamePage setLeverItemActiveItem(@Nullable ItemStack leverItemActiveItem) {
        this.leverItemActiveItem = leverItemActiveItem;
        return this;
    }


    @NotNull
    public List<Integer> getCloseButtonSlots() {
        return closeButtonSlots;
    }

    public ArcadiumGamePage setCloseButtonSlots(@Nullable List<Integer> closeButtonSlots) {
        if(closeButtonSlots == null) return this;
        this.closeButtonSlots = closeButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getCloseButtonItem() {
        return closeButtonItem;
    }

    public ArcadiumGamePage setCloseButtonItem(@Nullable ItemStack closeButtonItem) {
        this.closeButtonItem = closeButtonItem;
        return this;
    }


    @NotNull
    public List<Integer> getRestartButtonSlots() {
        return restartButtonSlots;
    }

    public ArcadiumGamePage setRestartButtonSlots(@Nullable List<Integer> restartButtonSlots) {
        if(restartButtonSlots == null) return this;
        this.restartButtonSlots = restartButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getRestartButtonItem() {
        return restartButtonItem;
    }

    public ArcadiumGamePage setRestartButtonItem(@Nullable ItemStack restartButtonItem) {
        this.restartButtonItem = restartButtonItem;
        return this;
    }


    @NotNull
    public List<Integer> getNotificationsButtonSlots() {
        return notificationsButtonSlots;
    }

    public ArcadiumGamePage setNotificationsButtonSlots(@Nullable List<Integer> notificationsButtonSlots) {
        if(notificationsButtonSlots == null) return this;
        this.notificationsButtonSlots = notificationsButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getNotificationsItem() {
        return notificationsItem;
    }

    public ArcadiumGamePage setNotificationsItem(@Nullable ItemStack notificationsItem) {
        this.notificationsItem = notificationsItem;
        return this;
    }


    @Nullable
    public String getNotificationsButtonTitle() {
        return notificationsButtonTitle;
    }

    public ArcadiumGamePage setNotificationsButtonTitle(@Nullable String notificationsButtonTitle) {
        this.notificationsButtonTitle = notificationsButtonTitle;
        return this;
    }


    @NotNull
    public List<String> getNotificationsButtonLore() {
        return notificationsButtonLore;
    }

    public ArcadiumGamePage setNotificationsButtonLore(@Nullable List<String> notificationsButtonLore) {
        if(notificationsButtonLore == null) return this;
        this.notificationsButtonLore = notificationsButtonLore;
        return this;
    }


    @NotNull
    public List<Integer> getMusicInactiveButtonSlots() {
        return musicInactiveButtonSlots;
    }

    public ArcadiumGamePage setMusicInactiveButtonSlots(@Nullable List<Integer> musicInactiveButtonSlots) {
        if(musicInactiveButtonSlots == null) return this;
        this.musicInactiveButtonSlots = musicInactiveButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getMusicInactiveItem() {
        return musicInactiveItem;
    }

    public ArcadiumGamePage setMusicInactiveItem(@Nullable ItemStack musicInactiveItem) {
        this.musicInactiveItem = musicInactiveItem;
        return this;
    }


    @Nullable
    public String getMusicInactiveButtonTitle() {
        return musicInactiveButtonTitle;
    }

    public ArcadiumGamePage setMusicInactiveButtonTitle(@Nullable String musicInactiveButtonTitle) {
        this.musicInactiveButtonTitle = musicInactiveButtonTitle;
        return this;
    }


    @NotNull
    public List<String> getMusicInactiveButtonLore() {
        return musicInactiveButtonLore;
    }

    public ArcadiumGamePage setMusicInactiveButtonLore(@Nullable List<String> musicInactiveButtonLore) {
        if(musicInactiveButtonLore == null) return this;
        this.musicInactiveButtonLore = musicInactiveButtonLore;
        return this;
    }


    @NotNull
    public List<Integer> getMusicActiveButtonSlots() {
        return musicActiveButtonSlots;
    }

    public ArcadiumGamePage setMusicActiveButtonSlots(@Nullable List<Integer> musicActiveButtonSlots) {
        if(musicActiveButtonSlots == null) return this;
        this.musicActiveButtonSlots = musicActiveButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getMusicActiveItem() {
        return musicActiveItem;
    }

    public ArcadiumGamePage setMusicActiveItem(@Nullable ItemStack musicActiveItem) {
        this.musicActiveItem = musicActiveItem;
        return this;
    }


    @Nullable
    public String getMusicActiveButtonTitle() {
        return musicActiveButtonTitle;
    }

    public ArcadiumGamePage setMusicActiveButtonTitle(@Nullable String musicActiveButtonTitle) {
        this.musicActiveButtonTitle = musicActiveButtonTitle;
        return this;
    }


    @NotNull
    public List<String> getMusicActiveButtonLore() {
        return musicActiveButtonLore;
    }

    public ArcadiumGamePage setMusicActiveButtonLore(@Nullable List<String> musicActiveButtonLore) {
        if(musicActiveButtonLore == null) return this;
        this.musicActiveButtonLore = musicActiveButtonLore;
        return this;
    }


    @NotNull
    public List<Integer> getScoreSlots() {
        return scoreSlots;
    }

    public ArcadiumGamePage setScoreSlots(@Nullable List<Integer> scoreSlots) {
        if(scoreSlots == null) return this;
        this.scoreSlots = scoreSlots;
        return this;
    }


    @Nullable
    public ItemStack getScoreItem() {
        return scoreItem;
    }

    public ArcadiumGamePage setScoreItem(@Nullable ItemStack scoreItem) {
        this.scoreItem = scoreItem;
        return this;
    }


    @Nullable
    public String getScoreTitle() {
        return scoreTitle;
    }

    public ArcadiumGamePage setScoreTitle(@Nullable String scoreTitle) {
        this.scoreTitle = scoreTitle;
        return this;
    }


    @NotNull
    public List<String> getScoreLore() {
        return scoreLore;
    }

    public ArcadiumGamePage setScoreLore(@Nullable List<String> scoreLore) {
        if(scoreLore == null) return this;
        this.scoreLore = scoreLore;
        return this;
    }


    @NotNull
    public List<Integer> getRatingSlots() {
        return ratingSlots;
    }

    public ArcadiumGamePage setRatingSlots(@Nullable List<Integer> ratingSlots) {
        if(ratingSlots == null) return this;
        this.ratingSlots = ratingSlots;
        return this;
    }


    @Nullable
    public ItemStack getRatingItem() {
        return ratingItem;
    }

    public ArcadiumGamePage setRatingItem(@Nullable ItemStack ratingItem) {
        this.ratingItem = ratingItem;
        return this;
    }


    @Nullable
    public String getRatingTitle() {
        return ratingTitle;
    }

    public ArcadiumGamePage setRatingTitle(@Nullable String ratingTitle) {
        this.ratingTitle = ratingTitle;
        return this;
    }


    @NotNull
    public List<String> getRatingLore() {
        return ratingLore;
    }

    public ArcadiumGamePage setRatingLore(@Nullable List<String> ratingLore) {
        if(ratingLore == null) return this;
        this.ratingLore = ratingLore;
        return this;
    }


    @NotNull
    public List<Integer> getGlobalInfoSlots() {
        return globalInfoSlots;
    }

    public ArcadiumGamePage setGlobalInfoSlots(@Nullable List<Integer> globalInfoSlots) {
        if(globalInfoSlots == null) return this;
        this.globalInfoSlots = globalInfoSlots;
        return this;
    }


    @Nullable
    public ItemStack getGlobalInfoItem() {
        return globalInfoItem;
    }

    public ArcadiumGamePage setGlobalInfoItem(@Nullable ItemStack globalInfoItem) {
        this.globalInfoItem = globalInfoItem;
        return this;
    }


    @Nullable
    public String getGlobalInfoTitle() {
        return globalInfoTitle;
    }

    public ArcadiumGamePage setGlobalInfoTitle(@Nullable String globalInfoTitle) {
        this.globalInfoTitle = globalInfoTitle;
        return this;
    }


    @NotNull
    public List<String> getGlobalInfoLore() {
        return globalInfoLore;
    }

    public ArcadiumGamePage setGlobalInfoLore(@Nullable List<String> globalInfoLore) {
        if(globalInfoLore == null) return this;
        this.globalInfoLore = globalInfoLore;
        return this;
    }


    @NotNull
    public List<Integer> getYoursInfoSlots() {
        return yoursInfoSlots;
    }

    public ArcadiumGamePage setYoursInfoSlots(@Nullable List<Integer> yoursInfoSlots) {
        if(yoursInfoSlots == null) return this;
        this.yoursInfoSlots = yoursInfoSlots;
        return this;
    }


    @Nullable
    public ItemStack getYoursInfoItem() {
        return yoursInfoItem;
    }

    public ArcadiumGamePage setYoursInfoItem(@Nullable ItemStack yoursInfoItem) {
        this.yoursInfoItem = yoursInfoItem;
        return this;
    }


    @Nullable
    public String getYoursInfoTitle() {
        return yoursInfoTitle;
    }

    public ArcadiumGamePage setYoursInfoTitle(@Nullable String yoursInfoTitle) {
        this.yoursInfoTitle = yoursInfoTitle;
        return this;
    }


    @NotNull
    public List<String> getYoursInfoLore() {
        return yoursInfoLore;
    }

    public ArcadiumGamePage setYoursInfoLore(@Nullable List<String> yoursInfoLore) {
        if(yoursInfoLore == null) return this;
        this.yoursInfoLore = yoursInfoLore;
        return this;
    }


    @NotNull
    public List<Integer> getPreviousPageButtonSlots() {
        return previousPageButtonSlots;
    }

    public ArcadiumGamePage setPreviousPageButtonSlots(@Nullable List<Integer> previousPageButtonSlots) {
        if(previousPageButtonSlots == null) return this;
        this.previousPageButtonSlots = previousPageButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getPreviousPageButtonItem() {
        return previousPageButtonItem;
    }

    public ArcadiumGamePage setPreviousPageButtonItem(@Nullable ItemStack previousPageButtonItem) {
        this.previousPageButtonItem = previousPageButtonItem;
        return this;
    }


    @NotNull
    public List<Integer> getNextPageButtonSlots() {
        return nextPageButtonSlots;
    }

    public ArcadiumGamePage setNextPageButtonSlots(@Nullable List<Integer> nextPageButtonSlots) {
        if(nextPageButtonSlots == null) return this;
        this.nextPageButtonSlots = nextPageButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getNextPageButtonItem() {
        return nextPageButtonItem;
    }

    public ArcadiumGamePage setNextPageButtonItem(@Nullable ItemStack nextPageButtonItem) {
        this.nextPageButtonItem = nextPageButtonItem;
        return this;
    }


    @NotNull
    public List<Integer> getPageSlots() {
        return pageSlots;
    }

    public ArcadiumGamePage setPageSlots(@Nullable List<Integer> pageSlots) {
        if(pageSlots == null) return this;
        this.pageSlots = pageSlots;
        return this;
    }


    @NotNull
    public Map<Integer, ItemStack> getPageItems() {
        return pageItems;
    }

    public ArcadiumGamePage setPageItems(@Nullable Map<Integer, ItemStack> pageItems) {
        if(pageItems == null) return this;
        this.pageItems = pageItems;
        return this;
    }


    @Nullable
    public BoomboxSong getBackgroundMusic() {
        return backgroundMusic;
    }

    public ArcadiumGamePage setBackgroundMusic(@Nullable BoomboxSong backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
        return this;
    }


    @NotNull
    public Map<Integer, ItemStack> getEmptySlots() {
        return emptySlots;
    }

    public ArcadiumGamePage setEmptySlots(@NotNull Map<Integer, ItemStack> emptySlots) {
        if(emptySlots == null) return this;
        this.emptySlots = emptySlots;
        return this;
    }
}
