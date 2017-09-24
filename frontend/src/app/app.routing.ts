import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {DashboardComponent} from "./dashboard/dashboard.component";

export const routes: Routes = [
	{
		path: '',
		redirectTo: 'dashboard',
		pathMatch: 'full',
	},
	{
		path: '',
		component: DashboardComponent,
		data: {
			title: 'Início'
		},
		children: [
			{
				path: 'dashboard',
				loadChildren: './dashboard/dashboard.module#DashboardModule'
			},
		]
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
