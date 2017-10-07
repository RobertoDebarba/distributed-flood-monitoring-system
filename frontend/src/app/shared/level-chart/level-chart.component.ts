import {Component, Input, OnInit} from "@angular/core";

@Component({
	templateUrl: 'level-chart.component.html',
	selector: 'level-chart'
})
export class LevelChartComponent implements OnInit {

	@Input()
	public mainChartData: Array<any>;

	@Input()
	public mainChartLabels: Array<any>;

	@Input()
	public yAxisUnit: String = "m";

	ngOnInit(): void {
		let yAxisUnit = this.yAxisUnit;

		this.mainChartOptions = {
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
							return Number((value).toFixed(2)) + " " + yAxisUnit;
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
		}
	};

	public static convertHex(hex: string, opacity: number) {
		hex = hex.replace('#', '');
		const r = parseInt(hex.substring(0, 2), 16);
		const g = parseInt(hex.substring(2, 4), 16);
		const b = parseInt(hex.substring(4, 6), 16);

		return 'rgba(' + r + ', ' + g + ', ' + b + ', ' + opacity / 100 + ')';
	}

	public mainChartOptions: any;

	public mainChartColours: Array<any> = [
		{
			backgroundColor: LevelChartComponent.convertHex('#63c2de', 10),
			borderColor: '#63c2de',
			pointHoverBackgroundColor: '#fff'
		}
	];

	public mainChartLegend = false;

	public mainChartType = 'line';
}
