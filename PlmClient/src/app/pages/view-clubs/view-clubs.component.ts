import { Component, OnInit } from '@angular/core';
import { ClubDataInterface } from 'src/app/Interfaces/club-data.interface';
import { ClubDetailsService } from 'src/app/services/club-details.service';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-view-clubs',
  templateUrl: './view-clubs.component.html',
  styleUrls: ['./view-clubs.component.css']
})
export class ViewClubsComponent implements OnInit {

  elementData: ClubDataInterface[] = []
  dataSource = new MatTableDataSource<ClubDataInterface>();
  
  displayedColumns: string[] = [
    "clubName",
    "clubLocation",
    "wins",
    "draws",
    "defeats",
    "goalsReceived",
    "goalsScored",
    "numOfPoints",
    "matchesPlayed"
  ];

  constructor(private service: ClubDetailsService) { }

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    let resp = this.service.getData();

    resp.subscribe(
      (data) => {
        this.elementData = data;
        this.dataSource = new MatTableDataSource<ClubDataInterface>(this.elementData);
      },
      (error) => {
        console.log('An error occurred:', error);
      }
    );

  }
}
