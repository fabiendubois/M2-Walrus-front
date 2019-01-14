import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.serices';

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  started = false;

  constructor(private quizService: QuizService) { }

  ngOnInit() {
  }

  start() {
    this.quizService.start(1).subscribe(data => {
      this.started = true;
    });
  }
  
  QuizStarted() {

  }

}

