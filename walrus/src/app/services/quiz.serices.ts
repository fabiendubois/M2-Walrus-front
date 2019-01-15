import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class QuizService {
    constructor(private httpClient: HttpClient) {}

    findAllQuestions(id_quiz) : Observable<any> {
        return this.httpClient.get<any>(environment.apiUrl + 'quiz/' + id_quiz + '/questions');
    }

    findById(id) : Observable<any>{
        return this.httpClient.get<any>(environment.apiUrl + 'quiz/' + id);
    }

    start(id) : Observable<any> {
        return this.httpClient.post<any>(environment.apiUrl + 'quiz/' + id + '/_start', '{}');
    }

    startQuestion(id_quiz, id_question) : Observable<any> {
        return this.httpClient.post<any>(environment.apiUrl + 'quiz/' + id_quiz + '/questions/' + id_question +'/_start', '{}');
    }

    completeQuestion(id_quiz, id_question) : Observable<any> {
        return this.httpClient.post<any>(environment.apiUrl + 'quiz/' + id_quiz + '/questions/' + id_question +'/_complete', '{}');
    }

    vote(id_choice, content) : Observable<any> {
        let obj = {
            "content": content
        }
        return this.httpClient.post<any>(environment.apiUrl + 'choices/' + id_choice + '/answers', obj);
    }
    
    /*
    join(id_quiz: any, email: any): Observable<any> {
        return this.httpClient.put<any>(environment.apiUrl + 'technologies', technology);
    }
    */
}