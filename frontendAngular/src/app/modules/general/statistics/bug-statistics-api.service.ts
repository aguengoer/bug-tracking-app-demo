import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BugsStatisticModel} from './bugs-statistic.model';

@Injectable()
export class BugStatisticsApiService {

  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }


  public doGetAll(): Observable<BugsStatisticModel> {
    return this.httpClient.get<BugsStatisticModel>(this.getBaseUrl());
  }

  private getBaseUrl(): string {
    return `http://localhost:8080/bug/statistic`;
  }

}
