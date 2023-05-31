package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void decrease_the_quality_of_an_standard_item() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void sulfuras_is_inmutable(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void quality_of_an_item_is_never_negative(){
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void subtract_one_day_to_sellIn(){
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }
    @Test
    void quality_of_Aged_Brie_incremente_one(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void quality_of_Aged_Brie_incremente_two_when_sellIn_is_negative(){
        Item[] items = new Item[] { new Item("Aged Brie", -1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void quality_of_Aged_Brie_incremente_two_when_sellIn_is_zero(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    //Age Brie increment quality +1 every day. When SellIn <0-> quality +2 every day


}