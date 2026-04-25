import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubscriberList } from './subscriber-list/subscriber-list';
import { CreateSubscriber } from './create-subscriber/create-subscriber';
import { UpdateSubscriber } from './update-subscriber/update-subscriber';
import { SubscriberDetails } from './subscriber-details/subscriber-details';

const routes: Routes = [
  {path: 'subscribers', component: SubscriberList},
  {path: 'create-subscriber', component: CreateSubscriber},
  {path: '', redirectTo: 'subscribers', pathMatch: 'full'},
  {path: 'update-subscriber/:id', component: UpdateSubscriber},
  {path: 'subscriber-details/:id', component: SubscriberDetails}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
