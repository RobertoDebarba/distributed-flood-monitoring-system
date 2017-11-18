import {Response} from 'express';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import {Http} from '@angular/http';
import {environment} from '../../environments/environment';
import 'rxjs/add/operator/map';

export interface Touch {
	name: string,
	email: string,
	message: string
}

@Injectable()
export class TouchService {

	constructor(private http: Http) {
	}

	public postTouch(touch: Touch): Observable<Response> {
		return this.http.post(environment.api + 'touch', touch);
	}

}
