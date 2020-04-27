import { TestBed } from '@angular/core/testing';

import { AddadminService } from './addadmin.service';

describe('AddadminService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddadminService = TestBed.get(AddadminService);
    expect(service).toBeTruthy();
  });
});
