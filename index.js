class Item {
    constructor(name, sellIn, quality){
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
    }
  }
  
class Shop { 
  sulfuras = 'Sulfuras, Hand of Ragnaros';

  backstage = 'Backstage passes to a TAFKAL80ETC concert';

  brie = 'Aged Brie';

  constructor(items=[]){
    this.items = items;
  }

  updateQuality() {
    for (const i in this.items) {
      this.processItems(this.items[i]);
    }
    return this.items;
  }

  increaseQuality(item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  decreaseQuality(item) {
    if (item.name != this.sulfuras) {
      item.quality = item.quality - 1;
    }
  }

  processItems(item) {
    if (item.name === this.sulfuras) return;

    if (item.name != this.brie && item.name != this.backstage) {
      if (item.quality > 0) this.decreaseQuality(item);
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
        if (item.name == this.backstage) {
          if (item.sellIn < 11) this.increaseQuality(item);
      
          if (item.sellIn < 6) this.increaseQuality(item);
          
        }
      }
    }

    this.decreaseQuality(item);

    if (item.sellIn < 0) {
      if (item.name != this.brie) {
        if (item.name != this.backstage) {
          if (item.quality > 0) {
            this.decreaseQuality(item);
          }
        } else {
          item.quality = item.quality - item.quality;
        }
      } else {
        this.increaseQuality(item);
      }
    } 
  }
}

module.exports = {
  Item,
  Shop
}