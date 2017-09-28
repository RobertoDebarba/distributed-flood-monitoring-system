import {NgModule} from "@angular/core";
import {ChartsModule} from "ng2-charts/ng2-charts";
import {DashboardRoutingModule} from "./dashboard-routing.module";
import {RiverLevelComponent} from "./riverlevel/river-level.component";
import {ModalModule} from "ng2-bootstrap/modal";
import {RiverLevelService} from "./riverlevel/river-level.service";
import {CommonModule, DatePipe} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {TextMaskModule} from "angular2-text-mask";
import {RainFallService} from "./rainfall/rain-fall.service";
import {RainFallComponent} from "./rainfall/rain-fall.component";

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		DashboardRoutingModule,
		ChartsModule,
		TextMaskModule,
		ModalModule.forRoot()
	],
	declarations: [
		RiverLevelComponent,
		RainFallComponent
	],
	providers: [
		RiverLevelService,
		RainFallService,
		DatePipe
	]
})
export class DashboardModule {
}
