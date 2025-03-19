package com.gildedrose;

public class GildedRoseItem {

    public String name;

    public int sellIn;

    public int quality;

    public GildedRoseItem(Item item) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }
}
