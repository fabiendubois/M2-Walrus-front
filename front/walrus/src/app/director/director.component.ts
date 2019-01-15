import { Component, OnInit } from '@angular/core';
import { QuizService } from '../services/quiz.serices';

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  started = false;
  quiz;

  best_word = "";

  choices5;
  words = [];

  constructor(private quizService: QuizService) { }

  ngOnInit() {
    // Vérification si le quiz est start
    this.quizService.findById(1).subscribe(data => {
      this.started = data.started;
      if (this.started === true) {
        this.getAllQuestions();
      }
    });
  }

  startQuiz() {
    this.quizService.start(1).subscribe(data => {
      this.started = true;
      // START FIRST QUESTION
      this.startQuestion(1);
      // Récupérer le quiz avec les questions et les choix
      this.getAllQuestions();
    });
  }


  startQuestion(id_question) {
    this.quizService.startQuestion(1, id_question).subscribe(data => {
    });
  }

  completeQuestion(id_question) {
    this.quizService.completeQuestion(1, id_question).subscribe(data => {
    });
  }

  getAllQuestions() {
    this.quizService.findAllQuestions(1).subscribe(data => {
      this.quiz = data;
    });
  }

  next() {
    let lenght = this.quiz.lenght;
    var size = Object.keys(this.quiz).length;
    for (let e in this.quiz) {
      if (this.quiz[e].started === true) {
        this.quizService.completeQuestion(1, this.quiz[e].id).subscribe(data => {
          if ((this.quiz[e].id + 1) <= size) {
            this.quizService.startQuestion(1, this.quiz[e].id + 1).subscribe(data => {

              this.looping(this.quiz[e].id + 1);
            });
          }
        });
      }
    }
  }


  private async looping(size) {
    while(true) {
      this.getAllQuestions(); 

      if(size === 5) {
        console.log(this.quiz[4]);
        this.choices5 = this.quiz[4].choices[0].answers;
        console.log(this.choices5);
        this.words = [];
        for(let e of this.choices5) {
          this.words.push(e.content);
        }
        console.log("WORDS",this.words);
        let tmp = this.occurrence(this.words);
        this.best_word = Object.keys(tmp)[0]
      }

      await this.delay(1400);
    }
  }

  private delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  occurrence(array) {
    var result = {};
    if (array instanceof Array) { // Check if input is array.
        array.forEach(function (v, i) {
            if (!result[v]) { // Initial object property creation.
                result[v] = [i]; // Create an array for that property.
            } else { // Same occurrences found.
                result[v].push(i); // Fill the array.
            }
        });
    }
    return result;
};
}

