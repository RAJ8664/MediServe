import { TestBed } from '@angular/core/testing';

import { BannerConfigService } from '../components/banner/service/banner.service';

describe('BannerConfigService', () => {
  let service: BannerConfigService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BannerConfigService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
