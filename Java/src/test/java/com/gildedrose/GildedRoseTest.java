package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void lower_both_values_for_every_item_at_end_of_each_day() {
        Item[] items = new Item[]{
            new Item("myItem1", 5, 5),
            new Item("myItem2", 8, 7)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);

        assertEquals(7, app.items[1].sellIn);
        assertEquals(6, app.items[1].quality);
    }

    @Test
    void once_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
        Item[] items = new Item[]{
            new Item("myItem", 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void the_quality_of_an_item_is_never_negative() {
        Item[] items = new Item[]{
            new Item("myItem", 0, 0),
            new Item("Aged Brie", 0, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertTrue(app.items[0].quality >= 0);
        assertTrue(app.items[1].quality >= 0);
        assertTrue(app.items[2].quality >= 0);
    }

    @Test
    void agedBrie_increases_in_quality_the_older_it_gets() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 12, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void the_quality_of_an_item_is_never_more_than_50() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 12, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfuras_a_legendary_item_never_has_to_be_sold_or_decreases_in_quality() {
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstage_passes_increase_in_quality_as_sell_in_value_approaches() {
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);
        assertEquals(27, app.items[1].quality); // increases by 2 when there are 10 days or less
        assertEquals(28, app.items[2].quality); // increases by 3 when there are 5 days or less
        assertEquals(0, app.items[3].quality); // drops to 0 after the concert
    }

    @Test
    void conjured_items_degrade_in_quality_twice_as_fast_as_normal_items() {
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", 11, 25),
            new Item("Conjured Mana Cake", 0, 25)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(21, app.items[1].quality);
    }


}
