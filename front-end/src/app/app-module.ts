import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { SubscriberList } from './subscriber-list/subscriber-list';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { CreateSubscriber } from './create-subscriber/create-subscriber';
import { FormsModule } from '@angular/forms';
import { UpdateSubscriber } from './update-subscriber/update-subscriber';
import { SubscriberDetails } from './subscriber-details/subscriber-details';

@NgModule({
  declarations: [App, SubscriberList, CreateSubscriber, UpdateSubscriber, SubscriberDetails],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [App],
})
export class AppModule {}
