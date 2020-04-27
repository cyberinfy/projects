import { TestBed } from '@angular/core/testing';

import { AdminfeedbackService } from './adminfeedback.service';

describe('AdminfeedbackService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminfeedbackService = TestBed.get(AdminfeedbackService);
    expect(service).toBeTruthy();
  });
});
