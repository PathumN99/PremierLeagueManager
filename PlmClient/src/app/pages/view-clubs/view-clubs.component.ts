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

  
  elementData: ClubDataInterface[] = [
    { name: 'name1', location: 'Texas' },
    { name: 'name2', location: 'LA' },
    { name: 'name3', location: 'Washington' },
    { name: 'name4', location: 'New York' },
  ];
  displayedColumns: string[] = ['name', 'location'];
  dataSource = new MatTableDataSource<ClubDataInterface>(this.elementData);

  clubs: any[] = [];

  constructor(private service: ClubDetailsService) { }

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    let resp = this.service.getData();
    resp.subscribe(
      data => this.clubs = data
      // error => {
      //   console.log('An error occurred:', error);
      // }
    );
    
  }

}
