package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item inputItem) {
        GildedRoseItem item = new GildedRoseItem(inputItem);

        if (item.isSulfuras()) {
            return;
        }

        if (item.isAgedBrie()) {
            updateQualityForAgedBrie(item);
        } else if (item.isBackstagePasses()) {
            updateQualityForBackstagePasses(item);
        } else if (item.isConjured()) {
            updateQualityForConjured(item);
        } else {
            updateQualityForNormalItems(item);
        }

        item.decreaseSellIn();

        item.update(inputItem);
    }

    private static void updateQualityForConjured(GildedRoseItem item) {
        if (item.hasPassedSellByDate()) {
            item.decreaseQuality(4);
        } else
            item.decreaseQuality(2);
    }

    private static void updateQualityForNormalItems(GildedRoseItem item) {
        if (item.hasPassedSellByDate()) {
            item.decreaseQuality(2);
        } else
            item.decreaseQuality();
    }

    private static void updateQualityForBackstagePasses(GildedRoseItem item) {
        if (item.hasPassedSellByDate()) {
            item.nullifyQuality();
        } else if (item.hasSellInValueHigherThen(10)) {
            item.increaseQuality();
        } else if (item.hasSellInValueHigherThen(5)) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality(3);
        }
    }

    private static void updateQualityForAgedBrie(GildedRoseItem item) {
        if (item.hasPassedSellByDate()) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality();
        }
    }

}
