import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ClubDetailsService } from 'src/app/services/club-details.service';

@Component({
  selector: 'app-delete-club',
  templateUrl: './delete-club.component.html',
  styleUrls: ['./delete-club.component.css']
})
export class DeleteClubComponent {

  constructor(private http: HttpClient, private service: ClubDetailsService) { }

  idRequired = false;
  hasData = false;
  clubNotExist = false;
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

    if (this.param == null) {
      this.idRequired = true;
      this.hasData = false;
      this.clubNotExist = false;
    } else {
      let retData = this.http.get(`http://localhost:8080/api/football-club/${this.param}`);
      retData.subscribe((data) => {

        if (data == null) {
          this.clubNotExist = true;
        } else {
          this.clubNotExist = false;
        }

        if (data) {
          this.hasData = true;
        }
        this.idRequired = false;


        this.sampleObj = data;
        console.log("Retieved Data", data);
      },
        (error) => {
          this.idRequired = true;
          console.log('An error occurred:', error);
        })
    }
  }

  clearFields() {
    this.idRequired = false;
    this.hasData = false;
    this.param = null;
    this.clubNotExist = false;
  }

  deleteRecord() {
    const confirmation = confirm("This record will be deleted. Are you sure?");

    if (confirmation) {
      let retData = this.http.delete(`http://localhost:8080/api/football-club/delete/${this.param}`, { responseType: 'text' });
      retData.subscribe((data) => {
        console.log("Success Message!", data);
      },
        (error) => {
          console.log('An error occurred:', error);
        })
    }
  }

}
