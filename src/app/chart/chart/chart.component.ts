import { Component } from '@angular/core';
import {ServiceService} from "../../service.service";
import {EChartsOption} from "echarts";

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.scss']
})
export class ChartComponent {
  options1: EChartsOption;
  options2: EChartsOption;
  options3: EChartsOption;
  dataA: number[] = [];
  dataTimeA: number[] = [];
  dataTimeB: number[] = [];
  dataTimeC: number[] = [];
  dataB: number[] = [];
  dataC: number[] = [];

  constructor(private service: ServiceService) {
    const xAxisData = [];
    //let dataArray: number[];
    const data1: number[] = [];
    const data2 = [];
    this.service.downloadKZA().subscribe(res => {
      this.dataA = res
      //console.log(this.dataA)
      //console.log(this.dataA.map((value, index, array) => value));
    });
    this.service.downloadKZB().subscribe(res =>{
      this.dataB = res
      //console.log(this.dataB)
    })
    this.service.downloadKZC().subscribe(res =>{
      this.dataC = res
      //console.log(this.dataC)

    })
    this.service.downloadTimeKZA().subscribe(res =>{
      this.dataTimeA = res
      console.log(this.dataTimeA)
    })

    this.service.downloadTimeKZB().subscribe(res =>{
      this.dataTimeB = res
      console.log(this.dataTimeA)

    })

    this.service.downloadTimeKZC().subscribe(res =>{
      this.dataTimeC = res
      console.log(this.dataTimeA)

    })

    this.options1 = {
      legend: {
        data: ['data1', 'data2','data3'],
        align: 'left',
      },
      tooltip: {},
      xAxis: {
        data: [],
      },
      yAxis: {},
      series: [
        {
          name: 'line 1',
          type: 'line',
          data:  this.dataA,
          animationDelay: (idx) => idx * 10,
        },
        /*{
          name: 'line 2',
          type: 'line',
          data: data2,
          animationDelay: (idx) => idx * 10 + 100,
        },*/
      ],
      animationEasing: 'elasticOut',
      animationDelayUpdate: (idx) => idx * 5,
    }
    this.options2 = {
      legend: {
        data: ['data1', 'data2', 'data3'],
        align: 'left',
      },
      tooltip: {},
      xAxis: {
        data: [],
      },
      yAxis: {},
      series: [
        {
          name: 'line 2',
          type: 'line',
          data: [],
          animationDelay: (idx) => idx * 10 + 100,
        },
      ],
      animationEasing: 'elasticOut',
      animationDelayUpdate: (idx) => idx * 5,
    }
    this.options3 = {
      legend: {
        data: ['data1', 'data2', 'data3'],
        align: 'left',
      },
      tooltip: {},
      xAxis: {
        data: [],
      },
      yAxis: {},
      series: [
        {
          name: 'line 2',
          type: 'line',
          data: [],
          animationDelay: (idx) => idx * 10 + 100,
        },
      ],
      animationEasing: 'elasticOut',
      animationDelayUpdate: (idx) => idx * 5,
    }







    setTimeout(()=>{
      this.options1 = {
        legend: {
          data: ['data1', 'data2', 'data3'],
          align: 'left',
        },
        tooltip: {},
        xAxis: {
          data: this.dataTimeA.map((value, index, array) => value),
        },
        yAxis: {},
        series: [
          {
            name: 'line 1',
            type: 'line',
            data: this.dataA,
            animationDelay: (idx) => idx * 10,
          },
        ],
        animationEasing: 'elasticOut',
        animationDelayUpdate: (idx) => idx * 5,
      }

      this.options2 = {
        legend: {
          data: ['data1', 'data2', 'data3'],
          align: 'left',
        },
        tooltip: {},
        xAxis: {
          data: this.dataTimeB.map((value, index, array) => value),
        },
        yAxis: {},
        series: [
          {
            name: 'line 2',
            type: 'line',
            data: this.dataB,
            animationDelay: (idx) => idx * 10 + 100,
          },
        ],
        animationEasing: 'elasticOut',
        animationDelayUpdate: (idx) => idx * 5,
      }

      this.options3 = {
        legend: {
          data: ['data1', 'data2', 'data3'],
          align: 'left',
        },
        tooltip: {},
        xAxis: {
          data: this.dataTimeC.map((value, index, array) => value),
        },
        yAxis: {},
        series: [
          {
            name: 'line 2',
            type: 'line',
            data: this.dataC,
            animationDelay: (idx) => idx * 10 + 100,
          },
        ],
        animationEasing: 'elasticOut',
        animationDelayUpdate: (idx) => idx * 5,
      }

    },300);


    //console.log(this.dataArray)



  }
}
