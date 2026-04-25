import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subscriber } from './subscriber';



@Injectable({
  providedIn: 'root',
})
export class SubscriberService {
  private baseURL = "http://localhost:8080/ims/subscriber"

  constructor(private httpClient: HttpClient) {}

  getSubscribersList(): Observable<Subscriber[]>{
    return this.httpClient.get<Subscriber[]>(`${this.baseURL}`);     
  }

  createSubscriber(subscriber: Subscriber): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, subscriber);
  }

  getSubscriberByphoneNumber(phoneNumber: number): Observable<Subscriber>{
     return this.httpClient.get<Subscriber>(`${this.baseURL}/${phoneNumber}`);
  }

   updateSubscriber(phoneNumber: number, subscriber: Subscriber): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${phoneNumber}`, subscriber);
  }

  deleteSubscriber(phoneNumber: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${phoneNumber}`);
  }

}

