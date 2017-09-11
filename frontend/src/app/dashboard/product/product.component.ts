import {Component} from "@angular/core";
import {ProductService} from "../shared/service/product.services";

@Component({
  templateUrl: 'product.component.html',
  providers: [ProductService]
})
export class ProductComponent {
}
