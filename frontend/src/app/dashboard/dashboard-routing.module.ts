import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {RiverLevelComponent} from "./riverlevel/river-level.component";

const routes: Routes = [
	{
		path: '',
		redirectTo: 'riverlevel',
		pathMatch: 'full',
	},
	{
		path: 'riverlevel',
		component: RiverLevelComponent,
		data: {
			title: 'Nível do Rio'
		}
	}
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule]
})
export class DashboardRoutingModule {
}
