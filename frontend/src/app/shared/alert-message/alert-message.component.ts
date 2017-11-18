import {Component, Input} from '@angular/core';

export class Alert {
	public isVisible = false;
	public isError = false;
	public message = ' ';

	public warn(message: string, isError: boolean) {
		this.message = message;
		this.isError = isError;
		this.isVisible = true;
	}
}

@Component({
	selector: 'alert-message',
	templateUrl: './alert-message.component.html'
})
export class AlertMessageComponent {

	@Input()
	public message: string;

	@Input()
	isError: boolean;

	constructor() {
	}
}
