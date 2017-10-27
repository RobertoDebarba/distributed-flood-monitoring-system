import {Response} from "express";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Rx";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import "rxjs/add/operator/map";

export interface Flood {
	year: number,
	level: number
}

@Injectable()
export class FloodService {

	constructor(private http: Http) {
	}

	public getFloods(): Observable<Flood[]> {
		return this.http.get(environment.api + 'flood?size=10')
			.map((res: Response) => res.json().content);
	}

}
