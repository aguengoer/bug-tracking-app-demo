import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './modules/general/home/home.component';
import {NotFoundComponent} from './modules/general/not-found/not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BugCreateUpdateService} from "./modules/general/bug-list/bug-edit-form/bug-create-update.service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [BugCreateUpdateService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
