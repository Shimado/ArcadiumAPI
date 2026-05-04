package com.github.Shimado.arcadiumapi.instances;

import com.github.Shimado.arcadiumapi.interfaces.items.GeneralChangeableItem;
import com.github.Shimado.arcadiumapi.interfaces.items.GeneralItem;
import com.github.Shimado.boomboxapi.instances.BoomboxSong;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ArcadiumGamePage {

    private final int guiSize;
    private final String guiTitle;

    private double minBetPrice = 0.01;
    private int minBetPriceInItems = 1;
    private double maxBetPrice = 10000000.0;
    private int maxBetPriceInItems = 64;
    private double maxDiffBetweenBets = 100.0;

    private GeneralItem addMoneyBetItem;
    private double addMoneyBetPerClick = 1000.0;
    private double addMoneyBetPerClickBig = 10000.0;

    private GeneralItem removeMoneyBetItem;
    private double removeMoneyBetPerClick = 1000.0;
    private double removeMoneyBetPerClickBig = 10000.0;

    private GeneralItem spotItem;
    private GeneralItem leverInactiveItem;
    private GeneralItem leverActiveItem;
    private GeneralItem closeButtonItem;
    private GeneralItem restartButtonItem;
    private GeneralChangeableItem notificationItems;
    private GeneralItem musicInactiveItem;
    private GeneralItem musicActiveItem;
    private GeneralItem scoreItem;
    private GeneralItem ratingItem;
    private GeneralItem globalInfoItem;
    private GeneralItem yourInfoItem;
    private GeneralItem previousPageItem;
    private GeneralItem nextPageItem;
    private GeneralChangeableItem pageItems;
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


    @Nullable
    public GeneralItem getAddMoneyBetItem() {
        return addMoneyBetItem;
    }

    public ArcadiumGamePage setAddMoneyBetItem(@Nullable GeneralItem addMoneyBetItem) {
        this.addMoneyBetItem = addMoneyBetItem;
        return this;
    }


    public double getAddMoneyBetPerClick() {
        return addMoneyBetPerClick;
    }

    public ArcadiumGamePage setAddMoneyBetPerClick(double addMoneyBetPerClick) {
        this.addMoneyBetPerClick = addMoneyBetPerClick;
        return this;
    }


    public double getAddMoneyBetPerClickBig() {
        return addMoneyBetPerClickBig;
    }

    public ArcadiumGamePage setAddMoneyBetPerClickBig(double addMoneyBetPerClickBig) {
        this.addMoneyBetPerClickBig = addMoneyBetPerClickBig;
        return this;
    }


    @Nullable
    public GeneralItem getRemoveMoneyBetItem() {
        return removeMoneyBetItem;
    }

    public ArcadiumGamePage setRemoveMoneyBetItem(@Nullable GeneralItem removeMoneyBetItem) {
        this.removeMoneyBetItem = removeMoneyBetItem;
        return this;
    }


    public double getRemoveMoneyBetPerClick() {
        return removeMoneyBetPerClick;
    }

    public ArcadiumGamePage setRemoveMoneyBetPerClick(double removeMoneyBetPerClick) {
        this.removeMoneyBetPerClick = removeMoneyBetPerClick;
        return this;
    }


    public double getRemoveMoneyBetPerClickBig() {
        return removeMoneyBetPerClickBig;
    }

    public ArcadiumGamePage setRemoveMoneyBetPerClickBig(double removeMoneyBetPerClickBig) {
        this.removeMoneyBetPerClickBig = removeMoneyBetPerClickBig;
        return this;
    }


    @Nullable
    public GeneralItem getSpotItem() {
        return spotItem;
    }

    public ArcadiumGamePage setSpotItem(@Nullable GeneralItem spotItem) {
        this.spotItem = spotItem;
        return this;
    }


    @Nullable
    public GeneralItem getLeverInactiveItem() {
        return leverInactiveItem;
    }

    public ArcadiumGamePage setLeverInactiveItem(@Nullable GeneralItem leverInactiveItem) {
        this.leverInactiveItem = leverInactiveItem;
        return this;
    }


    @Nullable
    public GeneralItem getLeverActiveItem() {
        return leverActiveItem;
    }

    public ArcadiumGamePage setLeverActiveItem(@Nullable GeneralItem leverActiveItem) {
        this.leverActiveItem = leverActiveItem;
        return this;
    }


    @Nullable
    public GeneralItem getCloseButtonItem() {
        return closeButtonItem;
    }

    public ArcadiumGamePage setCloseButtonItem(@Nullable GeneralItem closeButtonItem) {
        this.closeButtonItem = closeButtonItem;
        return this;
    }


    @Nullable
    public GeneralItem getRestartButtonItem() {
        return restartButtonItem;
    }

    public ArcadiumGamePage setRestartButtonItem(@Nullable GeneralItem restartButtonItem) {
        this.restartButtonItem = restartButtonItem;
        return this;
    }


    @Nullable
    public GeneralChangeableItem getNotificationItems() {
        return notificationItems;
    }

    public ArcadiumGamePage setNotificationItems(@Nullable GeneralChangeableItem notificationItems) {
        this.notificationItems = notificationItems;
        return this;
    }


    @Nullable
    public GeneralItem getMusicInactiveItem() {
        return musicInactiveItem;
    }

    public ArcadiumGamePage setMusicInactiveItem(@Nullable GeneralItem musicInactiveItem) {
        this.musicInactiveItem = musicInactiveItem;
        return this;
    }


    @Nullable
    public GeneralItem getMusicActiveItem() {
        return musicActiveItem;
    }

    public ArcadiumGamePage setMusicActiveItem(@Nullable GeneralItem musicActiveItem) {
        this.musicActiveItem = musicActiveItem;
        return this;
    }


    @Nullable
    public GeneralItem getScoreItem() {
        return scoreItem;
    }

    public ArcadiumGamePage setScoreItem(@Nullable GeneralItem scoreItem) {
        this.scoreItem = scoreItem;
        return this;
    }


    @Nullable
    public GeneralItem getRatingItem() {
        return ratingItem;
    }

    public ArcadiumGamePage setRatingItem(@Nullable GeneralItem ratingItem) {
        this.ratingItem = ratingItem;
        return this;
    }


    @Nullable
    public GeneralItem getGlobalInfoItem() {
        return globalInfoItem;
    }

    public ArcadiumGamePage setGlobalInfoItem(@Nullable GeneralItem globalInfoItem) {
        this.globalInfoItem = globalInfoItem;
        return this;
    }


    @Nullable
    public GeneralItem getYourInfoItem() {
        return yourInfoItem;
    }

    public ArcadiumGamePage setYourInfoItem(@Nullable GeneralItem yourInfoItem) {
        this.yourInfoItem = yourInfoItem;
        return this;
    }


    @Nullable
    public GeneralItem getPreviousPageItem() {
        return previousPageItem;
    }

    public ArcadiumGamePage setPreviousPageItem(@Nullable GeneralItem previousPageItem) {
        this.previousPageItem = previousPageItem;
        return this;
    }


    @Nullable
    public GeneralItem getNextPageItem() {
        return nextPageItem;
    }

    public ArcadiumGamePage setNextPageItem(@Nullable GeneralItem nextPageItem) {
        this.nextPageItem = nextPageItem;
        return this;
    }


    @Nullable
    public GeneralChangeableItem getPageItems() {
        return pageItems;
    }

    public ArcadiumGamePage setPageItems(@Nullable GeneralChangeableItem pageItems) {
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
