import {Component, OnInit} from "@angular/core";
import {RiverLevel, RiverLevelService} from "./river-level.service";
import {DatePipe} from "@angular/common";

@Component({
	templateUrl: 'river-level.component.html',
	selector: 'river-level',
	providers: [RiverLevelService]
})
export class RiverLevelComponent implements OnInit {

	public riverLevels: RiverLevel[];

	constructor(private riverLevelService: RiverLevelService,
				private datePipe: DatePipe) {
	}

	public ngOnInit(): void {
		this.riverLevelService.getRiverLevels().subscribe((riverLevels: RiverLevel[]) => {
			this.riverLevels = riverLevels;

			this.mainChartData = [riverLevels.reduce((result: any, riverLevel: RiverLevel) => {
				result.data.unshift(riverLevel.level);
				return result;
			}, {data: [], label: 'Nível do Rio'})];

			this.mainChartLabels = riverLevels.map((riverLevel: RiverLevel) => {
				return this.datePipe.transform(riverLevel.time, 'HH:mm')
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
						return Number((value).toFixed(2)) + " m";
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
			backgroundColor: RiverLevelComponent.convertHex('#63c2de', 10),
			borderColor: '#63c2de',
			pointHoverBackgroundColor: '#fff'
		}
	];

	public mainChartLegend = false;

	public mainChartType = 'line';
}
