import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

import { QuizService } from '../../services/quiz.serices'

@Component({
  selector: 'app-create-component-dialog',
  templateUrl: './create-component-dialog.component.html',
  styleUrls: ['./create-component-dialog.component.css']
})
export class CreateComponentDialogComponent implements OnInit {

  quizForm = this.fb.group({
    name: ['', Validators.required]
  });

  constructor(
    private quizService: QuizService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<CreateComponentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public application: any) { }

  ngOnInit() {
  }

  create() {
    this.quizService.add(this.quizForm.value.name).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
