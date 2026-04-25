import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriberDetails } from './subscriber-details';

describe('SubscriberDetails', () => {
  let component: SubscriberDetails;
  let fixture: ComponentFixture<SubscriberDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SubscriberDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(SubscriberDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
