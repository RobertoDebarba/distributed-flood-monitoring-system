import {Component} from '@angular/core';
import {Touch, TouchService} from './touch.service';
import {Toast, ToasterConfig, ToasterService} from 'angular2-toaster';

@Component({
	templateUrl: 'touch.component.html',
	selector: 'touch'
})
export class TouchComponent {

	public name: string;
	public email: string;
	public message: string;

	public configToaster: ToasterConfig = new ToasterConfig({
		positionClass: 'toast-top-right',
		limit: 1,
		animation: 'fade'
	});

	constructor(private touchService: TouchService, private toasterService: ToasterService) {
	}

	public postTouch(): void {
		let touch: Touch = {
			name: this.name,
			email: this.email,
			message: this.message
		};
		this.touchService.postTouch(touch).subscribe(
			() => {
				var toast: Toast = {
					type: 'success',
					title: 'Sucesso',
					body: 'E-mail enviado com sucesso!'
				};
				this.toasterService.pop(toast);
			},
			err => {
				var toast: Toast = {
					type: 'error',
					title: 'Erro',
					body: `Ocorreu um erro ao enviar o e-mail. Mensagem: ${err.text()}`
				};
				this.toasterService.pop(toast);
			});
	}
}
