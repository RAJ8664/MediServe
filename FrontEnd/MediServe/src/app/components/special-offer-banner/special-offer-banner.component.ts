import { Component, OnInit, OnDestroy, PLATFORM_ID, Inject } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BannerConfigService, OfferBannerConfig } from '../banner/service/banner.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-special-offer-banner',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './special-offer-banner.component.html',
  styleUrl: './special-offer-banner.component.css'
})
export class SpecialOfferBannerComponent implements OnInit, OnDestroy {
  // Flag to check if code is running in browser
  private isBrowser: boolean;
  
  // Offer banner configuration will be provided by the service
  offerConfig!: OfferBannerConfig;
  private subscription: Subscription = new Subscription();

  constructor(
    private bannerService: BannerConfigService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  ngOnInit(): void {
    // Ensure we have the latest configuration
    if (this.isBrowser) {
      this.bannerService.reloadConfigurations();
    }
    
    // Subscribe to offer banner configuration from the service
    this.subscription.add(
      this.bannerService.offerBanner$.subscribe(config => {
        this.offerConfig = config;
      })
    );
  }

  ngOnDestroy(): void {
    // Clean up subscription when component is destroyed
    this.subscription.unsubscribe();
  }

  /**
   * Updates the offer banner image URL via the service
   * @param imageUrl - New Cloudinary image URL
   * @param imageAlt - Optional alt text for the image
   */
  updateOfferImage(imageUrl: string, imageAlt?: string): void {
    if (this.isBrowser) {
      this.bannerService.updateOfferBannerImage(imageUrl, imageAlt);
    }
  }
}
