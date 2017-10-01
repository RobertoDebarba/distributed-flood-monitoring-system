import {Component, OnInit} from "@angular/core";
import {Initial, InitialService} from "./initial.service";
import {DatePipe} from "@angular/common";

@Component({
	templateUrl: 'initial.component.html',
	selector: 'initial',
	providers: [InitialService]
})
export class InitialComponent implements OnInit {

	public initial: Initial;
	public riverLevel: number;
	public rainIntensity: string;
	public riverStatus: string;

	public mainChartData: Array<any>;
	public mainChartLabels: Array<any>;

	public rainIntensityCardClass: string;
	public riverStatusCardClass: string;

	constructor(private rainFallServiceService: InitialService,
				private datePipe: DatePipe) {
	}

	public ngOnInit(): void {
		this.rainFallServiceService.getInitial().subscribe((initial: Initial) => {
			this.initial = initial;
			this.riverLevel = initial.riverLevel;
			this.rainIntensity = initial.rainIntensity;
			this.riverStatus = initial.riverStatus;
			this.mainChartData = [{
				data: initial.riverLevelHistoric.reverse(),
				label: 'Nível do Rio'
			}];
			this.mainChartLabels = initial.riverLevelHistoricTime.map((time: Date) => {
				return this.datePipe.transform(time, 'HH:mm') + " h"
			}).reverse();

			this.verifyRainIntensity();
			this.verifyRiverStatus();
		});
	}

	public redirectToRiverLevel(): void {
	}

	public redirectToRainFall(): void {
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
