import { TestBed } from '@angular/core/testing';

import { ClubDetailsService } from './club-details.service';

describe('ClubDetailsService', () => {
  let service: ClubDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClubDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
