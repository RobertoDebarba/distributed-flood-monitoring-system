import {Component} from "@angular/core";
import {Router} from "@angular/router";

interface Page {
	title: string,
	route: string
}

@Component({
	selector: 'app-dashboard',
	templateUrl: './dashboard.component.html'
})
export class DashboardComponent {

	public pages: Page[] = [
		{title: 'Nível do Rio', route: 'riverlevel'},
		{title: 'Chuva', route: 'rainfall'}
	];

	constructor(private router: Router) {
	}

	public isActivePage(page: Page): boolean {
		return this.router.url.indexOf(page.route) > 0
	}

}
