import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-popular-products',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './popular-products.component.html',
  styleUrl: './popular-products.component.css'
})
export class PopularProductsComponent implements OnInit {
  // Popular products data
  popularProducts = [
    { 
      id: 1, 
      name: 'Paracetamol 500mg', 
      price: 250, 
      discountPrice: 200,
      image: 'https://picsum.photos/200/200?random=1', 
      rating: 4.7, 
      reviewsCount: 128,
      isNew: false
    },
    { 
      id: 2, 
      name: 'Vitamin C 1000mg', 
      price: 450, 
      discountPrice: null,
      image: 'https://picsum.photos/200/200?random=2', 
      rating: 4.5, 
      reviewsCount: 96,
      isNew: true
    },
    { 
      id: 3, 
      name: 'Digital Blood Pressure Monitor', 
      price: 3500, 
      discountPrice: 2999,
      image: 'https://picsum.photos/200/200?random=3', 
      rating: 4.8, 
      reviewsCount: 57,
      isNew: false
    },
    { 
      id: 4, 
      name: 'Aloe Vera Skin Gel 100ml', 
      price: 350, 
      discountPrice: 299,
      image: 'https://picsum.photos/200/200?random=4', 
      rating: 4.3, 
      reviewsCount: 42,
      isNew: false
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
