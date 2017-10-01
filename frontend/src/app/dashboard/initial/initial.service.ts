import {Response} from "express";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Rx";
import {Http} from "@angular/http";
import {environment} from "../../../environments/environment";
import "rxjs/add/operator/map";

export interface Initial {
	riverLevel: number,
	rainIntensity: string,
	riverStatus: string,
	riverLevelHistoric: number[],
	riverLevelHistoricTime: Date[]
}

@Injectable()
export class InitialService {

	constructor(private http: Http) {
	}

	public getInitial(): Observable<Initial> {
		return this.http.get(environment.api + 'dashboard')
			.map((res: Response) => res.json());
	}

}
