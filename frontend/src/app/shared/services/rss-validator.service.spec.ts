/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RssValidatorService } from './rss-validator.service';

describe('Service: RssValidator', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RssValidatorService]
    });
  });

  it('should ...', inject([RssValidatorService], (service: RssValidatorService) => {
    expect(service).toBeTruthy();
  }));
});
