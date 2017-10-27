import {NgModule} from "@angular/core";
import {DatePipe} from "@angular/common";
import {FloodComponent} from "./flood.component";
import {FloodService} from "./flood.service";
import {FloodRoutingModule} from "./flood-routing.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
	imports: [
		SharedModule,
		FloodRoutingModule
	],
	declarations: [
		FloodComponent
	],
	providers: [
		FloodService,
		DatePipe
	]
})
export class FloodModule {
}
