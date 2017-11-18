import {NgModule} from '@angular/core';
import {TouchComponent} from './touch.component';
import {TouchService} from './touch.service';
import {TouchRoutingModule} from './touch-routing.module';
import {SharedModule} from '../shared/shared.module';

@NgModule({
	imports: [
		SharedModule,
		TouchRoutingModule
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

