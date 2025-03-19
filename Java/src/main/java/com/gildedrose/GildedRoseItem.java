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

    public void update(Item item) {
        item.name = this.name;
        item.sellIn = this.sellIn;
        item.quality = this.quality;
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    public boolean isBackstagePasses() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean hasPassedSellByDate() {
        return sellIn <= 0;
    }

    public void increaseQuality() {
        quality++;
    }

    public void increaseQuality(int increment) {
        quality += increment;
    }

    public void decreaseQuality() {
        quality--;
    }
}
