import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const products = [
        { id: 11, name: 'Reebok Jacket',price:1599,imageUrl: '../assets/productImages/1.jpg' },
        { id: 12, name: 'Reebok Shoes',price:1599,imageUrl: '../assets/productImages/2.jpg'  },
        { id: 13, name: 'Adidas Lower',price:1599,imageUrl: '../assets/productImages/3.jpg'  },
        { id: 14, name: 'Puma Shoes',price:1099,imageUrl: '../assets/productImages/4.jpg'  },
        { id: 15, name: 'Tag Heur Watch',price:11599,imageUrl: '../assets/productImages/5.jpg'  },
        { id: 16, name: 'Van Heusen T-shirts',price:1599,imageUrl: '../assets/productImages/6.jpg'  },
        { id: 17, name: 'Mufti-Shirt',price:2599,imageUrl: '../assets/productImages/7.jpg'  },
        { id: 18, name: 'Safari Bagpack',price:1599,imageUrl: '../assets/productImages/8.jpg'  }
      ];
      return {products};
  }
}