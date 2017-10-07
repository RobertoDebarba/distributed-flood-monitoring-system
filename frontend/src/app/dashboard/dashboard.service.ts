import {Response} from "express";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Rx";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import "rxjs/add/operator/map";

export interface Dashboard {
	riverLevel: number,
	rainIntensity: string,
	riverStatus: string,
	riverLevelHistoric: number[],
	riverLevelHistoricTime: Date[]
}

@Injectable()
export class DashboardService {

	constructor(private http: Http) {
	}

	public getDashboard(): Observable<Dashboard> {
		return this.http.get(environment.api + 'dashboard')
			.map((res: Response) => res.json());
	}

}
