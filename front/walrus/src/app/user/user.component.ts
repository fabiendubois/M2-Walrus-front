import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.serices';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  started = false;

  constructor(
    private quizService: QuizService
  ) { }

  ngOnInit() {
    this.looping();
  }

  private async looping() {
    while (this.started === false) {
      this.QuizStarted();     
      await this.delay(3000);
    }
  }
  
  
  QuizStarted() {
    this.quizService.findById(1).subscribe(data => {
      this.started = data.started;
    });
  }

  private delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
}
