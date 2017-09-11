import {OrderService} from "../shared/service/order.service";
import {ProductService} from "../shared/service/product.services";
import {ClientService} from "../shared/service/client.services";
import {Component, Injectable, OnInit} from "@angular/core";

@Component({
  templateUrl: 'order.component.html',
  providers: [OrderService, ClientService, ProductService]
})

@Injectable()
export class OrderComponent implements OnInit {

  ngOnInit(): void {
    for (let i = 0; i <= this.mainChartElements; i++) {
      this.mainChartData1.push(OrderComponent.random(50, 200));
    }
  }

  // convert Hex to RGBA
  public static convertHex(hex: string, opacity: number) {
    hex = hex.replace('#', '');
    const r = parseInt(hex.substring(0, 2), 16);
    const g = parseInt(hex.substring(2, 4), 16);
    const b = parseInt(hex.substring(4, 6), 16);

    return 'rgba(' + r + ', ' + g + ', ' + b + ', ' + opacity / 100 + ')';
  }

  public static random(min: number, max: number) {
    return Math.floor(Math.random() * (max - min + 1) + min);
  }

  public mainChartElements = 27;
  public mainChartData1: Array<number> = [];

  public mainChartData: Array<any> = [
    {
      data: this.mainChartData1,
      label: 'Current'
    }
  ];
  /* tslint:disable:max-line-length */
  public mainChartLabels: Array<any> = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Monday', 'Thursday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
  /* tslint:enable:max-line-length */
  public mainChartOptions: any = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
      xAxes: [{
        gridLines: {
          drawOnChartArea: false,
        },
        ticks: {
          callback: function (value: any) {
            return value.charAt(0);
          }
        }
      }],
      yAxes: [{
        ticks: {
          beginAtZero: true,
          maxTicksLimit: 5,
          stepSize: Math.ceil(250 / 5),
          max: 250
        }
      }]
    },
    elements: {
      line: {
        borderWidth: 2
      },
      point: {
        radius: 0,
        hitRadius: 10,
        hoverRadius: 4,
        hoverBorderWidth: 3,
      }
    },
    legend: {
      display: false
    }
  };
  public mainChartColours: Array<any> = [
    { // brandInfo
      backgroundColor: OrderComponent.convertHex('#63c2de', 10),
      borderColor: '#63c2de',
      pointHoverBackgroundColor: '#fff'
    }
  ];
  public mainChartLegend = false;
  public mainChartType = 'line';
}
