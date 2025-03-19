package com.gildedrose;

class GildedRose {
    GildedRoseItem[] items;

    public GildedRose(Item[] items) {
        this.items = new GildedRoseItem[items.length];
        for (int i = 0; i < items.length; i++)
            this.items[i] = new GildedRoseItem((items[i]));
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            updateQualityForItem(item);
        }
    }

    public void updateQualityForItem(GildedRoseItem item) {
        if (!item.isAgedBrie()
            && !item.isBackstagePasses()) {
            if (item.quality > 0) {
                if (!item.isSulfuras()) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.isBackstagePasses()) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.isSulfuras()) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.isAgedBrie()) {
                if (!item.isBackstagePasses()) {
                    if (item.quality > 0) {
                        if (!item.isSulfuras()) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
