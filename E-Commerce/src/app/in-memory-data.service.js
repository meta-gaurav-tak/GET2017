"use strict";
var InMemoryDataService = (function () {
    function InMemoryDataService() {
    }
    InMemoryDataService.prototype.createDb = function () {
        var products = [
            { id: 11, name: 'Reebok Jacket', price: 1599 },
            { id: 12, name: 'Reebok Shoes', price: 1599 },
            { id: 13, name: 'Adidas Lower', price: 1599 },
            { id: 14, name: 'Puma Shoes', price: 1099 },
            { id: 15, name: 'Tag Heur Watch', price: 11599 },
            { id: 16, name: 'Van Heusen T-shirts', price: 1599 },
            { id: 17, name: 'Mufti-Shirt', price: 2599 },
            { id: 18, name: 'Safari Bagpack', price: 1599 },
            { id: 19, name: 'Reebok Jacket', price: 1599 },
            { id: 20, name: 'Reebok Jacket', price: 1599 }
        ];
        return { products: products };
    };
    return InMemoryDataService;
}());
exports.InMemoryDataService = InMemoryDataService;
//# sourceMappingURL=in-memory-data.service.js.map