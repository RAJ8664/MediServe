import { Component, OnInit, OnDestroy, PLATFORM_ID, Inject } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BannerConfigService, BannerConfig } from './service/banner.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-banner',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './banner.component.html',
  styleUrl: './banner.component.css'
})
export class BannerComponent implements OnInit, OnDestroy {
  // Flag to check if code is running in browser
  private isBrowser: boolean;
  
  // Banner configuration will be provided by the service
  bannerConfig!: BannerConfig;
  private subscription: Subscription = new Subscription();

  constructor(
    private bannerService: BannerConfigService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  ngOnInit(): void {
    // Subscribe to banner configuration from the service
    this.subscription.add(
      this.bannerService.mainBanner$.subscribe(config => {
        this.bannerConfig = config;
      })
    );
  }

  ngOnDestroy(): void {
    // Clean up subscription when component is destroyed
    this.subscription.unsubscribe();
  }

  /**
   * Updates the banner image URL via the service
   * @param imageUrl - New Cloudinary image URL
   * @param imageAlt - Optional alt text for the image
   */
  updateBannerImage(imageUrl: string, imageAlt?: string): void {
    if (this.isBrowser) {
      this.bannerService.updateMainBannerImage(imageUrl, imageAlt);
    }
  }
}
