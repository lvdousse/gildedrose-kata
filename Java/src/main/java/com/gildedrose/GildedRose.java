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
            if (item.hasPassedSellByDate()) {
                item.increaseQuality(2);
            } else {
                item.increaseQuality();
            }
        } else if (item.isBackstagePasses()) {
            if (item.hasPassedSellByDate()) {
                item.nullifyQuality();
            } else if (item.hasSellInValueHigherThen(10)) {
                item.increaseQuality();
            } else if (item.hasSellInValueHigherThen(5)) {
                item.increaseQuality(2);
            } else {
                item.increaseQuality(3);
            }

        } else {
            if (item.hasPassedSellByDate()) {
                item.decreaseQuality(2);
            } else
                item.decreaseQuality();
        }

        item.decreaseSellIn();

        item.update(inputItem);
    }

}
