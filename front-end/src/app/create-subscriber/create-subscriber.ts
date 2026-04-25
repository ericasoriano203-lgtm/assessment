import { Component, OnInit } from '@angular/core';

import { SubscriberService } from '../subscriber-service';
import { Router } from '@angular/router';
import { Subscriber } from '../subscriber';

@Component({
  selector: 'app-create-subscriber',
  standalone: false,
  templateUrl: './create-subscriber.html',
  styleUrl: './create-subscriber.css',
})
export class CreateSubscriber implements OnInit{

  subscriber: Subscriber = new Subscriber();
  constructor(
      private subscriberService: SubscriberService,
      private router: Router
  ) {}

  ngOnInit(): void {}

  saveSubscriber(){
    this.subscriberService.createSubscriber(this.subscriber).subscribe( data => {
      console.log(data);
      this.goToSubscriberList();
    },
      error => console.log(error));
  }

  goToSubscriberList(){
    this.router.navigate(['/subscribers']);
  }

  onSubmit(){
    console.log(this.subscriber);
    this.saveSubscriber();
  }

}
