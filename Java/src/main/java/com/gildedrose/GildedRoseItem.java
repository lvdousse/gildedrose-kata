package com.gildedrose;

public class GildedRoseItem {

    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    
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
        return AGED_BRIE.equals(name);
    }

    public boolean isBackstagePasses() {
        return BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(name);
    }

    public boolean isSulfuras() {
        return SULFURAS_HAND_OF_RAGNAROS.equals(name);
    }

    public boolean isConjured() {
        return CONJURED_MANA_CAKE.equals(name);
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
}
