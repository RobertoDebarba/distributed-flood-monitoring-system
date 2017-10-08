import {Component, ElementRef, OnInit} from "@angular/core";
import {Dashboard, DashboardService} from "./dashboard.service";
import {DatePipe} from "@angular/common";

@Component({
	templateUrl: './dashboard.component.html',
	selector: 'dashboard',
	providers: [DashboardService]
})
export class DashboardComponent implements OnInit {

	public dashboard: Dashboard;
	public riverLevel: number;
	public rainIntensity: string;
	public riverStatus: string;

	public mainChartData: Array<any>;
	public mainChartLabels: Array<any>;

	constructor(private dashboardService: DashboardService,
				private datePipe: DatePipe,
				private el: ElementRef) {
		let tag = document.createElement("script");
		tag.src = "../../../assets/js/weather-widget.js";
		this.el.nativeElement.appendChild(tag);
	}

	public ngOnInit(): void {
		this.dashboardService.getDashboard().subscribe((dashboard: Dashboard) => {
			this.dashboard = dashboard;
			this.riverLevel = dashboard.riverLevel;
			this.rainIntensity = dashboard.rainIntensity;
			this.riverStatus = dashboard.riverStatus;
			this.mainChartData = [{
				data: dashboard.riverLevelHistoric.reverse(),
				label: 'Nível do Rio'
			}];
			this.mainChartLabels = dashboard.riverLevelHistoricTime.map((time: Date) => {
				return this.datePipe.transform(time, 'HH:mm') + " h"
			}).reverse();
		});
	}

	public getRiverLevelFixed(): string {
		if (this.riverLevel)
			return `${this.riverLevel.toFixed(2)} m`;
	}

}
