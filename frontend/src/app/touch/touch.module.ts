import {NgModule} from '@angular/core';
import {TouchComponent} from './touch.component';
import {TouchService} from './touch.service';
import {TouchRoutingModule} from './touch-routing.module';
import {SharedModule} from '../shared/shared.module';
import {LaddaModule} from 'angular2-ladda';

@NgModule({
	imports: [
		SharedModule,
		TouchRoutingModule,
		LaddaModule.forRoot({
			style: "slide-right",
			spinnerSize: 24,
			spinnerColor: "white",
			spinnerLines: 12
		})
	],
	declarations: [
		TouchComponent
	],
	providers: [
		TouchService
	]
})
export class TouchModule {
}

