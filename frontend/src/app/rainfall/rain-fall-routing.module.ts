import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {RainFallComponent} from "./rain-fall.component";

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: RainFallComponent }
	])],
	exports: [RouterModule]
})

export class RainFallRoutingModule {}
