import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BugTrackingResponseModel} from '../bug-tracking-response.model';

@Injectable({
  providedIn: 'root'
})
export class BugCreateUpdateService {

  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public doUpdate(id: string, body: BugTrackingResponseModel): Observable<BugTrackingResponseModel> {
    return this.httpClient.put<BugTrackingResponseModel>(this.getBaseUrl() + '/' + id, body);
  }

  public doCreate(body: BugTrackingResponseModel): Observable<void> {
    return this.httpClient.post<void>(this.getBaseUrl() + '/create', body);
  }

  private getBaseUrl(): string {
    return `http://localhost:8080/bug`;
  }

}
