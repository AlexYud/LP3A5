// Referência: https://github.com/seppevs/gildedrose-js
// Atividade feita em dupla: André Correia Zarzur, Alexandre Yudi I. Oliveira

class Item {
  constructor(name, sellIn, quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }
}

class BaseUpdate {
  getMinimumQuality() {
    return 0;
  }

  getMaximumQuality() {
    return 50;
  }

  appliesTo(item) {
    return true;
  }

  setQuality(item, value) {
    const maximumQuality = this.getMaximumQuality();
    const getMinimumQuality = this.getMinimumQuality();
    if (value < maximumQuality && value > getMinimumQuality) {
      item.quality = value
    } else if (value >= maximumQuality) {
      item.quality = maximumQuality
    } else {
      item.quality = getMinimumQuality
    }
  }

  updateItem(item) {
    const qualityDecrement = item.sellIn < 1 ? 2 : 1;
    this.setQuality(item, item.quality - qualityDecrement);
    item.sellIn -= 1;
  }
}

class AgedBrieUpdate extends BaseUpdate {
  appliesTo(item) {
    return item.name === 'Aged Brie';
  }

  updateItem(item) {
    item.sellIn -= 1;
    const qualityIncrement = (item.sellIn < 0) ? 2 : 1;
    super.setQuality(item, item.quality + qualityIncrement);
  }
}

class BackstagePassUpdate extends BaseUpdate {
  appliesTo(item) {
    return item.name === 'Backstage passes to a TAFKAL80ETC concert';
  }

  updateItem(item) {
    const qualityIncrement = item.sellIn < 1 ? qualityIncrement = -item.quality : item.sellIn < 6 ? qualityIncrement = 3 : item.sellIn < 11 ? qualityIncrement = 2 : qualityIncrement = 1;

    super.setQuality(item, item.quality + qualityIncrement);
    item.sellIn -= 1;
  }
}

class SulfurasUpdate extends BaseUpdate {
  appliesTo(item) {
    return item.name === 'Sulfuras, Hand of Ragnaros';
  }
}

class Shop {
  constructor(items = []) {
    this.items = items;
    this.updateTypes = [
      new BaseUpdate(),
      new AgedBrieUpdate(),
      new BackstagePassUpdate(),
      new SulfurasUpdate(),
    ]
  }

  updateQuality() {
    for (let item of this.items) {
      const updateType = this.updateTypes.find((updateType) => updateType.appliesTo(item)); // Encontrar o tipo de update baseado no nome
      updateType.updateItem(item);
    }
    return this.items;
  }
}

module.exports = {
  Item,
  Shop
};
