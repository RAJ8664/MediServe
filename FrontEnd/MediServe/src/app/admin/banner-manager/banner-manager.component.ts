import { Component, OnInit, PLATFORM_ID, Inject } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BannerConfigService, BannerConfig, OfferBannerConfig } from '../../components/banner/service/banner.service';

@Component({
  selector: 'app-banner-manager',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './banner-manager.component.html',
  styleUrl: './banner-manager.component.css'
})
export class BannerManagerComponent implements OnInit {
  // Flag to check if code is running in browser
  private isBrowser: boolean;
  
  // Form models for banner image URLs
  mainBannerUrl: string = '';
  offerBannerUrl: string = '';
  
  // Current configurations for display
  mainBannerConfig: BannerConfig | null = null;
  offerBannerConfig: OfferBannerConfig | null = null;
  
  // Status messages
  mainBannerUpdateStatus: string = '';
  offerBannerUpdateStatus: string = '';

  constructor(
    private bannerService: BannerConfigService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  ngOnInit(): void {
    // Reload configurations to ensure we have the latest data
    if (this.isBrowser) {
      this.bannerService.reloadConfigurations();
    }
    
    // Get current configurations
    this.bannerService.mainBanner$.subscribe(config => {
      this.mainBannerConfig = config;
      this.mainBannerUrl = config.imageUrl;
    });
    
    this.bannerService.offerBanner$.subscribe(config => {
      this.offerBannerConfig = config;
      this.offerBannerUrl = config.imageUrl;
    });
  }

  /**
   * Update the main banner image
   */
  updateMainBanner(): void {
    if (!this.isBrowser) {
      this.mainBannerUpdateStatus = 'Updates can only be made in a browser environment';
      return;
    }
    
    if (!this.isValidCloudinaryUrl(this.mainBannerUrl)) {
      this.mainBannerUpdateStatus = 'Please enter a valid Cloudinary URL';
      return;
    }
    
    this.bannerService.updateMainBannerImage(this.mainBannerUrl);
    
    // Force a save to localStorage
    try {
      localStorage.setItem('mediServe_mainBanner', JSON.stringify({
        ...this.mainBannerConfig,
        imageUrl: this.mainBannerUrl
      }));
    } catch (e) {
      console.error('Error saving to localStorage', e);
    }
    
    this.mainBannerUpdateStatus = 'Main banner image updated successfully!';
    
    // Clear status message after 3 seconds
    if (this.isBrowser) {
      setTimeout(() => {
        this.mainBannerUpdateStatus = '';
      }, 3000);
    }
  }

  /**
   * Update the offer banner image
   */
  updateOfferBanner(): void {
    if (!this.isBrowser) {
      this.offerBannerUpdateStatus = 'Updates can only be made in a browser environment';
      return;
    }
    
    if (!this.isValidCloudinaryUrl(this.offerBannerUrl)) {
      this.offerBannerUpdateStatus = 'Please enter a valid Cloudinary URL';
      return;
    }
    
    this.bannerService.updateOfferBannerImage(this.offerBannerUrl);
    
    // Force a save to localStorage
    try {
      localStorage.setItem('mediServe_offerBanner', JSON.stringify({
        ...this.offerBannerConfig,
        imageUrl: this.offerBannerUrl
      }));
    } catch (e) {
      console.error('Error saving to localStorage', e);
    }
    
    this.offerBannerUpdateStatus = 'Offer banner image updated successfully!';
    
    // Clear status message after 3 seconds
    if (this.isBrowser) {
      setTimeout(() => {
        this.offerBannerUpdateStatus = '';
      }, 3000);
    }
  }

  /**
   * Reset main banner to default configuration
   */
  resetMainBanner(): void {
    if (!this.isBrowser) {
      this.mainBannerUpdateStatus = 'Updates can only be made in a browser environment';
      return;
    }
    
    if (this.isBrowser && confirm('Are you sure you want to reset the main banner to the default configuration?')) {
      this.bannerService.resetMainBanner();
      this.mainBannerUpdateStatus = 'Main banner reset to default configuration';
      
      // Clear status message after 3 seconds
      setTimeout(() => {
        this.mainBannerUpdateStatus = '';
      }, 3000);
    }
  }

  /**
   * Reset offer banner to default configuration
   */
  resetOfferBanner(): void {
    if (!this.isBrowser) {
      this.offerBannerUpdateStatus = 'Updates can only be made in a browser environment';
      return;
    }
    
    if (this.isBrowser && confirm('Are you sure you want to reset the offer banner to the default configuration?')) {
      this.bannerService.resetOfferBanner();
      this.offerBannerUpdateStatus = 'Offer banner reset to default configuration';
      
      // Clear status message after 3 seconds
      setTimeout(() => {
        this.offerBannerUpdateStatus = '';
      }, 3000);
    }
  }

  /**
   * Reload configurations from localStorage
   */
  reloadConfigurations(): void {
    if (this.isBrowser) {
      this.bannerService.reloadConfigurations();
      this.mainBannerUpdateStatus = 'Configurations reloaded from localStorage';
      this.offerBannerUpdateStatus = 'Configurations reloaded from localStorage';
      
      // Clear status messages after 3 seconds
      setTimeout(() => {
        this.mainBannerUpdateStatus = '';
        this.offerBannerUpdateStatus = '';
      }, 3000);
    }
  }

  /**
   * Validate if URL is from Cloudinary
   * @param url - URL to validate
   * @returns boolean indicating if URL is from Cloudinary
   */
  private isValidCloudinaryUrl(url: string): boolean {
    // Basic validation - check if it's a URL and contains cloudinary
    return !!url && 
           url.startsWith('http') && 
           (url.includes('cloudinary.com') || url.includes('res.cloudinary'));
  }
}
