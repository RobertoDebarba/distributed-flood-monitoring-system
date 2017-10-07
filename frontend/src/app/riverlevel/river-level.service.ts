import {Response} from "express";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Rx";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import "rxjs/add/operator/map";

export interface RiverLevel {
	time: Date,
	level: number,
	river: string,
	city: string,
	federationUnit: string
}

@Injectable()
export class RiverLevelService {

	constructor(private http: Http) {
	}

	public getRiverLevels(): Observable<RiverLevel[]> {
		return this.http.get(environment.api + 'riverlevel?size=10')
			.map((res: Response) => res.json().content);
	}

}
