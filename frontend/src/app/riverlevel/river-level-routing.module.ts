import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {RiverLevelComponent} from "./river-level.component";

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: RiverLevelComponent }
	])],
	exports: [RouterModule]
})

export class RiverLevelRoutingModule {}
