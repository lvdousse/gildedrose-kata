package com.gildedrose;

public class GildedRoseItem {

    private String name;

    private int sellIn;

    private int quality;

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
        if (quality < 50)
            quality++;
    }

    public void decreaseQuality() {
        if (quality > 0)
            quality--;
    }

    public void increaseQuality(int increment) {
        quality = Math.min(50, quality + increment);
    }

    public void decreaseQuality(int increment) {
        quality = Math.max(0, quality - increment);
    }

    public void nullifyQuality() {
        this.quality = 0;
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    public boolean hasSellInValueHigherThen(int nrOfDays) {
        return sellIn > nrOfDays;
    }

    public boolean isConjured() {
        return name.equals("Conjured Mana Cake");
    }
}
