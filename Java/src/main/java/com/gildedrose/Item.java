package com.gildedrose;

/**
 * Do not alter the Item class or Items property as those belong to
 * the goblin in the corner who will insta-rage and one-shot you as
 * he doesn't believe in shared code ownership (you can make the
 * UpdateQuality method and Items property static if you like, we'll
 * cover for you).
 */
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
