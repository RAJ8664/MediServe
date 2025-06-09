import { Injectable, PLATFORM_ID, Inject, APP_INITIALIZER } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';

// Interface for main banner configuration
export interface BannerConfig {
  title: string;
  subtitle: string;
  primaryButtonText: string;
  primaryButtonLink: string;
  secondaryButtonText: string;
  secondaryButtonLink: string;
  imageUrl: string;
  imageAlt: string;
  backgroundColor: string;
}

// Interface for special offer banner configuration
export interface OfferBannerConfig {
  title: string;
  description: string;
  highlightedText: string;
  buttonText: string;
  buttonLink: string;
  imageUrl: string;
  imageAlt: string;
  backgroundColor: string;
}

@Injectable({
  providedIn: 'root'
})
export class BannerConfigService {
  // Flag to check if code is running in browser
  private isBrowser: boolean;
  
  // Default configuration for main banner
  private defaultMainBanner: BannerConfig = {
    title: 'Your Health, Delivered <span class="text-amber-400">At Your Doorstep</span>',
    subtitle: 'Nepal\'s premium online pharmacy providing quality medicines and healthcare products with fast delivery and exceptional service.',
    primaryButtonText: 'Shop Now',
    primaryButtonLink: '/products',
    secondaryButtonText: 'Learn More',
    secondaryButtonLink: '/about',
    imageUrl: 'https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg',
    imageAlt: 'Healthcare Products',
    backgroundColor: 'bg-gradient-to-r from-emerald-600 to-emerald-700'
  };

  // Default configuration for special offer banner
  private defaultOfferBanner: OfferBannerConfig = {
    title: 'Get 15% off on your first order!',
    description: 'Use code at checkout to avail the discount on your first purchase.',
    highlightedText: 'MEDISERVE15',
    buttonText: 'Shop Now',
    buttonLink: '/products',
    imageUrl: 'https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg',
    imageAlt: 'Special Offer',
    backgroundColor: 'bg-gradient-to-r from-emerald-600 to-emerald-700'
  };

  // BehaviorSubjects to store current configurations
  private mainBannerSubject = new BehaviorSubject<BannerConfig>(this.defaultMainBanner);
  private offerBannerSubject = new BehaviorSubject<OfferBannerConfig>(this.defaultOfferBanner);

  // Expose configuration as observables
  mainBanner$: Observable<BannerConfig> = this.mainBannerSubject.asObservable();
  offerBanner$: Observable<OfferBannerConfig> = this.offerBannerSubject.asObservable();

  // Flag to track if initialization has been done
  private initialized = false;

  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(this.platformId);
    
    // Load saved configurations from localStorage if available and in browser
    if (this.isBrowser) {
      // Use setTimeout to ensure this runs after Angular is fully initialized
      setTimeout(() => {
        if (!this.initialized) {
          this.loadSavedConfigurations();
          this.initialized = true;
        }
      }, 0);
    }
  }

  /**
   * Update main banner image
   * @param imageUrl - New Cloudinary image URL
   * @param imageAlt - Optional alternative text for the image
   */
  updateMainBannerImage(imageUrl: string, imageAlt?: string): void {
    const currentConfig = this.mainBannerSubject.getValue();
    this.mainBannerSubject.next({
      ...currentConfig,
      imageUrl,
      imageAlt: imageAlt || currentConfig.imageAlt
    });
    
    // Save to localStorage if in browser
    if (this.isBrowser) {
      this.saveMainBannerConfig();
    }
  }

  /**
   * Update special offer banner image
   * @param imageUrl - New Cloudinary image URL
   * @param imageAlt - Optional alternative text for the image
   */
  updateOfferBannerImage(imageUrl: string, imageAlt?: string): void {
    const currentConfig = this.offerBannerSubject.getValue();
    this.offerBannerSubject.next({
      ...currentConfig,
      imageUrl,
      imageAlt: imageAlt || currentConfig.imageAlt
    });
    
    // Save to localStorage if in browser
    if (this.isBrowser) {
      this.saveOfferBannerConfig();
    }
  }

  /**
   * Update main banner configuration
   * @param config - New banner configuration
   */
  updateMainBanner(config: Partial<BannerConfig>): void {
    const currentConfig = this.mainBannerSubject.getValue();
    this.mainBannerSubject.next({
      ...currentConfig,
      ...config
    });
    
    // Save to localStorage if in browser
    if (this.isBrowser) {
      this.saveMainBannerConfig();
    }
  }

  /**
   * Update special offer banner configuration
   * @param config - New offer banner configuration
   */
  updateOfferBanner(config: Partial<OfferBannerConfig>): void {
    const currentConfig = this.offerBannerSubject.getValue();
    this.offerBannerSubject.next({
      ...currentConfig,
      ...config
    });
    
    // Save to localStorage if in browser
    if (this.isBrowser) {
      this.saveOfferBannerConfig();
    }
  }

  /**
   * Reset main banner to default configuration
   */
  resetMainBanner(): void {
    this.mainBannerSubject.next(this.defaultMainBanner);
    
    if (this.isBrowser) {
      localStorage.removeItem('mediServe_mainBanner');
    }
  }

  /**
   * Reset offer banner to default configuration
   */
  resetOfferBanner(): void {
    this.offerBannerSubject.next(this.defaultOfferBanner);
    
    if (this.isBrowser) {
      localStorage.removeItem('mediServe_offerBanner');
    }
  }

  /**
   * Force reload configurations from localStorage
   * Can be called manually if needed
   */
  reloadConfigurations(): void {
    if (this.isBrowser) {
      this.loadSavedConfigurations();
    }
  }

  /**
   * Load saved configurations from localStorage
   * Only called in browser environment
   */
  private loadSavedConfigurations(): void {
    if (!this.isBrowser) return;
    
    try {
      const savedMainBanner = localStorage.getItem('mediServe_mainBanner');
      const savedOfferBanner = localStorage.getItem('mediServe_offerBanner');

      if (savedMainBanner) {
        try {
          const config = JSON.parse(savedMainBanner);
          this.mainBannerSubject.next({
            ...this.defaultMainBanner,
            ...config
          });
          console.log('Loaded main banner config from localStorage');
        } catch (e) {
          console.error('Error loading main banner config from localStorage', e);
        }
      }

      if (savedOfferBanner) {
        try {
          const config = JSON.parse(savedOfferBanner);
          this.offerBannerSubject.next({
            ...this.defaultOfferBanner,
            ...config
          });
          console.log('Loaded offer banner config from localStorage');
        } catch (e) {
          console.error('Error loading offer banner config from localStorage', e);
        }
      }
    } catch (e) {
      console.error('Error accessing localStorage', e);
    }
  }

  /**
   * Save main banner configuration to localStorage
   * Only called in browser environment
   */
  private saveMainBannerConfig(): void {
    if (!this.isBrowser) return;
    
    try {
      const config = this.mainBannerSubject.getValue();
      localStorage.setItem('mediServe_mainBanner', JSON.stringify(config));
      console.log('Saved main banner config to localStorage');
    } catch (e) {
      console.error('Error saving main banner config to localStorage', e);
    }
  }

  /**
   * Save offer banner configuration to localStorage
   * Only called in browser environment
   */
  private saveOfferBannerConfig(): void {
    if (!this.isBrowser) return;
    
    try {
      const config = this.offerBannerSubject.getValue();
      localStorage.setItem('mediServe_offerBanner', JSON.stringify(config));
      console.log('Saved offer banner config to localStorage');
    } catch (e) {
      console.error('Error saving offer banner config to localStorage', e);
    }
  }
}
