package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityForItem(item);
        }
    }

    public void updateQualityForItem(Item inputItem) {
        GildedRoseItem item = new GildedRoseItem(inputItem);

        if (item.isSulfuras()) {
            return;
        }

        if (item.isAgedBrie()) {
            if (item.hasPassedSellByDate()) {
                item.increaseQuality(2);
            } else {
                item.increaseQuality();
            }
        } else if (item.isBackstagePasses()) {
            item.increaseQuality();

            if (item.sellIn <= 10) {
                item.increaseQuality();
            }

            if (item.sellIn <= 5) {
                item.increaseQuality();
            }
            if (item.hasPassedSellByDate()) {
                item.quality = 0;
            }
        } else {
            if (item.hasPassedSellByDate()) {
                item.decreaseQuality(2);
            } else
                item.decreaseQuality();
        }

        item.sellIn = item.sellIn - 1;

        item.update(inputItem);
    }

}
