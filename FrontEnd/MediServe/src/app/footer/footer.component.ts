import { Component, AfterViewInit, ViewChild, ElementRef, PLATFORM_ID, Inject } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { RouterModule } from '@angular/router';

interface Particle {
  x: number;
  y: number;
  size: number;
  speedX: number;
  speedY: number;
  opacity: number;
}

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent implements AfterViewInit {
  @ViewChild('particles', { static: false }) particlesContainer!: ElementRef;
  
  // Current year for copyright
  currentYear = new Date().getFullYear();
  
  // Footer links
  quickLinks = [
    { name: 'Home', url: '/' },
    { name: 'Products', url: '/products' },
    { name: 'Prescriptions', url: '/prescriptions' },
    { name: 'Health Articles', url: '/articles' },
    { name: 'Contact Us', url: '/contact' }
  ];
  
  categories = [
    { name: 'Medications', url: '/category/medications' },
    { name: 'Vitamins & Supplements', url: '/category/vitamins' },
    { name: 'Personal Care', url: '/category/personal-care' },
    { name: 'Medical Devices', url: '/category/devices' },
    { name: 'Health Foods', url: '/category/health-foods' }
  ];
  
  customerService = [
    { name: 'My Account', url: '/account' },
    { name: 'Track Order', url: '/track-order' },
    { name: 'Returns & Refunds', url: '/returns' },
    { name: 'Shipping Policy', url: '/shipping' },
    { name: 'FAQs', url: '/faqs' }
  ];
  
  private particles: Particle[] = [];
  private animationFrameId: number = 0;
  private isBrowser: boolean;
  
  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(platformId);
  }
  
  ngAfterViewInit(): void {
    if (this.isBrowser) {
      setTimeout(() => {
        this.initParticles();
      }, 100);
    }
  }
  
  /**
   * Initialize the particles animation
   */
  private initParticles(): void {
    if (!this.particlesContainer) return;
    
    const container = this.particlesContainer.nativeElement;
    const containerRect = container.getBoundingClientRect();
    
    // Create particles
    for (let i = 0; i < 30; i++) {
      this.particles.push({
        x: Math.random() * containerRect.width,
        y: Math.random() * containerRect.height,
        size: Math.random() * 3 + 1,
        speedX: Math.random() * 0.5 - 0.25,
        speedY: Math.random() * 0.5 - 0.25,
        opacity: Math.random() * 0.5 + 0.1
      });
    }
    
    // Create particle elements
    this.particles.forEach(particle => {
      const particleElement = document.createElement('div');
      particleElement.className = 'particle';
      particleElement.style.width = `${particle.size}px`;
      particleElement.style.height = `${particle.size}px`;
      particleElement.style.left = `${particle.x}px`;
      particleElement.style.top = `${particle.y}px`;
      particleElement.style.opacity = particle.opacity.toString();
      container.appendChild(particleElement);
    });
    
    // Start animation
    this.animateParticles();
  }
  
  /**
   * Animate particles with requestAnimationFrame
   */
  private animateParticles(): void {
    if (!this.isBrowser || !this.particlesContainer) return;
    
    const container = this.particlesContainer.nativeElement;
    const containerRect = container.getBoundingClientRect();
    const particleElements = container.querySelectorAll('.particle');
    
    // Update particle positions
    this.particles.forEach((particle, index) => {
      // Update position
      particle.x += particle.speedX;
      particle.y += particle.speedY;
      
      // Bounce off walls
      if (particle.x <= 0 || particle.x >= containerRect.width) {
        particle.speedX *= -1;
      }
      
      if (particle.y <= 0 || particle.y >= containerRect.height) {
        particle.speedY *= -1;
      }
      
      // Update element position
      if (particleElements[index]) {
        particleElements[index].style.left = `${particle.x}px`;
        particleElements[index].style.top = `${particle.y}px`;
      }
    });
    
    // Continue animation loop
    this.animationFrameId = requestAnimationFrame(() => this.animateParticles());
  }
  
  ngOnDestroy(): void {
    if (this.isBrowser && this.animationFrameId) {
      cancelAnimationFrame(this.animationFrameId);
    }
  }
}
