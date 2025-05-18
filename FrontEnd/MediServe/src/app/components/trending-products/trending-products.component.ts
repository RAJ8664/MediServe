import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-trending-products',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './trending-products.component.html',
  styleUrl: './trending-products.component.css'
})
export class TrendingProductsComponent implements OnInit {
  // Trending products data
  trendingProducts = [
    { 
      id: 5, 
      name: 'N95 Face Mask (Pack of 10)', 
      price: 650, 
      discountPrice: 499,
      image: 'https://picsum.photos/200/200?random=5', 
      rating: 4.9, 
      reviewsCount: 204,
      isNew: false,
      trending: true
    },
    { 
      id: 6, 
      name: 'Digital Thermometer', 
      price: 1200, 
      discountPrice: 999,
      image: 'https://picsum.photos/200/200?random=6', 
      rating: 4.7, 
      reviewsCount: 178,
      isNew: false,
      trending: true
    },
    { 
      id: 7, 
      name: 'Herbal Immune Booster', 
      price: 850, 
      discountPrice: null,
      image: 'https://picsum.photos/200/200?random=7', 
      rating: 4.6, 
      reviewsCount: 132,
      isNew: true,
      trending: true
    },
    { 
      id: 8, 
      name: 'Diabetic Health Supplement', 
      price: 1200, 
      discountPrice: 990,
      image: 'https://picsum.photos/200/200?random=8', 
      rating: 4.5, 
      reviewsCount: 89,
      isNew: false,
      trending: true
    }
  ];

  constructor() { }

  ngOnInit(): void {
    // In a real app, you would fetch products from a service
  }

  // Method to generate an array of stars for ratings
  generateRatingStars(rating: number): number[] {
    const fullStars = Math.floor(rating);
    const hasHalfStar = rating % 1 >= 0.5;
    const stars = Array(5).fill(0).map((_, i) => {
      if (i < fullStars) return 2; // full star
      if (i === fullStars && hasHalfStar) return 1; // half star
      return 0; // empty star
    });
    return stars;
  }
}
