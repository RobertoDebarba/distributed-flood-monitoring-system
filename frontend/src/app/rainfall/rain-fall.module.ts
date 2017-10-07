import {NgModule} from "@angular/core";
import {DatePipe} from "@angular/common";
import {RainFallComponent} from "./rain-fall.component";
import {RainFallService} from "./rain-fall.service";
import {RainFallRoutingModule} from "./rain-fall-routing.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
	imports: [
		SharedModule,
		RainFallRoutingModule
	],
	declarations: [
		RainFallComponent,
	],
	providers: [
		RainFallService,
		DatePipe
	]
})
export class RainFallModule {
}
