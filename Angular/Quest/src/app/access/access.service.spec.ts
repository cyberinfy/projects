import { TestBed } from '@angular/core/testing';

import { AccessService } from './access.service';

describe('AssessService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccessService = TestBed.get(AccessService);
    expect(service).toBeTruthy();
  });
});
