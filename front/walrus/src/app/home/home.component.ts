import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { CreateComponentDialogComponent } from '.././dialogs/create-component-dialog/create-component-dialog.component';
import { JoinComponentDialogComponent } from '.././dialogs/join-component-dialog/join-component-dialog.component';
 
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  joinDialog() {}

  createDialog() {
    const dialogRef = this.dialog.open(CreateComponentDialogComponent, {
      data: { application: "" }
    });

    dialogRef.afterClosed().subscribe(result => {
      
    });
  }
  
}
