import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";

import {AppComponent} from "./app.component";
import {DropdownModule} from "ng2-bootstrap/dropdown";
import {TabsModule} from "ng2-bootstrap/tabs";

import {ChartsModule} from "ng2-charts/ng2-charts";

import {AppRoutingModule} from "./app-routing.module";

import {Http, HttpModule, RequestOptions, XHRBackend} from "@angular/http";
import {interceptHttpFactory, InterceptHttpService} from "./providers/http/intercept-http.service";
import {DashboardModule} from "./dashboard/dashboard.module";

@NgModule({
	imports: [
		BrowserModule,
		HttpModule,
		AppRoutingModule,
		DropdownModule.forRoot(),
		TabsModule.forRoot(),
		ChartsModule,
		DashboardModule
	],
	declarations: [
		AppComponent
	],
	providers: [
		{
			provide: LocationStrategy,
			useClass: HashLocationStrategy
		},
		{
			provide: Http,
			useClass: InterceptHttpService,
			deps: [XHRBackend, RequestOptions],
			useFactory: interceptHttpFactory
		},
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule {
}
