import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class QuizService {
    constructor(private httpClient: HttpClient) {}

    /*
    findAll(): Observable<any> {
        return this.httpClient.get<any>(environment.apiUrl + 'technologies');
    }
    */

    add(name: any): Observable<any> {
        let quiz = {
            "started": false,
            "name": "",
            "nb_users": 0
        };

        quiz.name = name;
        return this.httpClient.post<any>(environment.apiUrl + 'quiz', quiz);
    }

    findAllQuestions(id_quiz) : Observable<any> {
        return this.httpClient.get<any>(environment.apiUrl + 'quiz/' + id_quiz + '/questions');
    }

    /*
    join(id_quiz: any, email: any): Observable<any> {
        return this.httpClient.put<any>(environment.apiUrl + 'technologies', technology);
    }
    */
}