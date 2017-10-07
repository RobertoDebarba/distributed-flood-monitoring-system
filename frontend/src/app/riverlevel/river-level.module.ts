import {NgModule} from "@angular/core";
import {DatePipe} from "@angular/common";
import {RiverLevelComponent} from "./river-level.component";
import {RiverLevelService} from "./river-level.service";
import {RiverLevelRoutingModule} from "./river-level-routing.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
	imports: [
		SharedModule,
		RiverLevelRoutingModule
	],
	declarations: [
		RiverLevelComponent
	],
	providers: [
		RiverLevelService,
		DatePipe
	]
})
export class RiverLevelModule {
}

