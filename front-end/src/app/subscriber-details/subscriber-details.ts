import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SubscriberService } from '../subscriber-service';
import { Subscriber } from '../subscriber';

@Component({
  selector: 'app-subscriber-details',
  standalone: false,
  templateUrl: './subscriber-details.html',
  styleUrl: './subscriber-details.css',
})
export class SubscriberDetails implements OnInit {

  phoneNumber: number
  subscriber: Subscriber
  constructor(private route: ActivatedRoute, private subscriberService: SubscriberService) {}

  ngOnInit(): void {
    this.phoneNumber = this.route.snapshot.params['id'];
    this.subscriber = new Subscriber();
    this.subscriberService.getSubscriberByphoneNumber(this.phoneNumber).subscribe( data => {
      this.subscriber = data;
    })
  }

}
