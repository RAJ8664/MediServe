import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BannerAdminComponent } from './banner-admin.component';

describe('BannerAdminComponent', () => {
  let component: BannerAdminComponent;
  let fixture: ComponentFixture<BannerAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BannerAdminComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BannerAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
