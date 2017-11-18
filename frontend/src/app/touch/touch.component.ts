import {Component} from '@angular/core';
import {Touch, TouchService} from './touch.service';
import {Alert} from '../shared/alert-message/alert-message.component';

@Component({
	templateUrl: 'touch.component.html',
	selector: 'touch'
})
export class TouchComponent {

	public name: string;
	public email: string;
	public message: string;
	alert: Alert = new Alert();

	constructor(private touchService: TouchService) {
	}

	public postTouch(): void {
		let touch: Touch = {
			name: this.name,
			email: this.email,
			message: this.message
		};
		this.touchService.postTouch(touch).subscribe(
			res => this.alert.warn("E-mail enviado com sucesso!", false),
			err => this.alert.warn(`Ocorreu um erro ao enviar o e-mail. Mensagem: ${err.text()}`, true));
	}

}
