import {Response} from "express";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Rx";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import "rxjs/add/operator/map";

export interface RainFall {
	time: Date,
	intensity: number,
	stationName: string,
	city: string,
	federationUnit: string
}

@Injectable()
export class RainFallService {

	constructor(private http: Http) {
	}

	public getRainFalls(): Observable<RainFall[]> {
		return this.http.get(environment.api + 'rainfall?size=10')
			.map((res: Response) => res.json().content);
	}

}
