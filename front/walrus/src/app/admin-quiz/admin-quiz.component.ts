import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.serices';

@Component({
  selector: 'app-admin-quiz',
  templateUrl: './admin-quiz.component.html',
  styleUrls: ['./admin-quiz.component.css']
})
export class AdminQuizComponent implements OnInit {

  questions = [];
  displayedColumns: string[] = ['content', 'actions'];

  constructor(
    private quizService: QuizService
  ) { }

  ngOnInit() {
    this.loadData();
  }

  addDialog() {

  }

  loadData() {
    this.quizService.findAllQuestions(1).subscribe(data => {
      this.questions = data;
    });

  }

}
