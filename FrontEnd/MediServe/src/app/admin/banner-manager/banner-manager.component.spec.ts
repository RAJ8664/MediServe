import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BannerManagerComponent } from './banner-manager.component';

describe('BannerManagerComponent', () => {
  let component: BannerManagerComponent;
  let fixture: ComponentFixture<BannerManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BannerManagerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BannerManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
