import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BugComponent} from './bug.component';
import {BugEditFormComponent} from './bug-edit-form/bug-edit-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbDatepickerModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http';
import {BugTrackingApiService} from './bug-tracking-api.service';
import {BugCreateUpdateService} from "./bug-edit-form/bug-create-update.service";
import {BugRoutingModule} from "./bug-routing.module";

@NgModule({
  imports: [
    CommonModule,
    BugRoutingModule,
    ReactiveFormsModule,
    NgbDatepickerModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  exports: [
    BugComponent
  ],
  entryComponents: [BugEditFormComponent],
  declarations: [
    BugComponent,
    BugEditFormComponent
  ],
  providers: [BugTrackingApiService, BugCreateUpdateService],
})
export class BugModule {
}
