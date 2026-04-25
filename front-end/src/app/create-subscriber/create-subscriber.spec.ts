import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSubscriber } from './create-subscriber';

describe('CreateSubscriber', () => {
  let component: CreateSubscriber;
  let fixture: ComponentFixture<CreateSubscriber>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateSubscriber],
    }).compileComponents();

    fixture = TestBed.createComponent(CreateSubscriber);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
