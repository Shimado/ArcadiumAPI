package com.github.Shimado.arcadiumapi.instances;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArcadiumGamePage {

    private int guiSize = 6;
    private String guiTitle = "";

    private List<Integer> musicButtonSlots = new ArrayList<>();
    private ItemStack musicButtonItemInactive;
    private String musicButtonItemInactiveTitle;
    private List<String> musicButtonItemInactiveLore = new ArrayList<>();
    private ItemStack musicButtonItemActive;
    private String musicButtonItemActiveTitle;
    private List<String> musicButtonItemActiveLore = new ArrayList<>();

    private List<Integer> globalStatsButtonSlots = new ArrayList<>();
    private ItemStack globalStatsButtonItem;
    private List<String> globalStatsButtonLore = new ArrayList<>();

    private List<Integer> yourStatsButtonSlots = new ArrayList<>();
    private ItemStack yourStatsButtonItem;
    private List<String> yourStatsButtonLore = new ArrayList<>();

    private Map<Integer, ItemStack> emptySlots = new HashMap<>();



    public int getGuiSize(){
        return guiSize;
    }

    public ArcadiumGamePage setGuiSize(int guiSize){
        this.guiSize = guiSize;
        return this;
    }


    @Nullable
    public String getGuiTitle(){
        return guiTitle;
    }

    public ArcadiumGamePage setGuiTitle(@NotNull String guiTitle){
        if(guiTitle == null) return this;
        this.guiTitle = guiTitle;
        return this;
    }


    @NotNull
    public List<Integer> getMusicButtonSlots() {
        return musicButtonSlots;
    }

    public ArcadiumGamePage setMusicButtonSlots(@NotNull List<Integer> musicButtonSlots) {
        if(musicButtonSlots == null) return this;
        this.musicButtonSlots = musicButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonItemInactive() {
        return musicButtonItemInactive;
    }

    public ArcadiumGamePage setMusicButtonItemInactive(@Nullable ItemStack musicButtonItemInactive) {
        this.musicButtonItemInactive = musicButtonItemInactive;
        return this;
    }


    @Nullable
    public String getMusicButtonItemInactiveTitle() {
        return musicButtonItemInactiveTitle;
    }

    public ArcadiumGamePage setMusicButtonItemInactiveTitle(@Nullable String musicButtonItemInactiveTitle) {
        this.musicButtonItemInactiveTitle = musicButtonItemInactiveTitle;
        return this;
    }


    @NotNull
    public List<String> getMusicButtonItemInactiveLore() {
        return musicButtonItemInactiveLore;
    }

    public ArcadiumGamePage setMusicButtonItemInactiveLore(@NotNull List<String> musicButtonItemInactiveLore) {
        if(musicButtonItemInactiveLore == null) return this;
        this.musicButtonItemInactiveLore = musicButtonItemInactiveLore;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonItemActive() {
        return musicButtonItemActive;
    }

    public ArcadiumGamePage setMusicButtonItemActive(@Nullable ItemStack musicButtonItemActive) {
        this.musicButtonItemActive = musicButtonItemActive;
        return this;
    }


    @Nullable
    public String getMusicButtonItemActiveTitle() {
        return musicButtonItemActiveTitle;
    }

    public ArcadiumGamePage setMusicButtonItemActiveTitle(@Nullable String musicButtonItemActiveTitle) {
        this.musicButtonItemActiveTitle = musicButtonItemActiveTitle;
        return this;
    }


    @NotNull
    public List<String> getMusicButtonItemActiveLore() {
        return musicButtonItemActiveLore;
    }

    public ArcadiumGamePage setMusicButtonItemActiveLore(@NotNull List<String> musicButtonItemActiveLore) {
        if(musicButtonItemActiveLore == null) return this;
        this.musicButtonItemActiveLore = musicButtonItemActiveLore;
        return this;
    }


    @NotNull
    public List<Integer> getGlobalStatsButtonSlots() {
        return globalStatsButtonSlots;
    }

    public ArcadiumGamePage setGlobalStatsButtonSlots(@NotNull List<Integer> globalStatsButtonSlots) {
        if(globalStatsButtonSlots == null) return this;
        this.globalStatsButtonSlots = globalStatsButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getGlobalStatsButtonItem() {
        return globalStatsButtonItem;
    }

    public ArcadiumGamePage setGlobalStatsButtonItem(@Nullable ItemStack globalStatsButtonItem) {
        this.globalStatsButtonItem = globalStatsButtonItem;
        return this;
    }


    @NotNull
    public List<String> getGlobalStatsButtonLore() {
        return globalStatsButtonLore;
    }

    public ArcadiumGamePage setGlobalStatsButtonLore(@NotNull List<String> globalStatsButtonLore) {
        if(globalStatsButtonLore == null) return this;
        this.globalStatsButtonLore = globalStatsButtonLore;
        return this;
    }


    @NotNull
    public List<Integer> getYourStatsButtonSlots() {
        return yourStatsButtonSlots;
    }

    public ArcadiumGamePage setYourStatsButtonSlots(@NotNull List<Integer> yourStatsButtonSlots) {
        if(yourStatsButtonSlots == null) return this;
        this.yourStatsButtonSlots = yourStatsButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getYourStatsButtonItem() {
        return yourStatsButtonItem;
    }

    public ArcadiumGamePage setYourStatsButtonItem(@Nullable ItemStack yourStatsButtonItem) {
        this.yourStatsButtonItem = yourStatsButtonItem;
        return this;
    }


    @NotNull
    public List<String> getYourStatsButtonLore() {
        return yourStatsButtonLore;
    }

    public ArcadiumGamePage setYourStatsButtonLore(@NotNull List<String> yourStatsButtonLore) {
        if(yourStatsButtonLore == null) return this;
        this.yourStatsButtonLore = yourStatsButtonLore;
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
