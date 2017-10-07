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

	public rainIntensityCardClass: string;
	public riverStatusCardClass: string;

	constructor(private rainFallServiceService: DashboardService,
				private datePipe: DatePipe,
				private el: ElementRef) {
		let tag = document.createElement("script");
		tag.src = "../../../assets/js/weather-widget.js";
		this.el.nativeElement.appendChild(tag);
	}

	public ngOnInit(): void {
		this.rainFallServiceService.getDashboard().subscribe((dashboard: Dashboard) => {
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

			this.verifyRainIntensity();
			this.verifyRiverStatus();
		});
	}

	private verifyRainIntensity(): void {
		switch (this.rainIntensity) {
			case "NORMAL":
				this.rainIntensity = "Normal";
				this.rainIntensityCardClass = "bg-success";
				break;
			case "MODERATE":
				this.rainIntensity = "Moderada";
				this.rainIntensityCardClass = "bg-warning";
				break;
			case "HEAVY":
				this.rainIntensity = "Forte";
				this.rainIntensityCardClass = "bg-alert";
				break;
			case "VERY_STRONG":
				this.rainIntensity = "Muito forte";
				this.rainIntensityCardClass = "bg-danger";
				break;
		}
	}

	private verifyRiverStatus(): void {
		switch (this.riverStatus) {
			case "NORMAL":
				this.riverStatus = "Normal";
				this.riverStatusCardClass = "bg-success";
				break;
			case "ATTENTION":
				this.riverStatus = "Atenção";
				this.riverStatusCardClass = "bg-warning";
				break;
			case "ALERT":
				this.riverStatus = "Alerta";
				this.riverStatusCardClass = "bg-alert";
				break;
			case "READINESS":
				this.riverStatus = "Prontidão";
				this.riverStatusCardClass = "bg-danger";
				break;
		}
	}

	public getRiverLevelFixed(): string {
		if (this.riverLevel)
			return `${this.riverLevel.toFixed(2)} m`;
	}

}
