import {NgModule} from "@angular/core";
import {DatePipe} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";
import {DashboardService} from "./dashboard.service";
import {DashboardRoutingModule} from "./dashboard-routing.module";
import {SharedModule} from "../shared/shared.module";
import {RiverStatusPipe} from "./pipes/river-status.pipe";
import {RainIntensityPipe} from "./pipes/rain-intensity.pipe";

@NgModule({
	imports: [
		DashboardRoutingModule,
		SharedModule
	],
	declarations: [
		DashboardComponent,
		RiverStatusPipe,
		RainIntensityPipe
	],
	providers: [
		DashboardService,
		DatePipe
	]
})
export class DashboardModule {
}
