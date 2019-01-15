import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.serices';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  started = false;
  quiz;
  previous_question = 0;
  question_encour = 1;
  voted = false;

  reponse5 = "";

  constructor(
    private quizService: QuizService
  ) { }

  ngOnInit() {
    this.looping();
  }

  private async looping() {
    while (this.started === false) {
      this.QuizStarted();
      if(this.started == false) {
        await this.delay(3000);
      }     
    }

    while (this.started === true) {
      this.getAllQuestions();     
      await this.delay(1400);
    }
  }
  

  getAllQuestions() {
    this.quizService.findAllQuestions(1).subscribe(data => {
      this.quiz = data;
      for (let e in this.quiz) {
        if (this.quiz[e].started === true) {
          this.question_encour = this.quiz[e].id;
          if(this.previous_question === this.question_encour) {
            this.voted = true;
          } else {
            this.voted = false
          }
        }
      }


      console.log("this.previous_question",this.previous_question);
      console.log(" this.question_encour",  this.question_encour);
    });
  }
  
  
  QuizStarted() {
    this.quizService.findById(1).subscribe(data => {
      this.started = data.started;
    });
  }

  vote(id_choice, id_question) {

    this.previous_question = this.question_encour;
    this.question_encour = id_question;
    
    console.log("this.previous_question",this.previous_question);
    console.log(" this.question_encour",  this.question_encour);

    if(this.previous_question === this.question_encour) {
      this.voted = true;
    } else {
      this.voted = false
    }

    this.quizService.vote(id_choice, this.reponse5).subscribe(data => {
    });
  }

  private delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
}
