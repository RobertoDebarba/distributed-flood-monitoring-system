import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

export const routes: Routes = [
	{
		path: '',
		redirectTo: 'dashboard',
		pathMatch: 'full',
	},
	{
		path: 'riverlevel',
		loadChildren: 'app/riverlevel/river-level.module#RiverLevelModule'
	},
	{
		path: 'rainfall',
		loadChildren: 'app/rainfall/rain-fall.module#RainFallModule'
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
