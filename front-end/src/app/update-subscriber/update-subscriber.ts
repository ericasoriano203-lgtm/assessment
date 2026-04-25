import { Component, OnInit } from '@angular/core';
import { SubscriberService } from '../subscriber-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscriber } from '../subscriber';

@Component({
  selector: 'app-update-subscriber',
  standalone: false,
  templateUrl: './update-subscriber.html',
  styleUrl: './update-subscriber.css',
})
export class UpdateSubscriber implements OnInit {

  phoneNumber: number;
  subscriber: Subscriber = new Subscriber();

  constructor(private subscriberService: SubscriberService,
      private route: ActivatedRoute,
      private router: Router) {}

  ngOnInit(): void {
    this.phoneNumber = this.route.snapshot.params['id'];

    this.subscriberService.getSubscriberByphoneNumber(this.phoneNumber).subscribe(data => {
      this.subscriber = data;
    }, error => console.log(error));
  }


 onSubmit(){
    this.subscriberService.updateSubscriber(this.phoneNumber, this.subscriber).subscribe( data =>{
      this.goToSubscriberList();
    }
    , error => console.log(error));
 }

 goToSubscriberList(){
    this.router.navigate(['/subscribers']);
 }

    
}

