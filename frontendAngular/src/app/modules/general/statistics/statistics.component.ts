import {Component, OnInit} from '@angular/core';
import {BugStatisticsApiService} from './bug-statistics-api.service';
import {BugsStatisticModel} from './bugs-statistic.model';

@Component({
  selector: 'app-contact',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  model: BugsStatisticModel;

  constructor(private statisticApi: BugStatisticsApiService) {
  }

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.statisticApi.doGetAll().subscribe((personModel: any) => {
      this.model = personModel;
    });
  }

}
