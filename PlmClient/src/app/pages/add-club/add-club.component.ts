import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-club',
  templateUrl: './add-club.component.html',
  styleUrls: ['./add-club.component.css']
})
export class AddClubComponent {

  constructor(private http: HttpClient) { }

  onSubmit(submitData: any) {
    this.http.post('http://localhost:8080/api/football-club', submitData)
      .subscribe((result) => {
        console.log("result", result);
      })
  }

}
