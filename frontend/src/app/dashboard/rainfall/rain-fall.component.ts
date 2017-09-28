import {Component, OnInit} from "@angular/core";
import {DatePipe} from "@angular/common";
import {RainFall, RainFallService} from "./rain-fall.service";

@Component({
	templateUrl: 'rain-fall.component.html',
	selector: 'rain-fall',
	providers: [RainFallService]
})
export class RainFallComponent implements OnInit {

	public rainFalls: RainFall[];

	constructor(private rainFallServiceService: RainFallService,
				private datePipe: DatePipe) {
	}

	public ngOnInit(): void {
		this.rainFallServiceService.getRainFalls().subscribe((rainFalls: RainFall[]) => {
			this.rainFalls = rainFalls;

			this.mainChartData = [rainFalls.reduce((result: any, rainFall: RainFall) => {
				result.data.unshift(rainFall.intensity);
				return result;
			}, {data: [], label: 'Nível do Rio'})];

			this.mainChartLabels = rainFalls.map((rainFall: RainFall) => {
				return this.datePipe.transform(rainFall.time, 'HH:mm') + " h"
			}).reverse();
		});
	}

	public mainChartData: Array<any>;

	public mainChartLabels: Array<any>;

	public static convertHex(hex: string, opacity: number) {
		hex = hex.replace('#', '');
		const r = parseInt(hex.substring(0, 2), 16);
		const g = parseInt(hex.substring(2, 4), 16);
		const b = parseInt(hex.substring(4, 6), 16);

		return 'rgba(' + r + ', ' + g + ', ' + b + ', ' + opacity / 100 + ')';
	}

	public mainChartOptions: any = {
		responsive: true,
		maintainAspectRatio: false,
		scales: {
			xAxes: [{
				gridLines: {
					drawOnChartArea: true,
				}
			}],
			yAxes: [{
				ticks: {
					beginAtZero: false,
					callback: function (value: any) {
						return Number((value).toFixed(2)) + " mm";
					}
				}
			}]
		},
		elements: {
			line: {
				borderWidth: 2
			},
			point: {
				radius: 0,
				hitRadius: 10,
				hoverRadius: 4,
				hoverBorderWidth: 3,
			}
		},
		legend: {
			display: false
		}
	};

	public mainChartColours: Array<any> = [
		{
			backgroundColor: RainFallComponent.convertHex('#63c2de', 10),
			borderColor: '#63c2de',
			pointHoverBackgroundColor: '#fff'
		}
	];

	public mainChartLegend = false;

	public mainChartType = 'line';
}
