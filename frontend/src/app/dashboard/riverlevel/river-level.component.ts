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
	public mainChartData: Array<any>;
	public mainChartLabels: Array<any>;

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
				return this.datePipe.transform(riverLevel.time, 'HH:mm') + " h"
			}).reverse();
		});
	}

}
