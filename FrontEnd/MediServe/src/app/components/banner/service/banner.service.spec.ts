import { TestBed } from '@angular/core/testing';

import { BannerConfigService } from './banner.service';

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
