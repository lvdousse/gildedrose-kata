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
        if (item.isAgedBrie()
            || item.isBackstagePasses()) {

            if (item.quality < 50) {
                item.increaseQuality();

                if (item.isBackstagePasses()) {
                    if (item.sellIn < 11) {
                        item.increaseQuality();
                    }

                    if (item.sellIn < 6) {
                        item.increaseQuality();
                    }
                }
            }

        } else {
            if (item.quality > 0) {
                if (!item.isSulfuras()) {
                    item.decreaseQuality();
                }
            }
        }

        if (!item.isSulfuras()) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.hasPassedSellByDate()) {

            if (item.isAgedBrie()) {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
            } else {
                if (!item.isBackstagePasses()) {
                    if (item.quality > 0) {
                        if (!item.isSulfuras()) {
                            item.decreaseQuality();
                        }
                    }
                } else {
                    item.quality = 0;
                }
            }
        }
        item.update(inputItem);
    }

}
