package org.example;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MINIMUM_QUALITY = 0;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY_OF_STANDARD_PRODUCT = 50;
    public static final int SECOND_QUALITY_INCREMENT = 11;
    public static final int THIRD_QUALITY_INCREMENT = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (isNotSulfuras(item)){
                subtractOneDayToSellIn(item);
                if(QualityOfItemIsHigherThanZero(item)){
                    decreaseQuality(item);
                }
                if (isAgedBrie(item)){
                    if(timeToSellExpired(item)){
                        increaseQuality(item);
                    }
                    increaseQuality(item);
                }
            }






//            if (isNotAgedBrie(item) && isNotBackstagePasses(item) && isNotSulfuras(item) && isQualityOfItemIsHigherThanZero(item)) {
//                decreaseQuality(item);
//            } else {
//                if (qualityIsLowerThanTheMaximumOfStandardProducts(item)) {
//                    incrementQuality(item);
//                    if (isBackstagePasses(item) && shouldIncreaseTheQualityASecondTime(item)) {
//                        incrementQuality(item);
//                    }
//                    if (isBackstagePasses(item) && shouldIncreseTheQualityForTheThirdTime(item)) {
//                        incrementQuality(item);
//                    }
//                }
//            }
//            if (isNotSulfuras(item)) {
//                decreaseQuality(item);
//            }
//            if (item.sellIn < 0) {
//                if (isNotAgedBrie(item) && isNotBackstagePasses(item) && isNotSulfuras(item) && isQualityOfItemIsHigherThanZero(item)) {
//                    decreaseQuality(item);
//                } else {
//                    setQualityToZero(item);
//                }
//            } else {
//                if (qualityIsLowerThanTheMaximumOfStandardProducts(item)) {
//                    incrementQuality(item);
//                }
//            }
        }
    }

    private static boolean timeToSellExpired(Item item) {
        return item.sellIn < 0;
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private void subtractOneDayToSellIn(Item item) {
        item.sellIn -= 1;
    }


    private void setQualityToZero(Item item) {
        item.quality = MINIMUM_QUALITY;
    }


    private static boolean shouldIncreseTheQualityForTheThirdTime(Item item) {
        return item.sellIn < THIRD_QUALITY_INCREMENT; // TODO: rename constant
    }

    private static boolean shouldIncreaseTheQualityASecondTime(Item item) {
        return item.sellIn < SECOND_QUALITY_INCREMENT; // TODO: rename constant
    }

    private static boolean qualityIsLowerThanTheMaximumOfStandardProducts(Item item) {
        return item.quality < MAX_QUALITY_OF_STANDARD_PRODUCT;
    }

    private static void increaseQuality(Item item) {
        item.quality += 1;
    }

    private static void decreaseQuality(Item item) {
        item.quality -= 1;
    }

    private static boolean isNotSulfuras(Item item) {
        return !item.name.equals(SULFURAS);
    }

    private static boolean isNotAgedBrie(Item item) {
        return !item.name.equals(AGED_BRIE);
    }

    private static boolean QualityOfItemIsHigherThanZero(Item item) {
        return item.quality > MINIMUM_QUALITY;
    }

    private static boolean isNotBackstagePasses(Item item) {
        return !item.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

}

