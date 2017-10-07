import {NgModule} from "@angular/core";
import {DatePipe} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";
import {DashboardService} from "./dashboard.service";
import {InitialRoutingModule} from "./dashboard-routing.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
	imports: [
		InitialRoutingModule,
		SharedModule
	],
	declarations: [
		DashboardComponent
	],
	providers: [
		DashboardService,
		DatePipe
	]
})
export class DashboardModule {
}
