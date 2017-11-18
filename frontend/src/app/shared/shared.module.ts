import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {LevelChartComponent} from './level-chart/level-chart.component';
import {TextMaskModule} from 'angular2-text-mask';
import {ChartsModule} from 'ng2-charts';
import {ToasterModule} from 'angular2-toaster';

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ChartsModule,
		TextMaskModule,
		ToasterModule
	],
	declarations: [
		LevelChartComponent
	],
	exports: [
		CommonModule,
		FormsModule,
		ChartsModule,
		TextMaskModule,
		ToasterModule,
		LevelChartComponent
	]
})

export class SharedModule {
}
