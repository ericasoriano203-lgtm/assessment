import { Component, OnInit } from '@angular/core';
import { Subscriber} from '../subscriber'
import { SubscriberService } from '../subscriber-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subscriber-list',
  standalone: false,
  templateUrl: './subscriber-list.html',
  styleUrl: './subscriber-list.css',
})
export class SubscriberList implements OnInit {

  subscribers!: Subscriber[];

  constructor(private subscriberService: SubscriberService,
    private router: Router) {}

  ngOnInit(): void {
    this.getSubscribers();
  }

  private getSubscribers(){
    this.subscriberService.getSubscribersList().subscribe( data => {
      this.subscribers = data;
    });
  }

  subscriberDetails(phoneNumber: number){
    this.router.navigate(['subscriber-details', phoneNumber]);
  }

  updateSubscriber(phoneNumber: number){
    this.router.navigate(['update-subscriber', phoneNumber]);
  }

  deleteSubscriber(phoneNumber: number){
    this.subscriberService.deleteSubscriber(phoneNumber).subscribe( data => {
      console.log(data);
      this.getSubscribers();
    })
  }
}
