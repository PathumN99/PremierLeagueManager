import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ClubDataInterface } from 'src/app/Interfaces/club-data.interface';
import { ClubDetailsService } from 'src/app/services/club-details.service';

@Component({
  selector: 'app-update-club',
  templateUrl: './update-club.component.html',
  styleUrls: ['./update-club.component.css']
})
export class UpdateClubComponent {

  constructor(private http: HttpClient, private service: ClubDetailsService) { }

  param = null;

  sampleObj: any = {
    club_id: undefined,
    clubName: undefined,
    clubLocation: undefined,
    wins: undefined,
    draws: undefined,
    defeats: undefined,
    goalsReceived: undefined,
    goalsScored: undefined,
    numOfPoints: undefined,
    matchesPlayed: undefined,
  };

  uponClick() {
    let retData = this.http.get(`http://localhost:8080/api/football-club/${this.param}`);
    retData.subscribe((data) => {
      this.sampleObj = data;
      console.log("Retieved Data", data);
    },
      (error) => {
        console.log('An error occurred:', error);
      })
  }

  onSubmit(submitData: any) {
    this.http.put(`http://localhost:8080/api/football-club/update/${this.param}`, submitData)
      .subscribe((result) => {
        console.log("Request sucessfull!", result);
      },
        (error) => {
          console.log("Request Error!", error);
        })
  }

}
