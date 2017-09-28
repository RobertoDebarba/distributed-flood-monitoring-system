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
	public mainChartData: Array<any>;
	public mainChartLabels: Array<any>;

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

}
