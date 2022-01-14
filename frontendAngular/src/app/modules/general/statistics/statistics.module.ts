import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BugStatisticsApiService} from './bug-statistics-api.service';
import {StatisticsComponent} from "./statistics.component";
import {StatisticsRoutingModule} from "./statistics-routing.module";

@NgModule({
  imports: [
    CommonModule,
    StatisticsRoutingModule
  ],
  exports: [
    StatisticsComponent
  ],
  declarations: [
    StatisticsComponent
  ],
  providers: [
    BugStatisticsApiService
  ],
})
export class StatisticsModule {
}
