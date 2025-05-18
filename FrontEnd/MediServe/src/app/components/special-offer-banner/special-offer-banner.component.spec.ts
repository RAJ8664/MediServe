import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialOfferBannerComponent } from './special-offer-banner.component';

describe('SpecialOfferBannerComponent', () => {
  let component: SpecialOfferBannerComponent;
  let fixture: ComponentFixture<SpecialOfferBannerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecialOfferBannerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecialOfferBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
