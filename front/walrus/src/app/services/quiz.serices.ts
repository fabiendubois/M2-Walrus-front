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

    findById(id) {
        return this.httpClient.get<any>(environment.apiUrl + 'quiz/' + id);
    }

    start(id) {
        return this.httpClient.post<any>(environment.apiUrl + 'quiz/' + id + '/_start', '{}');
    }

    /*
    join(id_quiz: any, email: any): Observable<any> {
        return this.httpClient.put<any>(environment.apiUrl + 'technologies', technology);
    }
    */
}