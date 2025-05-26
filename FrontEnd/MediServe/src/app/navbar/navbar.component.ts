import { Component, OnInit, HostListener, PLATFORM_ID, Inject } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  // User location for delivery with animation
  userLocation: string = 'Kathmandu, Nepal';
  
  // Cart items count with animation
  cartItemsCount: number = 0;
  
  // Track scroll position for navbar animation
  isScrolled: boolean = false;
  
  // Browser detection
  private isBrowser: boolean;
  
  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(platformId);
  }
  
  ngOnInit(): void {
    // Initialize cart count (in a real app, this would come from a service)
    this.cartItemsCount = 3;
    
    // Check initial scroll position
    if (this.isBrowser) {
      this.checkScroll();
    }
  }
  
  /**
   * Listen for window scroll events to apply navbar animations
   */
  @HostListener('window:scroll', [])
  checkScroll(): void {
    if (!this.isBrowser) return;
    
    const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    this.isScrolled = scrollPosition > 50;
  }
  
  /**
   * Handle search functionality
   * @param event - Input event from search field
   */
  onSearch(event: Event): void {
    const searchTerm = (event.target as HTMLInputElement).value;
    console.log('Searching for:', searchTerm);
    
    // Add visual feedback for search (in a real app, this would trigger API calls)
    if (this.isBrowser && searchTerm.length > 2) {
      // Example of how you might add visual feedback
      const searchContainer = document.querySelector('.search-container');
      if (searchContainer) {
        searchContainer.classList.add('searching');
        
        // Remove the class after a delay
        setTimeout(() => {
          searchContainer.classList.remove('searching');
        }, 1000);
      }
    }
  }
  
  /**
   * Update cart count with animation
   * This would be called from a cart service in a real app
   */
  updateCartCount(count: number): void {
    if (this.isBrowser) {
      // Add animation class to badge
      const badge = document.querySelector('.cart-badge');
      if (badge) {
        badge.classList.add('updating');
        
        // Update count after brief delay for animation
        setTimeout(() => {
          this.cartItemsCount = count;
          
          // Remove animation class
          setTimeout(() => {
            badge.classList.remove('updating');
          }, 300);
        }, 200);
      } else {
        this.cartItemsCount = count;
      }
    } else {
      this.cartItemsCount = count;
    }
  }
}
