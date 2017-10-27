import {Component, OnInit} from "@angular/core";
import {Flood, FloodService} from "./flood.service";
import {DatePipe} from "@angular/common";

@Component({
	templateUrl: 'flood.component.html',
	selector: 'flood',
	providers: [FloodService]
})
export class FloodComponent implements OnInit {

	public floods: Flood[];

	constructor(private floodService: FloodService) {
	}

	public ngOnInit(): void {
		this.floodService.getFloods().subscribe((floods: Flood[]) => {
			this.floods = floods;
		});
	}

}
