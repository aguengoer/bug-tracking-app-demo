import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BugTrackingResponseModel} from './bug-tracking-response.model';

@Injectable()
export class BugTrackingApiService {

  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public doGetAll(): Observable<BugTrackingResponseModel[]> {
    return this.httpClient.get<BugTrackingResponseModel[]>(this.getBaseUrl());
  }


  public doDelete(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.getBaseUrl() + '/' + id);
  }

  private getBaseUrl(): string {
    return `http://localhost:8080/bug`;
  }

}
