import { Bear } from '../models/bear.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class BearService {

  endpoint = 'http://localhost:8084/ServletDemo/bear';

  // inject HttpClient
  constructor(private httpClient: HttpClient) { }

  public fetchBearInformation(id: number): Observable<Bear> {
    return this.httpClient.get<Bear>(`${this.endpoint}?id=${id}`);
  }

  // get all bears, for real, from our backend. using HttpClient, newer version of HttpModule
  public fetchAllBears(): Observable<Bear[]> {
    return this.httpClient.get<Bear[]>(this.endpoint);
  }
}
