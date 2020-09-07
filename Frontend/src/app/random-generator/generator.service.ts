import { Injectable }             from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable }             from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneratorService {

  constructor(private http: HttpClient) {
  }

  getGeneratedNumbers(min: number, max: number, howManyNumbers: number): Observable<number[]> {
    let parameters = new HttpParams();
    parameters = parameters.append('min', String(min));
    parameters = parameters.append('max', String(max));
    parameters = parameters.append('howManyNumbers', String(howManyNumbers));
    return this.http.get<number[]>(`/api/generate/numbers`, {params: parameters});
  }

  getGeneratedUUIDs(howManyNumbers: number): Observable<string[]> {
    let parameters = new HttpParams();
    parameters = parameters.append('howManyNumbers', String(howManyNumbers));
    return this.http.get<string[]>(`/api/generate/uuids`, {params: parameters});
  }

}
