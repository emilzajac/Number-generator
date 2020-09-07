import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DbNumbersService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<number[]> {
    return this.http.get<number[]>(`/api/numbers`);
  }

}
