import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {RiverLevelComponent} from "./riverlevel/river-level.component";
import {RainFallComponent} from "./rainfall/rain-fall.component";

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
	},
	{
		path: 'rainfall',
		component: RainFallComponent,
		data: {
			title: 'Chuva'
		}
	}
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule]
})
export class DashboardRoutingModule {
}
