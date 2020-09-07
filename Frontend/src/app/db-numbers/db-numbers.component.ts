import { Component, OnInit } from '@angular/core';
import { DbNumbersService }  from './db-numbers.service';
import { Router }            from '@angular/router';

@Component({
  selector: 'app-db-numbers',
  templateUrl: './db-numbers.component.html',
  styleUrls: ['./db-numbers.component.css']
})
export class DbNumbersComponent implements OnInit {

  dbNumbers: number[];

  constructor(private router: Router,
              private dbNumbersService: DbNumbersService) {
  }

  ngOnInit(): void {
    this.dbNumbersService.getAll()
      .subscribe((dbNumber: number[]) => this.dbNumbers = dbNumber);
  }

}
