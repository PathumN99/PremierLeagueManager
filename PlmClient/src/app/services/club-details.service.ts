import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClubDetailsService {

  private apiUrl = 'http://localhost:8080/api/student';

  constructor(private http: HttpClient) { }

  public getClubs() {
    return this.http.get(this.apiUrl);
  }

  getData(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

}
