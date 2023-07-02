import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ClubDetailsService } from 'src/app/services/club-details.service';

@Component({
  selector: 'app-update-club',
  templateUrl: './update-club.component.html',
  styleUrls: ['./update-club.component.css']
})
export class UpdateClubComponent {

  constructor(private http: HttpClient, private service: ClubDetailsService) { }

  singleVal: number = 1;
  sampleValue: string = "sample value";
  sampleNumber: number = 5;
  sampleObj = {};

  uponClick() {
    // let retData = this.service.getById(this.singleVal);
    let retData = this.http.get('http://localhost:8080/api/football-club/2');
    retData.subscribe((data) => {
      this.sampleObj = data;
      console.log("resultttt", data);
    },
      (error) => {
        console.log('An error occurred:', error);
      })
  }

  onSubmit(submitData: any) {
    let retData = this.service.getById(this.singleVal)
    console.log("result", submitData);
    console.log("result", this.singleVal);
    //   this.http.post('http://localhost:8080/api/football-club', submitData)
    //     .subscribe((result) => {
    //       console.log("result", result);
    //     })
  }

}
