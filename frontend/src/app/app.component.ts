import { Component } from '@angular/core';
import {Router} from "@angular/router";

interface Page {
	title: string,
	route: string
}

@Component({
    selector: 'body',
    templateUrl: './app.component.html'
})
export class AppComponent {

	public pages: Page[] = [
		{title: 'Início', route: 'dashboard'},
		{title: 'Nível do Rio', route: 'riverlevel'},
		{title: 'Chuva', route: 'rainfall'},
		{title: 'Enchentes', route: 'flood'}
	];

	constructor(private router: Router) {
	}

	public isActivePage(page: Page): boolean {
		return this.router.url.indexOf(page.route) > 0
	}
}
