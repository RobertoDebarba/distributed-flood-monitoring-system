import {Injectable} from "@angular/core";
import {Http, RequestOptions, RequestOptionsArgs, Response, XHRBackend} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/of";

@Injectable()
export class InterceptHttpService extends Http {

	constructor(private backend: XHRBackend,
				private defaultOptions: RequestOptions) {

		super(backend, defaultOptions);

		this.defaultOptions.headers.set('Access-Control-Allow-Origin', '*');
		this.defaultOptions.headers.set('Access-Control-Allow-Methods', ['GET', 'POST', 'PATCH', 'PUT', 'DELETE', 'OPTIONS']);
		this.defaultOptions.headers.set('Access-Control-Allow-Headers', ['Origin', 'Content-Type', 'X-Auth-Token']);
		this.defaultOptions.headers.set('Content-Type', 'application/json');
	}

	get(url: string, options?: RequestOptionsArgs): Observable<Response> {
		return super.get(url, options);
	}

	post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
		return super.post(url, body, options);
	}

	put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
		return super.put(url, body, options);
	}

	delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
		return super.delete(url, options);
	}

	patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
		return super.patch(url, body, options);
	}

	head(url: string, options?: RequestOptionsArgs): Observable<Response> {
		return super.head(url, options);
	}

}

export function interceptHttpFactory(backend: XHRBackend, defaultOptions: RequestOptions) {
	return new InterceptHttpService(backend, defaultOptions);
}
