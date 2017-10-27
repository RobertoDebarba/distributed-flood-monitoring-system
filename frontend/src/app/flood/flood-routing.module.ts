import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {FloodComponent} from "./flood.component";

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: FloodComponent }
	])],
	exports: [RouterModule]
})

export class FloodRoutingModule {}
