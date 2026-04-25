import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSubscriber } from './update-subscriber';

describe('UpdateSubscriber', () => {
  let component: UpdateSubscriber;
  let fixture: ComponentFixture<UpdateSubscriber>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateSubscriber],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateSubscriber);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
