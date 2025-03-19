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
        if (!isAgedBrie(item)
            && !isBackstagePasses(item)) {
            if (item.quality > 0) {
                if (!isSulfuras(item)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (isBackstagePasses(item)) {
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

        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePasses(item)) {
                    if (item.quality > 0) {
                        if (!isSulfuras(item)) {
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

    private boolean isAgedBrie(GildedRoseItem item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(GildedRoseItem item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(GildedRoseItem item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
