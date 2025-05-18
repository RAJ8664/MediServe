import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BannerComponent } from '../components/banner/banner.component';
import { PopularProductsComponent } from '../components/popular-products/popular-products.component';
import { TrendingProductsComponent } from '../components/trending-products/trending-products.component';
import { SpecialOfferBannerComponent } from '../components/special-offer-banner/special-offer-banner.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule, 
    RouterModule, 
    BannerComponent, 
    PopularProductsComponent, 
    TrendingProductsComponent,
    SpecialOfferBannerComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  // Featured categories
  categories = [
    { name: 'Medications', icon: 'pills', description: 'Prescription and over-the-counter medicines' },
    { name: 'Vitamins & Supplements', icon: 'capsules', description: 'Support your health with our range of supplements' },
    { name: 'Personal Care', icon: 'shower', description: 'Skincare, haircare, and personal hygiene products' },
    { name: 'Medical Devices', icon: 'stethoscope', description: 'Blood pressure monitors, glucose meters and more' },
    { name: 'Health Foods', icon: 'apple-alt', description: 'Nutritious options for a healthier lifestyle' },
    { name: 'Baby Care', icon: 'baby', description: 'Everything you need for your little one' }
  ];

  // Latest health articles
  healthArticles = [
    {
      title: 'Understanding High Blood Pressure',
      excerpt: 'Learn about the causes and management of hypertension.',
      image: 'https://picsum.photos/800/400?random=5',
      date: '2023-06-15'
    },
    {
      title: 'The Benefits of Regular Exercise',
      excerpt: 'How physical activity can improve your health and wellbeing.',
      image: 'https://picsum.photos/800/400?random=6',
      date: '2023-06-10'
    },
    {
      title: 'Nutrition Tips for a Healthy Life',
      excerpt: 'Simple dietary changes that can make a big difference.',
      image: 'https://picsum.photos/800/400?random=7',
      date: '2023-06-05'
    }
  ];

  constructor() { }

  ngOnInit(): void {
    // Initialize any data or make API calls here
  }
}
